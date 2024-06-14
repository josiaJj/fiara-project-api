package school.hei.fiara.fiaraproject.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import school.hei.fiara.fiaraproject.model.Brand;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer carId;
    @Column(nullable = false)
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
    @ManyToOne
    @JoinColumn(name = "brand_id", referencedColumnName = "brandId",nullable = true)
    private Brand brandId;
    private String model;
    @Column(precision = 10, scale = 2)
    private BigDecimal price;
    private String color;
    private String motorType;
    private Integer power;
    private Integer placeNumber;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String type;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "image_id", referencedColumnName = "imageId",nullable = true)
    private Image imageId;
    public enum Status {Pinned, NotPinned}

    public Car(Integer carId, String name, String description, Brand brandId, String model, BigDecimal price, String color, String motorType, Integer power, Integer placeNumber, Status status, String type, Image imageId) {
        this.carId = carId;
        this.name = name;
        this.description = description;
        this.brandId = brandId;
        this.model = model;
        this.price = price;
        this.color = color;
        this.motorType = motorType;
        this.power = power;
        this.placeNumber = placeNumber;
        this.status = status;
        this.type = type;
        this.imageId = imageId;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

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

    public Brand getBrandId() {
        return brandId;
    }

    public void setBrandId(Brand brandId) {
        this.brandId = brandId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
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

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Integer getPlaceNumber() {
        return placeNumber;
    }

    public void setPlaceNumber(Integer placeNumber) {
        this.placeNumber = placeNumber;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Image getImageId() {
        return imageId;
    }

    public void setImageId(Image imageId) {
        this.imageId = imageId;
    }
}