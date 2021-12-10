/******Funcções específicas para este tema*******/
const xml = carregaXML('./uteis/cards.xml');
const rand = {
    msgs: xml.getElementsByTagName("msgs")[0].textContent.substr(1).split("\n"),
    tipos: xml.getElementsByTagName("tipos")[0].textContent.substr(1).split("\n"),
    links: xml.getElementsByTagName("links")[0].textContent.substr(1).split("\n")
}
//Remove os últimos itens dos arrays, pois estão em branco
rand.msgs.pop()
rand.tipos.pop()
rand.links.pop()

function geraTipos() {
    return rand.tipos[Math.floor(Math.random() * rand.tipos.length)]
}
function geraMsgs() {
    return rand.msgs[Math.floor(Math.random() * rand.msgs.length)]
}
function geraLinks() {
    return rand.links[Math.floor(Math.random() * rand.links.length)]
}

function preencherForm() {
	document.getElementById('tipo').value = geraTipos()
	document.getElementById('aviso').value = geraMsgs()
	document.getElementById('link').value = geraLinks()
}

/**************Funções úteis Gerais ***************/
//Lê um arquivo de texto com uma coluna de dados e retorna uma lista
function carregaXML(arquivo) {
    let dados = '<mensagem>File not found</mensagem>'
    let xml = new XMLHttpRequest()
    xml.open("GET", arquivo, false)
    xml.onreadystatechange = function () {
        if (xml.readyState === 4) {
            if (xml.status === 200 || xml.status == 0) {
                dados = xml.responseXML.getElementsByTagName("dados")[0]
            }
        }
    }
    xml.send()
    return dados
}
