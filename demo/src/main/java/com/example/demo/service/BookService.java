package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.mapper.BookMapper;
import com.example.demo.mapper.BorrowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookMapper bookMapper;


    public boolean addBook(Book book) {
        int i = bookMapper.insert(book);
        if (i == -1) {
//            System.out.println("Book already exists");
            return false;
        } else {
//            System.out.println("Book added");
            return true;
        }
    }

    public boolean deleteBook(int id) {
        int i = bookMapper.deleteByPrimaryKey(id);
        if (i == -1) {
//            System.out.println("Book not found");
            return false;
        } else {
//            System.out.println("Book deleted");
            return true;
        }
    }

    public void updateBook(Book book) {
        bookMapper.updateByPrimaryKey(book);
//        System.out.println("Book updated");
    }

    public Book getBook(int id) {
        Book book = bookMapper.selectByPrimaryKey(id);
//        if (book == null) {
//            System.out.println("Book not found");
//        } else {
//            System.out.println("Book found");
//        }
        return book;
    }

    public List<Book> getAllBooks() {

        return bookMapper.selectAll();
    }

}