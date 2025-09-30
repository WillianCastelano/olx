-- Tabela de usuários
CREATE TABLE IF NOT EXISTS users (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    phone_number BIGINT,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    created_on TIMESTAMP DEFAULT NOW(),
    updated_on TIMESTAMP,
    deleted_on TIMESTAMP,
    created_by BIGINT,
    updated_by BIGINT,
    deleted_by BIGINT
);

-- Tabela de endereços
CREATE TABLE IF NOT EXISTS addresses (
    id BIGINT PRIMARY KEY,
    street VARCHAR(255) NOT NULL,
    number BIGINT,
    complement VARCHAR(255),
    district VARCHAR(255),
    city VARCHAR(255),
    zip_code VARCHAR(50),
    uf CHAR(2),
    user_id BIGINT REFERENCES users(id) ON DELETE CASCADE
);

-- Tabela de anúncios (simplificada como string no JSON, você pode detalhar depois)
CREATE TABLE IF NOT EXISTS ads (
    id BIGINT PRIMARY KEY,
    user_id BIGINT REFERENCES users(id) ON DELETE CASCADE,
    title VARCHAR(255),
    description TEXT,
    price DECIMAL(10,2),
    created_on TIMESTAMP DEFAULT NOW()
);
