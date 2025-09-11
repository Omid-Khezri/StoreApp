package com.storeapp.util;

import com.storeapp.config.JwtUtil;

import java.util.Map;

public class TestJwt {
    public static void main(String[]args) {
        String token = JwtUtil.generatetoken(
                "admin@store.com",
                Map.of("role", "ADMIN")
        );
        System.out.println("Generated JWT Token");
        System.out.println(token);
    }
}
