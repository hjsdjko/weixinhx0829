package com.example.service;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.crypto.SecureUtil;
import com.example.common.ResultCode;
import com.example.dao.AdminInfoDao;
import com.example.entity.UserInfo;
import com.example.exception.CustomException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminInfoService {

    @Resource
    private AdminInfoDao adminInfoDao;

    /**
     * 新增用户
     */
    public UserInfo add(UserInfo userInfo) {
        List<Long> fileList = userInfo.getFileList();
        if (!CollectionUtil.isEmpty(fileList)) {
            userInfo.setFileIds(fileList.toString());
        }
        // 唯一校验
        int count = adminInfoDao.checkRepeat("yonghuming", userInfo.getYonghuming(), null);
        if (count > 0) {
            throw new CustomException(ResultCode.USER_EXIST_ERROR);
        }
        if (userInfo.getMima() == null) {
            // 默认密码123456
            userInfo.setMima(SecureUtil.md5("123456"));
        } else {
            userInfo.setMima(SecureUtil.md5(userInfo.getMima()));
        }
        adminInfoDao.insertSelective(userInfo);
        return userInfo;
    }

    public void delete(Long id) {
        adminInfoDao.deleteByPrimaryKey(id);
    }

    public void update(UserInfo userInfo) {
        List<Long> fileList = userInfo.getFileList();
        if (!CollectionUtil.isEmpty(fileList)) {
            userInfo.setFileIds(fileList.toString());
        }
        adminInfoDao.updateByPrimaryKeySelective(userInfo);
    }

    public UserInfo findById(Long id) {
        return adminInfoDao.selectByPrimaryKey(id);
    }

    public UserInfo findByIdAndLevel(Long id, Integer level) {
        Example example = new Example(UserInfo.class);
        example.createCriteria().andEqualTo("id", id)
                .andEqualTo("level", level);
        List<UserInfo> list = adminInfoDao.selectByExample(example);
        return list.get(0);
    }

    public List<UserInfo> findAll() {
        return adminInfoDao.selectAll();
    }

    public PageInfo<UserInfo> findPage(Integer pageNum, Integer pageSize, String name) {
        PageHelper.startPage(pageNum, pageSize);
        List<UserInfo> all = adminInfoDao.findByName(name);
        return PageInfo.of(all);
    }

    /**
     * 登录
     */
    public UserInfo login(String name, String password) {
        List<UserInfo> list = adminInfoDao.findByName(name);
        if (CollectionUtil.isEmpty(list)) {
            throw new CustomException(ResultCode.USER_NOT_EXIST_ERROR);
        }
        if (!SecureUtil.md5(password).equalsIgnoreCase(list.get(0).getMima())) {
            throw new CustomException(ResultCode.USER_ACCOUNT_ERROR);
        }

        return list.get(0);
    }

    /**
     * 重置密码（忘记密码）
     */
    public UserInfo resetMima(String name) {
        List<UserInfo> list = adminInfoDao.findByName(name);
        if (CollectionUtil.isEmpty(list)) {
            throw new CustomException(ResultCode.USER_NOT_EXIST_ERROR);
        }
        list.get(0).setMima(SecureUtil.md5("123456"));
        update(list.get(0));
        return list.get(0);
    }

    /**
     * 修改密码
     */
    public boolean changePassword(Long id, String newPassword) {
        UserInfo userInfo = findById(id);
        if(userInfo == null) {
            throw new CustomException(ResultCode.USER_NOT_EXIST_ERROR);
        }
        userInfo.setMima(SecureUtil.md5(newPassword));
        update(userInfo);
        return true;
    }

}
