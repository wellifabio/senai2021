n = 0
countPar = 0
while n < 5:
	n += 1
	entrada = int(input())
	if entrada % 2 == 0:
		countPar += 1
print(countPar, "valores pares")