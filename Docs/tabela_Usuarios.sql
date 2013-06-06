CREATE TABLE usuarios(
id SERIAL PRIMARY KEY,
nome VARCHAR(50) NOT NULL,
senha VARCHAR(50)NOT NULL
);


INSERT INTO usuarios( nome , senha) VALUES
('sergio','1234');

INSERT INTO usuarios( nome , senha) VALUES
('ricardo','4321');


SELECT *FROM usuarios;