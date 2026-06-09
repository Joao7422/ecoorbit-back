DROP DATABASE IF EXISTS ecoorbit;
CREATE DATABASE ecoorbit;

USE ecoorbit;

CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    tipo VARCHAR(50) NOT NULL
);

CREATE TABLE areas_monitoradas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cidade VARCHAR(100) NOT NULL,
    estado VARCHAR(2) NOT NULL,
    tamanho_hectares DOUBLE NOT NULL,
    usuario_id INT NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);

CREATE TABLE alertas_ambientais (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tipo VARCHAR(100) NOT NULL,
    nivel_risco VARCHAR(50) NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    data_alerta DATE NOT NULL,
    area_id INT NOT NULL,
    FOREIGN KEY (area_id) REFERENCES areas_monitoradas(id)
);

INSERT INTO usuarios (nome, email, tipo) VALUES
('João Pedro', 'joao@email.com', 'Produtor Rural'),
('Instituto Verde', 'contato@institutoverde.org', 'ONG Ambiental'),
('Prefeitura Sustentável', 'meioambiente@prefeitura.gov.br', 'Prefeitura');

INSERT INTO areas_monitoradas (nome, cidade, estado, tamanho_hectares, usuario_id) VALUES
('Fazenda Verde', 'Caraguatatuba', 'SP', 120.5, 1),
('Reserva Mata Azul', 'Ubatuba', 'SP', 300.0, 2),
('Parque Municipal Norte', 'São Paulo', 'SP', 85.7, 3);

INSERT INTO alertas_ambientais (tipo, nivel_risco, descricao, data_alerta, area_id) VALUES
('Risco de Queimada', 'Alto', 'Análise simulada por satélite identificou vegetação seca e risco elevado de queimadas.', '2026-06-09', 1),
('Baixa Vegetação', 'Médio', 'A área apresentou redução de cobertura vegetal em comparação com registros anteriores.', '2026-06-09', 2),
('Risco de Desmatamento', 'Alto', 'Dados orbitais simulados indicaram possível avanço de desmatamento na região monitorada.', '2026-06-09', 3);