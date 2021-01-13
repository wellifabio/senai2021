const entrada = document.getElementById("entrada");
const saida = document.getElementById("saida");
var jogos = [];
var numeros = [];
var txtSaida = '';

function geraJogos() {
    let nJ = parseInt(entrada.value.split(" ")[0]);
    let nN = parseInt(entrada.value.split(" ")[1]);
    let nTemp = 0;
    jogos = [];
    saida.innerHTML = "";
    if ((nJ === 1 || nJ === 2) && (nN > 5) && (nN < 16)) {
        for (i = 0; i < nJ; i++) {
            for (j = 0; j < nN; j++) {
                while (numeros.indexOf(nTemp = Math.floor(Math.random() * 59 + 1)) >= 0);
                if (parseInt(nTemp) < 10) nTemp = "0" + nTemp;
                numeros.push(nTemp);
            }
            numeros = numeros.sort();
            jogos.push(numeros);
            numeros = [];
        }
        //Monta a saída na tela
        for (i = 0; i < jogos.length; i++) {
            let linha = document.createElement("label");
            linha.innerHTML = jogos[i];
            saida.appendChild(linha);
        }
        //Monta a saída em txt
        for (i = 0; i < jogos.length; i++) {
            let linha = jogos[i].toString();
            txtSaida += linha.replaceAll(",", " ");
            txtSaida += "\r\n";
        }
        let btPDF = document.createElement("button");
        btPDF.innerHTML = "Gerar Bilhete";
        btPDF.setAttribute("onclick", "salvarPDF()");
        saida.appendChild(btPDF);

        let todosOsJogos = document.createElement("label");
        todosOsJogos.innerHTML = "Jogos acumulados:"+txtSaida;
        saida.appendChild(todosOsJogos);

        let btSalvar = document.createElement("button");
        btSalvar.innerHTML = "Salvar";
        btSalvar.setAttribute("onclick", "salvarTXT()");
        saida.appendChild(btSalvar);
    } else {
        alert("Opção de bilhete inválida, cada bilhete aceita no máximo 2 jogos, de 6 a 15 números.");
    }
}

function salvarTXT() {
    let link = document.createElement("a");
    link.href = "data:," + txtSaida;
    link.download = "jogos.txt";
    link.click();
}

function salvarPDF() {
    var x = 50;
    var y = 50;
    var doc = new jsPDF();
    doc.addImage("./bilhete.png", 'PNG', x + 6, y + 6, 98, 138);
    doc.setFillColor('#000');
    let val = 0;
    let xx = 0;
    let yy = 0;
    for (i = 0; i < jogos.length; i++) {
        for (j = 0; j < jogos[i].length; j++) {
            val = parseInt(jogos[i][j]);
            if (val < 11) {
                yy = y + 31.2;
                xx = x + 12 + 7.2 * val;
            } else if (val < 21) {
                yy = y + 35;
                xx = x + 12 + 7.2 * (val - 10);
            } else if (val < 31) {
                yy = y + 39.1;
                xx = x + 12 + 7.2 * (val - 20);
            } else if (val < 41) {
                yy = y + 43.2;
                xx = x + 12 + 7.2 * (val - 30);
            } else if (val < 51) {
                yy = y + 46.9;
                xx = x + 12 + 7.2 * (val - 40);
            } else {
                yy = y + 50.2;
                xx = x + 12 + 7.2 * (val - 50);
            }
            doc.rect(xx, yy, 5.2, 2.6, 'F');
        }
        y += 29.5;
    }
    yy = 142.2;
    xx = x + 12 + 7.2 * (jogos[0].length - 5);
    doc.rect(xx, yy, 5.2, 2.6, 'F');
    doc.save('bilhete.pdf');
}