@Echo off
set PGUSER=postgres
set PGPASSWORD=postgres
c:
cd 
cd C:\PostgreSQL\12\bin
@echo "Aguarde enquanto o banco de dados é atualizado..."
psql -U postgres -c "create database sync"
psql -U postgres -c "CREATE TABLE cidade( 
      id  SERIAL    NOT NULL  , 
      nome text   NOT NULL  , 
      id_estado integer   NOT NULL  , 
 PRIMARY KEY (id)) ; 

CREATE TABLE convenio( 
      id  SERIAL    NOT NULL  , 
      nome text   NOT NULL  , 
      codigo text   NOT NULL  , 
 PRIMARY KEY (id)) ; 

CREATE TABLE estado( 
      id  SERIAL    NOT NULL  , 
      nome text   NOT NULL  , 
      uf text   NOT NULL  , 
      id_pais integer   NOT NULL  , 
 PRIMARY KEY (id)) ; 

CREATE TABLE funcao( 
      id  SERIAL    NOT NULL  , 
      especializacao text   NOT NULL  , 
      nivel_permissao integer   NOT NULL  , 
 PRIMARY KEY (id)) ; 

CREATE TABLE funcionario( 
      id  SERIAL    NOT NULL  , 
      nome text   NOT NULL  , 
      sexo text   NOT NULL  , 
      dt_nascimento date   NOT NULL  , 
      cpf text   NOT NULL  , 
      telefone text   NOT NULL  , 
      email text   NOT NULL  , 
      formacao text   , 
      tipo_contrato text   NOT NULL  , 
      salario float   NOT NULL  , 
      endereco text   NOT NULL  , 
      id_cidade integer   NOT NULL  , 
 PRIMARY KEY (id)) ; 

CREATE TABLE funcionario_funcao( 
      id  SERIAL    NOT NULL  , 
      id_funcionario integer   NOT NULL  , 
      id_funcao integer   NOT NULL  , 
 PRIMARY KEY (id)) ; 

CREATE TABLE leito( 
      id  SERIAL    NOT NULL  , 
      nome text   NOT NULL  , 
 PRIMARY KEY (id)) ; 

CREATE TABLE paciente( 
      id  SERIAL    NOT NULL  , 
      nome text   NOT NULL  , 
      dt_nascimento date   NOT NULL  , 
      cpf text   NOT NULL  , 
      sexo text   NOT NULL  , 
      telefone text   NOT NULL  , 
      email text   , 
      endereco text   NOT NULL  , 
      id_convenio integer   NOT NULL  , 
      id_cidade integer   NOT NULL  , 
 PRIMARY KEY (id)) ; 

CREATE TABLE pais( 
      id  SERIAL    NOT NULL  , 
      nome text   NOT NULL  , 
      idioma text   NOT NULL  , 
 PRIMARY KEY (id)) ; 

CREATE TABLE produto( 
      id  SERIAL    NOT NULL  , 
      nome text   NOT NULL  , 
      validade date   , 
      marca text   , 
 PRIMARY KEY (id)) ; 

CREATE TABLE registro_cirurgia( 
      id  SERIAL    NOT NULL  , 
      dt_registro date   NOT NULL  , 
      id_tipo_cirurgia integer   NOT NULL  , 
      id_funcionario integer   NOT NULL  , 
      id_paciente integer   NOT NULL  , 
 PRIMARY KEY (id)) ; 

CREATE TABLE registro_exame( 
      id  SERIAL    NOT NULL  , 
      dt_registro timestamp   NOT NULL  , 
      id_tipo_exame integer   NOT NULL  , 
      id_funcionario integer   NOT NULL  , 
      id_paciente integer   NOT NULL  , 
 PRIMARY KEY (id)) ; 

CREATE TABLE registro_lotacao( 
      id  SERIAL    NOT NULL  , 
      fl_ativo boolean   NOT NULL  , 
      id_leito integer   NOT NULL  , 
      id_funcionario integer   NOT NULL  , 
      id_paciente integer   NOT NULL  , 
 PRIMARY KEY (id)) ; 

CREATE TABLE tipo_cirurgia( 
      id  SERIAL    NOT NULL  , 
      nome text   NOT NULL  , 
      duracao integer   , 
      id_produto integer   NOT NULL  , 
 PRIMARY KEY (id)) ; 

