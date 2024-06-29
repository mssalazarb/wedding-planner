CREATE TABLE user_type (
    id BIGSERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(100) NOT NULL,
    related_table VARCHAR(100),
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE user_system (
    id BIGSERIAL PRIMARY KEY NOT NULL,
    user_name VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(200) NOT NULL,
    user_type_id BIGINT NOT NULL,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW(),
    CONSTRAINT fk_user_type_id FOREIGN KEY (user_type_id) REFERENCES user_type (id)
);

ALTER TABLE customer
ADD COLUMN user_id BIGINT DEFAULT NULL,
ADD CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES user_system(id);
