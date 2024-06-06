package school.hei.fiara.fiaraproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;
import school.hei.fiara.fiaraproject.model.Appointment;
import school.hei.fiara.fiaraproject.repository.AppointmentRepository;
import school.hei.fiara.fiaraproject.service.AppointmentService;

import java.util.List;

@CrossOrigin
@RestController
public class AppointmentController {
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("Appointment/{id}")

    public Appointment getAppointmentById(@PathVariable Integer id) {
        return appointmentService.getAppointmentById(id);
    }

    @GetMapping("/Appointment")
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @PostMapping("/SaveAppointment")
    public Appointment saveAppointment(@RequestBody Appointment appointment) {
        Appointment savedAppointment = appointmentRepository.save(appointment);
        sendEmail(appointment);
        return savedAppointment;
    }

    @PutMapping("/Appointment/Update/{id}")
    public Appointment updateAppointment(@PathVariable Integer id, @RequestBody Appointment appointment) {
        return appointmentService.updateAppointment(id, appointment);
    }

    @DeleteMapping("/Appointment/Delete/{id}")
    public void deleteAppointmentById(@PathVariable Integer id) {
        appointmentService.deleteAppointmentById(id);
    }


    @Value("${emailAdmin}")
    private String emailAdmin;

    private void sendEmail(Appointment appointment) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(emailAdmin);
        mailMessage.setSubject("New Appointment Created");
        mailMessage.setText("Name: " + appointment.getName() + "\n" +
                "First Name: " + appointment.getFirstName() + "\n" +
                "Email: " + appointment.getEmail() + "\n" +
                "Message: " + appointment.getMessage() + "\n" +
                "Contact: " + appointment.getContact() + "\n" +
                "Appointment Date: " + appointment.getAppointmentDate() + "\n" +
                "Car: " + appointment.getCar().getName() + "\n" +
                "Status: " + appointment.getStatus());
        mailSender.send(mailMessage);
    }
}
