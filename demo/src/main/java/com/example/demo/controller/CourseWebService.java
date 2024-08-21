package com.example.demo.controller;

import com.example.demo.entity.Course;
import com.example.demo.entity.SSCItem;
import com.example.demo.entity.User;

import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/coursewebservice")
public class CourseWebService {

    @Autowired
    CourseService courseService;

//--------------------------------------user------------------------------------------------------------
    @GetMapping("/courses")
    List<Course> show_course(){

        return courseService.show_course();

    }

    //-----------------------------------student------------------------------------------------------------

    @GetMapping("/student/selected_courses")
    List<SSCItem> student_selected_courses(User user){

        return courseService.student_selected_courses(user);

    }

    @PostMapping("/student/choose_course")
    Boolean student_choose_course(@RequestBody Course course, @RequestBody User user){

       return courseService.student_choose_course(course, user);
    }

    @PostMapping("/student/cancel_course")
    Boolean student_cancel_course(@RequestBody Course course, @RequestBody User user){
        SSCItem sscItem = new SSCItem();
        sscItem.setValue(course, user);
        return courseService.student_cancel_course(sscItem);

    }

    //-----------------------------------teacher------------------------------------------------------------

    @PostMapping("/teacher/teach_course")
    Boolean teacher_teach_course(@RequestBody Course course, @RequestBody User user){

        return courseService.teacher_teach_course(course, user);
    }

    @PostMapping("/teacher/cancel_course")
    Boolean teacher_cancel_course(@RequestBody Course course){
        return courseService.teacher_cancel_course(course);

    }





    //-----------------------------------administrator------------------------------------------------------------
    @PostMapping("/administrator/add_course")
    Boolean administrator_add_course(@RequestBody Course course){
         return courseService.administrator_add_course(course);

    }

    @PostMapping("/administrator/delete_course")
    Boolean administrator_delete_course(@RequestBody Course course){
        return courseService.administrator_delete_course(course);

    }

    @PostMapping("/administrator/update_course")
    Boolean administrator_update_course(@RequestBody Course course){
        return courseService.administrator_update_course(course);

    }




}