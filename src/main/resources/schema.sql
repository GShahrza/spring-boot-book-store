

insert into role(role_name) values('ROLE_ADMIN');
insert into role(role_name) values('ROLE_USER');
insert into role(role_name) values('ROLE_PUBLISHER');

insert into account( email, password, username) values('sahrza00@gmail.com','$2a$12$ktrzy..7Lx7Q2OjGxNwfAOu01JsyeWCn9Ie8hyduxc7ttvXgcn2l2','gshahrza');
insert into account( email, password, username) values('user@gmail.com','$2a$12$ktrzy..7Lx7Q2OjGxNwfAOu01JsyeWCn9Ie8hyduxc7ttvXgcn2l2','ex_user');
insert into account( email, password, username) values('publisher@gmail.com','$2a$12$ktrzy..7Lx7Q2OjGxNwfAOu01JsyeWCn9Ie8hyduxc7ttvXgcn2l2','ex_publisher');
insert into account( email, password, username) values('publisher2@gmail.com','$2a$12$ktrzy..7Lx7Q2OjGxNwfAOu01JsyeWCn9Ie8hyduxc7ttvXgcn2l2','ex_publishe2r');
insert into account( email, password, username) values('publisher3@gmail.com','$2a$12$ktrzy..7Lx7Q2OjGxNwfAOu01JsyeWCn9Ie8hyduxc7ttvXgcn2l2','ex_publisher3');
insert into account( email, password, username) values('publisher4@gmail.com','$2a$12$ktrzy..7Lx7Q2OjGxNwfAOu01JsyeWCn9Ie8hyduxc7ttvXgcn2l2','ex_publisher4');


insert into accounts_roles(account_id, role_id) values (1,1);
insert into accounts_roles(account_id, role_id) values (2,2);
insert into accounts_roles(account_id, role_id) VALUES (3,3);
insert into accounts_roles(account_id, role_id) values (4,3);
insert into accounts_roles(account_id, role_id) values (5,3);
insert into accounts_roles(account_id, role_id) values (6,3);

insert into user_profile(first_name, last_name, account_id) values ('Shahrza','Gahramanov',1);
insert into user_profile(first_name, last_name, account_id) values ('User','Example',2);
insert into user_profile(first_name, last_name, account_id) values ('Publisher','Example',3);
insert into user_profile(first_name, last_name, account_id) values ('Publisher2','Example',4);
insert into user_profile(first_name, last_name, account_id) values ('Publisher3','Example',5);
insert into user_profile(first_name, last_name, account_id) values ('Publisher4','Example',6);

insert into category(category_name) values ('CLASSICS');
insert into category(category_name) values ('FANTASY');
insert into category(category_name) values ('HORROR');

insert into book(isbn, rating, tittle, total_pages) values (9780136019701,7.5,'Example Classic Book',100);
insert into book(isbn, rating, tittle, total_pages) values (2560132118409,7.3,'Example Fantasy Book',200);
insert into book(isbn, rating, tittle, total_pages) values (3750032012305,5.9,'Example Horror Book',150);
insert into book(isbn, rating, tittle, total_pages) values (5283430519701,9.4,'Example Classic Book2',96);
insert into book(isbn, rating, tittle, total_pages) values (1382146059724,7.5,'Example Fantasy Book2',132);
insert into book(isbn, rating, tittle, total_pages) values (6742836012713,7.5,'Example Horror Book2',110);

insert into books_categories(book_id, category_id) values(1,1);
insert into books_categories(book_id, category_id) values(4,1);
insert into books_categories(book_id, category_id) values(2,2);
insert into books_categories(book_id, category_id) values(5,2);
insert into books_categories(book_id, category_id) values(3,3);
insert into books_categories(book_id, category_id) values(6,3);

insert into books_authors(author_id, book_id) values(3,1);
insert into books_authors(author_id, book_id) values(4,1);

insert into books_authors(author_id, book_id) values(5,2);
insert into books_authors(author_id, book_id) values(6,2);

insert into books_authors(author_id, book_id) values(3,3);
insert into books_authors(author_id, book_id) values(6,3);

insert into books_authors(author_id, book_id) values(4,4);
insert into books_authors(author_id, book_id) values(5,4);

insert into books_authors(author_id, book_id) values(3,5);

insert into books_authors(author_id, book_id) values(4,6);





