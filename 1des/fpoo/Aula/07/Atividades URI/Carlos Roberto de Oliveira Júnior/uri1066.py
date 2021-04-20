'''
Carlos Roberto de Oliveira Júnior
URI 1066
SENAI - SP - Jaguariúna
'''
n = 0
pos = 0
neg = 0
par = 0
imp = 0
while n < 5:
    n += 1
    a = int(input())
    if (a > 0):#positivos
        pos += 1
    elif (a < 0):#negativos
        neg += 1
    
    if (a % 2) == 0:#pares
        par += 1
    else:#impares
        imp += 1

print(f"{par} valor(es) par(es)\n{imp} valor(es) impar(es)\n{pos} valor(es) positivo(s)\n{neg} valor(es) negativo(s)")
