const entrada = document.getElementById("entrada");
const saida = document.getElementById("saida");
var numeros = [];
var jogos = [];

function gerarJogos() {
    let jog = entrada.value.split(" ")[0];
    let num = entrada.value.split(" ")[1];
    for (j = 0; j < jog; j++) { // Laço que gera os jogos
        for (i = 0; i < num; i++) { // Laço que gera os números
            //impede números repetidos
            while (numeros.indexOf(numTemp = Math.floor(Math.random() * 59 + 1)) >= 0);
            numeros[i] = numTemp; //Atribuo o número temporário (não repetido) ao vetor
        }
        numeros.sort(sortfunction); // Ordena o vetor - crescente
        jogos.push(numeros); //Atribui o vetor à matriz 
        numeros = []; //Zera o vetor
    }
    saida.innerHTML = "";
    for (j = 0; j < jogos.length; j++) {
        let linha = document.createElement("label");
        linha.innerHTML = jogos[j];
        saida.appendChild(linha);
    }
    let btSave = document.createElement("button");
    btSave.innerHTML = "Salvar";
    btSave.setAttribute("onclick", "save()");
    saida.appendChild(btSave);
    let btSavePDF = document.createElement("button");
    btSavePDF.innerHTML = "Salvar em PDF";
    btSavePDF.setAttribute("onclick", "savePDF()");
    saida.appendChild(btSavePDF);
}

function save() {
    let textoSalvo = '';
    for (i = 0; i < jogos.length; i++) {
        textoSalvo += jogos[i].toString().replaceAll(",", " ") + "\n";
    }
    let link = document.createElement("a");
    link.href = "data:," + textoSalvo;
    link.download = "jogos.txt";
    link.click();
}

function savePDF() {
    let textoSalvo = '';
    for (i = 0; i < jogos.length; i++) {
        textoSalvo += jogos[i].toString().replaceAll(",", " ") + "\n";
    }
    var doc = new jsPDF()
    doc.text(textoSalvo, 20, 20)
    doc.save('jogos.pdf')

    /*
    Link do artigo sobre como gerar arquivos PDFs
    https://medium.com/code-prestige/gerando-arquivos-pdf-com-javascript-23e8b19fde99
    */
}

function sortfunction(a, b) { //Função auxiliar para ordenar
    return (a - b);
}