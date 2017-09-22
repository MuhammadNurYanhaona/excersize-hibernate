create TABLE cards (
  id NUMBER not null,
  issuer VARCHAR2(100),
  brand VARCHAR2(100),
  pan VARCHAR2(16),
  CONSTRAINT card_pk PRIMARY KEY (id)
);

CREATE TABLE debit_cards (
  card_id NUMBER not null,
  account_no VARCHAR2(20),
  pin VARCHAR2(6),
  CONSTRAINT db_card_pk PRIMARY  KEY (card_id),
  CONSTRAINT db_card_fk FOREIGN KEY (card_id) REFERENCES cards(id)
);

CREATE TABLE credit_cards (
  card_id NUMBER not null,
  interest_rate FLOAT,
  transaction_limit NUMBER,
  CONSTRAINT cr_card_pk PRIMARY  KEY (card_id),
  CONSTRAINT cr_card_fk FOREIGN KEY (card_id) REFERENCES cards(id)
);