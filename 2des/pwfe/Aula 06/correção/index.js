var nome = document.querySelector("#nome");
var endereco = document.querySelector("#endereco");
var lanche = document.querySelector("#lanche");

var prod = document.querySelector(".producao");

function lancarpedido() {
    let card = document.createElement("div");
    card.className = "card";

    let data = document.createElement("div");
    data.className = "dadoscli";

    let pnome = document.createElement("p");
    pnome.id = "pnome";
    pnome.innerHTML = nome.value;

    let pende = document.createElement("p");
    pende.id = "pende";
    pende.innerHTML = endereco.value;

    data.appendChild(pnome);
    data.appendChild(pende);

    let planche = document.createElement("p");
    planche.id = "planche";
    planche.innerHTML = lanche.value;

    let button = document.createElement("button");
    button.innerHTML = "Enviar para entrega";

    card.appendChild(data);
    card.appendChild(planche);
    card.appendChild(button);

    prod.appendChild(card);
}