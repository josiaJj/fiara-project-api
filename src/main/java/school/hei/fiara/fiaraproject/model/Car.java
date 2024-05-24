package school.hei.fiara.fiaraproject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "price")
    private double price;

    @Column(name = "color")
    private String color;

    @Column(name = "motor_type")
    private String motorType;

    @Column(name = "power")
    private String power;

    @Column(name = "place_number")
    private int placeNumber;

    @Column(name = "status")
    private String status;

    @Column(name = "type")
    private String type;
}
