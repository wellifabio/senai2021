const modal = document.getElementById("modal");
const gantt = document.getElementById("gantt");
const prazo = document.getElementById("prazo");
const atividade = document.getElementById("atividade");
const recurso = document.getElementById("recurso");
const inicio = document.getElementById("inicio");
const duracao = document.getElementById("duracao");
const status = document.getElementById("status");
var tipo = "Dias";
var colunas = 1;

function getInicialConfig() {
    modal.setAttribute("style", "display:flex;")
}

function criarCronograma() {
    if (prazo.value !== '' && prazo.value > 0) {
        if (prazo.value > 31) {
            tipo = 'Semanas';
            colunas = parseInt(prazo.value / 7);
            if (colunas > 40) {
                tipo = 'Meses';
                colunas = parseInt(prazo.value / 30);
            }
        } else {
            colunas = prazo.value;
        }
        table = document.createElement("table");
        thead = document.createElement("thead");
        tr1 = document.createElement("tr");
        tr1.innerHTML = "<th rowspan='2'>Atividades</th><th rowspan='2'>Recursos</th><th rowspan='2'>Ini.</th><th rowspan='2'>Dur.</th><th rowspan='2'>Stat.</th><th colspan='" + colunas + "'>" + tipo + "</th>";
        tr2 = document.createElement("tr");
        for (i = 1; i <= colunas; i++) {
            tr2.innerHTML += "<th>" + i + "</th>";
        }
        tbody = document.createElement("tbody");
        tbody.setAttribute("id", "corpo");
        btSalvar = document.createElement("button");
        btSalvar.setAttribute("onclick", "salvarCSV()");
        btSalvar.innerHTML = "Salvar em CSV";
        btPrint = document.createElement("button");
        btPrint.setAttribute("onclick", "imprimir()");
        btPrint.innerHTML = "Imprimir";
        thead.appendChild(tr1);
        thead.appendChild(tr2);
        table.appendChild(thead);
        table.appendChild(tbody);
        gantt.appendChild(table);
        gantt.appendChild(btSalvar);
        gantt.appendChild(btPrint);
        duracao.setAttribute("placeholder", tipo);
        switch (tipo) {
            case "Dias": inicio.setAttribute("placeholder", "Dia"); break;
            case "Semanas": inicio.setAttribute("placeholder", "Semana"); break;
            default: inicio.setAttribute("placeholder", "Mês"); break;
        }
        modal.setAttribute("style", "display:none;");
    } else {
        alert("Preencha os campos tipo e prazo do projeto.");
    }
}

function adicionar() {
    const corpo = document.getElementById("corpo");
    if (atividade.value != '' && recurso.value != '' && inicio.value != '' && duracao.value != '') {
        let duracaoMaxima = colunas - parseInt(inicio.value) + 1;
        if (inicio.value > 0 && duracao.value > 0 && parseInt(inicio.value) <= colunas && parseInt(duracao.value) <= duracaoMaxima) {
            let tr = document.createElement("tr");
            tr.innerHTML = `<td>${atividade.value}</td><td>${recurso.value}</td><td>${inicio.value}</td><td>${duracao.value}</td><td>${status.value}</td>`;
            for (i = 1; i <= colunas; i++) {
                if (i >= parseInt(inicio.value) && i <= parseInt(inicio.value) + parseInt(duracao.value) - 1) {
                    tr.innerHTML += "<td class='" + status.value + "'></td>";
                } else {
                    tr.innerHTML += "<td class='tdbranco'></td>";
                }
            }
            corpo.appendChild(tr);
        } else {
            alert("O início da atividade a a duração devem estar dentro do cronograma.");
        }
    } else {
        alert("Preencha todos os campos obrigatórios.");
    }
}

function imprimir() {
    if (true) {
        window.print();
        //https://tableless.com.br/dicas-de-css-para-impressao/
    } else {
        alert("Preencha todos os campos obrigatórios.");
    }
}

function salvarCSV() {
    if (corpo.getElementsByTagName("tr").length > 0) {
        let a = document.createElement("a");
        a.href = "data:," + tbodyToCSV(corpo);
        a.download = "gantt.csv";
        a.click();
    } else {
        alert("Não há dados na tabela para serem salvos.");
    }
}

//Função que percorre o corpo da tabela e converte o resultado em CSV
function tbodyToCSV(tbody) {
    let csv = prazo.value + "\r\n";
    let linhas = tbody.getElementsByTagName("tr");
    if (linhas.length > 0) {
        for (let lin = 0; lin < linhas.length; lin++) {
            let colunas = linhas[lin].getElementsByTagName("td");
            for (let col = 0; col < colunas.length - 1; col++) {
                //Remove células vazias
                if (colunas[col].textContent != '') csv += colunas[col].textContent + ";";
            }
            csv += "\r\n";
        }
    }
    return csv;
}

//Função que carrega um arquivo de texto
function carregarCSV() {
    if (window.File && window.FileReader && window.FileList && window.Blob) {
        let arquivo = document.getElementById("abrir");
        if(arquivo.value != ''){
            let arquivoLido = new FileReader(); //Leitor de arquivo
            arquivoLido.onload = function(fileLoadedEvent){
                let text = fileLoadedEvent.target.result;
                let row = text.split("\r\n");
                prazo.value = row[0];
                criarCronograma();
                //Preenche o gráfico linha por linha
                for(i = 1; i < row.length; i++){
                    let tr = document.createElement("tr");
                    let col = row[i].split(";");
                    tr.innerHTML = `<td>${col[0]}</td><td>${col[1]}</td><td>${col[2]}</td><td>${col[3]}</td><td>${col[4]}</td>`;
                    for (j = 1; j <= colunas; j++) {
                        if (j >= parseInt(col[2]) && j <= parseInt(col[2]) + parseInt(col[3]) - 1) {
                            tr.innerHTML += "<td class='" + col[4] + "'></td>";
                        } else {
                            tr.innerHTML += "<td class='tdbranco'></td>";
                        }
                    }
                    corpo.appendChild(tr); 
                }
            }
            arquivoLido.readAsText(arquivo.files[0], "UTF-8");
        } else {
            alert("Selecione o arquivo CSV.");
        }
    } else {
        alert("Arquivo(s) não suportado(s)");
    }
}