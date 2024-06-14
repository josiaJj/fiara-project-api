CREATE TYPE car_status AS ENUM ('Pinned', 'Not Pinned');

CREATE TABLE car (
    car_id  SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    brand VARCHAR(100),
    model VARCHAR(100),
    price DECIMAL(10, 2),
    color VARCHAR(50),
    motor_type VARCHAR(100),
    power INT,
    place_number INT,
    status car_status,
    type VARCHAR(100)
);