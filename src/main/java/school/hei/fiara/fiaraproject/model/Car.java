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
    @Column(name = "id")
    private int id;

    @Column(name = "name" , nullable = false , length = 200)
    private String name;

    @Column(name = "description" , nullable = false, length = 200)
    private String description;

    @Column(name = "brand" , nullable = false , length = 200)
    private String brand;

    @Column(name = "model" , nullable = false , length = 200)
    private String model;

    @Column(name = "price" , nullable = false)
    private double price;

    @Column(name = "color" , nullable = false , length = 200)
    private String color;

    @Column(name = "motor_type" , nullable = false , length = 200)
    private String motorType;

    @Column(name = "power" , nullable = false , length = 200)
    private String power;

    @Column(name = "place_number" , nullable = false , length = 200)
    private int placeNumber;

    @Column(name = "status" , nullable = false , length = 200)
    private String status;

    @Column(name = "type" ,nullable = false , length = 200)
    private String type;
}
