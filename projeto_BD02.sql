CREATE DATABASE IF NOT EXISTS empresa;

USE empresa;

-- criando as tabelas;
CREATE TABLE cliente(
id INT PRIMARY KEY,
nome VARCHAR(30) NOT NULL,
sexo CHAR CHECK(sexo in ('m', 'f', 'o')),
idade SMALLINT,
nascimento DATE
);

CREATE TABLE clienteespecial(
id INT PRIMARY KEY,
nome VARCHAR(30) NOT NULL,
sexo CHAR CHECK(sexo in ('m', 'f', 'o')),
idade SMALLINT,
id_cliente INT,
cashback DOUBLE(6,2),
FOREIGN KEY (id_cliente) REFERENCES cliente(id)
);

CREATE TABLE funcionario(
id INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(30) NOT NULL,
idade SMALLINT,
sexo CHAR(1) CHECK(sexo in ('m', 'f', 'o')),
cargo VARCHAR(10) CHECK(cargo in('vendedor','gerente','CEO')),
salario DOUBLE(10,2),
nascimento DATE
);

CREATE TABLE produto(
id INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(100) NOT NULL,
quantidade SMALLINT,
descricao VARCHAR(200),
valor DOUBLE(10,2)
);

CREATE TABLE venda(
id INT AUTO_INCREMENT PRIMARY KEY,
id_vendedor INT,
id_cliente INT,
data_venda DATE,
FOREIGN KEY (id_vendedor) REFERENCES funcionario(id),
FOREIGN KEY (id_cliente) REFERENCES cliente(id) 
);

-- INSERINDO VALORES
INSERT INTO funcionario (nome, idade, sexo, cargo, salario, nascimento) VALUES
('Russo', 21, 'm', 'CEO', 1000.00, '2001-01-01'),
('Arquimedes', 27, 'm', 'gerente', 9000.00, '1996-10-02'),
('Gil', 21, 'm', 'vendedor', 8000.00, '2002-06-06'),
('Duda', 21, 'f', 'vendedor', 8000.00, '2003-01-01'),
('Ray', 21, 'f', 'vendedor', 8000.00, '2001-01-01');

SELECT *,DATE_FORMAT(nascimento,'%m/%y') from funcionario;

SELECT * from funcionario;

