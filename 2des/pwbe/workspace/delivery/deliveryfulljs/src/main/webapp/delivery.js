const producao = document.querySelector(".producao")
const entrega = document.querySelector(".entrega")
var dh = new Date();

function lancarPedido() {
	//Cria um objeto e pega os dados do formulário
	let pedido = {
		cliente: document.querySelector("#cliente").value,
		endereco: document.querySelector("#endereco").value,
		produto: document.querySelector("#produto").value
	}
	//Chama a função que envia os dados para o BackEnd
	registraPedido(pedido);
}

function criaCard(obj) {
	//Cria o CARD na div Pedidos
	let card = document.createElement("div")
	let dados = document.createElement("div")
	let botao = document.createElement("button")
	card.className = "card"
	dados.className = "dados"
	dados.innerHTML = `<p>${obj.id}</p><p>${obj.cliente}</p><p>${obj.endereco}</p><p>${obj.produto}</p><p>${obj.data}</p><p>${obj.hora}</p>`
	botao.innerHTML = "<img width='50px' src='./assets/icon-check.png'>Enviar Entrega"
	botao.setAttribute("onClick", "iniciaEntrega(this)");
	card.appendChild(dados)
	card.appendChild(botao)
	producao.appendChild(card)
}

function iniciaEntrega(e) {
	let id = e.parentNode.children[0].children[0].innerText
	registraInicioEntrega(id)
	entrega.appendChild(e.parentNode)
	e.innerHTML = "<img width='50px' src='./assets/icon-motoboy.png'>Pedido entregue";
	e.addEventListener("click", () => {
		registraFimEntrega(id)
		e.parentNode.remove();
	});
}

function finalizaEntrega(e) {
	let id = e.parentNode.children[0].children[0].innerText
	registraFimEntrega(id)
	e.parentNode.remove();
}

function registraPedido(obj) {
	let data = "?cliente=" + obj.cliente
	data += "&endereco=" + obj.endereco
	data += "&produto=" + obj.produto
	let xhr = new XMLHttpRequest()
	xhr.addEventListener("readystatechange", function() {
		if (this.readyState === this.DONE) {
			obj.id = this.responseXML.getElementsByTagName("id")[0].textContent
			obj.data = dh.getDate() + "/" + (dh.getMonth() + 1) + "/" + dh.getFullYear()
			obj.hora = dh.getHours() + ":" + dh.getMinutes()
			console.log(obj.id + "," + obj.cliente + "," + obj.endereco + ", " + obj.produto + "," + obj.data + "," + obj.hora)
			criaCard(obj)
		}
	})
	xhr.open("POST", "registra" + data)
	xhr.send(data)
}

function registraInicioEntrega(id) {
	let data = "?inicio=" + id
	let xhr = new XMLHttpRequest()
	xhr.addEventListener("readystatechange", function() {
		if (this.readyState === this.DONE) {
			id = this.responseXML
			console.log(id)
		}
	})
	xhr.open("PUT", "registra"+data)
	xhr.send(data)
}

function registraFimEntrega(id) {
	let data = "?fim=" + id
	let xhr = new XMLHttpRequest()
	xhr.addEventListener("readystatechange", function() {
		if (this.readyState === this.DONE) {
			id = this.responseXML
			console.log(id)
		}
	})
	xhr.open("DELETE", "registra"+data)
	xhr.send(data)
}