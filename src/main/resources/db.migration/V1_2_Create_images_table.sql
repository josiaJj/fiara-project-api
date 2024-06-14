CREATE TABLE image (
    image_id SERIAL PRIMARY KEY,
    car_id INT REFERENCES car(Car_id),
    url VARCHAR(250) NOT NULL
);
