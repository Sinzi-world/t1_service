CREATE TABLE clients (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    is_blocked BOOLEAN DEFAULT TRUE NOT NULL
);

CREATE TABLE accounts (
    id UUID PRIMARY KEY,
    client_id UUID NOT NULL REFERENCES clients(id),
    balance DECIMAL(15, 2) NOT NULL,
    is_frozen BOOLEAN DEFAULT TRUE NOT NULL
);
