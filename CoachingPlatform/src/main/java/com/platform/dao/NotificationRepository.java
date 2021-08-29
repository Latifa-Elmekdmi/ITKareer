package com.platform.dao;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

import com.platform.Entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
	public Page<Notification> findByNotificationTitleContains(String notificationName, Pageable pageable);
}
