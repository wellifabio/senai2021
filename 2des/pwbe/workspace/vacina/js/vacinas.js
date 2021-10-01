var d1 = 0;
var d2 = 0;
var d1a = 0;
var d2a = 0;
var resultado = "";

function leArquivo(e){
    let arquivo = e.files[0]
    let fr = new FileReader()
    fr.onload = () => {
        vacinacao(fr.result)
    };
    fr.readAsText(arquivo)
}

function vacinacao(dados){
    let vetor = dados.split("\n")
    for(i = 1; i < vetor.length; i++){
        aplica(vetor[i]);
    }

    resultado += "\nPessoas completamente imunizadas: " + d2
    resultado += "\nPessoas imunizadas apenas com uma dose: " + d1
    resultado += "\nPessoas que tomaram a segunda dose com atraso: "+ d2a
    resultado += "\nPessoas esperando a segunda dose com atraso: "+ d1a

    console.log(resultado)
}

function aplica(lote){
    d1 += parseInt(lote)
}