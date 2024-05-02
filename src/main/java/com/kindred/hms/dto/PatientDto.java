package com.kindred.hms.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PatientDto {
    private Long patientId;
    private String name;
    private String gender;
    private String dateOfBirth;
    private String address;
    private String phoneNumber;
    private String email;
    private String medicalHistory;
    private String ssn;
}
