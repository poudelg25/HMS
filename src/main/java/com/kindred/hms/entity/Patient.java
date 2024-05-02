package com.kindred.hms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data //@Getter @Setter @ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;
    private String name;
    private String gender;
    private String dateOfBirth;
    private String address;
    private String phoneNumber;
    private String email;
    private String medicalHistory;
    private String ssn;
}

//import java.util.List;

//@Table(name = "patients")

/*@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id", referencedColumnName = "patientId")
    private List<Appointment> appointmentList;*/

//@OneToMany(fetch = FetchType.EAGER)
//@OneToMany@Fetch(FetchMode.JOIN)
   /* @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private List<Appointment> appointmentList;*/

/*    @OneToMany(cascade = CascadeType.ALL)
    private List<Doctor> doctorList;*/