CREATE TABLE tipo_exame( 
      id  SERIAL    NOT NULL  , 
      nome text   NOT NULL  , 
 PRIMARY KEY (id)) ; 

CREATE TABLE usuario( 
      id  SERIAL    NOT NULL  , 
      senha text   NOT NULL  , 
      nome text   NOT NULL  , 
      id_funcionario integer   NOT NULL  , 
 PRIMARY KEY (id)) ; 

 
  
ALTER TABLE cidade ADD CONSTRAINT fk_cidade_1 FOREIGN KEY (id_estado) references estado(id); 
ALTER TABLE estado ADD CONSTRAINT fk_estado_1 FOREIGN KEY (id_pais) references pais(id); 
ALTER TABLE funcionario ADD CONSTRAINT fk_rh_2 FOREIGN KEY (id_cidade) references cidade(id); 
ALTER TABLE funcionario_funcao ADD CONSTRAINT fk_funcionario_funcao_1 FOREIGN KEY (id_funcionario) references funcionario(id); 
ALTER TABLE funcionario_funcao ADD CONSTRAINT fk_funcionario_funcao_2 FOREIGN KEY (id_funcao) references funcao(id); 
ALTER TABLE paciente ADD CONSTRAINT fk_Atendente_2 FOREIGN KEY (id_cidade) references cidade(id); 
ALTER TABLE paciente ADD CONSTRAINT fk_atendente_4 FOREIGN KEY (id_convenio) references convenio(id); 
ALTER TABLE registro_cirurgia ADD CONSTRAINT fk_registro_cirurgia_1 FOREIGN KEY (id_tipo_cirurgia) references tipo_cirurgia(id); 
ALTER TABLE registro_cirurgia ADD CONSTRAINT fk_registro_cirurgia_2 FOREIGN KEY (id_funcionario) references funcionario(id); 
ALTER TABLE registro_cirurgia ADD CONSTRAINT fk_registro_cirurgia_3 FOREIGN KEY (id_paciente) references paciente(id); 
ALTER TABLE registro_exame ADD CONSTRAINT fk_registro_exame_1 FOREIGN KEY (id_tipo_exame) references tipo_exame(id); 
ALTER TABLE registro_exame ADD CONSTRAINT fk_registro_exame_2 FOREIGN KEY (id_funcionario) references funcionario(id); 
ALTER TABLE registro_exame ADD CONSTRAINT fk_registro_exame_3 FOREIGN KEY (id_paciente) references paciente(id); 
ALTER TABLE registro_lotacao ADD CONSTRAINT fk_registro_lotacao_1 FOREIGN KEY (id_leito) references leito(id); 
ALTER TABLE registro_lotacao ADD CONSTRAINT fk_registro_lotacao_2 FOREIGN KEY (id_funcionario) references funcionario(id); 
ALTER TABLE registro_lotacao ADD CONSTRAINT fk_registro_lotacao_3 FOREIGN KEY (id_paciente) references paciente(id); 
ALTER TABLE tipo_cirurgia ADD CONSTRAINT fk_Cirurgia_1 FOREIGN KEY (id_produto) references produto(id); 
ALTER TABLE usuario ADD CONSTRAINT fk_usuario_1 FOREIGN KEY (id_funcionario) references funcionario(id); 

  
SELECT setval('cidade_id_seq', coalesce(max(id),0) + 1, false) FROM cidade;
SELECT setval('convenio_id_seq', coalesce(max(id),0) + 1, false) FROM convenio;
SELECT setval('estado_id_seq', coalesce(max(id),0) + 1, false) FROM estado;
SELECT setval('funcao_id_seq', coalesce(max(id),0) + 1, false) FROM funcao;
SELECT setval('funcionario_id_seq', coalesce(max(id),0) + 1, false) FROM funcionario;
SELECT setval('funcionario_funcao_id_seq', coalesce(max(id),0) + 1, false) FROM funcionario_funcao;
SELECT setval('leito_id_seq', coalesce(max(id),0) + 1, false) FROM leito;
SELECT setval('paciente_id_seq', coalesce(max(id),0) + 1, false) FROM paciente;
SELECT setval('pais_id_seq', coalesce(max(id),0) + 1, false) FROM pais;
SELECT setval('produto_id_seq', coalesce(max(id),0) + 1, false) FROM produto;
SELECT setval('registro_cirurgia_id_seq', coalesce(max(id),0) + 1, false) FROM registro_cirurgia;
SELECT setval('registro_exame_id_seq', coalesce(max(id),0) + 1, false) FROM registro_exame;
SELECT setval('registro_lotacao_id_seq', coalesce(max(id),0) + 1, false) FROM registro_lotacao;
SELECT setval('tipo_cirurgia_id_seq', coalesce(max(id),0) + 1, false) FROM tipo_cirurgia;
SELECT setval('tipo_exame_id_seq', coalesce(max(id),0) + 1, false) FROM tipo_exame;
SELECT setval('usuario_id_seq', coalesce(max(id),0) + 1, false) FROM usuario;"
psql -U postgres -c "CREATE OR REPLACE VIEW v_reg_exame AS
SELECT reg.dt_registro AS data, tip.nome AS tipo_exame, fun.nome AS funcionario_resp, pac.nome AS paciente, pac.cpf AS pac_cpf
FROM registro_exame reg, tipo_exame tip, funcionario fun, paciente pac
WHERE tip.id=reg.id_tipo_exame AND reg.id_funcionario=fun.id AND reg.id_paciente=pac.id;

