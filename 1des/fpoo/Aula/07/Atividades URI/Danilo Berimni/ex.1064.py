

'''
Danilo Berimni
1 DES - Senai - Jaguariuna
Exercicio lista 4 - URI - 1064
eia 6 valores. Em seguida, mostre quantos destes valores digitados foram positivos. Na próxima linha, deve-se mostrar a média de todos os valores positivos digitados, com um dígito após o ponto decimal.

Entrada
A entrada contém 6 números que podem ser valores inteiros ou de ponto flutuante. Pelo menos um destes números será positivo.

Saída
O primeiro valor de saída é a quantidade de valores positivos. A próxima linha deve mostrar a média dos valores positivos digitados.

Exemplo de Entrada	Exemplo de Saída
7
-5
6
-3.4
4.6
12

4 valores positivos
7.4
'''
n = 0
contadorp = 0
somap = 0
while n < 6:
    n += 1
    entrada = eval (input())
    if entrada > 0:           #numero positivo
        somap = somap + entrada
        contadorp += 1
media = somap / contadorp
print(contadorp, "valores positivos")
print(f'{media:.1f}')
