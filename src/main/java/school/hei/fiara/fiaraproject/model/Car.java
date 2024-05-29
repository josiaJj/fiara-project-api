package school.hei.fiara.fiaraproject.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
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

    @Column(name = "motorType" , nullable = false , length = 200)
    private String motorType;

    @Column(name = "power" , nullable = false , length = 200)
    private String power;

    @Column(name = "place_number" , nullable = false , length = 200)
    private int placeNumber;

    @Column(name = "status" , nullable = false , length = 200)
    private String status;

    @Column(name = "type" ,nullable = false , length = 200)
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMotorType() {
        return motorType;
    }

    public void setMotorType(String motorType) {
        this.motorType = motorType;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public int getPlaceNumber() {
        return placeNumber;
    }

    public void setPlaceNumber(int placeNumber) {
        this.placeNumber = placeNumber;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



}
