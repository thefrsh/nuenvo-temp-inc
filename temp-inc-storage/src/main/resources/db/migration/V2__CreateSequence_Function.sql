CREATE OR REPLACE FUNCTION create_sequence_for(table_name VARCHAR) RETURNS VOID
    LANGUAGE plpgsql
AS $$
BEGIN
    EXECUTE format(
            'CREATE SEQUENCE IF NOT EXISTS %1$s_seq '
                'AS BIGINT '
                'INCREMENT BY 1 '
                'MINVALUE 1 '
                'START WITH 1 '
                'OWNED BY %1$s.id;', table_name
            );
END
$$;
