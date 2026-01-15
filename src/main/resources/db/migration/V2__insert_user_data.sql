INSERT INTO users (
    id,
    name,
    email,
    password,
    phone,
    active
) VALUES (
     gen_random_uuid(),
     'ADM_SUPPORT',
     'adm-support@inovate-barber.com',
     'adm',
     '42988652291',
     TRUE
);

INSERT INTO users (
    id,
    name,
    email,
    password,
    phone,
    active
) VALUES (
     gen_random_uuid(),
     'ADM_SUPPORT_1',
     'adm-support-1@inovate-barber.com',
     'adm',
     '42988652291',
     TRUE
);
