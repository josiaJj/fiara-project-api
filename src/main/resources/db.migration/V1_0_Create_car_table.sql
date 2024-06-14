CREATE TABLE car (
    car_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    brand VARCHAR(100),
    model VARCHAR(100),
    price DECIMAL(10, 2),
    color VARCHAR(50),
    motor_type VARCHAR(100),
    power INT,
    place_number INT,
    status ENUM('Pinned', 'Not Pinned'),
    type VARCHAR(100)
);