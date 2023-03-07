package com.example.demo.services;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Account;
import com.example.demo.repositories.AccountRepository;

import jakarta.transaction.Transactional;

@Service
public class AccountServiceImpl implements AccountService {
	private AccountRepository accountRepository;

	public AccountServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Override
	public void withdrawMoney(BigDecimal amount, Long id) {
		Optional<Account> account = this.accountRepository.findById(id);

		if (account.isEmpty()) {
			throw new RuntimeException("Account does not exist");
		}

		BigDecimal current = account.get().getBalance();

		if (amount.compareTo(current) > 0) {
			throw new RuntimeException("Cannot withdraw");
		}

		account.get().setBalance(current.subtract(amount));
		this.accountRepository.save(account.get());
	}

	@Override
	public void depositMoney(BigDecimal amount, Long id) {
		Account account = this.accountRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Sorry no account"));

		BigDecimal balance = account.getBalance().add(amount);
		account.setBalance(balance);

		this.accountRepository.save(account);
	}

	@Override
	@Transactional
	public void transferMoney(Long accountFrom, Long accountTo, BigDecimal amount) {
		withdrawMoney(amount, accountFrom);
		depositMoney(amount, accountTo);
	}

}