const tipo = document.querySelector('#tipo')
const aviso = document.querySelector('#aviso')
const link = document.querySelector('#link')
const mural = document.querySelector('#mural')

function add() {
    let card = document.createElement('div')
    card.setAttribute("class", tipo.value)
    card.innerHTML += '<button onclick="del(this)">X</button>'
    card.innerHTML += '<a href="' + link.value + '" target="_blank">'
    card.innerHTML += '<p>' + aviso.value + '</p>'
    card.innerHTML += '</a>'
    mural.appendChild(card)
}

function del(e){
    e.parentNode.remove()
}