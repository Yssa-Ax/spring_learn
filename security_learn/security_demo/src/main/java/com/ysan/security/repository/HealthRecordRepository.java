package com.ysan.security.repository;

import java.util.List;

import com.ysan.security.domain.HealthRecord;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HealthRecordRepository extends JpaRepository<HealthRecord, Integer> {

	List<HealthRecord> getHealthRecordsByUsername(String username);
}
