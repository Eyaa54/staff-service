package com.hospital.staffservice.dto;

import lombok.Data;
import java.time.LocalDateTime;

// Copie simplifiée d'un rendez-vous, tel que renvoyé par le microservice Appointment.
// (On ne connaît pas son entité, on décrit juste les champs qu'on veut lire.)
@Data
public class AppointmentDTO {
    private Long id;
    private Long doctorId;
    private Long patientId;
    private LocalDateTime dateTime;
    private String status;
}
