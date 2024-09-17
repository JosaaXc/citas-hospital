package com.kosmos.consultorio.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDto {

    @Size(min = 3, max = 50, message = "El nombre del paciente debe tener entre 3 y 50 caracteres")
    private String patientName;

    @NotNull(message = "El id del doctor es requerido")
    private Long doctorId;

    @NotNull(message = "El id del consultorio es requerido")
    private Long officeId;

    @NotNull(message = "La fecha y hora de la cita es requerida")
    private LocalDateTime dateTime;

}
