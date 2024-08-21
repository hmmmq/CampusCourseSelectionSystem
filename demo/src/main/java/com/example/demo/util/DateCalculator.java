package com.example.demo.util;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Component
public class DateCalculator {
    public String calculateDate() {
        LocalDate today = LocalDate.now();
        LocalDateTime now = LocalDateTime.now();
        return now.toString();// 默认格式: yyyy-MM-dd
    }

}
