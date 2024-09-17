package com.kosmos.consultorio.repositories;

import org.springframework.data.repository.CrudRepository;

import com.kosmos.consultorio.models.Doctor;

public interface DoctorRepository extends CrudRepository<Doctor, Long> {
    
}
