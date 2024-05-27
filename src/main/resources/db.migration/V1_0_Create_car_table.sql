CREATE TABLE car (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    brand VARCHAR(255) NOT NULL,
    model VARCHAR(255) NOT NULL,
    price DOUBLE NOT NULL,
    color VARCHAR(255),
    motor_type VARCHAR(255),
    power VARCHAR(255),
    place_number INT NOT NULL,
    status VARCHAR(255) NOT NULL,
    type VARCHAR(255)
);