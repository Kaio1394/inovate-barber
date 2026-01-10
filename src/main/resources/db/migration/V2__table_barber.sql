CREATE TABLE barbers(
    id UUID PRIMARY KEY,
    full_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone VARCHAR(30) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    barbershop_id UUID NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP,
    CONSTRAINT uk_barbers_email UNIQUE (email),
    CONSTRAINT uk_barbers_cpf UNIQUE (cpf),
    CONSTRAINT fk_barber_barbershop
        FOREIGN KEY (barbershop_id)
        REFERENCES barbershops (id)
);