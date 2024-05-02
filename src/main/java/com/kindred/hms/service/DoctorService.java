package com.kindred.hms.service;

import com.kindred.hms.dto.DoctorDto;
import com.kindred.hms.entity.Doctor;
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
        return doctorRepository.findDoctorsByName(name).stream()
                .map(DoctorMapper::mapDoctorToDoctorDto)
                .collect(Collectors.toList());
    }

    public List<DoctorDto> findDoctorsByGender(String gender) {
        return doctorRepository.findDoctorsByGender(gender)
                .stream().map(DoctorMapper::mapDoctorToDoctorDto)
                .collect(Collectors.toList());
    }

    public List<DoctorDto> findDoctorsBySpecialization(String specialization) {
        return doctorRepository.findDoctorsBySpecialization(specialization)
                .stream().map(DoctorMapper::mapDoctorToDoctorDto)
                .collect(Collectors.toList());
    }

    public void updateDoctor(Long doctorId, DoctorDto doctorDto) {
        Doctor existingDoctor = doctorRepository.findById(doctorId).orElseThrow(() -> new RuntimeException("Entered doctor id: " + doctorId + " does not exist in the database!!"));

        existingDoctor.setName(doctorDto.getName());
        existingDoctor.setGender(doctorDto.getGender());
        existingDoctor.setSpecialization(doctorDto.getSpecialization());
        existingDoctor.setPhoneNumber(doctorDto.getPhoneNumber());
        existingDoctor.setEmail(doctorDto.getEmail());
        doctorRepository.save(existingDoctor);
    }

    public String deleteDoctor(Long doctorId) {
        Optional<Doctor> doctorOptional = doctorRepository.findById(doctorId);
        if (doctorOptional.isPresent()) {
            doctorRepository.deleteById(doctorId);
            return "Doctor record (ID: " + doctorId + ") deleted successfully!!";
        } else {
            return "Doctor record (ID: " + doctorId + ") could not found in the database!!";
        }
    }
}
