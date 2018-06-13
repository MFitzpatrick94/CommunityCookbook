INSERT INTO Category (CategoryId, CategoryName) VALUE (1, 'Breakfast')
INSERT INTO Category (CategoryId, CategoryName) VALUE (2, 'Appetizers')
INSERT INTO Category (CategoryId, CategoryName) VALUE (3, 'Salad/Soup')
INSERT INTO Category (CategoryId, CategoryName) VALUE (4, 'Entree')
INSERT INTO Category (CategoryId, CategoryName) VALUE (5, 'Dessert')
INSERT INTO Category (CategoryId, CategoryName) VALUE (6, 'Drinks')
INSERT INTO Amount VALUES(1, '1/8');
INSERT INTO Amount VALUES(2, '1/4');
INSERT INTO Amount VALUES(3, '1/3');
INSERT INTO Amount VALUES(4, '1/2');
INSERT INTO Amount VALUES(5, '3/4');
INSERT INTO Amount VALUES(6, '2/3');
INSERT INTO Amount VALUES(7, '1');
INSERT INTO Amount VALUES(8, '1 1/4');
INSERT INTO Amount VALUES(9, '1 1/3');
INSERT INTO Amount VALUES(10, '1 1/2');
INSERT INTO Amount VALUES(11, '1 3/4');
INSERT INTO Amount VALUES(12, '1 2/3');
INSERT INTO Amount VALUES(13, '2');
INSERT INTO Amount VALUES(14, '2 1/4');
INSERT INTO Amount VALUES(15, '2 1/3');
INSERT INTO Amount VALUES(16, '2 1/2');
INSERT INTO Amount VALUES(17, '2 3/4');
INSERT INTO Amount VALUES(18, '2 2/3');
INSERT INTO Amount VALUES(19, '3');
INSERT INTO Amount VALUES(20, '3 1/2');
INSERT INTO Amount VALUES(21, '4');
INSERT INTO Amount VALUES(22, '4 1/2');
INSERT INTO Amount VALUES(23, '5');
INSERT INTO Amount VALUES(24, '6');
INSERT INTO Amount VALUES(25, '8');
INSERT INTO Amount VALUES(26, 'Pinch');
INSERT INTO measurement VALUES(1, 'tsp');
INSERT INTO measurement VALUES(2, 'Tbsp');
INSERT INTO measurement VALUES(3, 'cups');
INSERT INTO measurement VALUES(4, 'oz');
INSERT INTO measurement VALUES(5, 'pounds');
INSERT INTO measurement VALUES(6, 'liters');
INSERT INTO measurement VALUES(7, 'box');
INSERT INTO measurement VALUES(8, 'can');
INSERT INTO measurement VALUES(9, 'jar');
INSERT INTO Recipe VALUES(1, 'Broccoli Quinoa Salad', null, 'IFOODREAL', '20 mins', 6, 3, null)
INSERT INTO Ingredient VALUES(1, 'Quinoa, uncooked', 1, 7, 3);
INSERT INTO Ingredient VALUES(2, 'Water', 1, 10, 3);
INSERT INTO Ingredient VALUES(3, 'Almonds, slivered or corsley chopped', 1, 7, 3);
INSERT INTO Ingredient VALUES(4, 'Broccoli (including stems), cut into small chunks', 1, 10, 5);
INSERT INTO Ingredient VALUES(5, 'Herbs, finely chopped', 1, 7,3);
INSERT INTO Ingredient VALUES(6, 'Olive Oil, Extra Virgin', 1, 19, 2);
INSERT INTO Ingredient VALUES(7, 'Lemon Zest', 1, 4, null);
INSERT INTO Ingredient VALUES(8, 'Lemon Juice', 1, 4, 2);
INSERT INTO Ingredient VALUES(9, 'Salt', 1, 5, 1);
INSERT INTO INgredient VALUES(10, 'Black Pepper, ground', 1, 2, 1)
INSERT INTO Directions VALUES(1, 'In a medium pot, add quinoa, water, and a pinch of salt. Cover, bring to a boil, reduce heat to low and cook
for 10 minues. Remove from heat, let stand for 5 minutes and fluff with a fork. Set aside to cool.', 1,null, 1);
INSERT INTO Directions VALUES(2, 'While quinoa cooks, preheat small skillet on low and add almonds. Toast until golden brownm stirring
occasionally. Set aside to cool.', 2, null, 1);
INSERT INTO Directions VALUES(3, 'In a food processor, add broccoli and process in batches until coarsley chopped. Add to a large bowl along
with remaining ingredients and gently stir to combine. Serve cold.',3,'I add more oil and season to taste as quinoa can be very dry otherwise',
1)
