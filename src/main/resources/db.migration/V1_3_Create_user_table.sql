CREATE TABLE "app_user" (
    "user_id" SERIAL PRIMARY KEY,
    "email" VARCHAR(255) NOT NULL UNIQUE,
    "password" VARCHAR(255) NOT NULL,
    "name" VARCHAR(255)
);

INSERT INTO app_user (email, password, name)
VALUES ('user1@example.com', 'password1', 'User One'),
       ('user2@example.com', 'password2', 'User Two');