CREATE TABLE "user" (
    "user_id" INT PRIMARY KEY AUTO_INCREMENT,
    "email" VARCHAR(255) NOT NULL UNIQUE,
    "password" VARCHAR(255) NOT NULL,
    "name" VARCHAR(255)
);