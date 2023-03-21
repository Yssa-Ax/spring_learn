package com.ysan.security.service;

import java.util.List;

import com.ysan.security.domain.HealthRecord;
import com.ysan.security.repository.HealthRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class HealthRecordService {

    @Autowired
    private HealthRecordRepository healthRecordRepository;

    public List<HealthRecord> getHealthRecordsByUsername(String userName) {
    	
        return healthRecordRepository.getHealthRecordsByUsername(userName);
    }
}
