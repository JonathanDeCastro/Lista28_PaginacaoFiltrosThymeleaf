  create table funcionario (
       id int8 generated by default as identity,
        nascimento date,
        nome varchar(255),
        endereco varchar(255),
        num_dep int4,
        salario numeric(19, 2),
        primary key (id)
  );