package com.example.demo.controller;

import com.example.demo.entity.Course;
import com.example.demo.entity.SSCItem;
import com.example.demo.entity.User;

import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@RequestMapping("/coursewebservice")
@Controller
public class CourseWebService {

    @Autowired
    CourseService courseService;


    //-----------------------------------student------------------------------------------------------------

    @PostMapping("/student/selected_courses")
    ModelAndView student_selected_courses(User user){
        List<SSCItem> sscItems = courseService.student_selected_courses(user);
        List<Course> courses = courseService.show_course();
        ModelAndView mv = new ModelAndView();
        mv.addObject("sscItems", sscItems);
        mv.addObject("user", user);
        mv.addObject("courses", courses);
        mv.setViewName("student");
        return mv;
    }

    @PostMapping("/student/choose_course")
    ModelAndView student_choose_course( Course course, User user){
        courseService.student_choose_course(course, user);
        List<SSCItem> sscItems = courseService.student_selected_courses(user);
        List<Course> courses = courseService.show_course();
        ModelAndView mv = new ModelAndView();
        mv.addObject("sscItems", sscItems);
        mv.addObject("user", user);
        mv.addObject("courses", courses);
        mv.setViewName("student");
        return mv;
    }

    @PostMapping("/student/cancel_course")
    ModelAndView student_cancel_course( Course course,  User user){
        SSCItem sscItem = new SSCItem();
        sscItem.setValue(course,user);
        courseService.student_cancel_course(sscItem);
        List<SSCItem> sscItems = courseService.student_selected_courses(user);
        List<Course> courses = courseService.show_course();
        ModelAndView mv = new ModelAndView();
        mv.addObject("sscItems", sscItems);
        mv.addObject("user", user);
        mv.addObject("courses", courses);
        mv.setViewName("student");
        return mv;

    }

    //-----------------------------------teacher------------------------------------------------------------

    @PostMapping("/teacher/teach_course")
    ModelAndView teacher_teach_course( Course course,  User user){
        courseService.teacher_teach_course(course, user);
        List<Course> teacher_teached_courses = courseService.show_teacher_teached_course(user);
        List<Course> teacher_unteached_courses = courseService.show_teacher_unteached_course();
        ModelAndView mv = new ModelAndView();
        mv.addObject("courses1", teacher_teached_courses);
        mv.addObject("courses2", teacher_unteached_courses);
        mv.addObject("user", user);
        mv.setViewName("teacher");
        return mv;
    }

    @PostMapping("/teacher/cancel_course")
    ModelAndView teacher_cancel_course(Course course,  User user){
        courseService.teacher_cancel_course(course);
        List<Course> teacher_teached_courses = courseService.show_teacher_teached_course(user);
        List<Course> teacher_unteached_courses = courseService.show_teacher_unteached_course();
        ModelAndView mv = new ModelAndView();
        mv.addObject("courses1", teacher_teached_courses);
        mv.addObject("courses2", teacher_unteached_courses);
        mv.addObject("user", user);
        mv.setViewName("teacher");
        return mv;
    }





    //-----------------------------------administrator------------------------------------------------------------
    @PostMapping("/administrator/add_course")
    ModelAndView administrator_add_course( Course course, User user){
        courseService.administrator_add_course(course);
        List<Course> courses = courseService.show_course();
        ModelAndView mv = new ModelAndView();
        mv.addObject("courses", courses);
        mv.addObject("user", user);
        mv.setViewName("administrator");
        return mv;


    }

    @PostMapping("/administrator/delete_course")
    ModelAndView administrator_delete_course( Course course, User user){
        courseService.administrator_delete_course(course);
        List<Course> courses = courseService.show_course();
        ModelAndView mv = new ModelAndView();
        mv.addObject("courses", courses);
        mv.addObject("user", user);
        mv.setViewName("administrator");
        return mv;

    }

    @PostMapping("/administrator/update_course")
    ModelAndView administrator_update_course(Course course, User user){
        courseService.administrator_update_course(course);
        List<Course> courses = courseService.show_course();
        ModelAndView mv = new ModelAndView();
        mv.addObject("courses", courses);
        mv.addObject("user", user);
        mv.setViewName("administrator");
        return mv;
    }




}