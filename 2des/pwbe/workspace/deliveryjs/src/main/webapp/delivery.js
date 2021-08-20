const cliente = document.querySelector("#cliente")
const endereco = document.querySelector("#endereco")
const produto = document.querySelector("#produto")

const producao = document.querySelector(".producao")
const entrega = document.querySelector(".entrega")

function lancarPedido() {
    let card = document.createElement("div")
    let dados = document.createElement("div")
    let pCliente = document.createElement("p")
    let pEndereco = document.createElement("p")
    let pProduto = document.createElement("p")
    let pData = document.createElement("p")
    let pHora = document.createElement("p")
    let botao = document.createElement("button")

    card.className = "card"
    dados.className = "dados"
    pCliente.innerHTML = cliente.value
    pEndereco.innerHTML = endereco.value
    pProduto.innerHTML = produto.value
    pData.innerHTML = dh.getDate() + "/" + (dh.getMonth() + 1) + "/" + dh.getFullYear()
    pHora.innerHTML = dh.getHours() + ":" + dh.getMinutes()

    dados.appendChild(pCliente)
    dados.appendChild(pData)
    dados.appendChild(pEndereco)
    dados.appendChild(pHora)
    dados.appendChild(pProduto)

    botao.innerHTML = "<img width='50px' src='./assets/icon-check.png'>Enviar Entrega"
	botao.setAttribute("onclick","entrega(this)");
    botao.addEventListener("click", () => {
        entrega.appendChild(card)
        dh = new Date
        pHora.innerHTML = dh.getHours() + ":" + dh.getMinutes()
        botao.innerHTML = "<img width='50px' src='./assets/icon-motoboy.png'>Pedido entregue";
        botao.addEventListener("click", () => {
            card.remove();
        });
    });

    card.appendChild(dados)
    card.appendChild(botao)
    producao.appendChild(card)
	registra(cliente.value,endereco.value,produto.value);
}

function entrega(e){
	entrega.appendChild(e.parentNode)
}

function registra(cli,endr,prod){
	let data = "?cliente="+cli
	data += "&endereco="+endr
	data +="&produto="+prod
	
	let xhr = new XMLHttpRequest()
	xhr.addEventListener("readystatechange", function () {
	  if (this.readyState === this.DONE) {
	    console.log(this.responseText);
	  }
	})
	
	xhr.open("POST", "./registra.jsp"+data)
	xhr.send(data)
}