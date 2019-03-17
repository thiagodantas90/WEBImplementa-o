--CRIAR AS TABELAS

-- CLIENTES
CREATE TABLE public.clientes
(
  id_cliente serial NOT NULL,
  nome_cliente character(100) NOT NULL,
  email_cliente character(100),
  senha_cliente character(20),
  CONSTRAINT id_cliente PRIMARY KEY (id_cliente)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.clientes
  OWNER TO postgres;


-- LOJISTAS
  CREATE TABLE public.lojistas
(
  id_lojista serial NOT NULL,
  nome_lojista character(100) NOT NULL,
  email_lojista character(100),
  senha_lojista character(20),
  CONSTRAINT pk_lojista PRIMARY KEY (id_lojista)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.lojistas
  OWNER TO postgres;


-- PRODUTOS
  CREATE TABLE public.produtos
(
  id_produto serial NOT NULL,
  nome_produto character(50) NOT NULL,
  descricao_produto character(50),
  preco_unitario character(10),
  quantidade integer,
  CONSTRAINT pk_nome_produto PRIMARY KEY (id_produto)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.produtos
  OWNER TO postgres;