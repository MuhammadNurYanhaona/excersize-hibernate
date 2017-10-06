create table articles (
  article_id INTEGER not null,
  title VARCHAR(100),
  category VARCHAR(100),
  CONSTRAINT article_pk PRIMARY KEY (article_id)
);

CREATE SEQUENCE article_seq
 START WITH     10
 INCREMENT BY   1
 NO CYCLE;