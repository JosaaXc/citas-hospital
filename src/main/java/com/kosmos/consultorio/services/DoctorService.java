package com.kosmos.consultorio.services;

import org.springframework.stereotype.Service;

import com.kosmos.consultorio.dto.DoctorDto;
import com.kosmos.consultorio.models.Doctor;
import com.kosmos.consultorio.repositories.DoctorRepository;

@Service
public class DoctorService {

    final private DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public Doctor save(DoctorDto doctorDto) {
        
        Doctor doctor = Doctor.builder()
            .firstName(doctorDto.getFirstName())
            .paternalLastName(doctorDto.getPaternalLastName())
            .maternalLastName(doctorDto.getMaternalLastName())
            .specialty(doctorDto.getSpecialty())
            .build();
        return doctorRepository.save(doctor);

    }

    public Doctor findById(Long id) {
        return doctorRepository.findById(id).orElse(null);
    }

}
