/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
