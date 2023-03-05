package com.example.demo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.example.demo.services.AccountService;
import com.example.demo.services.UserService;

import jakarta.transaction.Transactional;

@Component
public class ConsoleRunner implements CommandLineRunner {

	@Autowired
	private UserService userService;

	@Autowired
	private AccountService accountService;

	public ConsoleRunner(UserService userService) {
		this.userService = userService;
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		this.userService.register("NewUser", 21);
		this.accountService.transferMoney(2L, 1L, BigDecimal.TEN);

	}

}
