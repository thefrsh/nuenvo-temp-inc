CREATE TABLE IF NOT EXISTS thermometers
(
    id          BIGINT      NOT NULL UNIQUE,
    room_id     BIGINT,
    FOREIGN KEY (room_id)   REFERENCES rooms(id),
    PRIMARY KEY (id)

) INHERITS (base_entity);

DO $$ BEGIN
    PERFORM create_sequence_for('thermometers');
END $$;
