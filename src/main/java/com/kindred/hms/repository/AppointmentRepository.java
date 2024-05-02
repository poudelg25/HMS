package com.kindred.hms.repository;

import com.kindred.hms.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
/*
    @Query(value = "SELECT * FROM Appointment WHERE ssn=:ssn", nativeQuery = true)
    public List<Appointment> findAppointmentsBySsn(String ssn);
*/

public Appointment findAppointmentByAppointmentId(Long appointmentId);
}