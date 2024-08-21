package com.example.demo.entity;

import com.example.demo.util.DateCalculator;

public class SSCItem {
    private Integer id;

    private Integer studentid;

    private String studentnumber;

    private String studentname;

    private String teachername;

    private Integer courseid;

    private String coursename;

    private String coursetime;

    private String position;

    private String selecttime;

    private Integer teacherid;

    private String teachernumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public String getStudentnumber() {
        return studentnumber;
    }

    public void setStudentnumber(String studentnumber) {
        this.studentnumber = studentnumber;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getCoursetime() {
        return coursetime;
    }

    public void setCoursetime(String coursetime) {
        this.coursetime = coursetime;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSelecttime() {
        return selecttime;
    }

    public void setSelecttime(String selecttime) {
        this.selecttime = selecttime;
    }

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

    public String getTeachernumber() {
        return teachernumber;
    }

    public void setTeachernumber(String teachernumber) {
        this.teachernumber = teachernumber;
    }

    public void setValue(Course course, User user) {
        this.setCourseid(course.getId());
        this.setCoursename(course.getCoursename());
        this.setCoursetime(course.getTime());
        this.setTeacherid(course.getTeacherid());
        this.setTeachername(course.getTeachername());
        this.setTeachernumber(course.getTeachernumber());
        this.setStudentid(user.getId());
        this.setStudentname(user.getName());
        this.setStudentnumber(user.getNumber());
        this.setPosition(course.getClassroom());
        this.setSelecttime(DateCalculator.calculateDate());
    }
}