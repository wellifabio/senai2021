'''
Danilo Berimni
1 DES - Senai - Jaguariuna
Exercicio lista 4 - URI - 1059
'''

n = 0
countPos = 0
while n < 6:
    n += 1
    entrada = eval(input())
    if entrada > 0:           #numero positivo
        countPos += 1
print (countPos, 'valores positivos')
