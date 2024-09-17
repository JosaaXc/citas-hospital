package com.kosmos.consultorio.repositories;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import com.kosmos.consultorio.models.Appointment;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
    Optional<Appointment> findByDateAndTimeAndDoctorIdAndOfficeId(LocalDate date, LocalTime time, Long doctorId, Long officeId);
}