INSERT INTO cliente (id, nome, sexo, idade, nascimento) VALUES 
(1, 'João Silva', 'm', 25, 19990515),
(2, 'Maria Santos', 'f', 30, 19940820),
(3, 'Pedro Oliveira', 'm', 22,20020210),
(4, 'Ana Costa', 'f', 35, 19871125),
(5, 'Carlos Pereira', 'm', 28, 19940307),
(6, 'Juliana Almeida', 'f', 40, 19820912),
(7, 'Fernando Santos', 'm', 33, 19890630),
(8, 'Sandra Silva', 'f', 27, 19951218),
(9, 'Ricardo Souza', 'm', 45, 19770402),
(10, 'Luciana Lima', 'f', 29, 19930724),
(11, 'Gabriel Pereira', 'm', 31, 19911005),
(12, 'Aline Santos', 'f', 26, 19960808),
(13, 'Marcelo Oliveira', 'm', 38, 19840130),
(14, 'Mariana Costa', 'f', 32, 19901115),
(15, 'Diego Almeida', 'm', 23, 19990325),
(16, 'Patrícia Lima', 'f', 36, 19860710),
(17, 'Roberto Souza', 'm', 41, 19810905),
(18, 'Carla Pereira', 'f', 34, 19880420),
(19, 'Paulo Santos', 'm', 37, 19851215),
(20, 'Camila Oliveira', 'f', 28, 19940228),
(21, 'Henrique Lima', 'm', 30, 19920620),
(22, 'Isabela Almeida', 'f', 31, 19910810),
(23, 'Vitor Costa', 'm', 33, 19891015),
(24, 'Larissa Souza', 'f', 27, 19950405),
(25, 'Daniel Santos', 'm', 29, 19931130),
(26, 'Tatiana Oliveira', 'f', 35, 19870120),
(27, 'Jorge Pereira', 'm', 32, 19900502),
(28, 'Cristina Lima', 'f', 26, 19960915),
(29, 'Felipe Almeida', 'm', 39, 19830310),
(30, 'Vanessa Costa', 'f', 24, 19980708),
(31, 'Márcio Silva', 'm', 45, 19770402),
(32, 'Renata Santos', 'f', 29, 19930724),
(33, 'Gustavo Oliveira', 'm', 31, 19911005),
(34, 'Amanda Costa', 'f', 26, 19960808),
(35, 'Rafael Pereira', 'm', 38, 19840130),
(36, 'Laura Almeida', 'f', 32, 19901115),
(37, 'Bruno Lima', 'm', 23, 19990325),
(38, 'Caroline Lima', 'f', 36, 19860710),
(39, 'Felipe Oliveira', 'm', 41, 19810905),
(40, 'Viviane Pereira', 'f', 34, 19880420),
(41, 'Rodrigo Santos', 'm', 37, 19851215),
(42, 'Nathalia Almeida', 'f', 28, 19940228),
(43, 'Eduardo Lima', 'm', 30, 19920620),
(44, 'Fernanda Almeida', 'f', 31, 19910810),
(45, 'Anderson Costa', 'm', 33, 19891015),
(46, 'Patrícia Oliveira', 'f', 27, 19950405),
(47, 'Marcos Santos', 'm', 29, 19931130),
(48, 'Mariana Almeida', 'f', 21, 20030215),
(49, 'Lucas Silva', 'm', 22, 20020520),
(50, 'Juliana Costa', 'f', 23, 20010310),
(51, 'Rafael Oliveira', 'm', 24, 20001125),
(52, 'Amanda Pereira', 'f', 25, 19990907),
(53, 'Gustavo Lima', 'm', 26, 19980712),
(54, 'Laura Almeida', 'f', 27, 19970430),
(55, 'Felipe Silva', 'm', 28, 19960218),
(56, 'Carolina Santos', 'f', 29, 19951225),
(57, 'Vinicius Oliveira', 'm', 30, 19941028),
(58, 'Beatriz Costa', 'f', 31, 19930810),
(59, 'Thiago Pereira', 'm', 32, 19920620),
(60, 'Vanessa Lima', 'f', 33, 19910405),
(61, 'Rafael Almeida', 'm', 34, 19900125),
(62, 'Amanda Costa', 'f', 35, 19890915),
(63, 'Gustavo Silva', 'm', 36, 19880708),
(64, 'Laura Oliveira', 'f', 37, 19870420),
(65, 'Felipe Santos', 'm', 38, 19860214),
(66, 'Carolina Lima', 'f', 39, 19851202),
(67, 'Vinicius Almeida', 'm', 40, 19841015),
(68, 'Beatriz Costa', 'f', 41, 19830828),
(69, 'Thiago Pereira', 'm', 42, 19820610),
(70, 'Vanessa Almeida', 'f', 43, 19810325),
(71, 'Rafael Santos', 'm', 44, 19801208),
(72, 'Amanda Lima', 'f', 45, 19791020),
(73, 'Gustavo Almeida', 'm', 46, 19780803),
(74, 'Laura Costa', 'f', 47, 19770515),
(75, 'Felipe Silva', 'm', 48, 19760228),
(76, 'Carolina Oliveira', 'f', 49, 19751210),
(77, 'Vinicius Lima', 'm', 50, 19740922),
(78, 'Beatriz Almeida', 'f', 51, 19730705),
(79, 'Thiago Costa', 'm', 52, 19720418),
(80, 'Vanessa Pereira', 'f', 53, 19710130),
(81, 'Rafaela Lima', 'm', 54, 19701112),
(82, 'Andréa Costa', 'f', 55, 19690825),
(83, 'Gustavo Almeida', 'm', 56, 19680607),
(84, 'Laura Costa', 'f', 57, 19670321),
(85, 'Felipe Silva', 'm', 58, 19661204),
(86, 'Carolina Oliveira', 'f', 59, 19650916),
(87, 'Vinicius Lima', 'm', 60, 19640730),
(88, 'Beatriz Almeida', 'f', 61, 19630511),
(89, 'Thiago Costa', 'm', 62, 19620223),
(90, 'Vanessa Pereira', 'f', 63, 19611207),
(91, 'Rafaela Lima', 'm', 64, 19600919),
(92, 'Andréa Costa', 'f', 65, 19590703),
(93, 'Gustavo Almeida', 'm', 66, 19580415),
(94, 'Laura Costa', 'f', 67, 19570127),
(95, 'Felipe Silva', 'm', 68, 19561204),
(96, 'Carolina Oliveira', 'f', 69, 19550916),
(97, 'Vinicius Lima', 'm', 70, 19540730),
(98, 'Beatriz Almeida', 'f', 71, 19530511),
(99, 'Thiago Costa', 'm', 72, 19520223),
(100, 'Vanessa Pereira', 'f', 73, 19511207);

