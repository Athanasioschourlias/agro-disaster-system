USE db;

--     INSERTING USERS FOR DEMO
-- password == admin
INSERT INTO user (tin_number, first_name, last_name, password,role,email)
VALUES (219113, 'admin' , 'admin','$2a$12$p.qL2GU7Ge8hIbg37Lc1EeUY8SrSVwWvC7iyGQkrdLiir.QMcbcHq','ADMIN','ADMIN@gmail.com');

INSERT INTO user (tin_number, first_name, last_name, password,role,email)
VALUES (000000, 'thanos' , 'chourlias','$2a$12$p.qL2GU7Ge8hIbg37Lc1EeUY8SrSVwWvC7iyGQkrdLiir.QMcbcHq','FARMER','farmer@gmail.com');


--     INSERTING FORMS FOR DEMO