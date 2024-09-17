package com.kosmos.consultorio.dto;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfficeDto {

    @Pattern(regexp = "\\d+", message = "Asegurese de que el número de oficina sea un número")
    private String roomNumber;

    @Pattern(regexp = "\\d+", message = "Asegurese de que el número de piso sea un número")
    private String floor;

}
