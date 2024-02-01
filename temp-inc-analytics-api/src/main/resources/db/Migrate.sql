CREATE TABLE IF NOT EXISTS base_entity
(
    uuid        VARCHAR(36)                     UNIQUE NOT NULL,
    created_at  TIMESTAMP(0) WITHOUT TIME ZONE  NOT NULL,
    updated_at  TIMESTAMP(0) WITHOUT TIME ZONE  NOT NULL,
    version     BIGINT                          NOT NULL
);

CREATE TABLE IF NOT EXISTS rooms
(
    id          BIGINT      NOT NULL UNIQUE,
    PRIMARY KEY (id)

) INHERITS (base_entity);

CREATE TABLE IF NOT EXISTS thermometers
(
    id          BIGINT      NOT NULL UNIQUE,
    room_id     BIGINT,
    FOREIGN KEY (room_id)   REFERENCES rooms(id),
    PRIMARY KEY (id)

) INHERITS (base_entity);

CREATE TABLE IF NOT EXISTS anomalies
(
    id             BIGINT                           NOT NULL UNIQUE,
    temperature    DOUBLE PRECISION                 NOT NULL,
    deviation      DOUBLE PRECISION                 NOT NULL,
    timestamp      INT                              NOT NULL,
    room_id        BIGINT                           NOT NULL,
    thermometer_id BIGINT                           NOT NULL,
    FOREIGN KEY    (thermometer_id)                 REFERENCES thermometers(id),
    FOREIGN KEY    (room_id)                        REFERENCES rooms(id),
    PRIMARY KEY    (id)

) INHERITS (base_entity);
