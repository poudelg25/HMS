package com.kindred.hms.mapper;


import com.kindred.hms.dto.PatientDto;
import com.kindred.hms.entity.Patient;

public class PatientMapper {

    public static PatientDto mapPatientToPatientDto(Patient patient){
        return PatientDto.builder().patientId(patient.getPatientId()).name(patient.getName()).gender(patient.getGender()).dateOfBirth(patient.getDateOfBirth()).address(patient.getAddress()).phoneNumber(patient.getPhoneNumber()).email(patient.getEmail()).medicalHistory(patient.getMedicalHistory()).ssn(patient.getSsn()).build();

    }

    public static Patient mapPatientDtoToPatient(PatientDto patientDto) {
        return Patient.builder().patientId(patientDto.getPatientId()).name(patientDto.getName()).gender(patientDto.getGender()).dateOfBirth(patientDto.getDateOfBirth()).address(patientDto.getAddress()).phoneNumber(patientDto.getPhoneNumber()).email(patientDto.getEmail()).medicalHistory(patientDto.getMedicalHistory()).ssn(patientDto.getSsn()).build();
        }
    }
