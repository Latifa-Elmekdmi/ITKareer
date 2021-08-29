package com.platform.dao;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

import com.platform.Entity.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
	public Page<Invoice> findByOwnerContains(String name, Pageable pageable);
}
