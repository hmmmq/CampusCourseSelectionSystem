package com.example.demo.util;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
@Component
public class IdCalculator {

    public static int calculateUserId(String string1, String string2) {
        String input = string1 + string2;
        try {
            // 使用 SHA-256 算法进行哈希计算
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(input.getBytes());

            // 将哈希字节数组转换为十六进制字符串
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            // 取前 8 字节的十六进制字符串并将其转换为 int
            String hashHex = hexString.toString().substring(0, 8);
            return Math.abs((int) Long.parseLong(hashHex, 16));

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new RuntimeException("Error calculating user ID", e);
        }
    }

    public static void main(String[] args) {
        String name = "exampleName";
        String password = "examplePassword";
        int userId = calculateUserId(name, password);
        System.out.println("User ID: " + userId);
    }
}
