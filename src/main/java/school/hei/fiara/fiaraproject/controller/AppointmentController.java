package school.hei.fiara.fiaraproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import school.hei.fiara.fiaraproject.model.Appointment;
import school.hei.fiara.fiaraproject.model.Car;
import school.hei.fiara.fiaraproject.service.AppointmentService;

import java.util.List;
import java.util.Optional;

@RequestMapping("/appointments")
@RestController
public class AppointmentController {

@Autowired
private AppointmentService appointmentService;
    @GetMapping("/{id}")
    public Optional<Appointment> getAppointmentById(@PathVariable Integer id) {
        return appointmentService.findById(id);
    }

    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentService.findAll();
    }

    @PostMapping
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        return appointmentService.save(appointment);
    }

    @PutMapping
    public Appointment updateAppointment(@RequestBody Appointment appointment){
        return appointmentService.update(appointment);
    }

    @DeleteMapping("/{id}")
    public void deleteAppointmentById(@PathVariable Integer id) {
        appointmentService.deleteById(id);
    }

}
