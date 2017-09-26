create table articles (
  article_id NUMBER not null,
  title VARCHAR2(100),
  category VARCHAR2(100),
  CONSTRAINT article_pk PRIMARY KEY (article_id)
);

CREATE SEQUENCE article_seq
 START WITH     10
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;