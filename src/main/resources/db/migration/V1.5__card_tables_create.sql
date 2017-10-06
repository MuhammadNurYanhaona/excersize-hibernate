create TABLE cards (
  id INTEGER not null,
  issuer VARCHAR(100),
  brand VARCHAR(100),
  pan VARCHAR(16),
  CONSTRAINT card_pk PRIMARY KEY (id)
);

CREATE TABLE debit_cards (
  card_id INTEGER not null,
  account_no VARCHAR(20),
  pin VARCHAR(6),
  CONSTRAINT db_card_pk PRIMARY  KEY (card_id),
  CONSTRAINT db_card_fk FOREIGN KEY (card_id) REFERENCES cards(id)
);

CREATE TABLE credit_cards (
  card_id INTEGER not null,
  interest_rate REAL,
  transaction_limit INTEGER ,
  CONSTRAINT cr_card_pk PRIMARY  KEY (card_id),
  CONSTRAINT cr_card_fk FOREIGN KEY (card_id) REFERENCES cards(id)
);