package com.kindred.hms.controller;

import com.kindred.hms.dto.PatientDto;
import com.kindred.hms.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    public ResponseEntity<String> addPatient(@RequestBody PatientDto patientDto) {
        patientService.savePatient(patientDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Patient record (ID: "+patientDto.getPatientId()+") created successfully!!");
    }

    @GetMapping
    public ResponseEntity<List<PatientDto>> getAllPatients() {
        return ResponseEntity.ok().body(patientService.getAllPatients());
    }

    @GetMapping("/id")
    public ResponseEntity<PatientDto> findPatientById(@RequestParam("id") Long patientId) {
       return ResponseEntity.ok().body(patientService.getPatientById(patientId));
    }

    @GetMapping("/name")
    public ResponseEntity<List<PatientDto>> findPatientByName(@RequestParam("name") String name) {
        return ResponseEntity.ok().body(patientService.getPatientByName(name));
    }

    @GetMapping("/ssn")
    public ResponseEntity<PatientDto> findPatientBySsn(@RequestParam("ssn") String ssn) {
        return ResponseEntity.ok().body(patientService.getPatientBySsn(ssn));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePatient(@PathVariable("id") Long patientId, @RequestBody PatientDto patientDto) {
        patientService.updatePatient(patientId, patientDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Patient record (ID: "+patientId+") updated successfully!!");
    }
}

 /*  @DeleteMapping
    public ResponseEntity<String> deletePatient(@RequestParam("id") Long id) {
        patientService.deletePatient(id);
        return ResponseEntity.ok().body("Patient deleted successfully!");
    }*/