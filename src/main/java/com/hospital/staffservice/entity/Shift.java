package com.hospital.staffservice.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;

// Un créneau de travail (planning / garde) affecté à un médecin.
@Entity
@Data
public class Shift {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;        // jour du shift
    private LocalTime startTime;   // heure de début
    private LocalTime endTime;     // heure de fin
    private String type;           // "Jour", "Nuit", "Garde"...

    // Le shift concerne UN médecin.
    @ManyToOne
    private Doctor doctor;
}
