var tablebody = document.querySelector("#tablebody");

var data = [
    ["Pegeout 206", "2006", "R$ 5.000,00"],    
    ["Jetta", "2012", "R$ 80.000,00"],
    ["Veloster", "2018", "R$ 45.000,00"]
];

/*data.forEach(item => {
    let modelo = item[0];
    let ano = item[1];
    let preco = item[2];

    //Cria um elemento html no js
    let colModelo = document.createElement("td");
    //Adiciona um texto entre as TAGs 
    colModelo.innerHTML = modelo;

    //Cria um elemento html no js
    let colAno = document.createElement("td");
    //Adiciona um texto entre as TAGs 
    colAno.innerHTML = ano;

    //Cria um elemento html no js
    let colPreco = document.createElement("td");
    //Adiciona um texto entre as TAGs 
    colPreco.innerHTML = preco;

    //Cria um elemento html no js
    let row = document.createElement("tr");
        
    //Adiciona um filho ao nó
    row.appendChild(colModelo);
    row.appendChild(colAno);
    row.appendChild(colPreco);

    tablebody.appendChild(row);
});*/

//Percorre as linhas da minha matriz
data.forEach(item => {    
    
    //Cria uma nova linha
    let row = document.createElement("tr");

    //Percorre as colunas do vetor da matriz
    item.forEach(datacol => {
        //Cria uma coluna
        let col = document.createElement("td");

        //Adiciona um valor a minha coluna
        col.innerHTML = datacol;

        //Adiciona a coluna na linha
        row.appendChild(col);
    });
    
    //Adiciona a linha a tabela
    tablebody.appendChild(row);
});

function buscar () {
    //Captura o valor do input de busca e muda para letras minisculas
    let val = document.querySelector("#busca").value.toLowerCase();

    //Seleciona todas as linhas da pagina html
    let rows = document.querySelectorAll("tr");

    //laço para percorrer todas as linhas, ignorando a linha do cabecalho
    for(let i = 1; i<rows.length; i++) {
        //converte a linha para texto e compara com o valor da busca
        if(rows[i].innerHTML.toString().toLowerCase().includes(val)) {
            //caso encontre exibe a linha na tela
            rows[i].style.display = "table-row";
        }else {
            //caso não encontre valor semelhante esconde a linha
            rows[i].style.display = "none";
        }
    }
}