package com.kosmos.consultorio.services;

import org.springframework.stereotype.Service;

import com.kosmos.consultorio.dto.OfficeDto;
import com.kosmos.consultorio.models.Office;
import com.kosmos.consultorio.repositories.OfficeRepository;

@Service
public class OfficeService {
    
    final private OfficeRepository officeRepository;

    public OfficeService(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

    public Office save(OfficeDto officeDto) {
        Office office = Office.builder()
            .roomNumber(officeDto.getRoomNumber())
            .floor(officeDto.getFloor())
            .build();
        return officeRepository.save(office);
    }

}
