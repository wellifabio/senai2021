/*Executar arquivo .sql de dentro e de fora do mysql, via linha de comando*/

-- importar dados de um script SQL
source D:\ARQUIVOS\SENAI\Planos_Ensino\2020_2_Semestre\BD\Aula6\hortelino.sql

-- Saídas em forma de arquivos de Texto TXT ou CSV
SELECT * FROM produtos INTO OUTFILE 'D:/ARQUIVOS/SENAI/Planos_Ensino/2020_2_Semestre/BD/Aula6/Produtos.txt';
SELECT * FROM Compras INTO OUTFILE 'D:/ARQUIVOS/SENAI/Planos_Ensino/2020_2_Semestre/BD/Aula6/Compras.csv'
FIELDS TERMINATED BY ';' ENCLOSED BY '"' LINES TERMINATED BY '\n';

-- Rodar scripts de fora do banco, no CMD ou SHELL
mysql -u root -p "" hortelinocompras < D:\ARQUIVOS\SENAI\Planos_Ensino\2020_2_Semestre\BD\Aula6\hortelino.sql

-- Gerar um Backup Completo de um Banco de Dados
mysqldump -u root -p hortelinocompras > D:\ARQUIVOS\SENAI\Planos_Ensino\2020_2_Semestre\BD\Aula6\backup.sql

-- Comando para verificar em qual pasta encontra-se os arquivos de dados do MySQL
show variables like 'datadir';