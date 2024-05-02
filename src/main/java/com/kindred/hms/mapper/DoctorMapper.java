package com.kindred.hms.mapper;

import com.kindred.hms.dto.DoctorDto;
import com.kindred.hms.entity.Doctor;


public class DoctorMapper {


    public static DoctorDto mapDoctorToDoctorDto(Doctor doctor){
        return DoctorDto.builder().doctorId(doctor.getDoctorId()).name(doctor.getName()).gender(doctor.getGender()).specialization(doctor.getSpecialization()).phoneNumber(doctor.getPhoneNumber()).email(doctor.getEmail()).build();

    }
    public static Doctor mapDoctorDtoToDoctor(DoctorDto doctorDto) {
        return Doctor.builder().doctorId(doctorDto.getDoctorId()).name(doctorDto.getName()).gender(doctorDto.getGender()).specialization(doctorDto.getSpecialization()).phoneNumber(doctorDto.getPhoneNumber()).email(doctorDto.getEmail()).build();
        }
    }

