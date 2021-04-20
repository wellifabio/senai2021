'''
Carlos Roberto de Oliveira Júnior
URI 1065
SENAI - SP - Jaguariúna
'''

a = 0
c = 0

while a < 5:
    a += 1
    entrada = eval(input())
    if (entrada % 2) == 0:
        c += 1

print(f"{c} valores pares")