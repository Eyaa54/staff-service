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

// Remplit la base avec quelques donnees d'exemple au demarrage
// (uniquement si la base est vide) pour que Swagger ne soit pas vide a la demo.
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

    @Override
    public void run(String... args) {
        if (deptRepo.count() > 0) return; // deja rempli, on ne refait rien

        Department cardio = new Department();
        cardio.setName("Cardiologie");
        cardio.setLocation("Batiment A - 2e etage");
        cardio.setDescription("Service de cardiologie");
        deptRepo.save(cardio);

        Doctor doc = new Doctor();
        doc.setFirstName("Sarra");
        doc.setLastName("Ben Ali");
        doc.setSpeciality("Cardiologie");
        doc.setEmail("sarra@hospital.tn");
        doc.setPhone("20123456");
        doc.setDepartment(cardio);
        doctorRepo.save(doc);

        Shift shift = new Shift();
        shift.setDate(LocalDate.now());
        shift.setStartTime(LocalTime.of(8, 0));
        shift.setEndTime(LocalTime.of(16, 0));
        shift.setType("Jour");
        shift.setDoctor(doc);
        shiftRepo.save(shift);
    }
}
