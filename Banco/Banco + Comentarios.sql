CREATE TABLE vacina (
  vacina_id SERIAL PRIMARY KEY,
  vacina_nome TEXT NOT NULL,
  vacina_dose INT NOT NULL,
  vacina_intervalo INT NOT NULL,
  vacina_tipo TEXT NOT NULL, ## Retirar e deixar só o status como text
  vacina_status BOOLEAN NOT NULL,
  vacina_FK_restricoes INT NOT NULL,
  vacina_FK_tipovacina INT NOT NULL,
  CONSTRAINT FK_Vacina_Restricoes FOREIGN KEY (vacina_FK_restricoes) REFERENCES restricao (restricao_id),
  CONSTRAINT FK_Vacina_Tipovacina FOREIGN KEY (vacina_FK_tipovacina) REFERENCES tipo_vacina (tipoV_id)
);

CREATE TABLE tipo_vacina (
  tipoV_id serial PRIMARY KEY,
  tipoV_nome varchar not null,
  tipoV_nivel varchar not null,
  tipoV_status boolean not null
);

CREATE TABLE funcionario (
  funcionario_id serial primary key,
  funcionario_nome TEXT NOT NULL,
  funcionario_idade BIGINT NOT NULL,
  funcionario_cofen BIGINT NOT NULL,
  funcionario_cpf TEXT NOT NULL,
  funcionario_endereco TEXT NOT NULL,
  funcionario_acesso TEXT NOT NULL
  );


CREATE TABLE calendario(
  calendario_id SERIAL PRIMARY KEY,
  calendario_dataprevista DATE NOT NULL,
  calendario_datadeinsercaodomedicamento DATE,
  calendario_idvacina INT NOT NULL,
  calendario_comentarioeventos TEXT,
  calendario_statusvacinacalendario TEXT NOT NULL,
  calendario_func_aplica INT,

  CONSTRAINT vacina_informacoes FOREIGN KEY (calendario_idvacina) REFERENCES vacina (vacina_id),
  
  CONSTRAINT func_aplica FOREIGN KEY (calendario_func_aplica) REFERENCES funcionario (funcionario_id)
);


#FALTA CRIAR // CALENDARIO USUARIO DE VACINACOES TOMADAS
CREATE TABLE calendario_usuario(
  calendarioUS_id SERIAL primary key,
  calendarioUS_datainsercaodomendicamento date not null,
  calendarioUS_HoraCadastro time not null, #campo para seguranca do sistema
  calendarioUS_FK_Funcionario int not null, #REFERENCIADO TABELA FUNCIONARIO
  calendarioUS_FK_Vacina int not null, #REFERENCIADO TABELA VACINA
  calendarioUS_FK_Posto int not null, #REFERENCIADO TABELA POSTO
  constraint calendarioUS_funcionario foreign key (calendarioUS_FK_Funcionario) references funcionario (funcionario_id),
  constraint calendarioUS_vacina foreign key (calendarioUS_FK_Vacina) references vacina (vacina_id),
  constraint calendarioUS_posto foreign key (calendarioUS_FK_Posto) references posto (posto_id)
);


#FALTA CRIAR // CALENDARIO DE VACINAS OBRIGATORIOS QUE TODOS USUARIO PRECISA TOMAR DEPENDENDO DA RESTRICOESs
CREATE TABLE calendario_obrigatorio(
  calendarioOB_id SERIAL primary key,
  calendarioOB_diasdevida int not null,
  calendarioOB_comentario varchar(150),
  calendarioOB_DataCadastro date not null, #campo para seguranca do sistema
  calendarioOB_HoraCadastro time not null, #campo para seguranca do sistema
  calendarioOB_FK_Restricoes int not null, #REFERENCIANDO TABELA RESTRICOES
  calendarioOB_FK_Funcionario int not null, #REFERENCIANDO TABELA FUNCIONARIO
  calendarioOB_FK_Vacina int not null, #REFERENCIANDO TABELA VACINA
  constraint calendarioOB_retricoes FOREIGN key (calendarioOB_FK_Restricoes) references restricao (restricao_id),
  constraint calendarioOB_funcionario foreign key (calendarioOB_FK_Funcionario) references funcionario (funcionario_id),
  constraint calendarioOB_vacina foreign key (calendarioOB_FK_Vacina) references vacina (vacina_id)
);

#TABELA N/N da TABELA calendario_obrigatorio e TABELA RESTRICAO
CREATE TABLE calendarioOB_has_Restricoes(
  calendarioOB_id int not null,
  restricoes_id int not null,
  constraint calendarioID foreign key (calendarioOB_id) references calendario_obrigatorio (calendarioOB_id),
  constraint restricoesID foreign key (restricoes_id) references restricao (restricao_id)
);


