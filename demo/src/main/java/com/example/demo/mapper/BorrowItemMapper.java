package com.example.demo.mapper;

import com.example.demo.entity.BorrowItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface BorrowItemMapper {
    int deleteByPrimaryKey(Integer idborrowitem);

    int insert(BorrowItem record);

    BorrowItem selectByPrimaryKey(Integer idborrowitem);

    List<BorrowItem> selectAll();

    int updateByPrimaryKey(BorrowItem record);
}