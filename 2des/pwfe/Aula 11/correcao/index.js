function add() {
    let corpo = document.querySelector(".corpo")
    let card = document.createElement("div")
    let comp = document.getElementById("compromisso")
    card.className = "card"
    card.innerHTML = "<label>"+comp.value+"</label>"
    let importante = document.createElement("button")
    importante.className = "importante"
    importante.addEventListener("click", () => {
        card.setAttribute("style","background-color:#fbb;border: 1px solid #600;");
    });
    let excluir = document.createElement("button")
    excluir.className = "excluir"
    excluir.addEventListener("click", () => {
        card.remove();
    });
    card.appendChild(importante)
    card.appendChild(excluir)
    corpo.appendChild(card)
    comp.value = ""
}