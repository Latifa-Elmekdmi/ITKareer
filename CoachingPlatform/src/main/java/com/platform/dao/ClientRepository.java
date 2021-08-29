package com.platform.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.platform.Entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
	public Page<Client> findBylastNameContains(String lastName, Pageable pageable);
	
}
