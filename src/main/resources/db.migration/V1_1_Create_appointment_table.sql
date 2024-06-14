CREATE TYPE appointment_status AS ENUM ('pending', 'validated', 'rejected', 'archived');
CREATE TABLE appointment (
    appointment_id SERIAL PRIMARY KEY,
    car_id INT REFERENCES car(car_id),
    name VARCHAR(255),
    first_name VARCHAR(255),
    email VARCHAR(255),
    message TEXT,
    contact VARCHAR(100),
    appointment_date TIMESTAMP,
    status appointment_status
);