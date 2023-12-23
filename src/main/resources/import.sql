INSERT INTO tb_categories (description) VALUES ('Entrada');

INSERT INTO tb_categories (description) VALUES ('Saída');

INSERT INTO
    tb_sub_categories (description, CATEGORYID_ID)
VALUES ('Educação', 2);

INSERT INTO
    tb_finacialmethod (description, percente)
VALUES ('Necessidades Essenciais', 50);

INSERT INTO
    tb_finacialmethod (description, percente)
VALUES ('Despesas Pessoaiss', 30);

INSERT INTO
    tb_finacialmethod (description, percente)
VALUES (
        'Poupança e Investimentos',
        20
    );