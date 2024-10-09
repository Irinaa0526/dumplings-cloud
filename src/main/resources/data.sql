delete from Ingredient_Ref;
delete from Dumplings;
delete from Dumplings_Order;
delete from Ingredient;

insert into Ingredient (id, name, type) values ('CLS', 'Classic', 'WRAP');
insert into Ingredient (id, name, type) values ('TMT', 'Tomato', 'WRAP');
insert into Ingredient (id, name, type) values ('GRC', 'Garlic', 'WRAP');
insert into Ingredient (id, name, type) values ('SPN', 'Spinach', 'WRAP');

insert into Ingredient (id, name, type) values ('BF', 'Beef', 'PROTEIN');
insert into Ingredient (id, name, type) values ('PRK', 'Pork', 'PROTEIN');
insert into Ingredient (id, name, type) values ('LMB', 'Lamb', 'PROTEIN');
insert into Ingredient (id, name, type) values ('CHKN', 'Chicken', 'PROTEIN');

insert into Ingredient (id, name, type) values ('CHED', 'Cheddar', 'CHEESE');
insert into Ingredient (id, name, type) values ('JACK', 'Monterrey Jack', 'CHEESE');

insert into Ingredient (id, name, type) values ('TOM', 'Tomato', 'SAUCE');
insert into Ingredient (id, name, type) values ('MNS', 'Mayonnaise', 'SAUCE');
insert into Ingredient (id, name, type) values ('SCR', 'Sour cream', 'SAUCE');
insert into Ingredient (id, name, type) values ('GAR', 'Garlic', 'SAUCE');
insert into Ingredient (id, name, type) values ('TKE', 'Tkemali', 'SAUCE');
insert into Ingredient (id, name, type) values ('MATS', 'Matsoni', 'SAUCE');
insert into Ingredient (id, name, type) values ('SATS', 'Satsebeli', 'SAUCE');
insert into Ingredient (id, name, type) values ('ADJ', 'Adjika', 'SAUCE');