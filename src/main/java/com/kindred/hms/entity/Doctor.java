package com.kindred.hms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctorId;
    private String name;
    private String gender;
    private String specialization;
    private String phoneNumber;
    private String email;
}

   /*
   import java.util.List;
   //@Table(name = "doctors")

   @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctor_id", referencedColumnName = "doctorId")
    private List<Appointment> appointmentList;*/
