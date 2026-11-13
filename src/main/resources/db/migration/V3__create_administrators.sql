CREATE TABLE administrators (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100) NOT NULL UNIQUE CHECK (length(trim(username)) > 0),
    password_hash VARCHAR(60) NOT NULL,
    active BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP(6) NOT NULL DEFAULT CURRENT_TIMESTAMP
);
-- A primeira conta é provisionada interativamente, nunca por seed de senha.