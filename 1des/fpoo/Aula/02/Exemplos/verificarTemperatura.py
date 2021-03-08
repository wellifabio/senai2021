temp = eval(input("Qual a tempertura atual:"))

if temp > 32: # Caso seja maior que 32
	print("Nossa está quente")
	print("Se hidrate!")
elif temp> 15: # Caso a temperatua esteja entre 32 e maior que 15
	print("Não está quente")
	print("Traga uma jaqueta")
else: # Caso seja menor do que 15
	print("Nossa! Está congelando")
	print("Traga uma jaqueta")

print('Senai é o melhor')