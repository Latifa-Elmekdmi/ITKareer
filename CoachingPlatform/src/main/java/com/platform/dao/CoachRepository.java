package com.platform.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.platform.Entity.Coach;

public interface CoachRepository extends JpaRepository<Coach, Long>{
	public Page<Coach> findByfirstNameContains(String lastName, Pageable pageable);

}
