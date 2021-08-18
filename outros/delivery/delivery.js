const cliente = document.querySelector("#cliente")
const endereco = document.querySelector("#endereco")
const produto = document.querySelector("#produto")

const producao = document.querySelector(".producao")
const entrega = document.querySelector(".entrega")

function lancarPedido(){
    let card = document.createElement("div")
    let dados = document.createElement("div")
    let pCliente = document.createElement("p")
    let pEndereco = document.createElement("p")
    let pProduto = document.createElement("p")
    let botao = document.createElement("button")
    
    card.className = "card"  
    dados.className = "dados";   
    pCliente.innerHTML = cliente.value;   
    pEndereco.innerHTML = endereco.value;
    pProduto.innerHTML = produto.value;
    botao.innerHTML = "Enviar para entrega";

    dados.appendChild(pCliente);
    dados.appendChild(pEndereco);

    botao.addEventListener("click", () => {
        entrega.appendChild(card);
        botao.innerHTML = "Pedido entregue";
        botao.addEventListener("click", () => {
            botao.remove();
        });
    });

    card.appendChild(dados);
    card.appendChild(pProduto);
    card.appendChild(botao);

    producao.appendChild(card);
    console.log("oi");
}