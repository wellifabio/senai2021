'''
Danilo Berimni
1 Des
ex.1066
'''
n = 0
quantPos = 0
quantNeg = 0
quantPar = 0
quantImp = 0
while n < 5:
    a = int(input())
    if a > 0:#positivo
        quantPos += 1
    elif a < 0:#negativo
        quantNeg += 1

    if (a % 2) == 0:#par
        quantPar += 1
    else:#neg
        quantImp += 1

    n += 1
print(f'{quantPar} valor(es) par(es)')
print(f'{quantImp} valor(es) impar(es)')
print(f'{quantPos} valor(es) positivo(s)')
print(f'{quantNeg} valor(es) negativo(s)')
