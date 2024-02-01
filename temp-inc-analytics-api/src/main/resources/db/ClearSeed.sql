TRUNCATE TABLE anomalies CASCADE;
TRUNCATE TABLE thermometers CASCADE;
TRUNCATE TABLE rooms CASCADE;

INSERT INTO rooms (uuid, created_at, updated_at, version, id)
VALUES (gen_random_uuid(), current_timestamp, current_timestamp, 1, 1);

INSERT INTO thermometers (uuid, created_at, updated_at, version, id, room_id)
VALUES (gen_random_uuid(), current_timestamp, current_timestamp, 1, 1, 1);

INSERT INTO thermometers (uuid, created_at, updated_at, version, id, room_id)
VALUES (gen_random_uuid(), current_timestamp, current_timestamp, 1, 2, 1);

INSERT INTO anomalies (uuid, created_at, updated_at, version, id, temperature, deviation, timestamp, room_id, thermometer_id)
VALUES (gen_random_uuid(), current_timestamp, current_timestamp, 1, 1, 20.1, 4.1, 1706741104, 1, 1);

INSERT INTO anomalies (uuid, created_at, updated_at, version, id, temperature, deviation, timestamp, room_id, thermometer_id)
VALUES (gen_random_uuid(), current_timestamp, current_timestamp, 1, 2, 20.5, 5.1, 1706741105, 1, 1);

INSERT INTO anomalies (uuid, created_at, updated_at, version, id, temperature, deviation, timestamp, room_id, thermometer_id)
VALUES (gen_random_uuid(), current_timestamp, current_timestamp, 1, 3, 25.1, 6.4, 1706741106, 1, 1);

INSERT INTO anomalies (uuid, created_at, updated_at, version, id, temperature, deviation, timestamp, room_id, thermometer_id)
VALUES (gen_random_uuid(), current_timestamp, current_timestamp, 1, 4, 27.8, 4.8, 1706741107, 1, 1);

INSERT INTO anomalies (uuid, created_at, updated_at, version, id, temperature, deviation, timestamp, room_id, thermometer_id)
VALUES (gen_random_uuid(), current_timestamp, current_timestamp, 1, 5, 26.3, 7.2, 1706741108, 1, 1);

INSERT INTO anomalies (uuid, created_at, updated_at, version, id, temperature, deviation, timestamp, room_id, thermometer_id)
VALUES (gen_random_uuid(), current_timestamp, current_timestamp, 1, 6, 23.7, 3.3, 1706741109, 1, 2);

INSERT INTO anomalies (uuid, created_at, updated_at, version, id, temperature, deviation, timestamp, room_id, thermometer_id)
VALUES (gen_random_uuid(), current_timestamp, current_timestamp, 1, 7, 29.4, 4.9, 1706741110, 1, 2);

INSERT INTO anomalies (uuid, created_at, updated_at, version, id, temperature, deviation, timestamp, room_id, thermometer_id)
VALUES (gen_random_uuid(), current_timestamp, current_timestamp, 1, 8, 27.1, 2.6, 1706741111, 1, 2);

INSERT INTO anomalies (uuid, created_at, updated_at, version, id, temperature, deviation, timestamp, room_id, thermometer_id)
VALUES (gen_random_uuid(), current_timestamp, current_timestamp, 1, 9, 26.6, 8.3, 1706741112, 1, 2);

INSERT INTO anomalies (uuid, created_at, updated_at, version, id, temperature, deviation, timestamp, room_id, thermometer_id)
VALUES (gen_random_uuid(), current_timestamp, current_timestamp, 1, 10, 25.2, 6.5, 1706741113, 1, 2);
