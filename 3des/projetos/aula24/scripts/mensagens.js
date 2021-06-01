const urlBase = "http://wellifabio.000webhostapp.com/src/controll/routes/"; //"../../src/controll/routes/"
const xhr = new XMLHttpRequest();
const corpo = document.getElementById("corpo");

function loadMessages() {
  if (window.localStorage.getItem("type") === 'admin') email = "";
  else email = "?email=" + window.localStorage.getItem("email");
  fetch(urlBase + 'route.message.php' + email)
    .then((resp) => {
      if (!resp.ok)
        throw new Error("Erro ao executar requisição: " + resp.status);
      return resp.json();
    })
    .then((data) => {
      data.forEach((val) => {
        let card = document.createElement("div");
        let nome = document.createElement("label");
        let message = document.createElement("td");
        let quando = document.createElement("label");
        card.setAttribute("class", "card");
        card.setAttribute("style", "background-image: url('../assets/back1.png'); background-size: 100% 100%;");
        nome.setAttribute("class", "tit1");
        message.setAttribute("class", "normal");
        message.setAttribute("style", "width:100%;");
        message.setAttribute("id", "td" + val.id);
        quando.setAttribute("class", "normal");
        quando.setAttribute("id", "quando" + val.id);
        nome.setAttribute("id", "nome" + val.id);
        nome.innerHTML = val.name;
        nome.innerHTML += "<img class='botao' id='btEdit" + val.id + "' onclick='editMessage(" + val.id + ")' src='../assets/menus/editar.png' title='Editar'/>";
        nome.innerHTML += "<img class='botao' id='btDel" + val.id + "' onclick='delMessage(" + val.id + ")' src='../assets/menus/excluir.png' title='Excluir' />";
        message.innerHTML += val.message;
        quando.innerHTML = "id = " + val.id + " - " + val.email + " - " + val.date + " - " + val.tyme;
        card.appendChild(nome);
        card.appendChild(message);
        card.appendChild(quando);
        corpo.appendChild(card);
      })
    })
    .catch((err) => {
      console.error(err.message);
    });
}

function delMessage(id) {
  let data = new FormData();
  data.append("action", "delete");
  data.append("id", id);
  if (window.confirm("Confirma Exclusão da mensagem id = " + id + " ?")) {
    xhr.addEventListener("readystatechange", function () {
      if (this.readyState === this.DONE) {
        let resp = JSON.parse(this.responseText);
        if (resp.hasOwnProperty("err")) {
          alert(resp.erro);
        }
        window.location.reload();
      }
    });
    xhr.open("POST", urlBase + 'route.message.php');
    xhr.send(data);
  }
}

function editMessage(id) {
  let celulaMsg = document.getElementById("td" + id);
  let btEdit = document.getElementById("btEdit" + id);
  document.getElementById("btDel" + id).remove();
  btEdit.setAttribute("src", "../assets/menus/send.png");
  celulaMsg.setAttribute("contenteditable", "true");
  celulaMsg.focus();
  btEdit.setAttribute("onclick", `sendMessage(${id})`);
  btEdit.setAttribute("title","Enviar alteração");
}

function sendMessage(id) {
  let data = new FormData();
  let nome = document.getElementById("nome" + id).innerText;
  let email = document.getElementById("quando" + id).innerText;
  let msg = document.getElementById("td" + id).innerText;
  data.append("action", "update");
  data.append("id", id);
  data.append("name", nome);
  data.append("message", msg);
  data.append("email", email.split(" - ")[1]);
  xhr.addEventListener("readystatechange", function () {
    if (this.readyState === this.DONE) {
      let resp = JSON.parse(this.responseText);
      if (resp.hasOwnProperty("err")) {
        alert(resp.erro);
      } else {
        alert("Mensagem alterada com sucesso.");
      }
      window.location.reload();
    }
  });
  xhr.open("POST", urlBase + 'route.message.php');
  xhr.send(data);
}