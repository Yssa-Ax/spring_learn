package com.ysan.appointment.service.impl;

import com.ysan.appointment.client.CardMapper;
import com.ysan.appointment.client.CardRestTemplateClient;
import com.ysan.appointment.client.DoctorMapper;
import com.ysan.appointment.client.DoctorRestTemplateClient;
import com.ysan.appointment.config.AppointmentConfig2;
import com.ysan.appointment.domain.Appointment;
import com.ysan.appointment.repository.AppointmentRepository;
import com.ysan.appointment.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Administrator
 * @description
 * @since 2023/3/20 13:10
 **/
@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    DoctorRestTemplateClient doctorRestTemplateClient;

    @Autowired
    CardRestTemplateClient cardRestTemplateClient;

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    AppointmentConfig2 appointmentConfig2;


    //    @HystrixCommand(
//            threadPoolKey = "getDoctor",
//            threadPoolProperties = {
//                    @HystrixProperty(name="maxQueueSize", value="10"),
//                    @HystrixProperty(name="coreSize", value="2")
//            },commandProperties = {
//                    @HystrixProperty(name="execution.isolation.strategy", value="THREAD")
//            , @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="3000")
//            }, fallbackMethod = "getDoctorByIdFallback"
//    )
//    @CircuitBreaker(name = "appointmentService", fallbackMethod = "getDoctorByIdFallback")
    public DoctorMapper getDoctorById(Long doctorId) {

//        //模拟远程调用超时的场景
//        try{
//            Thread.sleep(2000);
//        } catch(InterruptedException ex) {
//            ex.printStackTrace();
//        }

        return doctorRestTemplateClient.getDoctorById(doctorId);
    }

    //resilience4j的Fallback方法的输入参数需要添加额外的exception参数
//    public DoctorMapper getDoctorByIdFallback(Long doctorId, Throwable t) {
//        return new DoctorMapper(10000L, "FallbackCode", "FallbackName");
//    }

//    public DoctorMapper getDoctorByIdFallback(Long doctorId) {
//        return new DoctorMapper(10000L, "FallbackCode", "FallbackName");
//    }



    public Appointment generateAppointment(Long doctorId, Long cardId) {

        Appointment appointment = new Appointment();
        appointment.setDoctorId(doctorId);
        appointment.setCardId(cardId);
        appointment.setRemark(appointmentConfig2.getRemark());
        appointment.setCreateTime(new Date());

        appointmentRepository.save(appointment);

        return appointment;
    }


    public CardMapper getCard(String cardCode) {

        return cardRestTemplateClient.getCardByCardCode(cardCode);
    }

    public DoctorMapper getDoctor(String doctorName) {

        return doctorRestTemplateClient.getDoctorByDoctorName(doctorName);
    }

    public Appointment generateAppointment(String doctorName, String cardCode) {

        Appointment appointment = new Appointment();

        //获取远程Card信息
        CardMapper card = getCard(cardCode);
        if (card == null) {
            return appointment;
        }

        //获取远程Doctor信息
        DoctorMapper doctor = getDoctor(doctorName);
        if (doctor == null) {
            return appointment;
        }

        appointment.setDoctorId(doctor.getId());
        appointment.setCardId(card.getId());
        appointment.setRemark(appointmentConfig2.getRemark());
        appointment.setCreateTime(new Date());

        appointmentRepository.save(appointment);

        return appointment;
    }
}
