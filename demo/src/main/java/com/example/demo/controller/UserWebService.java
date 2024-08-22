package com.example.demo.controller;

import com.example.demo.entity.Course;
import com.example.demo.entity.SSCItem;
import com.example.demo.entity.User;
import com.example.demo.service.CourseService;
import com.example.demo.service.UserService;
import com.example.demo.util.IdCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
public class UserWebService {
    @Autowired
    UserService userService;
    @Autowired
    CourseService courseService;

    @PostMapping("/user/register_user")
    public ModelAndView register_user(User user) {

        ModelAndView mv = new ModelAndView();

        userService.register(user);

        mv.setViewName("index");

        return mv;

    }

    @PostMapping("/user/login")
    public ModelAndView login(User user) {
        ModelAndView mv = new ModelAndView();
        boolean login = userService.login(user);
        if (!login) {
            mv.setViewName("index");
        } else {
            mv.addObject(user);
            if (user.getType().equals(2)) {
                List<Course> courses = courseService.show_course();
                mv.addObject("courses", courses);
                mv.addObject("user", user);
                mv.setViewName("administrator");
            } else if (user.getType().equals(1)) {
                List<Course> teacher_teached_courses = courseService.show_teacher_teached_course(user);
                List<Course> teacher_unteached_courses = courseService.show_teacher_unteached_course();
                List<SSCItem> sscItems = courseService.selectByTeacherId(user.getId());
                mv.addObject("courses1", teacher_teached_courses);
                mv.addObject("courses2", teacher_unteached_courses);
                mv.addObject("user", user);
                mv.addObject("sscItems",sscItems);
                mv.setViewName("teacher");
            } else if (user.getType().equals(0)) {
                List<SSCItem> sscItems = courseService.student_selected_courses(user);
                List<Course> courses = courseService.show_student_unselected_courses(user.getId());
                mv.addObject("sscItems", sscItems);
                mv.addObject("user", user);
                mv.addObject("courses", courses);
                mv.setViewName("student");
            }
        }
        return mv;

    }

    @RequestMapping("/index")
    public ModelAndView getIndex() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    @PostMapping("/user/logout")
    public ModelAndView logOut() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

}
