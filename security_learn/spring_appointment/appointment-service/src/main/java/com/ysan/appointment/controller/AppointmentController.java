package com.ysan.appointment.controller;

import com.ysan.appointment.client.DoctorMapper;
import com.ysan.appointment.domain.Appointment;
import com.ysan.appointment.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="appointments")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @GetMapping(value="/doctors/{doctorId}")
    public DoctorMapper getDoctorById(@PathVariable("doctorId") Long doctorId) {
        return appointmentService.getDoctorById(doctorId);
    }

//    @PostMapping(value="/{doctorId}/{cardId}")
//    public Appointment addAppointment(@PathVariable("doctorId") Long doctorId, @PathVariable("cardId") Long cardId) {
//
//        return appointmentService.generateAppointment(doctorId, cardId);
//    }

    @PostMapping(value="/{doctorName}/{cardCode}")
    public Appointment addAppointment(@PathVariable("doctorName") String doctorName, @PathVariable("cardCode") String cardCode) {

        return appointmentService.generateAppointment(doctorName, cardCode);
    }
}
