CREATE OR REPLACE VIEW v_reg_exame AS
SELECT reg.dt_registro AS data, tip.nome AS tipo_exame, fun.nome AS funcionario_resp, pac.nome AS paciente, pac.cpf AS pac_cpf
FROM registro_exame reg, tipo_exame tip, funcionario fun, paciente pac
WHERE tip.id=reg.id_tipo_exame AND reg.id_funcionario=fun.id AND reg.id_paciente=pac.id;

CREATE OR REPLACE VIEW v_reg_cirurgia AS
SELECT reg.dt_registro AS data, tip.nome AS tipo_cirurgia, fun.nome AS funcionario_resp, pac.nome AS paciente, pac.cpf AS pac_cpf
FROM registro_cirurgia reg, tipo_cirurgia tip, funcionario fun, paciente pac
WHERE tip.id=reg.id_tipo_cirurgia AND reg.id_funcionario=fun.id AND reg.id_paciente=pac.id;