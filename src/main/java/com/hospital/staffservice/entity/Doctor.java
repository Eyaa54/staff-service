package com.hospital.staffservice.entity;

import jakarta.persistence.*;
import lombok.Data;

// Un médecin / membre du personnel soignant.
@Entity
@Data
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String speciality;   // spécialité : Cardiologue, Pédiatre...
    private String email;
    private String phone;

    // Un médecin appartient à UN service (département).
    @ManyToOne
    private Department department;
}
