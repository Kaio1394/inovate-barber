CREATE TABLE barbershops (
    id UUID PRIMARY KEY,
    fantasy_name VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    cnpj VARCHAR(14) NOT NULL UNIQUE,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP,
    CONSTRAINT uk_barbers_cnpj UNIQUE (cnpj)
);