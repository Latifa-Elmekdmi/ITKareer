package com.platform.dao;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

import com.platform.Entity.Resource;

public interface ResourceRepository extends JpaRepository<Resource, Long> {
	public Page<Resource> findByResourceNameContains(String nameResource, Pageable pageable);
}
