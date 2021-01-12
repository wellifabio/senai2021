const arquivo = document.getElementById("file");
const saida = document.getElementById("saida");
const entrada = document.getElementById("entrada");

function verificarAposta(){
    if(arquivo.value != ''){
        if(entrada.value != ''){
            let sorteados = entrada.value.split(" ");
            let acertos = 0;
            if(sorteados.length == 6){
                let arquivoLido = new FileReader(); //Leitor de arquivo
                arquivoLido.onload = function(fileLoadedEvent){
                    let text = fileLoadedEvent.target.result;
                    let row = text.split("\n");
                    //Mostra linha por linha
                    for(i = 0; i < row.length; i++){
                        let linha = document.createElement("label");
                        let escolhidos = row[i].split(" ");
                        for(j = 0; j < escolhidos.length;j++){
                            if(sorteados.indexOf(escolhidos[j])>=0){
                                acertos++;
                            }
                        }
                        switch(acertos){
                            case 4: break;
                                linha.innerHTML = row[i] + " QUADRA";
                            case 5: break;
                                linha.innerHTML = row[i] + " QUINA";
                            case 6:
                                linha.innerHTML = row[i] + " SENA";
                            break;
                            default:
                                linha.innerHTML = row[i] + " Acertos = "+acertos;
                            break;
                        }
                        saida.appendChild(linha);
                        acertos = 0;
                    }
                }
                arquivoLido.readAsText(arquivo.files[0], "UTF-8");    
            }else{
                alert("Digite apenas 6 números separados por espaços");    
            }
        }else{
            alert("Digite os números sorteados.");
        }
    } else {
        alert("Selecione o arquivo de jogos.");
    }
}