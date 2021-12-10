const tipo = document.querySelector('#tipo')
const aviso = document.querySelector('#aviso')
const link = document.querySelector('#link')
const mural = document.querySelector('#mural')

function add() {
    let card = document.createElement('div')
    card.setAttribute("class", "card " + tipo.value)
    card.innerHTML += '<div style="width:100%" align="right"><button class="fechar" onclick="del(this)">X</button></div>'
    card.innerHTML += '<p><a href="' + link.value + '" target="_blank">'+aviso.value+'</a></p>'
    mural.appendChild(card)
}

function del(e){
    e.parentNode.parentNode.remove()
}

function estilizarInput(){
    document.querySelector('#add').setAttribute("class",tipo.value)
}