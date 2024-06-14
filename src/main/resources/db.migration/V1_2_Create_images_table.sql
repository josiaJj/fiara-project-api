CREATE TABLE image (
    image_id INT AUTO_INCREMENT PRIMARY KEY,
    car_id INT REFERENCES car(Car_id),
    url VARCHAR(250) NOT NULL,
);
