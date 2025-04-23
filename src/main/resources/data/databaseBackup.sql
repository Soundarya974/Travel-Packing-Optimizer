INSERT INTO travel_items (name, weight, importance, is_fragile) VALUES
('T-Shirt', 2, 5, false),
('Pant', 2, 5, false),
('Toothbrush', 1, 9, false),
('Jeans', 3, 6, false),
('Jacket', 2, 8, false),
('Umbrella', 1, 7, false),
('Sunscreen', 1, 9, false),
('Laptop', 3, 10, true),
('Swimsuit', 2, 4, false),
('Trekking Shoes', 3, 8, false),
('Power Bank', 2, 9, true),
('Rain Coat', 2, 6, false),
('Phone Charger', 2, 10, true),
('Reusable Water Bottle', 3, 7, false),
('Hand Sanitizer', 1, 9, false),
('Notebook & Pen', 1, 5, false),
('Headphones', 1, 8, true),
('Snacks', 2, 7, false),
('Passport/ID', 1, 10, false),
('Medications', 1, 9, true),
('Sunglasses', 1, 9, false);



INSERT INTO seasons(id, name) VALUES
 (1, 'Summer'),
 (2, 'Winter'),
 (3, 'Monsoon'),
 (4, 'Spring');


INSERT INTO travel_types (id, name) VALUES
(1, 'Default'),
(2, 'Business'),
(3, 'Relaxation'),
(4, 'Adventure'),
(5, 'Trekking'),
(6, 'Family'),
(7, 'Backpacking');


INSERT INTO item_mappings (travel_type_id, item_id) VALUES
(1, 1),  -- T-shirt
(1, 2),  -- Pant
(1, 3),  -- Toothbrush
(1, 4),  -- Jeans
(1, 8),  -- Laptop
(1, 11), -- Power Bank
(1, 13), -- Phone Charger
(1, 14), -- Reusable Water Bottle
(1, 15), -- Hand Sanitizer
(2, 8),  -- Laptop for Business
(2, 11), -- Power Bank for Business
(2, 19), -- Passport/ID for Business
(3, 9),  -- Swimsuit for Relaxation
(3, 17),  -- Headphones for Relaxation
(4, 10), -- Trekking Shoes for Adventure
(4, 16), -- Notebook and Pen for Adventure
(6, 18), -- Snacks for Family
(6, 20), -- Medications for Family
(7, 10) -- Trekking Shoes for Backpacking
;


INSERT INTO item_mappings (season_id, item_id) VALUES
(1, 7),  -- Sunscreen for Summer
(2, 5), -- Jacket for Winter
(3, 6), -- Umbrella for Monsoon
(3, 12), -- Rain coat for Monsoon
(1, 1), -- T-Shirt for summer
(1,21)  -- Sunglasses for Summer
;

