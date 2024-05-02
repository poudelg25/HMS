package com.kindred.hms.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class AppointmentDto {
    private Long appointmentId;
    private LocalDateTime dateTime;
    private Long doctorId;
    private Long patientId;
}
