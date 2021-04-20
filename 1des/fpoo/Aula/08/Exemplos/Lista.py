pets = ['goldfish','cat','dog']

#print(pets[-3])
#print('cat' not in pets)

planets = ['earth', 'jupiter']
petsPlanets = pets + planets
#print(petsPlanets[1])
#print(planets[0][-1])
#print(planets*3)

'''
ages = [40, 53, 36, 18]
print(sum(ages))
print(min(ages))
print(max(ages))
print(sum(ages)/len(ages))
print(len(ages))

'''

'''
planets.append('saturn')
planets.append('earth')
print(planets)
print(planets.count('earth'))
print(planets.index('earth'))
planets.insert(2,'earth')
print(planets)
print(planets.pop())
print(planets)
print(planets.pop(2))
print(planets)
planets.remove('saturn')
planets.remove('earth')
print(planets) 
planets.reverse()
print(planets) 
planets.pop()

'''
'''
print(pets)
pets.sort()
print(pets)
'''
'''
t = [[4,7,2,5],[5,1,9,2],[8,3,6,6],[8,4,5,6]]
print(t)
print(t[2])
print(t[1][2])


countLine = len(t)
n = 0
while n < countLine:
    print(t[n])
    n += 1
'''

'''
print(pets)

for pet in pets:
    print(pet) 


countLine = len(pets)
n = 0
while n < countLine:
    print(pets[n])
    n+=1
'''

'''
phrase = input('Enter a phrase:')


for varCar in phrase:
    if varCar in 'aeoiuAEIOU':
        print(varCar)
'''

'''
listaNum1 = [1,2,3,4,5,6,7,8,9,10]
print(listaNum1)
listaNum2 = list(range(0,10))
print(listaNum2)
'''
'''
print(list(range(5)))
print(list(range(2,5)))
print(list(range(1,14,3)))
'''
'''
for i in range(5):
    print(i)
'''
'''
for i in range(2,5):
    print(i)
'''

'''
for i in range(1,14,3):
    print(i)
'''
'''
grades = [10,9,9.5,10,10]

for grade in grades:
    print(grade)
'''

'''
grades = [2,1,2,3]
lenGrades = len(grades)
for i in range(0,lenGrades): 
   print("Index:",i," Grade:",grades[i])
'''
'''
lst = [0,4,2,3]
aumentandoFlag = True
for i in range(0,len(lst)-1): # 0,1,2,...,len(lst)-2
    if(lst[i] > lst[i+1]):
        aumentandoFlag = False
        break
print(aumentandoFlag)
'''
'''
pricesList = [3500,4500.50, 9000]
sumPrice = 0
for price in pricesList:
    sumPrice += price
print('Python Sum:',sum(pricesList),' Our sum:', sumPrice)
'''

buyList = [['Rice',16.5,2,'Food'],['Toothpaste',1.6,3,'Clean body']]
print(buyList)