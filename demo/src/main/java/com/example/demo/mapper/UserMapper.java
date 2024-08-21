package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer iduser);

    int insert(User record);

    User selectByPrimaryKey(Integer iduser);

    List<User> selectAll();

    int updateByPrimaryKey(User record);
}