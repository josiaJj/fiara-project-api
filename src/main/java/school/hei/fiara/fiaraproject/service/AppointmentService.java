package school.hei.fiara.fiaraproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.hei.fiara.fiaraproject.model.Appointment;
import school.hei.fiara.fiaraproject.repository.AppointmentRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private EmailService emailService;
    public  Optional<Appointment>findById(Integer id){ return appointmentRepository.findById(id);}
    public List<Appointment> findAll(){return appointmentRepository.findAll();}
    public Appointment register(Appointment appointment){
        return appointmentRepository.save(appointment);
    }
    public void delete(Integer id){
        appointmentRepository.deleteById(id);
    }
    public void updateStatus(Integer appointmentId) {
        Optional<Appointment> optionalAppointment = appointmentRepository.findById(appointmentId);
        if (optionalAppointment.isPresent()) {
            Appointment appointment = optionalAppointment.get();
            LocalDateTime now = LocalDateTime.now();
            if (appointment.getAppointmentDate().isBefore(now)) {
                appointment.setStatus(Appointment.Status.archived);
                appointmentRepository.save(appointment);
                String emailBody = "Votre rendez-vous a été archivé.";
                emailService.sendEmail(appointment.getEmail(), "Statut du rendez-vous mis à jour", emailBody);
            } else {
                appointment.setStatus(Appointment.Status.validated);
                appointmentRepository.save(appointment);
            }
        }
    }
}
