package school.hei.fiara.fiaraproject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" , nullable = false)
    private int id;
    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;
    @Column(name = "name" , nullable = false , length = 200)
    private String name;

    @Column(name = "first_name" , nullable = false , length = 200)
    private String firstName;

    @Column(name = "email", nullable = false , length = 200)
    private String email;

    @Column(name = "message" , nullable = false , length = 200)
    private String message;

    @Column(name = "contact" , nullable = false , length = 200)
    private String contact;

    @Column(name = "appointment_date" , nullable = false)
    private Instant appointmentDate;

    @Column(name = "status" , nullable = false , length = 200)
    private String status;


    public boolean canUpdateStatus(String newStatus) {
        if (appointmentDate.isAfter(Instant.now())) {
            return newStatus.equals("Confirm") || newStatus.equals("Reject");
        } else {
            return newStatus.equals("Archive");
        }
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Instant getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Instant appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
}
