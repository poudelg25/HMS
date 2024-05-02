package com.kindred.hms.controller;

import com.kindred.hms.dto.AppointmentDto;
import com.kindred.hms.entity.Appointment;
import com.kindred.hms.service.AppointmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("api/v1/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;


    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;

    }

    @PostMapping
    public ResponseEntity<String> addAppointment(@RequestBody AppointmentDto appointmentDto) {
        appointmentService.saveAppointment(appointmentDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Appointment record (ID: " + appointmentDto.getAppointmentId() + ") created successfully!!");
    }

    @GetMapping
    public ResponseEntity<List<AppointmentDto>> getAllAppointments() {
        return ResponseEntity.ok().body(appointmentService.getAllAppointments());
    }

    @GetMapping("/appointmentId")
    public ResponseEntity<AppointmentDto> getAppointmentsByAppointmentId(@RequestParam("appointmentId") Long appointmentId) {
        return ResponseEntity.ok().body(appointmentService.getAppointmentByAppointmentId(appointmentId));
    }

    @PutMapping("/{appointmentId}")
    public ResponseEntity<String> updateAppointment(@PathVariable("appointmentId") Long appointmentId, @RequestBody AppointmentDto appointmentDto) {
        appointmentService.updateAppointment(appointmentId, appointmentDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Appointment record (ID: " + appointmentId + ") updated successfully!!");
    }

    @DeleteMapping("/{appointmentId}")
    public ResponseEntity<String> deleteAppointment(@PathVariable("appointmentId") Long appointmentId) {
        return ResponseEntity.ok().body(appointmentService.deleteAppointment(appointmentId));
    }


}
