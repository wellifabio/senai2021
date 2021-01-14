//Carrega as variáveis globais
var c = document.querySelector("#valorFinanciado");
var n = document.querySelector("#numeroParcelas");
var i = document.querySelector("#porcentagemJuros");
var montante = document.querySelector("#montanteFinal");
var valorParcelas = document.querySelector("#valorParcelas");
var corpoTabela = document.querySelector("#tableBody");
var botao = document.querySelector("#botao");
var template = document.querySelector("#templateLinhas"); //Template é uma tabela invisível

//Criando botões botão delete e update para remover linhas da tabela
var btDelete = document.createElement("button");
btDelete.innerText = "Excluir";
var btUpdate = document.createElement("button");
btUpdate.innerText = "Alterar";

//Função para calcular os Juros (apenas Compostos)
function jurosCompostos() {
  var m = parseFloat(
    parseFloat(c.value) *
      Math.pow(1 + parseFloat(i.value) / 100, parseInt(n.value))
  ).toFixed(2);
  var p = parseFloat(m / parseInt(n.value)).toFixed(2);
  montante.setAttribute("value", m);
  valorParcelas.setAttribute("value", p);
}

//Função que acrescenta valores a uma tabela, utilizando um template
function criaLinhasTemplate(event) {
  event.preventDefault(); //Executa com o do DOM padrão já carregado. Senão a págia é recarregada.
  if (c.value != "" && n.value != "" && i.value != "") {
    lista = template.content.querySelectorAll("td"); //Inicia uma lista de colunas <TD>
    lista[0].textContent = c.value;
    lista[1].textContent = n.value;
    lista[2].textContent = i.value;
    lista[3].textContent = montante.value;
    lista[4].textContent = valorParcelas.value;
    btUpdate.setAttribute("onclick", "alterarLinha(this)");
    btDelete.setAttribute("onclick", "excluirLinha(this)");
    lista[5].appendChild(btUpdate);
    lista[5].appendChild(btDelete);
    let novaLinha = document.importNode(template.content, true); //Junta as colunas em uma linha
    corpoTabela.appendChild(novaLinha); //Transfere o template para a tabela visível
    c.value = ""; //Limpa o campo do formulário
    n.value = ""; //Limpa o campo do formulário
    i.value = ""; //Limpa o campo do formulário
  } else {
    alert("Preencha os campos obrigatórios para registrar a simulação.");
  }
}

//Função para alterar o conteúdo de linhas da tabela
function alterarLinha(elemento) {
  c.value = elemento.parentNode.parentNode.cells[0].innerHTML;
  n.value = elemento.parentNode.parentNode.cells[1].innerHTML;
  i.value = elemento.parentNode.parentNode.cells[2].innerHTML;
  jurosCompostos(); //Chama a função para calcular novamente os Juros
  elemento.parentNode.parentNode.remove();
}

//Função para excluir linhas de uma tabela
function excluirLinha(elemento) {
  elemento.parentNode.parentNode.remove();
}

//Função que percorre o corpo da tabela e converte o resultado em CSV
function tbodyToCSV(tbody) {
  let csv = "";
  let linhas = tbody.getElementsByTagName("tr");
  if (linhas.length > 0) {
    for (let lin = 0; lin < linhas.length; lin++) {
      let colunas = linhas[lin].getElementsByTagName("td");
      for (let col = 0; col < colunas.length - 1; col++) {
        csv += colunas[col].textContent + ";";
      }
      csv += "\r\n";
    }
  }
  return csv;
}

//Salvar arquivo
function salvarArquivo() {
  if (corpoTabela.getElementsByTagName("tr").length > 0) {
    let a = document.createElement("a");
    a.href = "data:," + tbodyToCSV(corpoTabela);
    a.download = "financiamentos.csv";
    a.click();
  } else {
    alert("Não há dados na tabela para serem salvos.");
  }
}

//Função que carrega um arquivo de texto
function abrirArquivo() {
  if (window.File && window.FileReader && window.FileList && window.Blob) {
    let arquivoSelecionado = document.getElementById("abrir");
    arquivoSelecionado.addEventListener(
      "change",
      function (e) {
        let extensaoArquivo = /text.*/;
        let arquivoLido = arquivoSelecionado.files[0];
        if (arquivoLido.type.match(extensaoArquivo)) {
          let leitorDeArquivo = new FileReader();
          leitorDeArquivo.onload = function (e) {
            let linhas = leitorDeArquivo.result.split("\r\n");
            linhas.forEach((lin) => {
              let col = lin.split(";");
              lista = template.content.querySelectorAll("td");
              lista[0].textContent = col[0];
              lista[1].textContent = col[1];
              lista[2].textContent = col[2];
              lista[3].textContent = col[3];
              lista[4].textContent = col[4];
              btUpdate.setAttribute("onclick", "alterarLinha(this)");
              btDelete.setAttribute("onclick", "excluirLinha(this)");
              lista[5].appendChild(btUpdate);
              lista[5].appendChild(btDelete);
              let novaLinha = document.importNode(template.content, true);
              corpoTabela.appendChild(novaLinha);
            });
          };
          leitorDeArquivo.readAsText(arquivoLido);
        } else {
          alert("Por favor selecione arquivo de texto");
        }
      },
      false
    );
  } else {
    alert("Arquivo(s) não suportado(s)");
  }
}

//Eventos principais
i.addEventListener("keyup", jurosCompostos);
botao.addEventListener("click", criaLinhasTemplate);
window.onload = abrirArquivo();