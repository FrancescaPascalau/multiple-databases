CREATE TABLE IF NOT EXISTS tenant
(
    tenant_id VARCHAR(255) NOT NULL,
    schema    VARCHAR(255),
    CONSTRAINT pk_tenant PRIMARY KEY (tenant_id)
    );

CREATE TABLE IF NOT EXISTS employee
(
    id        BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    full_name VARCHAR(255),
    CONSTRAINT pk_employee PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS payment
(
    id          BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    employeeId BIGINT,
    amount      BIGINT,
    CONSTRAINT pk_payment PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS receipt
(
    id          BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    employeeId BIGINT,
    amount      BIGINT,
    issuedAt   TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_receipt PRIMARY KEY (id)
    );