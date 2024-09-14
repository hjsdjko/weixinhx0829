package com.example.dao;

import com.example.entity.UserInfo;
import com.example.vo.UserInfoVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@Repository
public interface UserInfoDao extends Mapper<UserInfo> {

    int checkRepeat(@Param("column") String column, @Param("value") String value, @Param("id") Long id);

    List<UserInfo> findByName(@Param("yonghuming") String name);

    @Select("select count(id) from user_info where level = 3")
    Integer count();

    List<UserInfo> getAll(Map<String, Object> pmap);

    List<UserInfo> getByName(@Param("name") String name);

    @Select("select * from user_info where level = 3 order by xuexizongshijian desc")
    List<UserInfo> paihang();
}