#TABELA PARA RESTRICAO
CREATE TABLE restricao (
  restricao_id serial primary key,
  restricao_nome TEXT NOT NULL,
  restricao_tipo TEXT NOT NULL,
  restricao_status BOOLEAN NOT NULL
);

#TABELA DO USUARIO
CREATE TABLE usuario (
  usuario_id serial primary key,
  usuario_nome TEXT NOT NULL,
  usuario_idade INTEGER NOT NULL,
  usuario_cpf TEXT NOT NULL,
  usuario_rg TEXT NOT NULL,
  usuario_senha varchar not null,
  usuario_telefone BIGINT NOT NULL,
  usuario_celular BIGINT NOT NULL,
  usuario_tiposague TEXT NOT NULL,
  usuario_peso NUMERIC NOT NULL,
  usuario_altura NUMERIC NOT NULL,
  usuario_nascimento DATE NOT NULL,
  usuario_acesso TEXT NOT NULL,
  usuario_status boolean NOT NULL
);

#TABELA DA CAMPANHA
CREATE TABLE campanha (
  campanha_id serial primary key,
  campanha_nome TEXT NOT NULL,
  campanha_inicio DATE NOT NULL,
  campanha_final DATE NOT NULL,
  vacina_id integer not null,
  campanha_status BOOLEAN NOT NULL,
	constraint campanha_vacina_vategoria foreign key (vacina_id) references vacina (vacina_id)
);

#TABELA N/N DA TABELA CAMPANHA E DA TABELA RESTRICAO
CREATE TABLE campanha_has_restricao (
  campanha_id INTEGER NOT NULL,
  restricao_id INTEGER NOT NULL,
	constraint campanha_has_restricao_FKIndex1 foreign key (campanha_id) references campanha (campanha_id),
	constraint campanha_has_restricao_FKIndex2 foreign key (restricao_id) references restricao (restricao_id)
);

#TABELA N/N DA TABELA CAMPANHA E DA TABELA USUARIO // SERA REGISTRADO OS USUARIOS ATINTGIDOS NA CAMPANHA E PODEMOS REALIZAR RELATORIOS
CREATE TABLE campanha_has_usuario (
  campanha_id INTEGER NOT NULL,
  usuario_id INTEGER NOT NULL,
  constraint campanha_has_usuario_FKIndex1 foreign key (campanha_id) references campanha (campanha_id),
	constraint campanha_has_usuario_FKIndex2 foreign key (usuario_id) references usuario (usuario_id)
);

#TABELA ENDERECO
CREATE TABLE endereco (
  endereco_id serial primary key,
  endereco_logradouro TEXT NOT NULL,
  endereco_numero INTEGER NOT NULL,
  endereco_cidade TEXT NOT NULL,
  endereco_bairro TEXT NOT NULL,
  endereco_complemento TEXT NOT NULL,
  endereco_cep INTEGER NOT NULL,
  endereco_uf TEXT NOT NULL,
  endereco_status boolean not null
);

#TABELA N/N DA TABELA ENDERECO A TABELA USUARIO // USUARIO PODE TER VARIOS ENDERECOS CADASTRADOS
CREATE TABLE endereco_has_usuario (
  endereco_id INTEGER NOT NULL,
  usuario_id INTEGER NOT NULL,
	constraint endereco_has_usuario_FKIndex1 foreign key (endereco_id) references endereco (endereco_id),
	constraint endereco_has_usuario_FKIndex2 foreign key (usuario_id) references usuario (usuario_id)
);

#CADASTRO DE POSTO DE SAUDE PARA INFORMAR NO CADASTRO CALENDARIO_USUARIO
CREATE TABLE posto (
  posto_id serial primary key,
  posto_nome TEXT NOT NULL,
  posto_telefone INTEGER NOT NULL,
  posto_FK_endereco INTEGER NOT NULL,
  constraint posto_FKIndex1 foreign key (endereco_id) references endereco (endereco_id)
);

#TABELA N/N DA TABELA USUARIO E TABELA RESTRICAO // FEITO PARA ARMAZENAR AS RESTRICOES DA VACINA 
CREATE TABLE usuario_has_restricao (
  usuario_id INTEGER NOT NULL,
  restricao_id INTEGER NOT NULL,
	constraint usuario_has_restricao_FKIndex1 foreign key (usuario_id) references usuario (usuario_id),
	constraint usuario_has_restricao_FKIndex2 foreign key (restricao_id) references restricao (restricao_id)
);