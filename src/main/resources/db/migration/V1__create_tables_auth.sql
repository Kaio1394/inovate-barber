CREATE TABLE users (
   id UUID PRIMARY KEY,
   email VARCHAR(255) NOT NULL,
   firebase_id VARCHAR(255) NOT NULL UNIQUE,
   active BOOLEAN NOT NULL DEFAULT TRUE,
   created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
   updated_at TIMESTAMP,
   constraint uk_users_email UNIQUE(email),
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
    CONSTRAINT uk_barbershops_cnpj UNIQUE (cnpj)
);

CREATE TABLE customers(
    id UUID PRIMARY KEY,
    full_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP,
    CONSTRAINT uk_customers_full_name UNIQUE(full_name),
    CONSTRAINT uk_customers_cpf UNIQUE(cpf)
);


CREATE TABLE products(
    id UUID PRIMARY KEY,
    barbershop_id UUID NOT NULL,
    name VARCHAR(255),
    description VARCHAR(255),
    sku VARCHAR(255),
    product_unit VARCHAR(255),
    product_type VARCHAR(255),
    cost_price DOUBLE NOT NULL,
    sale_price DOUBLE NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP,
    CONSTRAINT uk_sku UNIQUE(sku),
    CONSTRAINT fk_products_barbershops
        FOREIGN KEY (barbershop_id) REFERENCES barbershops(id)
);

CREATE TABLE user_barbershop (
     user_id UUID NOT NULL,
     barbershop_id UUID NOT NULL,
     role VARCHAR(50) NOT NULL,
     PRIMARY KEY (user_id, barbershop_id),
     CONSTRAINT fk_user_barbershops_user
         FOREIGN KEY (user_id) REFERENCES users(id),
     CONSTRAINT fk_user_barbershops_barbershops
         FOREIGN KEY (barbershop_id) REFERENCES barbershops(id)
);

CREATE TABLE barbershop_customer(
    barbershop_id UUID NOT NULL,
    customer_id UUID NULL,
    PRIMARY KEY (barbershop_id, customer_id),
    CONSTRAINT fk_barbershops_customers_barbershops
        FOREIGN KEY (barbershop_id) REFERENCES barbershops(id),
    CONSTRAINT fk_barbershops_customers_customers
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

