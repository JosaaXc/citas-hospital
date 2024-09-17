package com.kosmos.consultorio.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kosmos.consultorio.dto.DoctorDto;
import com.kosmos.consultorio.models.Doctor;
import com.kosmos.consultorio.services.DoctorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/doctors")
public class DoctorController {
    
    final private DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping
    public ResponseEntity<Doctor> createDoctor(@RequestBody @Valid DoctorDto doctorDto) {
        return new ResponseEntity<>(doctorService.save(doctorDto), HttpStatus.CREATED);
    }

    @GetMapping("{doctorId}/appointments")
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    
    
}
