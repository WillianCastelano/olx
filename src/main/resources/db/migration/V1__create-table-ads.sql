CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE ads (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    price NUMERIC(10,2),
    category VARCHAR(100),
    condition VARCHAR(50),
    status VARCHAR(50),
    created_by_user BIGINT REFERENCES users(id)
);
CREATE TABLE addresses (
    id BIGSERIAL PRIMARY KEY,
    street VARCHAR(255),
    number BIGINT,
    complement VARCHAR(255),
    district VARCHAR(255),
    city VARCHAR(255),
    zip_code VARCHAR(20),
    uf VARCHAR(2), -- armazenando a sigla do estado (ex: SP, RJ, MG)
    user_id BIGINT,
    CONSTRAINT fk_user_address FOREIGN KEY (user_id) REFERENCES users(id)
);
