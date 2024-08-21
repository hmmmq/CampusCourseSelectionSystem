package com.example.demo;
import com.example.demo.service.*;
import com.example.demo.entity.Book;
import com.example.demo.entity.User;
import com.example.demo.util.IdCalculator;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SpringBootApplication
@MapperScan("com.example.demo.mapper")  // 指定Mapper接口所在的包
public class DemoApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
       UserService userService = context.getBean(UserService.class);

        boolean login_flag = false;
        User user = new User();
        while (!login_flag) {
            System.out.println("欢迎来到图书管理系统");
            System.out.println("1.用户登录");
            System.out.println("2.用户注册");
            System.out.println("3.退出");
            System.out.println("请输入你的选择：");
            IdCalculator userIdCalculator = new IdCalculator();
            // 读取用户输入
            java.util.Scanner scanner = new java.util.Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("请输入用户名和密码：");
                    String name = scanner.next();
                    String password = scanner.next();
                    System.out.println("用户登录");
                    // 调用UserService的login方法
                    user.setName(name);
                    user.setPassword(password);
                    user.setIduser(userIdCalculator.calculateUserId(name, password));
                    boolean result = userService.login(user);
                    if (result) {
                        login_flag = true;
                        System.out.println("登录成功");
                    } else {
                        System.out.println("登录失败");
                    }

                    break;
                case 2:
                    System.out.println("用户注册");
                    System.out.println("请输入用户名和密码：");
                    name = scanner.next();
                    password = scanner.next();
                    user.setName(name);
                    user.setPassword(password);
                    System.out.println("是否为管理员？输入数字(1.是 0.否)");
                    int admin = scanner.nextInt();
                    //检验admin是不是0或1
                    while (admin != 0 && admin != 1) {
                        System.out.println("输入错误，请重新输入");
                        admin = scanner.nextInt();
                    }
                    user.setAdmin(admin);
                    user.setIduser(userIdCalculator.calculateUserId(name, password));
                    login_flag = userService.register(user);
                    if (login_flag) {
                        System.out.println("注册成功");
                    } else {
                        System.out.println("注册失败,用户已存在");
                    }
                    break;
                case 3:
                    System.out.println("退出");
                    break;
                default:
                    System.out.println("输入错误");
            }
        }
        if(user.getAdmin().equals(0)){

        BookService bookService = context.getBean(BookService.class);
        BorrowService borrowService = context.getBean(BorrowService.class);
        List<Book> booklist = bookService.getAllBooks();
        HashMap<Integer,Book> booklist2 = new HashMap<>();
        for (Book book : booklist) {
            booklist2.put(book.getIdbook(),book);
        }

        while(true) {
            System.out.println("成功登录图书管理系统");
            System.out.println("1.查看图书");
            System.out.println("2.借阅图书");
            System.out.println("3.归还图书");
            System.out.println("4.退出");
            System.out.println("请输入你的选择：");
            // 读取用户输入
            java.util.Scanner scanner = new java.util.Scanner(System.in);
            int choice = scanner.nextInt();
            booklist = bookService.getAllBooks();//更新图书列表
            booklist2 = new HashMap<>();
            for (Book book : booklist) {
                booklist2.put(book.getIdbook(),book);
            }

            switch (choice) {
                case 1:
                    System.out.println("查看图书列表");
                    for (Book book : booklist) {
                        System.out.println("图书编号：" + book.getIdbook() + " 书名：" + book.getBookname() + " 详情：" + book.getDescription()
                        + " 数量：" + book.getAmount() );
                    }
                    break;
                case 2:
                    System.out.println("借阅图书");
                    System.out.println("请输入要借阅的图书编号：用分号分割");
                    String[] bookIds = scanner.next().split(";");
                    List<Book> books = new ArrayList<>();
                    for (String bookId : bookIds) {
                        books.add(booklist2.get(Integer.parseInt(bookId)));
                    }
                    borrowService.borrowBook(user, books);
                    break;
                case 3:
                    System.out.println("归还图书");
                    borrowService.checkBorrow(user);
                    System.out.println("请输入要归还的图书编号：用分号分割");
                    String[] bookIds2 = scanner.next().split(";");
                    List<Book> books2 = new ArrayList<>();
                    for (String bookId : bookIds2) {
                        System.out.println(bookId);
                        books2.add(booklist2.get(Integer.parseInt(bookId)));
                    }
                    borrowService.returnBook(user, books2);
                    break;
                case 4:
                    System.out.println("退出");
                    System.exit(0);
                    break;
                default:
                    System.out.println("输入错误");
            }

        }

        }else{
            //管理员
            BookService bookService = context.getBean(BookService.class);
            while(true) {
                System.out.println("成功登录图书管理系统");
                System.out.println("1.查看图书");
                System.out.println("2.添加图书");
                System.out.println("3.修改图书");
                System.out.println("4.删除图书");
                System.out.println("5.退出");
                System.out.println("请输入你的选择：");
                // 读取用户输入
                java.util.Scanner scanner = new java.util.Scanner(System.in);
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("查看图书列表");
                        List<Book> booklist = bookService.getAllBooks();
                        for (Book book : booklist) {
                            System.out.println("图书编号：" + book.getIdbook() + " 书名：" + book.getBookname() + " 详情：" + book.getDescription()
                                    + " 数量：" + book.getAmount() );
                        }
                        break;
                    case 2:
                        System.out.println("添加图书");
                        System.out.println("请输入要添加的图书名：");
                        String bookname = scanner.next();
                        System.out.println("请输入要添加的图书详情：");
                        String description = scanner.next();
                        System.out.println("请输入要添加的图书数量：");
                        int amount = scanner.nextInt();
                        Book book = new Book();
                        book.setBookname(bookname);
                        book.setDescription(description);
                        book.setAmount(amount);
                        bookService.addBook(book);
                        break;
                    case 3:
                        System.out.println("修改图书");
                        System.out.println("请输入要修改的图书编号：");
                        int idbook2 = scanner.nextInt();
                        System.out.println("请输入修改后的图书名：");
                        String bookname2 = scanner.next();
                        System.out.println("请输入修改后的图书详情：");
                        String description2 = scanner.next();
                        System.out.println("请输入修改后的图书数量：");
                        int amount2 = scanner.nextInt();
                        Book book2 = new Book();
                        book2.setIdbook(idbook2);
                        book2.setBookname(bookname2);
                        book2.setDescription(description2);
                        book2.setAmount(amount2);
                        bookService.updateBook(book2);
                        break;
                    case 4:
                        System.out.println("删除图书");
                        System.out.println("请输入要删除的图书编号：");
                        int idbook = scanner.nextInt();
                        bookService.deleteBook(idbook);
                        break;
                    case 5:
                        System.out.println("退出");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("输入错误");
                }

            }
        }

    }

}
