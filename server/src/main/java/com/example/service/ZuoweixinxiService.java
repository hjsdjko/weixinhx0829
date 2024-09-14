package com.example.service;

import com.example.dao.ZuoweixinxiDao;
import com.example.entity.Zuoweixinxi;
import com.example.vo.ZuoweixinxiVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service
public class ZuoweixinxiService {

    @Resource
    private ZuoweixinxiDao zuoweixinxiDao;

    public Zuoweixinxi add(Zuoweixinxi zuoweixinxi) {
        zuoweixinxiDao.insertSelective(zuoweixinxi);
        return zuoweixinxi;
    }

    public void delete(Long id) {
        zuoweixinxiDao.deleteByPrimaryKey(id);
    }

    public void update(Zuoweixinxi zuoweixinxi) {
        zuoweixinxiDao.updateByPrimaryKeySelective(zuoweixinxi);
    }

    public Zuoweixinxi findById(Long id) {
        return zuoweixinxiDao.selectByPrimaryKey(id);
    }

    public List<ZuoweixinxiVo> findAll() {
        return zuoweixinxiDao.findByName("all");
    }

    public PageInfo<ZuoweixinxiVo> findPage(String name, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        PageHelper.startPage(pageNum, pageSize);
        List<ZuoweixinxiVo> all = findAllPage(request, name);
        return PageInfo.of(all);
    }

    public List<ZuoweixinxiVo> findAllPage(HttpServletRequest request, String name) {
		return zuoweixinxiDao.findByName(name);
    }

    public List<ZuoweixinxiVo> getAll(Map<String, Object> pmap) {
        return zuoweixinxiDao.getAll(pmap);
    }
}
