package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.entity.Borrow;
import com.example.demo.entity.BorrowItem;
import com.example.demo.entity.User;
import com.example.demo.mapper.BorrowItemMapper;
import com.example.demo.mapper.BorrowMapper;
import com.example.demo.util.DateCalculator;
import com.example.demo.util.IdCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BorrowService {
    @Autowired
    BorrowMapper borrowMapper;
    @Autowired
    BorrowItemMapper borrowItemMapper;
    @Autowired
    IdCalculator IdCalculator;
    @Autowired
    DateCalculator dateCalculator;
    @Autowired
    BookService bookService;

    public void borrowBook(User user, List<Book> books) {
        Borrow borrow = new Borrow();
        borrow.setUserid(user.getIduser());
        borrow.setUsername(user.getName());
        String date = dateCalculator.calculateDate();
        borrow.setBorrowdate(date);
        borrow.setIdborrow(IdCalculator.calculateUserId(user.getName(), date));
        borrow.setTotalamount(0);
        borrowMapper.insert(borrow);
        int total_amount = 0;
        for (Book b : books) {
            BorrowItem borrowItem = new BorrowItem();
            borrowItem.setIdborrowitem(IdCalculator.calculateUserId(String.valueOf(borrow.getIdborrow()), String.valueOf(b.getIdbook())));
            borrowItem.setBookid(b.getIdbook());
            borrowItem.setBookname(b.getBookname());
            borrowItem.setBookdescription(b.getDescription());
            borrowItem.setAmount(1);
            borrowItem.setBookdescription(b.getDescription());
            borrowItem.setParentid(borrow.getIdborrow());
            borrowItem.setUsername(user.getName());
            borrowItem.setUserid(user.getIduser());
            borrowItem.setBorrowdate(date);
            borrowItem.setIsReturned(0);
            borrowItem.setParentid(borrow.getIdborrow());
            borrowItemMapper.insert(borrowItem);
            total_amount+= 1;
            b.setAmount(b.getAmount()-1);
            bookService.updateBook(b);
        }
        borrow.setTotalamount(total_amount);
        borrowMapper.updateByPrimaryKey(borrow);
        System.out.println("借阅成功");

        checkBorrow(user);
    }
    public void returnBook(User user,List<Book> books){
        HashMap<Integer,Integer> bookHashMap = new HashMap<>();
        for(Book book:books){
            bookHashMap.put(book.getIdbook(), bookHashMap.getOrDefault(book.getIdbook(),0)+1);
        }

        List<BorrowItem> borrowItems = borrowItemMapper.selectAll();
        for(BorrowItem borrowItem:borrowItems){
            if(borrowItem.getUserid().equals(user.getIduser())){
                    if(bookHashMap.containsKey(borrowItem.getBookid())&&borrowItem.getIsReturned().equals(0)){
                        borrowItem.setIsReturned(1);
                        borrowItemMapper.updateByPrimaryKey(borrowItem);
                        Borrow borrow = borrowMapper.selectByPrimaryKey(borrowItem.getParentid());
                        borrow.setTotalamount(borrow.getTotalamount()-1);
                        borrowMapper.updateByPrimaryKey(borrow);
                        Book book = bookService.getBook(borrowItem.getBookid());
                        book.setAmount(book.getAmount()+1);
                        bookService.updateBook(book);
                        bookHashMap.put(borrowItem.getBookid(),bookHashMap.get(borrowItem.getBookid())-1);
                        if (bookHashMap.get(borrowItem.getBookid())==0){
                            bookHashMap.remove(borrowItem.getBookid());
                        }
                        if (bookHashMap.isEmpty()){
                            break;
                        }
                    }
            }
        }

        System.out.println("归还成功");
        checkBorrow(user);
    }
    public void checkBorrow(User user){
        List<BorrowItem> borrowItems = borrowItemMapper.selectAll();
        System.out.println("你当前借阅的书籍:");
        for(BorrowItem borrowItem:borrowItems){
            if(borrowItem.getUserid().equals(user.getIduser())){
                System.out.println(borrowItem.toString());
            }
        }

    }

}

