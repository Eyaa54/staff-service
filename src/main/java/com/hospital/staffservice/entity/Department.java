package com.hospital.staffservice.entity;

import jakarta.persistence.*;
import lombok.Data;

// Un service (département) de l'hôpital : Cardiologie, Pédiatrie, etc.
@Entity
@Data
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;         // ex : "Cardiologie"
    private String location;     // ex : "Bâtiment A - 2e étage"
    private String description;
}
