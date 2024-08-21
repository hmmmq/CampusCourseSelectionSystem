package com.example.demo.entity;

public class Borrow {
    private Integer idborrow;

    private Integer totalamount;

    private String borrowdate;

    private String username;

    private Integer userid;

    public Integer getIdborrow() {
        return idborrow;
    }

    public void setIdborrow(Integer idborrow) {
        this.idborrow = idborrow;
    }

    public Integer getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(Integer totalamount) {
        this.totalamount = totalamount;
    }

    public String getBorrowdate() {
        return borrowdate;
    }

    public void setBorrowdate(String borrowdate) {
        this.borrowdate = borrowdate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}