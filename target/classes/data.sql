insert into BOOK(id, title, author, publisher) values(1, 'Istio in Action', 'Christian Posta', 'Manning');
insert into BOOK(id, title, author, publisher) values(2, 'Spark in Action', 'Jean Perrin', 'Manning');
insert into BOOK(id, title, author, publisher) values(3, 'Kafka in Action', 'Djylan Scott', 'Manning');
insert into REVIEW(id, book_id, name, email, content) values(1, 1, 'Pete','pete@gmail.com', 'Some examples do not work.');
insert into REVIEW(id, book_id, name, email, content) values(2, 1, 'Vitaly','vitaly@gmail.com', 'Good content.');
insert into REVIEW(id, book_id, name, email, content) values(3, 2, 'Mary','mary@gmail.com', 'Good intro to spark.');
insert into REVIEW(id, book_id, name, email, content) values(4, 2, 'Dave','dave@gmail.com', 'Good examples.');
insert into REVIEW(id, book_id, name, email, content) values(5, 3, 'Tim','tim@gmail.com', 'Overcomplicated text.');
