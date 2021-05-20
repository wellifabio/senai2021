import random

cidades = ["Americana;SP","Amparo;SP","Campinas;SP","Jaguariúna;SP","Pedreira;SP","Belo Horizonte;MG","Pouso Alegre;MG","Monte Verde;MG","Curitiba;PR","Jacarezinho;PR","Londrina;PR"]
nomes = ["Amanda","Ana","Ana Paula","Maria","Ricardo","Matheus","Marcos","Lucas","João","Carlos","Alfredo","Bento","Elian","Juvenal","Fabrício","Hiago","Enso","Zilda","Gilberto","Ribamar","Ivo","Luciano","Nivaldo","Orácio","Paulo","Saulo","Timóteo"]
sobrenomes = ["Silva","Santos","Souza","Alves","de Oliveira","Belli","da Silva","Fernandes","Falcirolli","Martins","Ramos","Bourn","Freeman","Scovisk"]
meses = ["Jan","Fev","Mar","Abr","Mai","Jun","Jul","Ago","Set","Out","Nov"]
carros = ["Ka","Gol","Pálio","Uno","EcoSport","Fiesta","Polo","Cruze","Civic","Logan","Corola"]
salarios = [1800,1900,2050,2100,2200,2250]

arquivo = open("dados.csv","w")
arquivo.write("Data;Cidade;UF;Vendedor;Salario;Veículo;Preço\n")
for cidade in cidades:
    for c in range(0,random.randint(3,7)):
        nom = random.choice(nomes)
        nome = nom + " " + random.choice(sobrenomes)
        salario = random.choice(salarios)
        for mes in meses:
            for i in range(0,random.randint(1,28)):
                dia = random.randint(1,28)
                data = str(dia)+"-"+mes+"-"+"2020"
                for j in range(0,random.randint(0,len(carros))):
                    carro = random.choice(carros)
                    valor = random.randrange(10000,60000)
                    arquivo.write(data+";"+cidade+";"+nome+";"+str(salario)+";"+carro+";"+str(valor)+"\n")
arquivo.close()
print("Arquivo gerado e preenchido com sucesso")
            
    
