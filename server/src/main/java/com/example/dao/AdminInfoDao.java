package com.example.dao;

import com.example.entity.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface AdminInfoDao extends Mapper<UserInfo> {

    int checkRepeat(@Param("column") String column, @Param("value") String value, @Param("id") Long id);

    List<UserInfo> findByName(@Param("yonghuming") String name);

    @Select("select count(id) from user_info where level = 1")
    Integer count();
}
