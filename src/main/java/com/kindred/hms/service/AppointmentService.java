package com.kindred.hms.service;

import com.kindred.hms.dto.AppointmentDto;
import com.kindred.hms.entity.Appointment;
import com.kindred.hms.exception.AppointmentNotFoundException;
import com.kindred.hms.mapper.AppointmentMapper;
import com.kindred.hms.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.kindred.hms.mapper.AppointmentMapper.mapAppointmentToAppointmentDto;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public void saveAppointment(AppointmentDto appointmentDto) {
        appointmentRepository.save(AppointmentMapper.mapAppointmentDtoToAppointment(appointmentDto));
    }

    public List<AppointmentDto> getAllAppointments() {
        return appointmentRepository.findAll().stream()
                .map(AppointmentMapper::mapAppointmentToAppointmentDto)
                .collect(Collectors.toList());
    }

    public AppointmentDto getAppointmentByAppointmentId(Long appointmentId) {
        Appointment existingAppointment = appointmentRepository.findById(appointmentId).orElseThrow(() -> new AppointmentNotFoundException("Appointment with id - " + appointmentId + " Not Found!!"));
        return mapAppointmentToAppointmentDto(existingAppointment);
    }

    public void updateAppointment(Long appointmentId, AppointmentDto appointmentDto) {
        Appointment existingAppointment = appointmentRepository.findById(appointmentId).
                orElseThrow(() -> new AppointmentNotFoundException("Entered appointment id: " + appointmentId + " does not exist in the database!"));
        existingAppointment.setDoctorId(appointmentDto.getDoctorId());
        existingAppointment.setDateTime(appointmentDto.getDateTime());
        existingAppointment.setPatientId(appointmentDto.getPatientId());
        appointmentRepository.save(existingAppointment);
    }

    public String deleteAppointment(Long appointmentId) {
        Appointment existingAppointment = appointmentRepository.findAppointmentByAppointmentId(appointmentId);
        if (existingAppointment == null) {
            throw new AppointmentNotFoundException("Appointment with id - " + appointmentId + " Not Found!!!");
        }
        appointmentRepository.deleteById(appointmentId);
        return "Appointment record (ID: " + appointmentId + ") deleted successfully!!";
    }
}