CREATE TABLE appointment (
    "id" INT PRIMARY KEY AUTO_INCREMENT,
    "car_id" INT NOT NULL,
    "name" VARCHAR(255) NOT NULL,
    "first_name" VARCHAR(255) NOT NULL,
    "email" VARCHAR(255) NOT NULL,
    "message" TEXT,
    "contact" VARCHAR(255),
    "appointment_date" DATETIME NOT NULL,
    "status" VARCHAR(255) NOT NULL,
    CONSTRAINT fk_appointment_car FOREIGN KEY (car_id) REFERENCES car(id)
);