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

DO $$ BEGIN
    PERFORM create_sequence_for('anomalies');
END $$;
