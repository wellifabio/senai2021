function add() {
    let corpo = document.querySelector(".corpo")
    let card = document.createElement("div")
    card.className = "card"
    card.innerHTML = "<label>"+document.getElementById("compromisso").value+"</label>"
    let importante = document.createElement("button")
    importante.className = "importante"
    let excluir = document.createElement("button")
    excluir.className = "excluir"
    card.appendChild(importante)
    card.appendChild(excluir)
    corpo.appendChild(card)
}