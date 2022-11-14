INSERT
INTO
  customer
  (id, name, email, shipping_address)
VALUES
  (10001, 'Adeleke', 'adeleke@gmail.com', 'Dallas Tx');

INSERT
INTO
  customer
  (id, name, email, shipping_address)
VALUES
  (10002, 'omotayo', 'omotayo@outlook.com', 'Dallas Tx');

INSERT
INTO
  stock
  (id, item, unit_price, timestamp)
VALUES
  (10001, 'washing machine', 150, NOW());

INSERT
INTO
  stock
  (id, item, unit_price, timestamp)
VALUES
  (10002, 'Blender', 100, NOW());

INSERT
INTO
  stock
  (id, item, unit_price, timestamp)
VALUES
  (10003, 'Plasma', 120, NOW());

INSERT
INTO
  transaction
  (id, stock_id, quantity, customer_id, timestamp, total_price)
VALUES
  (10001, 10001, 2, 10001, NOW(),300);

INSERT
INTO
  transaction
  (id, stock_id, quantity, customer_id, timestamp, total_price)
VALUES
  (10002, 10001, 1, 10002, NOW(),150);

INSERT
INTO
  transaction
  (id, stock_id, quantity, customer_id, timestamp, total_price)
VALUES
  (10003, 10003, 2, 10002, NOW(),240);

INSERT
INTO
  reward
  (id, customer_id, per_1_dollar, total_reward, per_50_dollar, transaction_id)
VALUES
  (10001, 10001, 50, 100, 50, 10001);


INSERT
INTO
  reward
  (id, customer_id, per_1_dollar, total_reward, per_50_dollar, transaction_id)
VALUES
  (10002, 10002, 50, 100, 50, 10002);

INSERT
  INTO
    reward
    (id, customer_id, per_1_dollar, total_reward, per_50_dollar, transaction_id)
  VALUES
    (10003, 10002, 100, 150, 50, 10003);