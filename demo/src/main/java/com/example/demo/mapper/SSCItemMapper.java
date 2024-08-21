package com.example.demo.mapper;

import com.example.demo.entity.SSCItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SSCItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SSCItem record);

    SSCItem selectByPrimaryKey(Integer id);

    List<SSCItem> selectAll();

    int updateByPrimaryKey(SSCItem record);
}