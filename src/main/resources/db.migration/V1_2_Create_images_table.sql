CREATE TABLE images (
    "id" SERIAL  PRIMARY KEY,
    "product_id" INT NOT NULL,
    "url" VARCHAR(255) NOT NULL
);

INSERT INTO images (product_id, url)
VALUES (1, 'https://example.com/toyota_camry_image.jpg'),
       (2, 'https://example.com/honda_civic_image.jpg');
