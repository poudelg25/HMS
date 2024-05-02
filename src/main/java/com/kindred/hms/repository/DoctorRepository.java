package com.kindred.hms.repository;

import com.kindred.hms.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    public List<Doctor> findDoctorsByName(String name);

    public List<Doctor> findDoctorsByGender(String gender);

    public List<Doctor> findDoctorsBySpecialization(String speciality);

}
