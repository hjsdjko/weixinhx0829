package com.example.dao;

import com.example.entity.Zuoweileixing;
import com.example.vo.ZuoweileixingVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface ZuoweileixingDao extends Mapper<Zuoweileixing> {
    List<ZuoweileixingVo> findByName(@Param("name") String name);

}
