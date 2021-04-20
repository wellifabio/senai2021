'''
Carlos Roberto de Oliveira Júnior
URI 1060
SENAI - SP - Jaguariúna
'''
a = 0
c = 0
while a < 6:
    a += 1
    entrada = eval(input())
    if entrada > 0:
        c += 1

print(f"{c} valores positivos")
