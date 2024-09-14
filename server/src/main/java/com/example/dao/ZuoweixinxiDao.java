package com.example.dao;

import com.example.entity.Zuoweixinxi;
import com.example.vo.ZuoweixinxiVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@Repository
public interface ZuoweixinxiDao extends Mapper<Zuoweixinxi> {
    List<ZuoweixinxiVo> findByName(@Param("name") String name);

    List<ZuoweixinxiVo> getAll(Map<String, Object> pmap);
}
