INSERT
INTO
  customer
  (id, name, email, shipping_address)
VALUES
  (1, 'Adeleke', 'adeleke@gmail.com', 'Dallas Tx');

INSERT
INTO
  customer
  (id, name, email, shipping_address)
VALUES
  (2, 'omotayo', 'omotayo@outlook.com', 'Dallas Tx');

INSERT
INTO
  stock
  (id, item, unit_price, timestamp)
VALUES
  (1, 'washing machine', 150, NOW());

INSERT
INTO
  stock
  (id, item, unit_price, timestamp)
VALUES
  (2, 'Blender', 100, NOW());

INSERT
INTO
  stock
  (id, item, unit_price, timestamp)
VALUES
  (3, 'Plasma', 120, NOW());

INSERT
INTO
  transaction
  (id, stock_id, quantity, customer_id, timestamp, total_price)
VALUES
  (1, 1, 2, 1, NOW(),300);

INSERT
INTO
  transaction
  (id, stock_id, quantity, customer_id, timestamp, total_price)
VALUES
  (2, 1, 1, 2, NOW(),150);

INSERT
INTO
  transaction
  (id, stock_id, quantity, customer_id, timestamp, total_price)
VALUES
  (3, 3, 2, 2, NOW(),240);

INSERT
INTO
  reward
  (id, customer_id, per_1_dollar, total_reward, per_50_dollar, transaction_id)
VALUES
  (1, 1, 50, 100, 50, 1);


INSERT
INTO
  reward
  (id, customer_id, per_1_dollar, total_reward, per_50_dollar, transaction_id)
VALUES
  (2, 2, 50, 100, 50, 2);

INSERT
  INTO
    reward
    (id, customer_id, per_1_dollar, total_reward, per_50_dollar, transaction_id)
  VALUES
    (3, 2, 100, 150, 50, 3);