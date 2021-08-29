package com.platform.dao;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

import com.platform.Entity.Engagement;

public interface EngagementRepository extends JpaRepository<Engagement, Long> {
	public Page<Engagement> findByEngagemetnTitleContains(String engagementTitle, Pageable pageable);
}
