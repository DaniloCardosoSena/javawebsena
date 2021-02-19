package com.spring.javawebsena;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class JavawebsenaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavawebsenaApplication.class, args);
	//	System.out.print(new BCryptPasswordEncoder().encode("123")); Print Terminal Senha Criptografada
	}
}