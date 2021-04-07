n = 0
a = 0
somaA = 0
while n < 6:
	n += 1
	b = eval(input())
	if b > 0: 
		somaA += b
		a += 1

m = somaA / a
print(f'{a} valores positivos')
print(f'{m:.1f}')