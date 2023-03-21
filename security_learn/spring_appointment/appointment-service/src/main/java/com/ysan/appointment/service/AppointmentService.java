package com.ysan.appointment.service;

import com.ysan.appointment.client.CardMapper;
import com.ysan.appointment.client.DoctorMapper;
import com.ysan.appointment.domain.Appointment;

/**
 * @author Administrator
 * @description
 * @since 2023/3/20 13:07
 **/
public interface AppointmentService {
    DoctorMapper getDoctorById(Long doctorId);
    Appointment generateAppointment(Long doctorId, Long cardId);
    CardMapper getCard(String cardCode);
    DoctorMapper getDoctor(String doctorName);
    Appointment generateAppointment(String doctorName, String cardCode);

}
