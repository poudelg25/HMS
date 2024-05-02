package com.kindred.hms.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DoctorDto {
    private Long doctorId;
    private String name;
    private String gender;
    private String specialization;
    private String phoneNumber;
    private String email;
}
