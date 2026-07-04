package com.hospital.staffservice.client;

import com.hospital.staffservice.dto.AppointmentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

// Communication SYNCHRONE avec le microservice "appointment-service" d'un(e) camarade.
// Feign trouve ce service automatiquement grâce à Eureka (par son nom).
// NOTE : adapte le nom "appointment-service" et l'URL ci-dessous à ce que
//        le/la responsable du service Appointment a réellement nommé.
@FeignClient(name = "appointment-service")
public interface AppointmentClient {

    @GetMapping("/api/appointments/doctor/{doctorId}")
    List<AppointmentDTO> getAppointmentsByDoctor(@PathVariable("doctorId") Long doctorId);
}
