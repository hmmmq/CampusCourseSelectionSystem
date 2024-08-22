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


@Controller
public class CourseWebService {

    @Autowired
    CourseService courseService;

    //----------------------------------------common----------------------------------------------------------
    private static Course getCourse(String courseId, String courseName, String courseTime, String courseClassroom) {
        Course course = new Course();
        course.setId(Integer.parseInt(courseId));
        course.setCoursename(courseName);
        course.setTime(courseTime);
        course.setClassroom(courseClassroom);
        return course;
    }

    private static User getUser(int userId, String userName, String userNumber) {
        User user = new User();
        user.setId(userId);
        user.setName(userName);
        user.setNumber(userNumber);
        return user;
    }

    private static SSCItem getSscItem(String Id, Course course, User user) {
        SSCItem sscItem = new SSCItem();
        sscItem.setId(Integer.parseInt(Id));
        sscItem.setValue(course, user);
        return sscItem;
    }

    //-----------------------------------student------------------------------------------------------------

    @PostMapping("/student/choose_course")
    ModelAndView student_choose_course(
            @RequestParam("course.id") String courseId,
            @RequestParam("course.coursename") String courseName,
            @RequestParam("course.teacherid") String teacherId,
            @RequestParam("course.teachername") String teacherName,
            @RequestParam("course.teachernumber") String teacherNumber,
            @RequestParam("course.time") String courseTime,
            @RequestParam("course.classroom") String courseClassroom,
            @RequestParam("user.name") String userName,
            @RequestParam("user.number") String userNumber,
            @RequestParam("user.id") String userId

    ) {
        Course course = new Course();
        course.setId(Integer.valueOf(courseId));
        course.setCoursename(courseName);
        course.setTime(courseTime);
        course.setTeacherid(Integer.valueOf(teacherId));
        course.setTeachername(teacherName);
        course.setTeachernumber(teacherNumber);
        course.setClassroom(courseClassroom);
        User user = getUser(Integer.valueOf(userId), userName, userNumber);
        courseService.student_choose_course(course, user);
        ModelAndView mv = getStudentModelAndView(user);
        return mv;
    }

    @PostMapping("/student/cancel_course")
    ModelAndView student_cancel_course(@RequestParam("id") String Id,
                                       @RequestParam("user.id") String userId,
                                       @RequestParam("user.name") String userName,
                                       @RequestParam("user.number") String userNumber) {
        Course course = new Course();
        User user = getUser(Integer.parseInt(userId), userName, userNumber);
        SSCItem sscItem = getSscItem(Id, course, user);
        courseService.student_cancel_course(sscItem);
        ModelAndView mv = getStudentModelAndView(user);
        return mv;

    }


    private ModelAndView getStudentModelAndView(User user) {
        List<Course> courses = courseService.show_student_unselected_courses(user.getId());
        List<SSCItem> sscItems = courseService.student_selected_courses(user);
        ModelAndView mv = new ModelAndView();
        mv.addObject("sscItems", sscItems);
        mv.addObject("user", user);
        mv.addObject("courses", courses);
        mv.setViewName("student");
        return mv;
    }

    //-----------------------------------teacher------------------------------------------------------------

    @PostMapping("/teacher/teach_course")
    ModelAndView teacher_teach_course(@RequestParam("course.id") String courseId,
                                      @RequestParam("course.coursename") String courseName,
                                      @RequestParam("course.time") String courseTime,
                                      @RequestParam("course.classroom") String courseClassroom,
                                      @RequestParam("user.id") String userId,
                                      @RequestParam("user.name") String userName,
                                      @RequestParam("user.number") String userNumber) {
        Course course = getCourse(courseId, courseName, courseTime, courseClassroom);
        User user = getUser(Integer.parseInt(userId), userName, userNumber);
        courseService.teacher_teach_course(course, user);
        ModelAndView mv = getTeacherModelAndView(user);
        return mv;
    }


    @PostMapping("/teacher/cancel_course")
    ModelAndView teacher_cancel_course(@RequestParam("course.id") String courseId,
                                       @RequestParam("course.coursename") String courseName,
                                       @RequestParam("course.time") String courseTime,
                                       @RequestParam("course.classroom") String courseClassroom,
                                       @RequestParam("user.id") String userId,
                                       @RequestParam("user.name") String userName,
                                       @RequestParam("user.number") String userNumber) {
        Course course = getCourse(courseId, courseName, courseTime, courseClassroom);
        User user = getUser(Integer.parseInt(userId), userName, userNumber);

        courseService.teacher_cancel_course(course);
        ModelAndView mv = getTeacherModelAndView(user);
        return mv;
    }


    @PostMapping("/teacher/grade")
    ModelAndView teacher_grade() {
        ModelAndView mv = new ModelAndView();
        return mv;
    }

    private ModelAndView getTeacherModelAndView(User user) {
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
    ModelAndView administrator_add_course(@RequestParam("course.id") String courseId,
                                          @RequestParam("course.coursename") String courseName,
                                          @RequestParam("course.time") String courseTime,
                                          @RequestParam("course.classroom") String courseClassroom,
                                          @RequestParam("user.id") String userId,
                                          @RequestParam("user.name") String userName,
                                          @RequestParam("user.number") String userNumber) {

        Course course = getCourse(courseId, courseName, courseTime, courseClassroom);
        User user = getUser(Integer.parseInt(userId), userName, userNumber);
        courseService.administrator_add_course(course);
        ModelAndView mv = getAdminModelAndView(user);
        return mv;
    }


    @PostMapping("/administrator/delete_course")
    ModelAndView administrator_delete_course(@RequestParam("course.id") String courseId,
                                             @RequestParam("course.coursename") String courseName,
                                             @RequestParam("course.time") String courseTime,
                                             @RequestParam("course.classroom") String courseClassroom,
                                             @RequestParam("user.id") String userId,
                                             @RequestParam("user.name") String userName,
                                             @RequestParam("user.number") String userNumber) {
        Course course = getCourse(courseId, courseName, courseTime, courseClassroom);
        User user = getUser(Integer.parseInt(userId), userName, userNumber);
        courseService.administrator_delete_course(course);
        ModelAndView mv = getAdminModelAndView(user);
        return mv;
    }


    @PostMapping("/administrator/update_course")
    ModelAndView administrator_update_course(@RequestParam("course.id") String courseId,
                                             @RequestParam("course.coursename") String courseName,
                                             @RequestParam("course.time") String courseTime,
                                             @RequestParam("course.classroom") String courseClassroom,
                                             @RequestParam("user.id") String userId,
                                             @RequestParam("user.name") String userName,
                                             @RequestParam("user.number") String userNumber) {
        Course course = getCourse(courseId, courseName, courseTime, courseClassroom);
        User user = getUser(Integer.parseInt(userId), userName, userNumber);
        courseService.administrator_update_course(course);
        ModelAndView mv = getAdminModelAndView(user);
        return mv;
    }

    private ModelAndView getAdminModelAndView(User user) {
        List<Course> courses = courseService.show_course();
        ModelAndView mv = new ModelAndView();
        mv.addObject("courses", courses);
        mv.addObject("user", user);
        mv.setViewName("administrator");
        return mv;
    }
}