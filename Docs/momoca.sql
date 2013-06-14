
CREATE TABLE categoria
(
  cod serial PRIMARY KEY,
  nome text
);
  
CREATE TABLE produto
(
  id serial PRIMARY KEY,
  descricao text NOT NULL,
  cod_cat int not null,
  quantestoque integer,
  preco numeric(7,2)
 
);

CREATE TABLE usuarios(
  id SERIAL PRIMARY KEY,
  nome VARCHAR(50) NOT NULL,
  senha VARCHAR(50)NOT NULL
);

INSERT INTO usuarios( nome , senha) VALUES
('sergio','1234');

INSERT INTO usuarios( nome , senha) VALUES
('ricardo','4321');