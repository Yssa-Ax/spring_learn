package com.ysan.doctor.repository;

import com.ysan.doctor.domain.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Long>  {

	Doctor findDoctorByDoctorName(String doctorName);
}
