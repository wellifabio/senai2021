n = 0
quantPos = 0
quantNeg = 0
quantPar = 0
quantIm = 0
while n < 5:
	n += 1
	ent = int(input())
	if ent > 0: 
		quantPos += 1
	if ent < 0:
		quantNeg += 1
	if ent % 2 == 0:
		quantPar += 1
	if ent % 2 != 0:
		quantIm += 1

print(quantPar, "valor(es) par(es)")
print(quantIm, "valor(es) impar(es)")
print(quantPos, "valor(es) positivo(s)")
print(quantNeg, "valor(es) negativo(s)")
