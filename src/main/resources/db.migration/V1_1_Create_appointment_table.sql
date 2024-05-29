CREATE TABLE appointment (
    "id" SERIAL PRIMARY KEY,
    "car_id" INT NOT NULL,
    "name" VARCHAR(255) NOT NULL,
    "first_name" VARCHAR(255) NOT NULL,
    "email" VARCHAR(255) NOT NULL,
    "message" TEXT,
    "contact" VARCHAR(255),
    "appointment_date" TIMESTAMP NOT NULL,
    "status" VARCHAR(255) NOT NULL,
    CONSTRAINT fk_appointment_car FOREIGN KEY (car_id) REFERENCES car(id)
);

INSERT INTO appointment (car_id, name, first_name, email, message, contact, appointment_date, status)
VALUES (1, 'Baba', 'be', 'Baba@example.com', 'I want to schedule a test drive', '123-456-7890', NOW() + INTERVAL '1 day', 'Pending'),
       (2, 'Alice S', 'Alice', 'alice@example.com', 'Interested in purchasing', '987-654-3210', NOW() + INTERVAL '2 days', 'Pending');