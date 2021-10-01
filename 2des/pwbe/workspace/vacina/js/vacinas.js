var d1 = 0;
var d2 = 0;
var d1a = 0;
var d2a = 0;
var resultado = "";

function leArquivo(e) {
    let arquivo = e.files[0]
    let fr = new FileReader()
    fr.onload = () => {
        vacinacao(fr.result)
    };
    fr.readAsText(arquivo)
}

function vacinacao(dados) {
    let vetor = dados.split("\n")
    for (i = 0; i < vetor[0]; i++) {
        aplica(vetor[i + 1]);
    }

    resultado += "Pessoas completamente imunizadas: " + d2
    resultado += "\r\nPessoas imunizadas apenas com uma dose: " + d1
    resultado += "\r\nPessoas que tomaram a segunda dose com atraso: " + d2a
    resultado += "\r\nPessoas esperando a segunda dose com atraso: " + d1a

    download(resultado)

}

function download(dados){
    let a = document.createElement("a");
    a.href = "data:," + dados;
    a.download = "saida.txt";
    a.click();
}

function aplica(vacinas) {
    let lote = parseInt(vacinas)
    //Primeiro, se existem pessoas com a segunda dose em atraso
    if (d1a > 0) {
        //verifico se as doses são suficientes
        if (d1a <= lote) {
            d2 += d1a; //Acrecenta em imunizados
            lote -= d1a //Retiro do lote as doses aplicadas
            d2a += d1a; //Acrecenta em quem tomou atrazado
            d1 -= d1a; //Retira também de quem tomou a primeira dose
            d1a = 0; //Todos os atrazados vacinados            
        } else {
            d1a -= lote; //Aplico todas as doses
            d2a += lote; //Acrecenta em quem tomou atrazado
            d2 += lote; //Acrecenta em imunizados
            d1 -= lote //Remover de aguardando segunda dose
            lote = 0; //Esvazio o lote
        }
    }

    //Verifica se ainda há vacinas
    if (lote > 0) {
        //Em seguida, são vacinadas as pessoas com a segunda dose em dia
        if (d1 > 0) {
            //verifico se as doses são suficientes
            if (d1 <= lote) {
                d2 += d1; //Acrecenta em quem tomou atrazado
                lote -= d1; //Retiro do lote as doses aplicadas
                d1 = 0; //Todos os atrazados vacinados
            } else {
                d1 -= lote; //Aplico todas as doses
                d2 += lote; //Acrecenta em imunizados
                d1a += d1; //Acrescenta aos atrasados
                lote = 0; //Esvazio o lote
            }
        }
    }

    //Por fim, todas as vacinas restantes são aplicadas como primeira dose
    if (lote > 0) {
        d1 += lote; //aplica o lote inteiro
    }
}