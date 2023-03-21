package com.ysan.doctor.service.impl;

import com.ysan.doctor.domain.Doctor;
import com.ysan.doctor.repository.DoctorRepository;
import com.ysan.doctor.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * @description
 * @since 2023/3/20 13:22
 **/

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;


    @Override
    public Doctor getDoctorById(Long userId) {
        return doctorRepository.findById(userId).orElse(null);
    }

    @Override
    public Doctor getDoctorByDoctorName(String doctorName) {
        return doctorRepository.findDoctorByDoctorName(doctorName);
    }

    @Override
    public void addDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    @Override
    public void updateDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    @Override
    public void deleteDoctor(Doctor doctor) {
        doctorRepository.delete(doctor);
    }
}