SELECT COUNT(*) FROM cliente;


INSERT INTO produto (nome, quantidade, descricao, valor) VALUES
('Processador Intel Core i9', 50, 'Processador de alto desempenho para PCs', 1899.99),
('Placa Mãe ASUS ROG Strix Z590-E Gaming', 30, 'Placa mãe para jogos com suporte a Intel 11ª e 10ª geração', 1399.99),
('Gabinete NZXT H510', 100, 'Gabinete compacto e elegante com painel frontal de vidro temperado', 299.99),
('Fonte Corsair RM750x', 80, 'Fonte de alimentação modular com certificação 80 Plus Gold', 699.99),
('SSD Samsung 970 EVO Plus 1TB', 120, 'SSD NVMe M.2 com velocidades de leitura de até 3500MB/s', 899.99),
('HD Seagate Barracuda 2TB', 60, 'HD SATA 3.5" para armazenamento de dados', 399.99),
('Cooler Master Hyper 212 RGB', 50, 'Cooler de CPU com iluminação RGB', 199.99),
('Memória RAM Corsair Vengeance RGB Pro 16GB (2x8GB)', 70, 'Kit de memória DDR4 com iluminação RGB', 599.99),
('Placa de Vídeo NVIDIA GeForce RTX 3080', 40, 'Placa de vídeo de alta performance para jogos e computação gráfica', 5499.99),
('Water Cooler NZXT Kraken X73', 30, 'Sistema de resfriamento líquido com radiador de 360mm', 899.99),
('Monitor Gamer Acer Predator XB273K', 25, 'Monitor 4K com tecnologia G-Sync para jogos', 3499.99a),
('Teclado Mecânico Corsair K95 RGB Platinum XT', 50, 'Teclado mecânico premium com iluminação RGB', 899.99),
('Mouse Gamer Logitech G502 Hero', 80, 'Mouse gamer com sensor Hero de até 16000 DPI', 299.99),
('Headset HyperX Cloud Alpha', 100, 'Headset com drivers de câmara dupla para áudio mais nítido', 499.99),
('Cadeira Gamer DT3 Sports GT Racer', 50, 'Cadeira gamer com design ergonômico e confortável', 999.99),
('Mousepad Corsair MM800 RGB Polaris', 120, 'Mousepad com iluminação RGB personalizável', 199.99),
('Webcam Logitech C920s Pro HD', 70, 'Webcam Full HD com proteção de privacidade integrada', 399.99),
('Microfone Blue Yeti USB', 40, 'Microfone USB de alta qualidade para streaming e gravação', 699.99),
('Caixa de Som Logitech G560', 30, 'Caixas de som com tecnologia LIGHTSYNC para sincronização de luzes com jogos', 1299.99),
('Kit de Cabos Sleeved Corsair Premium', 50, 'Kit de cabos para fonte de alimentação com revestimento premium', 299.99);


select * FROM produto;

