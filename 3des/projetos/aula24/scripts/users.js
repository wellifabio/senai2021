const urlBase = "http://wellifabio.000webhostapp.com/src/controll/routes/"; //"../../src/controll/routes/"
const xhr = new XMLHttpRequest();
const corpo = document.getElementById("corpo");

function loadUsers() {
  if (window.localStorage.getItem("type") === 'admin') {
    fetch(urlBase + 'route.user.php')
      .then((resp) => {
        if (!resp.ok)
          throw new Error("Erro ao executar requisição: " + resp.status);
        return resp.json();
      })
      .then((data) => {
        data.forEach((val) => {
          let faixa = document.createElement("div");
          let bts = document.createElement("label");
          let id = document.createElement("td");
          let name = document.createElement("td");
          let email = document.createElement("td");
          let password = document.createElement("td");
          let type = document.createElement("td");
          let status = document.createElement("td");
          faixa.setAttribute("class", "faixa");
          faixa.setAttribute("style", "background-color:#ffe");
          bts.setAttribute("class", "botao");
          bts.setAttribute("id", "bts" + val.id);
          bts.innerHTML += "<img class='botao' id='btEdit" + val.id + "' onclick='editUser(" + val.id + ")' src='../assets/menus/editar.png' title='Editar'/>";
          bts.innerHTML += "<img class='botao' id='btDel" + val.id + "' onclick='delUser(" + val.id + ")' src='../assets/menus/excluir.png' title='Excluir'/>";
          id.innerHTML = val.id;
          id.setAttribute("id", "id" + val.id);
          id.setAttribute("style", "border: 1px solid #ccc;border-radius: 5px;width:80px; height:100%;");
          name.innerHTML = val.name;
          name.setAttribute("id", "name" + val.id);
          name.setAttribute("style", "border: 1px solid #ccc;border-radius: 5px;width:380px; height:100%;");
          email.innerHTML = val.email;
          email.setAttribute("id", "email" + val.id);
          email.setAttribute("style", "border: 1px solid #ccc;border-radius: 5px;width:380px; height:100%;");
          password.innerHTML = val.password;
          password.setAttribute("id", "password" + val.id);
          password.setAttribute("style", "border: 1px solid #ccc;border-radius: 5px;width:50px; height:100%;");
          type.innerHTML = val.type;
          type.setAttribute("id", "type" + val.id);
          type.setAttribute("style", "border: 1px solid #ccc;border-radius: 5px;width:100px; height:100%;");
          status.innerHTML = val.status;
          status.setAttribute("id", "status" + val.id);
          status.setAttribute("style", "border: 1px solid #ccc;border-radius: 5px;width:150px; height:100%;");
          faixa.appendChild(id);
          faixa.appendChild(name);
          faixa.appendChild(email);
          faixa.appendChild(password);
          faixa.appendChild(type);
          faixa.appendChild(status);
          faixa.appendChild(bts);
          corpo.appendChild(faixa);
        })
      })
      .catch((err) => {
        console.error(err.message);
      });
  } else {
    alert("Você não possui privilegios de administrador.");
  }
}

function createUser() {
  let data = new FormData();
  let id = document.getElementById("id").value;
  let name = document.getElementById("name").value;
  let email = document.getElementById("email").value;
  let password = document.getElementById("password").value;
  let type = document.getElementById("type").value;
  if (id != '' && name != '' && email != '' && password != '') {
    data.append("action", "create");
    data.append("id", id);
    data.append("name", name);
    data.append("email", email);
    data.append("password", password);
    data.append("type", type);
    xhr.addEventListener("readystatechange", function () {
      if (this.readyState === this.DONE) {
        let resp = JSON.parse(this.responseText);
        if (resp.hasOwnProperty("err")) {
          alert(resp.erro);
        } else {
          alert("User criado com sucesso.");
        }
        window.location.reload();
      }
    });
    xhr.open("POST", urlBase + 'route.user.php');
    xhr.send(data);
  } else {
    alert("Preencha todos os campos obrigatórios");
  }
}

function editUser(id) {
  let name = document.getElementById("name" + id);
  let email = document.getElementById("email" + id);
  let password = document.getElementById("password" + id);
  let type = document.getElementById("type" + id);
  name.setAttribute("contenteditable", "true");
  email.setAttribute("contenteditable", "true");
  password.setAttribute("contenteditable", "true");
  type.setAttribute("contenteditable", "true");
  name.focus();
  let btEdit = document.getElementById("btEdit" + id);
  btEdit.setAttribute("src", "../assets/menus/send.png");
  btEdit.setAttribute("style", "margin-left:40px;");
  btEdit.setAttribute("title", "Enviar alteração");
  btEdit.setAttribute("onclick", `updateUser(${id})`);
  document.getElementById("btDel" + id).remove();
}

function updateUser(id) {
  let data = new FormData();
  let name = document.getElementById("name" + id).innerHTML;
  let email = document.getElementById("email" + id).innerHTML;
  let password = document.getElementById("password" + id).innerHTML;
  let type = document.getElementById("type" + id).innerHTML;
  if (name != '' && email != '' && password != '' && type != '') {
    data.append("action", "update");
    data.append("id", id);
    data.append("name", name);
    data.append("email", email);
    data.append("password", password);
    data.append("type", type);
    xhr.addEventListener("readystatechange", function () {
      if (this.readyState === this.DONE) {
        let resp = JSON.parse(this.responseText);
        if (resp.hasOwnProperty("err")) {
          alert(resp.erro);
        } else {
          alert("User alterado com sucesso.");
        }
        window.location.reload();
      }
    });
    xhr.open("POST", urlBase + 'route.user.php');
    xhr.send(data);
  } else {
    alert("Preencha todos os campos obrigatórios");
  }
}

function delUser(id) {
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
    xhr.open("POST", urlBase + 'route.user.php');
    xhr.send(data);
  }
}
