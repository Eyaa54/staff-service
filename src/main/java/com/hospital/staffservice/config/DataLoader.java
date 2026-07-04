package com.hospital.staffservice.config;

import com.hospital.staffservice.entity.Department;
import com.hospital.staffservice.entity.Doctor;
import com.hospital.staffservice.entity.Shift;
import com.hospital.staffservice.repository.DepartmentRepository;
import com.hospital.staffservice.repository.DoctorRepository;
import com.hospital.staffservice.repository.ShiftRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.time.LocalTime;

// Remplit la base avec des donnees d'exemple au demarrage (si la base est vide),
// pour que Swagger ne soit pas vide pendant la demonstration.
@Component
public class DataLoader implements CommandLineRunner {

    private final DepartmentRepository deptRepo;
    private final DoctorRepository doctorRepo;
    private final ShiftRepository shiftRepo;

    public DataLoader(DepartmentRepository deptRepo, DoctorRepository doctorRepo, ShiftRepository shiftRepo) {
        this.deptRepo = deptRepo;
        this.doctorRepo = doctorRepo;
        this.shiftRepo = shiftRepo;
    }

    // Petites methodes utilitaires pour ecrire moins de lignes
    private Department dept(String name, String location, String desc) {
        Department d = new Department();
        d.setName(name);
        d.setLocation(location);
        d.setDescription(desc);
        return deptRepo.save(d);
    }

    private Doctor doc(String first, String last, String spec, String email, String phone, Department dep) {
        Doctor d = new Doctor();
        d.setFirstName(first);
        d.setLastName(last);
        d.setSpeciality(spec);
        d.setEmail(email);
        d.setPhone(phone);
        d.setDepartment(dep);
        return doctorRepo.save(d);
    }

    private void shift(LocalDate date, LocalTime start, LocalTime end, String type, Doctor doctor) {
        Shift s = new Shift();
        s.setDate(date);
        s.setStartTime(start);
        s.setEndTime(end);
        s.setType(type);
        s.setDoctor(doctor);
        shiftRepo.save(s);
    }

    @Override
    public void run(String... args) {
        if (deptRepo.count() > 0) return; // deja rempli, on ne refait rien

        // ---- 4 services (departements) ----
        Department cardio = dept("Cardiologie", "Batiment A - 2e etage", "Service de cardiologie");
        Department pediatrie = dept("Pediatrie", "Batiment B - 1er etage", "Service des enfants");
        Department urgences = dept("Urgences", "Rez-de-chaussee", "Service des urgences 24h/24");
        Department radiologie = dept("Radiologie", "Batiment C - sous-sol", "Imagerie medicale");

        // ---- 6 medecins repartis dans les services ----
        Doctor sarra  = doc("Sarra", "Ben Ali", "Cardiologie", "sarra@hospital.tn", "20123456", cardio);
        Doctor karim  = doc("Karim", "Trabelsi", "Pediatrie", "karim@hospital.tn", "22334455", pediatrie);
        Doctor amine  = doc("Amine", "Jouini", "Urgentiste", "amine@hospital.tn", "24556677", urgences);
        Doctor rania  = doc("Rania", "Gharbi", "Cardiologie", "rania@hospital.tn", "26778899", cardio);
        Doctor mohamed= doc("Mohamed", "Sassi", "Radiologue", "mohamed@hospital.tn", "29001122", radiologie);
        Doctor ines   = doc("Ines", "Khemiri", "Pediatrie", "ines@hospital.tn", "27889900", pediatrie);

        // ---- Plannings / gardes ----
        shift(LocalDate.now(),               LocalTime.of(8, 0),  LocalTime.of(16, 0), "Jour",  sarra);
        shift(LocalDate.now(),               LocalTime.of(20, 0), LocalTime.of(8, 0),  "Nuit",  amine);
        shift(LocalDate.now().plusDays(1),   LocalTime.of(8, 0),  LocalTime.of(16, 0), "Jour",  karim);
        shift(LocalDate.now().plusDays(1),   LocalTime.of(16, 0), LocalTime.of(0, 0),  "Garde", rania);
        shift(LocalDate.now().plusDays(2),   LocalTime.of(9, 0),  LocalTime.of(17, 0), "Jour",  mohamed);
        shift(LocalDate.now().plusDays(2),   LocalTime.of(8, 0),  LocalTime.of(20, 0), "Jour",  ines);
    }
}
