package com.example.demo.mapper;

import com.example.demo.entity.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface BookMapper {
    int deleteByPrimaryKey(Integer idbook);

    int insert(Book record);

    Book selectByPrimaryKey(Integer idbook);

    List<Book> selectAll();

    int updateByPrimaryKey(Book record);
}