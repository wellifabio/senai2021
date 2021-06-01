const urlBase = "http://wellifabio.000webhostapp.com/src/controll/routes/"; //"../../src/controll/routes/"
const xhr = new XMLHttpRequest();
const ruler = document.getElementById("ruler");
const boxMsg = document.createElement("div");
boxMsg.setAttribute("class", "boxMsg");
const messages = document.createElement("label");
messages.setAttribute("class", "message");
const login = document.createElement("input");
login.setAttribute("type", "text");
login.setAttribute("placeholder", "Email");
const password = document.createElement("input");
password.setAttribute("type", "password");
password.setAttribute("placeholder", "Senha");
const button = document.createElement("input");
button.setAttribute("type", "button");
const btCad = document.createElement("input");
btCad.setAttribute("type", "button");
btCad.setAttribute("value", "Cadastro");
btCad.setAttribute("onclick", "abrirModal()");
const modal = document.getElementById("modal");
var user = {
  name: window.localStorage.getItem("name"),
  email: window.localStorage.getItem("email"),
  type: window.localStorage.getItem("type"),
  status: window.localStorage.getItem("status")
}

function loadMainMenu() {
  let tipoMenu;
  console.log("Tipo de usuário: "+user.type);
  if (!isAnyOneLogged()) {
    tipoMenu = "publico";
  } else if (user.type == "admin") {
    tipoMenu = "admin";
  } else if (user.type == "aluno") {
    tipoMenu = "aluno";
  } else {
    tipoMenu = "aluno";
    window.location.href = "./perfil.html";
  }
  fetch(urlBase + "route.menu.php?type=" + tipoMenu)
    .then((resp) => {
      if (!resp.ok)
        throw new Error("Erro ao executar requisição: " + resp.status);
      return resp.json();
    })
    .then((data) => {
      data.forEach((val) => {
        let link = document.createElement("a");
        link.setAttribute("href", val.href);
        link.setAttribute("class", "menu");
        link.setAttribute("target", "mainFrame");
        link.innerHTML = `<img src='${val.icone}' onmouseover="altimg(this,'${val.iover}','${val.label}')" onmouseout="altimg(this,'${val.icone}','Mensagens do site:')">`;
        ruler.appendChild(link);
      });
      boxMsg.appendChild(messages);
      ruler.appendChild(boxMsg);
      if (isAnyOneLogged()) {
        messages.innerHTML = "Olá " + user.name;
        button.setAttribute("onclick", "doLogout()");
        button.setAttribute("value", "Sair");
        ruler.appendChild(button);
      } else {
        messages.innerHTML = "Mensagens do site:";
        ruler.appendChild(login);
        ruler.appendChild(password);
        button.setAttribute("onclick", "doLogin()");
        button.setAttribute("value", "Entrar");
        ruler.appendChild(button);
        ruler.appendChild(btCad);
      }
    })
    .catch((err) => {
      console.error(err.message);
    });
}

function altimg(e, arg, msg) {
  e.setAttribute("src", arg);
  messages.innerHTML = msg;
}

function doLogin() {
  if (login.value != "" && password.value != "") {
    //xhr.withCredentials = true;
    let data = new FormData();
    data.append("action", "login");
    data.append("email", login.value);
    data.append("password", password.value);
    xhr.addEventListener("readystatechange", function () {
      if (this.readyState === this.DONE) {
        let resp = JSON.parse(this.responseText);
        if (resp.hasOwnProperty("err")) {
          messages.innerHTML = resp.err;
        } else {
          window.localStorage.setItem("name", resp.name);
          window.localStorage.setItem("email", resp.email);
          window.localStorage.setItem("type", resp.type);
          window.localStorage.setItem("status", resp.status);
          window.location.reload();
        }
      }
    });
    xhr.open("POST", urlBase + "route.user.php");
    xhr.send(data);
  } else {
    messages.innerHTML = "Favor preencher o login e a senha";
  }
}

function countAcessos() {
  let data = new FormData();
  data.append("action", "update");
  data.append("status", "");
  data.append("email", window.localStorage.getItem("email"));
  xhr.addEventListener("readystatechange", function () { });
  xhr.open("POST", urlBase + "route.user.php");
  xhr.send(data);
}

function doLogout() {
  countAcessos();
  window.localStorage.removeItem("name");
  window.localStorage.removeItem("email");
  window.localStorage.removeItem("type");
  window.localStorage.removeItem("status");
  window.location.href = "./";
}

function isAnyOneLogged() {
  if (user.name != null) {
    return true;
  } else {
    return false;
  }
}

function abrirModal() {
  modal.setAttribute("style", "display:flex;");
}

function fecharModal() {
  modal.setAttribute("style", "display: none;");
}

function cadastrarUser() {
  let nome = document.getElementById("nome").value;
  let mail = document.getElementById("email").value;
  let cmail = document.getElementById("cemail").value;
  let senha = document.getElementById("senha").value;
  let csenha = document.getElementById("csenha").value;
  let politica = document.getElementById("politica").checked;
  if (nome !== '' && mail !== '' && cmail !== '' && senha !== '' && csenha !== '' && politica !== false) {
    if (mail === cmail) {
      if (senha === csenha) {
        let data = new FormData();
        data.append("action", "create");
        data.append("id", Math.floor(Math.random() * 9999 + 100));
        data.append("name", nome);
        data.append("email", mail);
        data.append("type", "validate");
        data.append("password", senha);
        xhr.addEventListener("readystatechange", function () {
          if (this.readyState === this.DONE) {
            let resp = JSON.parse(this.responseText);
            if (resp.hasOwnProperty("err")) {
              alert(resp.err);
            } else {
              alert("Usuário criado, enviamos um código de confirmação em seu e-mail.");
            }
            window.location.reload();
          }
        });
        xhr.open("POST", urlBase + "route.user.php");
        xhr.send(data);
      } else {
        alert("Senha e confirmação estão diferentes.");
      }
    } else {
      alert("Email e confirmação email estão diferentes.");
    }
  } else {
    alert("Preecha todos os capos com * e aceite os termos de privacidade.");
  }
}