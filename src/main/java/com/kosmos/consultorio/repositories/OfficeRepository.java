package com.kosmos.consultorio.repositories;

import org.springframework.data.repository.CrudRepository;

import com.kosmos.consultorio.models.Office;

public interface OfficeRepository extends CrudRepository<Office, Long> {
    
}
