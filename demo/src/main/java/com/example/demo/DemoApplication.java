package com.example.demo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
@MapperScan("com.example.demo.mapper")  // 指定Mapper接口所在的包
public class DemoApplication {

    public static void main(String[] args) {
            ApplicationContext context = SpringApplication.run(DemoApplication.class,args);
    }

}
