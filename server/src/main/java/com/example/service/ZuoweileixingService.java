package com.example.service;

import com.example.dao.ZuoweileixingDao;
import com.example.entity.Zuoweileixing;
import com.example.vo.ZuoweileixingVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class ZuoweileixingService {

    @Resource
    private ZuoweileixingDao zuoweileixingDao;

    public Zuoweileixing add(Zuoweileixing zuoweileixing) {
        zuoweileixingDao.insertSelective(zuoweileixing);
        return zuoweileixing;
    }

    public void delete(Long id) {
        zuoweileixingDao.deleteByPrimaryKey(id);
    }

    public void update(Zuoweileixing zuoweileixing) {
        zuoweileixingDao.updateByPrimaryKeySelective(zuoweileixing);
    }

    public Zuoweileixing findById(Long id) {
        return zuoweileixingDao.selectByPrimaryKey(id);
    }

    public List<ZuoweileixingVo> findAll() {
        return zuoweileixingDao.findByName("all");
    }

    public PageInfo<ZuoweileixingVo> findPage(String name, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        PageHelper.startPage(pageNum, pageSize);
        List<ZuoweileixingVo> all = findAllPage(request, name);
        return PageInfo.of(all);
    }

    public List<ZuoweileixingVo> findAllPage(HttpServletRequest request, String name) {
		return zuoweileixingDao.findByName(name);
    }

}
