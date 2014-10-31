insert into Role (id, nome) values ('1', 'admin');
insert into Permission (id, nome) values ('1', 'admin');
insert into role_permissions values (1, 1);
insert into Usuario (id, login, senha, nome, sobrenome, email) values ('1', 'kleber', '202cb962ac59075b964b07152d234b70', 'Kleber', 'Mota', 'kleber@mail.com');
insert into role_members values (1, 1);
