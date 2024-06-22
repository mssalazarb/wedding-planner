CREATE TABLE supplier_type (
    id BIGSERIAL PRIMARY KEY,
    type VARCHAR(30) NOT NULL UNIQUE,
    supplier_name VARCHAR(30) NOT NULL,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP
);

CREATE TABLE supplier (
    id BIGSERIAL PRIMARY KEY,
    supplier_type_id BIGINT,
    phone VARCHAR(10) NOT NULL,
    email VARCHAR(200) NOT NULL UNIQUE,
    high_street VARCHAR(150) NOT NULL,
    side_street VARCHAR(150) NOT NULL,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP,
    CONSTRAINT fk_supplier_type_id FOREIGN KEY (supplier_type_id) REFERENCES supplier_type (id)
);