package com.platform.dao;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

import com.platform.Entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	public Page<Role> findByRoleNameContains(String role, Pageable pageable);
}
