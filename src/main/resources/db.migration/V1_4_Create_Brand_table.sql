CREATE TABLE brand (
    brand_id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    image_id INTEGER,
    CONSTRAINT fk_image FOREIGN KEY(image_id) REFERENCES image(image_id) ON DELETE CASCADE
);