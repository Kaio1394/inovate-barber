CREATE TABLE users (
   id UUID PRIMARY KEY,
   name VARCHAR(255) NOT NULL,
   email VARCHAR(255) NOT NULL UNIQUE,
   password VARCHAR(255) NOT NULL,
   phone VARCHAR(255) NOT NULL,
   active BOOLEAN NOT NULL DEFAULT TRUE,
   created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
   updated_at TIMESTAMP
);

CREATE TABLE barbershops (
    id UUID PRIMARY KEY,
    fantasy_name VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    uf VARCHAR(2) NOT NULL,
    cnpj VARCHAR(14) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP,
    CONSTRAINT uk_barbershop_cnpj UNIQUE (cnpj)
);

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

CREATE TABLE user_barbershop (
     user_id UUID NOT NULL,
     barbershop_id UUID NOT NULL,
     role VARCHAR(50) NOT NULL,
     PRIMARY KEY (user_id, barbershop_id),
     CONSTRAINT fk_user_barbershop_user
         FOREIGN KEY (user_id) REFERENCES users(id),
     CONSTRAINT fk_user_barbershop_barbershop
         FOREIGN KEY (barbershop_id) REFERENCES barbershops(id)
);