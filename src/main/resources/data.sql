-- Inserting data into investor table
INSERT INTO investor (id, name, surname, contact_number, created_at, updated_at, line_1, line_2, suburb, address_city, address_postal) VALUES
(1, 'John', 'Doe', '123456789', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, '123 Main St', 'Apt 101', 'Springfield', 'Anytown', '12345'),
(2, 'Jane', 'Smith', '987654321', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, '456 Oak St', 'Unit 202', 'Maplewood', 'Othertown', '54321'),
(3, 'Michael', 'Johnson', '5551234567', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, '789 Elm St', NULL, 'Rivertown', 'Sometown', '67890'),
(4, 'Emily', 'Brown', '7779876543', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, '321 Pine St', 'Suite 404', 'Greenville', 'Anothertown', '09876'),
(5, 'David', 'Lee', '2223334444', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, '654 Birch St', NULL, 'Hilltown', 'Neighborhood', '13579');

-- Inserting data into product table
INSERT INTO product (id, investor_id, product_type, balance, created_at, updated_at) VALUES
(1, 1, 'Savings', 1000.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(2, 2, 'Checking', 2500.50, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(3, 3, 'Investment', 50000.75, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(4, 4, 'Savings', 750.25, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(5, 5, 'Checking', 12000.80, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

---- Inserting data into notice table
--INSERT INTO notice (id, account_number, investor_id, amount, product_type, created_at, updated_at) VALUES
--(1, '123456788', 1, 100.00, 'Savings', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
--(2, '123456788', 2, 50.00, 'Checking', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
--(3, '123456788', 3, 200.00, 'Investment', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
--(4, '1234567881', 4, 75.00, 'Savings', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
--(5, '1234567881', 5, 150.00, 'Checking', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
