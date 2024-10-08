package com.example.demo.mapper;

import com.example.demo.entity.Course;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface CourseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Course record);

    Course selectByPrimaryKey(Integer id);

    List<Course> selectAll();

    int updateByPrimaryKey(Course record);

    List<Course> selectByTeacherId(Integer id);
    //selectNullCourse
    List<Course> selectNullCourse();

    List<Course> selectStudentUnselectedCourses(Integer i);
}