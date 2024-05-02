package com.kindred.hms.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandling extends RuntimeException{

    @ExceptionHandler(AppointmentNotFoundException.class)
    public ResponseEntity<String> handleAppointmentNotFoundException(AppointmentNotFoundException e) {
        return ResponseEntity.internalServerError().body(e.getMessage());
    }

    @ExceptionHandler(ResourceNotCreatedException.class)
    public ResponseEntity<String> handleResourceNotCreatedException(ResourceNotCreatedException e) {
        return ResponseEntity.internalServerError().body("Error: " + e.getMessage());

    }

    @ExceptionHandler(DoctorNotFoundException.class)
    public ResponseEntity<String> handleDoctorNotFoundException(DoctorNotFoundException e) {
        return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
    }

    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<String> handlePatientNotFoundException(PatientNotFoundException e) {
        return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
    }

}

