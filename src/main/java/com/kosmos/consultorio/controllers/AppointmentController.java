package com.kosmos.consultorio.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kosmos.consultorio.dto.AppointmentDto;
import com.kosmos.consultorio.models.Appointment;
import com.kosmos.consultorio.services.AppointmentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    
    final private AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public ResponseEntity<Appointment> createAppointment(@RequestBody @Valid AppointmentDto appointmentDto) {
        return new ResponseEntity<>(appointmentService.save(appointmentDto), HttpStatus.CREATED);
    }

}
