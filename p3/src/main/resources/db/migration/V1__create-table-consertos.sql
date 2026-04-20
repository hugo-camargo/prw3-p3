CREATE TABLE consertos(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    data_entrada VARCHAR(50),
    data_saida VARCHAR(50),

    mecanico_nome VARCHAR(100),
    mecanico_anos_experiencia INT,

    veiculo_marca VARCHAR(50),
    veiculo_modelo VARCHAR(50),
    veiculo_ano VARCHAR(10)
);