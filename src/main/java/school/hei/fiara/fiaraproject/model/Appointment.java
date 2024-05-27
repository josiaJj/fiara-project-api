package school.hei.fiara.fiaraproject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" , nullable = false)
    private int id;

    @Column(name = "car_id" , nullable = false)
    private int carId;

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
}
