--Initialize ingredient table
INSERT INTO burger_builder.ingredient (ingredient_id, created_at, name, price, init_number, updated_at) VALUES (1, sysdate(), 'cheese', 0.4, 1, sysdate());
INSERT INTO burger_builder.ingredient (ingredient_id, created_at, name, price, init_number, updated_at) VALUES (2, sysdate(), 'salad', 0.5, 1, sysdate());
INSERT INTO burger_builder.ingredient (ingredient_id, created_at, name, price, init_number, updated_at) VALUES (3, sysdate(), 'bacon', 0.7, 1, sysdate());
INSERT INTO burger_builder.ingredient (ingredient_id, created_at, name, price, init_number, updated_at) VALUES (4, sysdate(), 'meat', 1.3, 1, sysdate());

--Initialize user table
--INSERT INTO burger_builder.user (email, name, city, state, street, zip_code, created_date, updated_date) VALUES ('margad@gmail.com', 'margad-erdene' , 'melbourne', 'victoria', 'Mt Alexander Road', 3032, sysdate(), sysdate());
