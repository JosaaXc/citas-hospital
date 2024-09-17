package com.kosmos.consultorio.repositories;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;
import java.util.List;

import com.kosmos.consultorio.models.Appointment;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
    Optional<Appointment> findByDateAndTimeAndDoctorIdAndOfficeId(LocalDate date, LocalTime time, Long doctorId, Long officeId);

    @Query("SELECT a FROM Appointment a WHERE a.doctor.id = :doctorId AND a.date = :date AND a.office.id = :officeId")
    List<Appointment> findByDoctorIdAndDateAndOfficeId(@Param("doctorId") Long doctorId, @Param("date") LocalDate date, @Param("officeId") Long officeId);

    @Query("SELECT COUNT(a) FROM Appointment a WHERE a.doctor.id = :doctorId AND a.date = :date")
    long countByDoctorIdAndDate(@Param("doctorId") Long doctorId, @Param("date") LocalDate date);
    
}
