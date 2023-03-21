package com.ysan.doctor.service;

import com.ysan.doctor.domain.Doctor;

/**
 * @author Administrator
 * @description
 * @since 2023/3/20 13:21
 **/
 public interface DoctorService {

     Doctor getDoctorById(Long userId);

     Doctor getDoctorByDoctorName(String doctorName);

     void addDoctor(Doctor doctor);

     void updateDoctor(Doctor doctor);

     void deleteDoctor(Doctor doctor);
}