CREATE OR REPLACE VIEW v_reg_cirurgia AS
SELECT reg.dt_registro AS data, tip.nome AS tipo_cirurgia, fun.nome AS funcionario_resp, pac.nome AS paciente, pac.cpf AS pac_cpf
FROM registro_cirurgia reg, tipo_cirurgia tip, funcionario fun, paciente pac
WHERE tip.id=reg.id_tipo_cirurgia AND reg.id_funcionario=fun.id AND reg.id_paciente=pac.id;"
psql -U postgres -c "CREATE FUNCTION valida_cidade() RETURNS trigger AS $valida_cidade$    BEGIN        IF NEW.nome IS NULL THEN            RAISE EXCEPTION 'A cidade não pode ser nula';END IF;RETURN NEW;END;$valida_cidade$ LANGUAGE plpgsql;
CREATE TRIGGER valida_cidade BEFORE INSERT OR UPDATE ON cidade    FOR EACH ROW EXECUTE PROCEDURE valida_cidade();
CREATE FUNCTION valida_usuario() RETURNS trigger AS $valida_usuario$    BEGIN        IF NEW.senha IS NULL THEN            RAISE EXCEPTION 'A senha não pode ser nula e nem fraca';END IF;IF NEW.senha < 5 THEN            RAISE EXCEPTION 'A senha não pode ser nula e nem fraca', NEW.senha;END IF;RETURN NEW;END;$valida_usuario$ LANGUAGE plpgsql;
CREATE TRIGGER valida_usuario BEFORE INSERT OR UPDATE ON usuario    FOR EACH ROW EXECUTE PROCEDURE valida_usuario();
CREATE FUNCTION valida_usuario() RETURNS trigger AS $valida_usuario$    BEGIN        IF NEW.nome IS NULL THEN            RAISE EXCEPTION 'O nome não pode ser nulo';END IF;IF NEW.nome == nome THEN           RAISE EXCEPTION 'Esse nome de usuário já existe na nossa base de dados';END IF;RETURN NEW;END;$valida_usuario$ LANGUAGE plpgsql;
CREATE TRIGGER valida_usuario BEFORE INSERT OR UPDATE ON usuario    FOR EACH ROW EXECUTE PROCEDURE valida_usuario();
CREATE FUNCTION exclui_funcionario_funcao() RETURNS trigger AS $exclui_funcionario_funcao$    BEGIN        DELETE FROM funcionario_funcao WHERE OLD.id=funcionario_funcao.id_funcionario;RETURN NULL;END;$exclui_funcionario_funcao$ LANGUAGE plpgsql;
CREATE TRIGGER exclui_funcionario_funcao BEFORE DELETE ON funcionario    FOR EACH ROW EXECUTE PROCEDURE exclui_funcionario_funcao();
CREATE FUNCTION exclui_funcao_funcionario() RETURNS trigger AS $exclui_funcao_funcionario$    BEGIN        DELETE FROM funcionario_funcao WHERE OLD.id=funcionario_funcao.id_funcao;RETURN NULL;END;$exclui_funcao_funcionario$ LANGUAGE plpgsql;
CREATE TRIGGER exclui_funcao_funcionario BEFORE DELETE ON funcao    FOR EACH ROW EXECUTE PROCEDURE exclui_funcao_funcionario();"
