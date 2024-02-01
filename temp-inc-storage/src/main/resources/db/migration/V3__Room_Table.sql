CREATE TABLE IF NOT EXISTS rooms
(
    id          BIGINT      NOT NULL UNIQUE,
    PRIMARY KEY (id)

) INHERITS (base_entity);

DO $$ BEGIN
    PERFORM create_sequence_for('rooms');
END $$;
