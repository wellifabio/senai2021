/******Funcções específicas para este tema*******/
const nomes = lerArquivoLista("./uteis/nomes.txt")
const sobrenomes = lerArquivoLista("./uteis/sobrenomes.txt")
const logradouros = lerArquivoLista("./uteis/logradouros.txt")
const bairros = lerArquivoLista("./uteis/bairros.txt")
const cidades = lerArquivoLista("./uteis/cidades.txt")
const produtos = ['X-Burguer', 'X-Egg', 'X-Bacon', 'X-Tudo', 'X-Frango', 'Refrigerante - Lata', 'Refrigerante - 2L']

function obterAgora() {
    let agora = document.getElementById('agora');
    let data = new Date
    agora.value = "Hoje é = " + data.getDate() + "/" + (data.getMonth() + 1) + "/" + data.getFullYear() + " Agora são = " + data.getHours() + ":" + data.getMinutes()
}

function preencherForm() {
    let cliente = document.getElementById('cliente');
    cliente.value = geraNomeCompleto()
    let endereco = document.getElementById('endereco');
    endereco.value = geraEnderecos()
    let produto = document.getElementById('produto');
    produtos.forEach(opcao => {
        produto.innerHTML += "<option>" + opcao + "</option>"
    });
    produto.value = geraProdutos()
}

function geraNomeCompleto() {
    let nome = nomes[Math.floor(Math.random() * nomes.length)]
    let sobrenome = sobrenomes[Math.floor(Math.random() * sobrenomes.length)]
    let sobrenome2 = sobrenomes[Math.floor(Math.random() * sobrenomes.length)]
    if (Math.floor(Math.random() * 2) == 1) {
        return nome + " " + sobrenome + " " + sobrenome2
    } else {
        return nome + " " + sobrenome
    }
}
function geraEnderecos() {
    let logradouro = logradouros[Math.floor(Math.random() * logradouros.length)]
    let bairro = bairros[Math.floor(Math.random() * bairros.length)]
    let cidade = cidades[Math.floor(Math.random() * cidades.length)]
    return logradouro + ", " + bairro + ", " + cidade
}
function geraProdutos() {
    return produtos[Math.floor(Math.random() * produtos.length)]
}

/**************Funções úteis Gerais ***************/
//Lê um arquivo de texto com uma coluna de dados e retorna uma lista
function lerArquivoLista(file) {
    let dados = 'File not found'
    let rawFile = new XMLHttpRequest()
    rawFile.open("GET", file, false)
    rawFile.onreadystatechange = function () {
        if (rawFile.readyState === 4) {
            if (rawFile.status === 200 || rawFile.status == 0) {
                dados = rawFile.responseText;
            }
        }
    }
    rawFile.send(null)
    return dados.split("\n")
}
