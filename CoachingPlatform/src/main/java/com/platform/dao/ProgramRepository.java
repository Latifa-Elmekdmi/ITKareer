package com.platform.dao;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

import com.platform.Entity.Program;

public interface ProgramRepository extends JpaRepository<Program, Long> {
	public Page<Program> findByProgramNameContains(String programName, Pageable pageable);
}
