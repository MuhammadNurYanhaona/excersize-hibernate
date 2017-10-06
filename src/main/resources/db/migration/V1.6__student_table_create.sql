create TABLE student (
  id INTEGER not null,
  name VARCHAR(50) not NULL,
  batch VARCHAR(5),
  birth_date DATE,
  school VARCHAR(50),
  profle text,
  CONSTRAINT student_pk PRIMARY KEY (id)
);