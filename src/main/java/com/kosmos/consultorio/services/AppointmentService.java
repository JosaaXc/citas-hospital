package com.kosmos.consultorio.services;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kosmos.consultorio.dto.AppointmentDto;
import com.kosmos.consultorio.exceptions.ResourceNotFoundException;
import com.kosmos.consultorio.models.Appointment;
import com.kosmos.consultorio.models.Doctor;
import com.kosmos.consultorio.models.Office;
import com.kosmos.consultorio.repositories.AppointmentRepository;
import com.kosmos.consultorio.repositories.DoctorRepository;
import com.kosmos.consultorio.repositories.OfficeRepository;

@Service
public class AppointmentService {
 
    final private AppointmentRepository appointmentRepository;
    final private DoctorRepository doctorRepository;
    final private OfficeRepository officeRepository;

    public AppointmentService(AppointmentRepository appointmentRepository, DoctorRepository doctorRepository, OfficeRepository officeRepository) {
        this.appointmentRepository = appointmentRepository;
        this.doctorRepository = doctorRepository;
        this.officeRepository = officeRepository;
    }

    
    public Appointment save(AppointmentDto appointmentDto) {

        Optional<Appointment> existingAppointment = appointmentRepository.findByDateAndTimeAndDoctorIdAndOfficeId(
            appointmentDto.getDate(), appointmentDto.getTime(), appointmentDto.getDoctorId(), appointmentDto.getOfficeId());

        if (existingAppointment.isPresent()) {
            throw new IllegalArgumentException("Ya existe una cita con el mismo doctor, consultorio, fecha y hora.");
        }

        Doctor doctor = doctorRepository.findById(appointmentDto.getDoctorId())
            .orElseThrow(() -> new ResourceNotFoundException("Doctor not found"));
        Office office = officeRepository.findById(appointmentDto.getOfficeId())
            .orElseThrow(() -> new ResourceNotFoundException("Office not found"));

        Appointment appointment = Appointment.builder()
            .doctor(doctor)
            .office(office)
            .patientName(appointmentDto.getPatientName())
            .date(appointmentDto.getDate())
            .time(appointmentDto.getTime())
            .build();

        return appointmentRepository.save(appointment);
    }
}
