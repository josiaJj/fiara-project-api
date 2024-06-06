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

    public Appointment getAppointmentById(Integer id) {
        Optional<Appointment> appointmentOptional = appointmentRepository.findById(id);
        if (appointmentOptional.isPresent()){
            return appointmentOptional.get();
        }
        return null;
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Appointment createAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public Appointment updateAppointment(Integer id, Appointment appointment) {
        Optional<Appointment> existingAppointment = appointmentRepository.findById(id);
        if (existingAppointment.isPresent()) {
            Appointment appointmentToUpdate = existingAppointment.get();
            appointmentToUpdate.setCar(appointment.getCar());
            appointmentToUpdate.setName(appointment.getName());
            appointmentToUpdate.setFirstName(appointment.getFirstName());
            appointmentToUpdate.setEmail(appointment.getEmail());
            appointmentToUpdate.setMessage(appointment.getMessage());
            appointmentToUpdate.setContact(appointment.getContact());
            appointmentToUpdate.setAppointmentDate(appointment.getAppointmentDate());
            appointmentToUpdate.setStatus(appointment.getStatus());
            return appointmentRepository.save(appointmentToUpdate);
        } else {
            return null;
        }
    }

    public Appointment updateAppointmentStatus(Integer id, String status) {
        Optional<Appointment> existingAppointment = appointmentRepository.findById(id);
        if (existingAppointment.isPresent()) {
            Appointment appointmentToUpdate = existingAppointment.get();
            if (appointmentToUpdate.canUpdateStatus(status)) {
                appointmentToUpdate.setStatus(status);
                return appointmentRepository.save(appointmentToUpdate);
            } else {
                throw new IllegalArgumentException("Invalid status update");
            }
        } else {
            return null;
        }
    }


    public void deleteAppointmentById(Integer id) {
        appointmentRepository.deleteById(id);
    }
}
