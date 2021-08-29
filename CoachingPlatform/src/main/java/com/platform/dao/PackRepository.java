package com.platform.dao;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

import com.platform.Entity.Pack;

public interface PackRepository extends JpaRepository<Pack, Long> {
	public Page<Pack> findByPackageNameContains(String packName, Pageable pageable);
}
