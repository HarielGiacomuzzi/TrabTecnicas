create table usuarios(
  id_usuario int not null,
  nome VARCHAR2(30) not null,
  cpf varchar(15),
  cnpj varchar(20),
  email varchar2(20),
  senha varchar2(20),
  
  primary key(id_usuario),
  constraint check_cpf_cnpj check(cpf != null OR cnpj != null) 
);

create table categorias(
  id_categoria int not null,
  desc_categoria varchar2(30),
  
  PRIMARY KEY (id_categoria)
);

create table bens(
  id_bem int not null,
  categoria_fk varchar(30),
  desc_breve varchar(30),
  desc_completa varchar2(30),
  leilao_fk int
  
  PRIMARY KEY (id_bem),
  FOREIGN KEY (leilao_fk) references leilao(id_leilao)
);

create table leilao(
  id_leilao int not null,
  tipo_leilao char not null,
  tipo_lance char not null,
  data_inicio date,
  data_fim date,
  vendedor_fk int,
  preco NUMBER(6,2),
  
  PRIMARY KEY (id_leilao),
  FOREIGN KEY (vendedor_fk) references usuarios(id_usuario)
);

create table lances(
  id_lance int not null,
  data_lance date,
  valor_lance NUMBER(6,2),
  usuario_fk int,
  leilao_fk int,
  
  PRIMARY KEY(id_lance),
  FOREIGN KEY (usuario_fk) references usuarios(id_usuario),
  FOREIGN KEY (leilao_fk) references leilao(id_leilao)
);