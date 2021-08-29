package com.platform.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.platform.Entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
	public Page<Account> findByEmailContains(String email,Pageable pageable);
}
