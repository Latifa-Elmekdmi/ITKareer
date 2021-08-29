package com.platform.dao;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

import com.platform.Entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	public Page<User> findByLastNameContains(String lastName, Pageable pageable);
}
