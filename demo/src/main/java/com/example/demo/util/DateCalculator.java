package com.example.demo.util;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Component
public class DateCalculator {
    public static String calculateDate() {
        LocalDate today = LocalDate.now();
        LocalDateTime now = LocalDateTime.now();
        return now.toString();
    }

    public static void main(String[] args) {
        DateCalculator dateCalculator = new DateCalculator();
        String date = dateCalculator.calculateDate();
        System.out.println("Current date and time: " + date);
    }

}
