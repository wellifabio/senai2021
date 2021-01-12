const arquivo = document.getElementById("file");
const saida = document.getElementById("saida");
var tabela = {
    6:4.50,
    7:31.50,
    8:126,
    9:378,
    10:945
}
var vTotal = 0;

function calcularAposta(){
    if(arquivo.value != ''){
        let arquivoLido = new FileReader(); //Leitor de arquivo
        arquivoLido.onload = function(fileLoadedEvent){
            let text = fileLoadedEvent.target.result;
            let row = text.split("\n");
            //Mostra linha por linha
            for(i = 0; i < row.length; i++){
                let linha = document.createElement("label");
                let qtdNum = row[i].split(" ").length;
                linha.innerHTML = tabela[qtdNum];
                vTotal += tabela[qtdNum];
                saida.appendChild(linha);  
            }
            let linha = document.createElement("label");
            linha.innerHTML = "O valor total da aposta é: R$"+vTotal;
            saida.appendChild(linha);
        }
        arquivoLido.readAsText(arquivo.files[0], "UTF-8");
    } else {
        alert("Selecione o arquivo de jogos.");
    }
}