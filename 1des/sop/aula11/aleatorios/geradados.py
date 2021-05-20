#Gerador de tabela CSV com dados para um Dashboard em Excel
import random
arquivo = open('dados.csv','w')
meses = ["jan","fev","mar","Abr","jun","jul","Ago","Set","Out","Nov","Dez"]
cidades = ["Campinas;SP","Americana;SP","Jaguariuna;SP","Pedreira;SP","Amparo;SP","Pirassununga;SP","Belo Horizonte;MG","Pouso Alegre;MG","Ouro Fino;MG","Curitiba;PR","Londrina;PR","Jacarezinho;PR"]
nomes = ["Marcos","Mariza","Ana Paula","José Maria","Maria José","João Paulo","Mauro","Bruno","Otávio","Suzana","Ivone","Xavier"]
sobrenomes = ["Silva","Souza","Santos","de Oliveira","de Mattos","Palha","Coelho"]
salarios = [1100,1500,1700,2200,2800,3300]
produtos = ["Corsa","Ka","Gol","Palio","Celta","Fiesta","Polo"]
precos = [10000,11000,12000,13000,15000,18000,20000,22500,25000,35500,45000,48000,55000]

arquivo.write("Data;Cidade;UF;Funcionario;Salario;Produto;Preço\r\n");

for cidade in cidades:
  for i in range(1,random.randrange(1,len(sobrenomes))):
    nome = random.choice(nomes) + " " + sobrenomes[i]
    salario = random.choice(salarios)
    for mes in meses:
      for j in range(1,random.randrange(1,len(produtos))):
        data = str(random.randrange(1,28))+"-"+mes+"-2020"
        produto = random.choice(produtos)
        preco = random.choice(precos)
        arquivo.write(data+";"+cidade+";"+nome+";"+str(salario)+";"+produto+";"+str(preco)+"\r\n")
print("Dados criados com sucesso");