CREATE TABLE IF NOT EXISTS base_entity
(
    uuid        VARCHAR(36)                     UNIQUE NOT NULL,
    created_at  TIMESTAMP(0) WITHOUT TIME ZONE  NOT NULL,
    updated_at  TIMESTAMP(0) WITHOUT TIME ZONE  NOT NULL,
    version     BIGINT                          NOT NULL
);
