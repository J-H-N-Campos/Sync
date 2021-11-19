/**
 * Author:  joao
 * Created: 08/10/2021
 */

-- Tabela cidade
-- não aceita nome nulo

CREATE FUNCTION valida_cidade() RETURNS trigger AS $valida_cidade$
    BEGIN
        IF NEW.nome IS NULL THEN
            RAISE EXCEPTION 'A cidade não pode ser nula';
        END IF;
    RETURN NEW;
END;
$valida_cidade$ LANGUAGE plpgsql;

CREATE TRIGGER valida_cidade BEFORE INSERT OR UPDATE ON cidade
    FOR EACH ROW EXECUTE PROCEDURE valida_cidade();

-- Tabela usuario
-- não aceita senha fraca na tabela do usuário
CREATE FUNCTION valida_usuario() RETURNS trigger AS $valida_usuario$
    BEGIN
        IF NEW.senha IS NULL THEN
            RAISE EXCEPTION 'A senha não pode ser nula e nem fraca';
        END IF;
        IF NEW.senha < 5 THEN
            RAISE EXCEPTION 'A senha não pode ser nula e nem fraca', NEW.senha;
        END IF;
    RETURN NEW;
END;
$valida_usuario$ LANGUAGE plpgsql;

CREATE TRIGGER valida_usuario BEFORE INSERT OR UPDATE ON usuario
    FOR EACH ROW EXECUTE PROCEDURE valida_usuario();

-- Tabela usuário
-- não aceita nomes duplicados

CREATE FUNCTION valida_usuario() RETURNS trigger AS $valida_usuario$
    BEGIN
        IF NEW.nome IS NULL THEN
            RAISE EXCEPTION 'O nome não pode ser nulo';
        END IF;
        IF NEW.nome == nome THEN
            RAISE EXCEPTION 'Esse nome de usuário já existe na nossa base de dados';
        END IF;
    RETURN NEW;
END;
$valida_usuario$ LANGUAGE plpgsql;

CREATE TRIGGER valida_usuario BEFORE INSERT OR UPDATE ON usuario
    FOR EACH ROW EXECUTE PROCEDURE valida_usuario();

-- Tabela funcionario_funcao
-- exclui os registros antes da exclusao do funcionario

CREATE FUNCTION exclui_funcionario_funcao() RETURNS trigger AS $exclui_funcionario_funcao$
    BEGIN
        DELETE FROM funcionario_funcao WHERE OLD.id=funcionario_funcao.id_funcionario;
        RETURN NULL;
    END;
$exclui_funcionario_funcao$ LANGUAGE plpgsql;

CREATE TRIGGER exclui_funcionario_funcao BEFORE DELETE ON funcionario
    FOR EACH ROW EXECUTE PROCEDURE exclui_funcionario_funcao();

-- Tabela funcionario_funcao
-- exclui os registros antes da exclusao da funcao

CREATE FUNCTION exclui_funcao_funcionario() RETURNS trigger AS $exclui_funcao_funcionario$
    BEGIN
        DELETE FROM funcionario_funcao WHERE OLD.id=funcionario_funcao.id_funcao;
        RETURN NULL;
    END;
$exclui_funcao_funcionario$ LANGUAGE plpgsql;

CREATE TRIGGER exclui_funcao_funcionario BEFORE DELETE ON funcao
    FOR EACH ROW EXECUTE PROCEDURE exclui_funcao_funcionario();