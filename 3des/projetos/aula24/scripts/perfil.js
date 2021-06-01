const urlBase = "http://wellifabio.000webhostapp.com/src/controll/routes/"; //"../../src/controll/routes/"
const xhr = new XMLHttpRequest();
const corpo = document.getElementById("corpo");
var nam = '';
var mail = '';
var tpe = '';

function loadPerfil() {
  if (window.localStorage.getItem("type") === 'aluno') {
    fetch(urlBase + 'route.user.php?email=' + window.localStorage.getItem("email"))
      .then((resp) => {
        if (!resp.ok)
          throw new Error("Erro ao executar requisição: " + resp.status);
        return resp.json();
      })
      .then((data) => {
        data.forEach((val) => {
          nam = val.name;
          mail = val.email;
          tpe = val.type;
          let bts = document.createElement("label");
          let name = document.createElement("label");
          let email = document.createElement("label");
          let password = document.createElement("label");
          let type = document.createElement("label");
          let status = document.createElement("label");
          let divSenha = document.createElement("div");
          bts.setAttribute("class", "botao");
          bts.setAttribute("id", "bts" + val.id);
          bts.innerHTML += "<img class='botao' id='btEdit' onclick='editSenha(" + val.id + ")' src='../assets/menus/editar.png' title='Trocar a senha'/>";
          bts.innerHTML += "<img class='botao' id='btDel' onclick='delPerfil(" + val.id + ")' src='../assets/menus/excluir.png' title='Excluir usuário'/>";
          name.innerHTML = val.name;
          name.setAttribute("style", "font-size:x-large;");
          name.setAttribute("id", "name");
          email.innerHTML = "Email: " + val.email;
          email.setAttribute("id", "email");
          password.innerHTML = "Nova senha";
          password.setAttribute("style", "border: 1px solid #ccc;border-radius: 5px;width:400px;font-weight:bold;");
          password.setAttribute("id", "password");
          type.innerHTML = val.type;
          type.setAttribute("id", "type");
          status.innerHTML = "Sua conta foi criada em " + val.status.split(" ")[0] + " e você já fez " + val.status.split(" ")[1] + " acessos.";
          status.setAttribute("id", "status");
          corpo.appendChild(name);
          corpo.appendChild(email);
          corpo.appendChild(type);
          corpo.appendChild(status);
          divSenha.appendChild(password);
          divSenha.appendChild(bts);
          corpo.appendChild(divSenha);
        })
      })
      .catch((err) => {
        console.error(err.message);
      });
  } else if (window.localStorage.getItem("type") === 'validate') {
    corpo.innerHTML = "<p class='tit1'>Foi enviado para a sua caixa de e-mail um código de confirmação:</p>";
    let codigo = document.createElement("input");
    codigo.setAttribute("id", "codigo");
    codigo.setAttribute("type", "text");
    codigo.setAttribute("placeholder", "Digite o código aqui");
    codigo.setAttribute("style", "width:200px;height:30px;margin-left:10px");
    let btConf = document.createElement("img");
    btConf.setAttribute("src", "../assets/menus/send.png");
    btConf.setAttribute("style", "width:50px;margin-left:40px;");
    btConf.setAttribute("title", "Enviar confirmação");
    btConf.setAttribute("onclick", `sendCodigo()`);
    let btsair = document.createElement("input");
    btsair.setAttribute("type", "button");
    btsair.setAttribute("onclick", "doLogout()");
    btsair.setAttribute("value", "Sair");
    btsair.setAttribute("style", "width:100px;height:30px;margin-left:10px");
    let divCod = document.createElement("div");
    divCod.setAttribute("class", "normal");
    divCod.appendChild(codigo);
    divCod.appendChild(btConf);
    divCod.appendChild(btsair);
    corpo.appendChild(divCod);
    corpo.innerHTML += "<p class='normal'>verifique em seu lixo eletrônico caso não tenha encontrado:</p>";
  } else {
    window.location.href = "./";
  }
}

function editSenha(id) {
  document.getElementById("password").remove();
  document.getElementById("btEdit").remove();
  document.getElementById("btDel").remove();
  let password = document.createElement("input");
  password.setAttribute("id", "password");
  password.setAttribute("type", "password");
  password.setAttribute("style", "width:200px;height:50px;margin-left:60px");
  let confirma = document.createElement("input");
  confirma.setAttribute("id", "confirma");
  confirma.setAttribute("type", "password");
  confirma.setAttribute("style", "width:200px;height:50px;margin-left:10px");
  let btEdit = document.createElement("img");
  let divPass = document.createElement("div");
  btEdit.setAttribute("src", "../assets/menus/send.png");
  btEdit.setAttribute("style", "width:50px;margin-left:40px;");
  btEdit.setAttribute("title", "Enviar alteração");
  btEdit.setAttribute("onclick", `updatePassword(${id})`);
  divPass.appendChild(password);
  divPass.appendChild(confirma);
  divPass.appendChild(btEdit);
  corpo.appendChild(divPass);
  password.focus();
}

function updatePassword(id) {
  let data = new FormData();
  let confirma = document.getElementById("confirma").value;
  let password = document.getElementById("password").value;
  if (password != '' && confirma != '') {
    if (password === confirma) {
      data.append("action", "update");
      data.append("id", id);
      data.append("name", nam);
      data.append("email", mail);
      data.append("password", password);
      data.append("type", tpe);
      xhr.addEventListener("readystatechange", function () {
        if (this.readyState === this.DONE) {
          let resp = JSON.parse(this.responseText);
          if (resp.hasOwnProperty("err")) {
            alert(resp.erro);
          } else {
            alert("Senha alterada com sucesso.");
          }
          window.location.reload();
        }
      });
      xhr.open("POST", urlBase + 'route.user.php');
      xhr.send(data);
    } else {
      alert("A senha não está igual a confirmação.");
    }
  } else {
    alert("Preencha todos os campos obrigatórios.");
  }
}

function delPerfil(id) {
  let data = new FormData();
  data.append("action", "delete");
  data.append("id", id);
  if (window.confirm("Confirma Exclusão do seu perfil?")) {
    xhr.addEventListener("readystatechange", function () {
      if (this.readyState === this.DONE) {
        let resp = JSON.parse(this.responseText);
        if (resp.hasOwnProperty("err")) {
          alert(resp.erro);
        }
        doLogout();
      }
    });
    xhr.open("POST", urlBase + 'route.user.php');
    xhr.send(data);
  }
}

function sendCodigo() {
  let data = new FormData();
  data.append("action", "update");
  data.append("email", window.localStorage.getItem("email"));
  data.append("cod", document.getElementById("codigo").value);
  xhr.addEventListener("readystatechange", function () {
    if (this.readyState === this.DONE) {
      let resp = JSON.parse(this.responseText);
      if (resp.hasOwnProperty("err")) {
        alert("Código inválido, digite novamente.");
        window.location.reload();
      } else {
        alert("Email validado com sucesso, faça o login novamente.");
        doLogout();
      }
    }
  });
  xhr.open("POST", urlBase + 'route.user.php');
  xhr.send(data);

}

function doLogout() {
  window.localStorage.removeItem("name");
  window.localStorage.removeItem("email");
  window.localStorage.removeItem("type");
  window.localStorage.removeItem("status");
  window.location.reload();
}