package com.kosmos.consultorio.repositories;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

import com.kosmos.consultorio.models.Appointment;
import com.kosmos.consultorio.models.Doctor;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
    List<Appointment> findByDoctorAndAppointmentDateTimeBetween( Doctor doctor, LocalDateTime start, LocalDateTime end );
    List<Appointment> findByDoctor( Doctor doctor );
}
