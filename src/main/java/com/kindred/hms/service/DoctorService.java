package com.kindred.hms.service;

import com.kindred.hms.dto.DoctorDto;
import com.kindred.hms.entity.Doctor;
import com.kindred.hms.exception.DoctorNotFoundException;
import com.kindred.hms.exception.PatientNotFoundException;
import com.kindred.hms.mapper.DoctorMapper;
import com.kindred.hms.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.kindred.hms.mapper.DoctorMapper.mapDoctorDtoToDoctor;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public void saveDoctor(DoctorDto doctorDto) {
        doctorRepository.save(mapDoctorDtoToDoctor(doctorDto));
    }

    public List<DoctorDto> getAllDoctors() {
        return doctorRepository.findAll().stream()
                .map(DoctorMapper::mapDoctorToDoctorDto)
                .collect(Collectors.toList());
    }

    public List<DoctorDto> findDoctorByName(String name) {
        List<Doctor> existingDoctor = doctorRepository.findDoctorsByName(name);
        if (existingDoctor.isEmpty()) {
            throw new DoctorNotFoundException("Doctor name - " + name + " not found!!");
        }
        return doctorRepository.findDoctorsByName(name).stream()
                .map(DoctorMapper::mapDoctorToDoctorDto)
                .collect(Collectors.toList());
    }

    public List<DoctorDto> findDoctorsByGender(String gender) {
        List<Doctor> existingDoctor = doctorRepository.findDoctorsByGender(gender);
        if (existingDoctor.isEmpty()) {
            throw new DoctorNotFoundException("Doctor with gender - " + gender + " not found!!");
        }
        return doctorRepository.findDoctorsByGender(gender)
                .stream().map(DoctorMapper::mapDoctorToDoctorDto)
                .collect(Collectors.toList());
    }

    public List<DoctorDto> findDoctorsBySpecialization(String specialization) {
        List<Doctor> existingDoctor = doctorRepository.findDoctorsBySpecialization(specialization);
        if (existingDoctor.isEmpty()) {
            throw new DoctorNotFoundException("Doctor with specialization - " + specialization + " not found!!");
        }
        return doctorRepository.findDoctorsBySpecialization(specialization)
                .stream().map(DoctorMapper::mapDoctorToDoctorDto)
                .collect(Collectors.toList());
    }

    public void updateDoctor(Long doctorId, DoctorDto doctorDto) {
        Doctor existingDoctor = doctorRepository.findById(doctorId).orElseThrow(() -> new DoctorNotFoundException("Entered doctor id - " + doctorId + " does not exist in the database!!"));

        existingDoctor.setName(doctorDto.getName());
        existingDoctor.setGender(doctorDto.getGender());
        existingDoctor.setSpecialization(doctorDto.getSpecialization());
        existingDoctor.setPhoneNumber(doctorDto.getPhoneNumber());
        existingDoctor.setEmail(doctorDto.getEmail());
        doctorRepository.save(existingDoctor);
    }

    public String deleteDoctorById(Long doctorId) {
        doctorRepository.findById(doctorId).orElseThrow(() -> new DoctorNotFoundException("Doctor with id - " + doctorId + " not found!!"));
        doctorRepository.deleteById(doctorId);
        return "Doctor record (ID: " + doctorId + ") deleted successfully!!";
    }
}
