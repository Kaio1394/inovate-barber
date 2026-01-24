CREATE TABLE users (
   id UUID PRIMARY KEY,
   email VARCHAR(255) NOT NULL,
   firebase_id VARCHAR(255) NOT NULL UNIQUE,
   active BOOLEAN NOT NULL DEFAULT TRUE,
   created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
   updated_at TIMESTAMP,
   constraint uk_user_email UNIQUE(email),
   constraint uk_firebase_id UNIQUE(firebase_id)
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

CREATE TABLE customers(
    id UUID PRIMARY KEY,
    full_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP,
    CONSTRAINT uk_customer_full_name UNIQUE(full_name),
    CONSTRAINT uk_customer_cpf UNIQUE(cpf)
);


CREATE TABLE products(
    id UUID PRIMARY KEY,
    description VARCHAR(255),
    price DOUBLE NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP,
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

CREATE TABLE barbershop_customer(
    barbershop_id UUID NOT NULL,
    customer_id UUID NULL,
    PRIMARY KEY (barbershop_id, customer_id),
    CONSTRAINT fk_barbershop_customer_barbershop
        FOREIGN KEY (barbershop_id) REFERENCES barbershops(id),
    CONSTRAINT fk_barbershop_customer_customer
        FOREIGN KEY (customer_id) REFERENCES customers(id)
);



-- CREATE TABLE barbers(
--     id UUID PRIMARY KEY,
--     full_name VARCHAR(255) NOT NULL,
--     email VARCHAR(255) NOT NULL,
--     phone VARCHAR(30) NOT NULL,
--     cpf VARCHAR(14) NOT NULL,
--     barbershop_id UUID NOT NULL,
--     created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
--     updated_at TIMESTAMP,
--     CONSTRAINT uk_barbers_email UNIQUE (email),
--     CONSTRAINT uk_barbers_cpf UNIQUE (cpf),
--     CONSTRAINT fk_barber_barbershop
--         FOREIGN KEY (barbershop_id)
--             REFERENCES barbershops (id)
-- );

