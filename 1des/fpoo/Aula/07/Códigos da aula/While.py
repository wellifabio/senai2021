'''
 Exemplos While
 Rafael Alves
 05/04/2021 - Senai - Jaguariúna - SP
'''

'''
n = 5
while n > 0:
    if n > 1:
        print('Fail error: n maior que 1')
    else:
        print('Fail error: n menor que 1')
    print(n)
    n -= 1
print('fogo!')
'''

'''
a = 1
b = 1000
while a!=b:
    print('Rafael: '+str(a))
    a +=1

    
print("a = ",a)
print("b = ",b)
'''

'''
num = float(input("Informe um número:"))
n = 1
while n<=5:
    print(n)
    if(num == n):
        break
    elif n == 3:
        break
    else:
        print("Ainda não parou o laço")
    n += 1
print('Fim!')
'''

'''
segundos = 960
minutos = segundos / 60
while minutos > 6:
    print('Ainta faltam mais de 6 minutos, tempo atual:'+ str(minutos))
    minutos-=1
    if minutos < 7:
        break
    
'''    
'''
entrada = 0    
while entrada != -1:
    entrada = eval(input('Digite a hora de entrada:'))
    
    if(entrada!= -1 and entrada < 7.25):
        print('Você bateu o cartão antes do horário, fale com o Paraguassu!')
        print('A casa caiu!')
        break
    elif entrada > 7.35:
        print('Você bateu o cartão depois do horário, fale com o Paraguassu!')
        print('A casa caiu, vai ter desconto na folha!')
        break
    elif( entrada !=-1):
        print('Vai para a sala de aula')
     '''
     
'''
num = float(input("Informe um número:"))
while num > 0:
    num = num - 1
    if num % 2 != 0: # Se é ímpar
        continue
    print(num) # Caso seja par
print("Fim")
'''

'''
num = float(input("Informe um número:"))
while num > 0:
    num = num - 1
    if num % 2 != 0: # Se é ímpar
        continue
    print(num) # Caso seja par
print("Fim")
'''
        
n = 0 
bomba = 7 # Valor para acertar
while n < 3: # Número de tentativas
    num = int(input('Informe um número inteiro'))
    n = n + 1
    if num == bomba: # O usário acertou o bomba
        print("Parabéns, você acertou após", n, "tentativas")
        break # Ao executar o break não entra no else
else: # Entra caso o usuário não acertou o bomba
    print("Não foi dessa vez")
print("Fim!")
       







