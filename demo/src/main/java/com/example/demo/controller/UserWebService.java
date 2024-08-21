package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserWebService {
    @Autowired
    UserService userService;



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
                mv.setViewName("administrator");
            } else if (user.getType().equals(1)) {
                mv.setViewName("teacher");
            } else if (user.getType().equals(0)) {
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

    @RequestMapping("/user/logout")
    public ModelAndView logOut() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

}
