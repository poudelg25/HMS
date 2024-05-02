package com.kindred.hms.controller;

import com.kindred.hms.dto.DoctorDto;
import com.kindred.hms.entity.Doctor;
import com.kindred.hms.service.DoctorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService){

        this.doctorService= doctorService;
    }
    @PostMapping
    public ResponseEntity<String> addDoctor(@RequestBody DoctorDto doctorDto) {
        doctorService.saveDoctor(doctorDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("New Doctor's record with (Name: "+doctorDto.getName()+") created successfully!!");
    }

    @GetMapping
    public ResponseEntity<List<DoctorDto>> getAllDoctors() {
        return ResponseEntity.ok().body(doctorService.getAllDoctors());
    }

    @GetMapping("/name")
    public ResponseEntity<List<DoctorDto>> getDoctorByName(@RequestParam("name") String name) {
        return ResponseEntity.ok().body(doctorService.findDoctorByName(name));
    }

    @GetMapping("/gender")
    public ResponseEntity<List<DoctorDto>> getDoctorsByGender(@RequestParam("gender") String gender){
        return ResponseEntity.ok().body(doctorService.findDoctorsByGender(gender));
    }

    @GetMapping("/specialization")
    public ResponseEntity<List<DoctorDto>> getDoctorsBySpecialization(@RequestParam("specialization") String specialization){
        return ResponseEntity.ok().body(doctorService.findDoctorsBySpecialization(specialization));
    }

   @PutMapping("/{id}")
    public ResponseEntity<String> updateDoctor(@PathVariable ("id") Long doctorId, @RequestBody DoctorDto doctorDto) {
        doctorService.updateDoctor(doctorId, doctorDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Doctor record (ID: "+doctorId+") updated successfully!!");
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable("id") Long doctorId) {
        //doctorService.deleteDoctor(doctorId);
        //return ResponseEntity.ok().body("Doctor record (ID: "+doctorId+") deleted successfully!!");
        return ResponseEntity.ok().body( doctorService.deleteDoctor(doctorId));
    }

}
