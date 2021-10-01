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

    resultado += "\nPessoas completamente imunizadas: " + d2
    resultado += "\nPessoas imunizadas apenas com uma dose: " + d1
    resultado += "\nPessoas que tomaram a segunda dose com atraso: " + d2a
    resultado += "\nPessoas esperando a segunda dose com atraso: " + d1a

    console.log(resultado)
}

function aplica(lote) {
    console.log("Lote = "+lote);
    //Primeiro, se existem pessoas com a segunda dose em atraso
    if(d1a > 0){
        //verifico se as doses são suficientes
        if(d1a <= lote){
            lote -= d1a //Retiro do lote as doses aplicadas
            d2a =+ d1a; //Acrecenta em quem tomou atrazado
            d2 += d1a; //Acrecenta em imunizados
            d1a = 0; //Todos os atrazados vacinados
        }else{
            d1a -= lote; //Aplico todas as doses
            d2a =+ lote; //Acrecenta em quem tomou atrazado
            d2 += lote; //Acrecenta em imunizados
            lote = 0; //Esvazio o lote
        }
    }

    //Em seguida, são vacinadas as pessoas com a segunda dose em dia
    if(d1 > 0){
        //verifico se as doses são suficientes
        if(d1 <= lote){
            lote -= d1 //Retiro do lote as doses aplicadas
            d2 =+ d1; //Acrecenta em quem tomou atrazado
            d1 = 0; //Todos os atrazados vacinados
        } else {
            d1 -= lote; //Aplico todas as doses
            d2 += lote; //Acrecenta em imunizados
            lote = 0; //Esvazio o lote
        }
    }

    //Por fim, todas as vacinas restantes são aplicadas como primeira dose
    if(d1 <= lote){
        d1 += lote; //aplica o lote inteiro
        console.log("aplica o lote inteiro como primeira dose");
    }
}