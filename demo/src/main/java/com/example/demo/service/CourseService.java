package com.example.demo.service;

import com.example.demo.entity.Course;
import com.example.demo.entity.SSCItem;
import com.example.demo.entity.User;
import com.example.demo.mapper.CourseMapper;
import com.example.demo.mapper.SSCItemMapper;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    SSCItemMapper sscItemMapper;//Student-Selected-Course-Item
    public List<Course> show_course() {
        return courseMapper.selectAll();
    }

    public List<SSCItem> student_selected_courses(User user) {
        return sscItemMapper.selectByStudentId(user.getId());
    }

    public Boolean student_choose_course(Course course, User user) {
        SSCItem sscItem = new SSCItem();
        sscItem.setValue(course,user);
        sscItemMapper.insert(sscItem);
        return true;
    }

    public Boolean student_cancel_course(SSCItem sscItem) {
        sscItemMapper.deleteByPrimaryKey(sscItem.getId());
        return true;
    }

    public Boolean teacher_teach_course(Course course, User user) {
        course.updateTeacher(user);
        courseMapper.updateByPrimaryKey(course);
        return true;
    }


    public Boolean teacher_cancel_course(Course course) {
        course.updateTeacher(null);
        courseMapper.updateByPrimaryKey(course);
        return true;
    }


    public Boolean administrator_add_course(Course course) {
        courseMapper.insert(course);
        return true;
    }

    public Boolean administrator_delete_course(Course course) {
        courseMapper.deleteByPrimaryKey(course.getId());
        return true;
    }

    public Boolean administrator_update_course(Course course) {
        courseMapper.updateByPrimaryKey(course);
        return true;
    }

    public List<Course> show_teacher_teached_course(User user) {
        return courseMapper.selectByTeacherId(user.getId());
    }

    public List<Course> show_teacher_unteached_course() {
        return courseMapper.selectNullCourse();
    }

    public List<Course> show_student_unselected_courses(Integer user_id) {
        return courseMapper.selectStudentUnselectedCourses(user_id);
    }
}
