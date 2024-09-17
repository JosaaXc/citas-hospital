package com.kosmos.consultorio.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDto {

    @Size(min = 3, max = 20, message = "El nombre debe tener entre 3 y 20 caracteres")
    private String firstName;

    @Size(min = 3, max = 20, message = "El apellido paterno debe tener entre 3 y 20 caracteres")
    private String paternalLastName;

    @Size(min = 3, max = 20, message = "El apellido materno debe tener entre 3 y 20 caracteres")
    private String maternalLastName;

    @Size(min = 3, max = 50, message = "La especialidad debe tener entre 3 y 50 caracteres")
    private String specialty;
    
}
