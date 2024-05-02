package com.kindred.hms.service;

import com.kindred.hms.dto.PatientDto;
import com.kindred.hms.entity.Patient;
import com.kindred.hms.mapper.PatientMapper;
import com.kindred.hms.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.kindred.hms.mapper.PatientMapper.mapPatientDtoToPatient;
import static com.kindred.hms.mapper.PatientMapper.mapPatientToPatientDto;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public void savePatient(PatientDto patientDto) {
        patientRepository.save(mapPatientDtoToPatient(patientDto));
    }

    public List<PatientDto> getAllPatients() {
        return patientRepository.findAll().stream()
                .map(PatientMapper::mapPatientToPatientDto)
                .collect(Collectors.toList());
    }

    public PatientDto getPatientById(Long patientId) {
        return mapPatientToPatientDto(patientRepository.findById(patientId).get());
    }


    public List<PatientDto> getPatientByName(String name) {
      return patientRepository.findPatientsByName(name).stream()
              .map(PatientMapper::mapPatientToPatientDto)
              .collect(Collectors.toList());
    }

    public PatientDto getPatientBySsn(String ssn) {
        return mapPatientToPatientDto(patientRepository.findPatientBySsn(ssn));
    }

    public void updatePatient(Long patientId, PatientDto patientDto) {
        Patient existingPatient = patientRepository.findById(patientId).
                orElseThrow(()->new RuntimeException("Entered id: " +patientId + " does not exist in the database!"));

        existingPatient.setName(patientDto.getName());
        existingPatient.setGender(patientDto.getGender());
        existingPatient.setDateOfBirth(patientDto.getDateOfBirth());
        existingPatient.setAddress(patientDto.getAddress());
        existingPatient.setPhoneNumber(patientDto.getPhoneNumber());
        existingPatient.setEmail(patientDto.getEmail());
        existingPatient.setMedicalHistory(patientDto.getMedicalHistory());
        existingPatient.setSsn(patientDto.getSsn());
        patientRepository.save(existingPatient);
    }
}
