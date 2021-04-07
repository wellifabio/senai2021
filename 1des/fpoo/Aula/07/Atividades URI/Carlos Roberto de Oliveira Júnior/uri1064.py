'''
Carlos Roberto de Oliveira Júnior
URI 1064
SENAI - SP - Jaguariúna
'''
a = 0
c = 0
media = 0
while a < 6:
    a += 1
    entrada = eval(input())
    if entrada > 0:
        media = media + entrada
        c += 1

print(f"{c} valores positivos")
print(f"{(media/c):.1f}")