const jogo1 = document.getElementById("jogo1");
const jogo2 = document.getElementById("jogo2");
const corpo = document.getElementById("corpo");
const btPDF = document.createElement("button");
btPDF.innerHTML = "Download do bilhete preechido";
btPDF.setAttribute("onclick", "salvarPDF()");
btPDF.setAttribute("id", "btPDF");
var isBtPDF = false;
var jogos = [];
var numeros = [];
var qtdNum = 0;

function geraJogos() {
    qtdNum = parseInt(document.getElementById("qtdNum").value);
    let nTemp = 0;
    jogos = [];
    for(x = 0; x < 2; x++){
        for(i = 0; i < qtdNum; i++){
            while (numeros.indexOf(nTemp = Math.floor(Math.random() * 25 + 1)) >= 0);
            numeros[i] = nTemp;
        }
        for(i = 0; i < qtdNum; i++)if (parseInt(numeros[i]) < 10) numeros[i] = "0" + numeros[i];
        numeros = numeros.sort();
        jogos.push(numeros);
        numeros = [];
    }
    jogo1.value = jogos[0].toString().replaceAll(",", " ");
    jogo2.value = jogos[1].toString().replaceAll(",", " ");
    verificarMinimoSeis();
}

function verificarMinimoSeis(){
    if((jogo1.value.length > 43 || jogo2.value.length > 43) && !isBtPDF){
        corpo.appendChild(btPDF);
        isBtPDF = true;
    }
    if((jogo1.value.length < 44 && jogo2.value.length < 44) && isBtPDF){
        document.getElementById("btPDF").remove();
        isBtPDF = false;
    }
}

function salvarPDF() {
    jogos = [];
    numeros = jogo1.value.split(" ");
    jogos.push(numeros);
    numeros = jogo2.value.split(" ");
    jogos.push(numeros);
    var x = 50;
    var y = 50;
    var doc = new jsPDF();
    doc.addImage("./bilhete.png", 'PNG', x + 6, y + 6, 75, 125);
    doc.setFillColor('#000');
    let val = 0;
    let xx = 0;
    let yy = 0;
    for (i = 0; i < jogos.length; i++) {
        for (j = 0; j < jogos[i].length; j++) {
            val = parseInt(jogos[i][j]);
            if (val < 6) {
                yy = y + 25.3 + 4.2 * val;
                xx = x + 63;
            } else if (val < 11) {
                yy = y + 25.3 + 4.2 * (val - 5);
                xx = x + 51.6;
            } else if (val < 16) {
                yy = y + 25.3 + 4.2 * (val - 10);
                xx = x + 39.4;
            } else if (val < 21) {
                yy = y + 25.3 + 4.2 * (val - 15);
                xx = x + 27.7;
            } else {
                yy = y + 25.3 + 4.2 * (val - 20);
                xx = x + 16.2;
            }
            doc.rect(xx, yy, 3.5, 2.6, 'F');
        }
        y += 23.2;
    }
    yy = 126.3;
    xx = x + 11.8 + 7.5 * (jogos[0].length - 14);
    doc.rect(xx, yy, 3.5, 2.6, 'F');
    doc.save('bilhete.pdf');
}