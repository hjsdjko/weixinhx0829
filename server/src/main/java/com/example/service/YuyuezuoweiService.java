package com.example.service;

import com.example.dao.YuyuezuoweiDao;
import com.example.entity.Yuyuezuowei;
import com.example.vo.YuyuezuoweiVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service
public class YuyuezuoweiService {

    @Resource
    private YuyuezuoweiDao yuyuezuoweiDao;

    public Yuyuezuowei add(Yuyuezuowei yuyuezuowei) {
        yuyuezuoweiDao.insertSelective(yuyuezuowei);
        return yuyuezuowei;
    }

    public void delete(Long id) {
        yuyuezuoweiDao.deleteByPrimaryKey(id);
    }

    public void update(Yuyuezuowei yuyuezuowei) {
        yuyuezuoweiDao.updateByPrimaryKeySelective(yuyuezuowei);
    }

    public Yuyuezuowei findById(Long id) {
        return yuyuezuoweiDao.selectByPrimaryKey(id);
    }

    public List<Yuyuezuowei> findAll() {
        return yuyuezuoweiDao.selectAll();
    }

    public PageInfo<Yuyuezuowei> findPage(Integer pageNum, Integer pageSize, HttpServletRequest request) {
        PageHelper.startPage(pageNum, pageSize);
        List<Yuyuezuowei> all = yuyuezuoweiDao.selectAll();
        return PageInfo.of(all);
    }

    public List<Yuyuezuowei> getAllYiYuyue(Map<String, Object> pmap) {
       return yuyuezuoweiDao.getAllYiYuyue(pmap);
    }

    public List<Yuyuezuowei> getAllMyYUyue(Map<String, Object> pmap) {
        return yuyuezuoweiDao.getAllMyYuyue(pmap);
    }

    public List<Yuyuezuowei> getAllMyYUyueHis(Map<String, Object> pmap) {
        return yuyuezuoweiDao.getAllMyYuyueHis(pmap);
    }
}
