create TABLE birds (
  name VARCHAR2(50) not null,
  scientific_name VARCHAR2(100),
  data_type VARCHAR2(20),
  CONSTRAINT bird_pk PRIMARY KEY (name)
);

CREATE TABLE provincial_birds (
  bird_name VARCHAR2(50) not null,
  found_in VARCHAR2(100),
  CONSTRAINT p_bird_pk PRIMARY  KEY (bird_name),
  CONSTRAINT p_bird_fk FOREIGN KEY (bird_name) REFERENCES birds(name)
);

CREATE TABLE migratory_birds (
  bird_name VARCHAR2(50) not null,
  migration_period VARCHAR2(100),
  CONSTRAINT m_bird_pk PRIMARY  KEY (bird_name),
  CONSTRAINT m_bird_fk FOREIGN KEY (bird_name) REFERENCES birds(name)
);