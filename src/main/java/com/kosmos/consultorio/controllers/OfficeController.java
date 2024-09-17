package com.kosmos.consultorio.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kosmos.consultorio.dto.OfficeDto;
import com.kosmos.consultorio.models.Office;
import com.kosmos.consultorio.services.OfficeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/offices")
public class OfficeController {

    final private OfficeService officeService;

    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @PostMapping
    public ResponseEntity<Office> save(@RequestBody @Valid OfficeDto officeDto) {
        return new ResponseEntity<>(officeService.save(officeDto), HttpStatus.CREATED);
    }

}
