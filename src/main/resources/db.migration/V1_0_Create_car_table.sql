CREATE TABLE car (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    brand VARCHAR(255) NOT NULL,
    model VARCHAR(255) NOT NULL,
    price DOUBLE PRECISION NOT NULL,
    color VARCHAR(255),
    motorType VARCHAR(255),
    power VARCHAR(255),
    place_number INT NOT NULL,
    status VARCHAR(255) NOT NULL,
    type VARCHAR(255)
);

INSERT INTO car (name, description, brand, model, price, color, motorType, power, place_number, status, type)
VALUES ('Toyota Camry', 'Family sedan car', 'Toyota', 'Camry', 25000.0, 'Silver', 'Gasoline', '180 hp', 5, 'Available', 'Sedan'),
       ('Honda Civic', 'Compact car', 'Honda', 'Civic', 22000.0, 'Red', 'Gasoline', '158 hp', 5, 'Available', 'Sedan');