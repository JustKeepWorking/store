CREATE TABLE student (
  id   SERIAL PRIMARY KEY,
  name VARCHAR(200),
  age  INTEGER
);

INSERT INTO student (name, age) VALUES ('NGUYEN`DUY`HAI', 20);

CREATE OR REPLACE FUNCTION get_all_student( INTEGER ) RETURNS refcursor  AS $$
DECLARE
  curs refcursor;
BEGIN
  OPEN curs FOR SELECT * FROM student WHERE id = $1;
  return curs;
END
$$ LANGUAGE plpgsql;