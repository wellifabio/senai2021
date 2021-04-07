'''
Danilo Berimni
ex.1060
'''


n = 0
countPos = 0
while n < 6:
    n += 1
    entrada = eval (input())
    if entrada > 0:           #numero positivo
        countPos += 1
print (countPos, 'valores positivos')
