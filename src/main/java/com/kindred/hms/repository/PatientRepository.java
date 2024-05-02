package com.kindred.hms.repository;

import com.kindred.hms.entity.Appointment;
import com.kindred.hms.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    public List<Patient> findPatientsByName(String name);

    public Patient findPatientBySsn(String ssn);
}
