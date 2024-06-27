CREATE TABLE customer (
    id BIGSERIAL PRIMARY KEY NOT NULL,
    full_name VARCHAR(200) NOT NULL,
    id_number VARCHAR(20) NOT NULL,
    phone VARCHAR(10) NOT NULL,
    email VARCHAR(200),
    address VARCHAR(250),
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE reception (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    phone VARCHAR(10) NOT NULL,
    email VARCHAR(200),
    address VARCHAR(250),
    price DECIMAL(10,2),
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE event (
    id BIGSERIAL PRIMARY KEY,
    customer_id BIGINT,
    reception_id BIGINT,
    description VARCHAR(30) NOT NULL,
    capacity INTEGER,
    start_date TIMESTAMP,
    end_date TIMESTAMP,
    status VARCHAR(50),
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW(),
    CONSTRAINT fk_customer_id FOREIGN KEY (customer_id) REFERENCES customer (id),
    CONSTRAINT fk_reception_id FOREIGN KEY (reception_id) REFERENCES reception (id)
);