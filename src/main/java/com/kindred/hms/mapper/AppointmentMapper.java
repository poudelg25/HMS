package com.kindred.hms.mapper;

import com.kindred.hms.dto.AppointmentDto;
import com.kindred.hms.entity.Appointment;

public class AppointmentMapper {

    public static AppointmentDto mapAppointmentToAppointmentDto(Appointment appointment){
        return AppointmentDto.builder().appointmentId(appointment.getAppointmentId()).
                dateTime(appointment.getDateTime()).doctorId(appointment.getDoctorId()).
                patientId(appointment.getPatientId()).build();

    }

    public static Appointment mapAppointmentDtoToAppointment(AppointmentDto appointmentDto){
        return Appointment.builder().appointmentId(appointmentDto.getAppointmentId()).
                dateTime(appointmentDto.getDateTime()).doctorId(appointmentDto.getDoctorId()).
                patientId(appointmentDto.getPatientId()).build();
    }
}
