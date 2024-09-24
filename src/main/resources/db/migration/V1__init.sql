CREATE TABLE IF NOT EXISTS wallet (
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    full_name TEXT NOT NULL,
    cpf_cnpj TEXT UNIQUE NOT NULL,
    email TEXT UNIQUE NOT NULL,
    password TEXT NOT NULL,
    is_merchant BOOLEAN NOT NULL DEFAULT FALSE,
    balance NUMERIC(15, 2) NOT NULL DEFAULT 0.00
);

CREATE TABLE IF NOT EXISTS transfer (
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    sender_id BIGINT REFERENCES wallet(id) ON DELETE CASCADE,
    receiver_id BIGINT REFERENCES wallet(id) ON DELETE CASCADE,
    amount NUMERIC(15, 2) NOT NULL CHECK (amount > 0),
    created_at TIMESTAMP WITH TIME ZONE DEFAULT NOW()
);