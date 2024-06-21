CREATE TABLE medico (
                        id SERIAL PRIMARY KEY,
                        crm VARCHAR(255) NOT NULL,
                        nome VARCHAR(255) NOT NULL
);

CREATE TABLE paciente (
                          id SERIAL PRIMARY KEY,
                          nome VARCHAR(255) NOT NULL,
                          cartao_sus VARCHAR(255) NOT NULL,
                          rua VARCHAR(255) NOT NULL,
                          numero VARCHAR(10) NOT NULL,
                          bairro VARCHAR(255) NOT NULL,
                          cidade VARCHAR(255) NOT NULL,
                          estado VARCHAR(2) NOT NULL
);

CREATE TABLE agendamento (
                             id SERIAL PRIMARY KEY,
                             medico_id BIGINT NOT NULL,
                             paciente_id BIGINT NOT NULL,
                             data_hora TIMESTAMP NOT NULL,
                             FOREIGN KEY (medico_id) REFERENCES medico(id),
                             FOREIGN KEY (paciente_id) REFERENCES paciente(id)
);
