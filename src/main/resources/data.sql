insert into Role (id, nome) values ('1', 'admin');
insert into Role (id, nome) values ('2', 'usuario');
insert into Role (id, nome) values ('3', 'role');
insert into Role (id, nome) values ('4', 'permission');

insert into Permission (id, nome) values ('1', 'admin');
insert into Permission (id, nome) values ('2', 'cadastrar_Usuario');
insert into Permission (id, nome) values ('3', 'alterar_Usuario');
insert into Permission (id, nome) values ('4', 'remover_Usuario');
insert into Permission (id, nome) values ('5', 'listagem_Usuario');
insert into Permission (id, nome) values ('6', 'cadastrar_Role');
insert into Permission (id, nome) values ('7', 'alterar_Role');
insert into Permission (id, nome) values ('8', 'remover_Role');
insert into Permission (id, nome) values ('9', 'listagem_Role');
insert into Permission (id, nome) values ('10', 'cadastrar_Permission');
insert into Permission (id, nome) values ('11', 'alterar_Permission');
insert into Permission (id, nome) values ('12', 'remover_Permission');
insert into Permission (id, nome) values ('13', 'listagem_Permission');


insert into role_permissions values (1, 1);
insert into role_permissions values (2, 2);
insert into role_permissions values (2, 3);
insert into role_permissions values (2, 4);
insert into role_permissions values (2, 5);
insert into role_permissions values (3, 6);
insert into role_permissions values (3, 7);
insert into role_permissions values (3, 8);
insert into role_permissions values (3, 9);
insert into role_permissions values (4, 10);
insert into role_permissions values (4, 11);
insert into role_permissions values (4, 12);
insert into role_permissions values (4, 13);

insert into Usuario (id, login, senha, nome, sobrenome, email) values ('1', 'kleber', '202cb962ac59075b964b07152d234b70', 'Kleber', 'Mota', 'kleber@mail.com');
insert into role_members values (1, 1);
insert into role_members values (1, 2);
insert into role_members values (1, 3);
insert into role_members values (1, 4);
