CREATE TABLE customer (
    id BIGSERIAL PRIMARY KEY NOT NULL,
    full_name VARCHAR(200) NOT NULL,
    phone VARCHAR(10) NOT NULL,
    email VARCHAR(200),
    address VARCHAR(250),
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW()
);