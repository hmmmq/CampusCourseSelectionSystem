package com.example.demo.mapper;

import com.example.demo.entity.Borrow;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface BorrowMapper {
    int deleteByPrimaryKey(Integer idborrow);

    int insert(Borrow record);

    Borrow selectByPrimaryKey(Integer idborrow);

    List<Borrow> selectAll();

    int updateByPrimaryKey(Borrow record);
}