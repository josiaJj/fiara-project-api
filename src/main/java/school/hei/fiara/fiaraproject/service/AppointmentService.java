package school.hei.fiara.fiaraproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.hei.fiara.fiaraproject.model.Appointment;

import school.hei.fiara.fiaraproject.repository.AppointmentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;


    public Optional<Appointment> findById(Integer id) {
        return appointmentRepository.findById(id);
    }

    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    public Appointment save(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public Appointment update(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public void deleteById(Integer id) {
        appointmentRepository.deleteById(id);
    }
}
