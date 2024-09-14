package com.example.dao;

import com.example.entity.Yuyuezuowei;
import com.example.vo.YuyuezuoweiVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@Repository
public interface YuyuezuoweiDao extends Mapper<Yuyuezuowei> {

    List<Yuyuezuowei> getAllYiYuyue(Map<String, Object> pmap);

    List<Yuyuezuowei> getAllMyYuyueHis(Map<String, Object> pmap);

    List<Yuyuezuowei> getAllMyYuyue(Map<String, Object> pmap);
}
