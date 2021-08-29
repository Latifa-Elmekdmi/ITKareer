package com.platform.dao;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

import com.platform.Entity.Command;

public interface CommandRepository extends JpaRepository<Command, Long> {
	public Page<Command> findByCommandIdContains(Long commandId, Pageable pageable);
}
