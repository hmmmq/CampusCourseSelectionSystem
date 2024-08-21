package com.example.demo.entity;

public class BorrowItem {
    private Integer idborrowitem;

    private Integer userid;

    private Integer bookid;

    private String borrowdate;

    private String username;

    private String bookname;

    private String bookdescription;

    private Integer amount;

    private Integer isReturned;

    private Integer parentid;

    public Integer getIdborrowitem() {
        return idborrowitem;
    }

    public void setIdborrowitem(Integer idborrowitem) {
        this.idborrowitem = idborrowitem;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
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

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getBookdescription() {
        return bookdescription;
    }

    public void setBookdescription(String bookdescription) {
        this.bookdescription = bookdescription;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getIsReturned() {
        return isReturned;
    }

    public void setIsReturned(Integer isReturned) {
        this.isReturned = isReturned;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    @Override
    public String toString() {
        String returnornot = isReturned==0?"否":"是";
        return "借阅条目{" +
                "用户id=" + userid +
                ", 图书id=" + bookid +
                ", 借阅时间='" + borrowdate + '\'' +
                ", 用户名='" + username + '\'' +
                ", 书名='" + bookname + '\'' +
                ", 详情='" + bookdescription + '\'' +
                ", 数量=" + amount +
                ", 是否归还=" + returnornot +
                '}';
    }
}