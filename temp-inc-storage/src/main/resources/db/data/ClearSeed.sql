TRUNCATE TABLE anomalies CASCADE;
TRUNCATE TABLE thermometers CASCADE;
TRUNCATE TABLE rooms CASCADE;

INSERT INTO rooms (uuid, created_at, updated_at, version, id)
VALUES (gen_random_uuid(), current_timestamp, current_timestamp, 1, 1);

INSERT INTO thermometers (uuid, created_at, updated_at, version, id, room_id)
VALUES (gen_random_uuid(), current_timestamp, current_timestamp, 1, 1, 1);
