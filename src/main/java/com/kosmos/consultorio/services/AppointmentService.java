package com.kosmos.consultorio.services;

import org.springframework.stereotype.Service;

import com.kosmos.consultorio.models.Appointment;
import com.kosmos.consultorio.repositories.AppointmentRepository;

@Service
public class AppointmentService {
 
    final private AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

}
