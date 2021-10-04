function leArquivo(parametro){
    let arquivo = parametro.files[0]
    let fr = new FileReader()
    fr.onload = () => {
        somaMaisUm(fr.result)
    };
    fr.readAsText(arquivo)
}

function somaMaisUm(dados){
    let saida = "";
    let linhas = dados.split("\n")
    linhas.forEach((linha)=>{
        let col = linha.split(" ")
        saida += col[0] + " " + (parseInt(col[1])+1) +" \r\n"
    })
    download(saida)
}

function download(dados){
    let a = document.createElement("a");
    a.href = "data:," + dados;
    a.download = "saida.txt";
    a.click();
}