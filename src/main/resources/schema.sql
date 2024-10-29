create table if not exists Dumplings_Order (
    id identity,
    delivery_Name varchar(50) not null,
    delivery_Street varchar(50) not null,
    delivery_City varchar(50) not null,
    delivery_State varchar(2) not null,
    delivery_Zip varchar(10) not null,
    cc_number varchar(16) not null,
    cc_expiration varchar(5) not null,
    cc_cvv varchar(3) not null,
    placed_at timestamp not null
);

create table if not exists Dumplings (
    id identity,
    name varchar(50) not null,
    size int,
    dumplings_order bigint not null,
    dumplings_order_key bigint not null,
    created_at timestamp not null
);

-- create table if not exists Ingredient_Ref (
--     ingredient_id varchar(4) not null,
--     dumplings_id bigint not null,
--     dumplings_key bigint not null
-- );

create table if not exists Ingredient (
    id varchar(4) not null,
    name varchar(25) not null,
    type varchar(10) not null
);

alter table Ingredient add primary key (id);
alter table Dumplings add foreign key (dumplings_order) references Dumplings_Order(id);
-- alter table Ingredient_Ref add primary key (ingredient_id, dumplings_id);
-- alter table Ingredient_Ref add foreign key (ingredient_id) references Ingredient(id);
-- alter table Ingredient_Ref add foreign key (dumplings_id) references Dumplings(id);