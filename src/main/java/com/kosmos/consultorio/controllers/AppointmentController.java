package com.kosmos.consultorio.controllers;

import org.springframework.format.annotation.DateTimeFormat;
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

import java.time.LocalDate;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


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

    @GetMapping("/{doctorId}")
    public ResponseEntity<List<AppointmentDto>> getAppointmentsByDoctor(
            @PathVariable Long doctorId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestParam Long officeId) {
        System.out.println("DoctorId: " + doctorId + ", Date: " + date + ", OfficeId: " + officeId);
        List<AppointmentDto> appointments = appointmentService.getAppointmentsByDoctorAndDateAndOffice(
                doctorId, date, officeId);
        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }
}
