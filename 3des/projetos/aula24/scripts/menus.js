const urlBase = "http://wellifabio.000webhostapp.com/src/controll/routes/"; //"../../src/controll/routes/"
const xhr = new XMLHttpRequest();
const corpo = document.getElementById("corpo");
var id = 0;

function loadMenus() {
  if (window.localStorage.getItem("type") === 'admin'){
    fetch(urlBase + 'route.menu.php')
      .then((resp) => {
        if (!resp.ok)
          throw new Error("Erro ao executar requisição: " + resp.status);
        return resp.json();
      })
      .then((data) => {
        data.forEach((val) => {
          id++;
          let faixa = document.createElement("div");
          let bts = document.createElement("label");
          let label = document.createElement("td");
          let href = document.createElement("td");
          let icone = document.createElement("td");
          let iover = document.createElement("td");
          let type = document.createElement("td");
          faixa.setAttribute("class", "faixa");
          faixa.setAttribute("style", "background-image: url('../assets/back5.png'); background-size: 100%");
          bts.setAttribute("class", "botao");
          bts.setAttribute("id", "bts" + id);
          bts.innerHTML += "<img class='botao' id='btEdit" + id + "' onclick='editMenu(" + id + ")' src='../assets/menus/editar.png' title='Editar'/>";
          bts.innerHTML += "<img class='botao' id='btDel" + id + "' onclick='delMenu(" + id + ")' src='../assets/menus/excluir.png' title='Excluir'/>";
          label.setAttribute("id", "label" + id);
          label.setAttribute("style", "border: 1px solid #ccc;border-radius: 5px;width:250px; height:100%;");
          label.innerHTML = val.label;
          href.setAttribute("id", "href" + id);
          href.setAttribute("style", "border: 1px solid #ccc;border-radius: 5px;width:250px; height:100%;");
          href.innerHTML = val.href;
          icone.setAttribute("id", "icone" + id);
          icone.setAttribute("style", "border: 1px solid #ccc;border-radius: 5px;width:280px; height:100%;");
          icone.innerHTML = val.icone;
          iover.setAttribute("id", "iover" + id);
          iover.setAttribute("style", "border: 1px solid #ccc;border-radius: 5px;width:280px; height:100%;");
          iover.innerHTML = val.iover;
          type.setAttribute("id", "type" + id);
          type.setAttribute("style", "border: 1px solid #ccc;border-radius: 5px;width:60px; height:100%;");
          type.innerHTML = val.type;
          faixa.appendChild(label);
          faixa.appendChild(href);
          faixa.appendChild(icone);
          faixa.appendChild(iover);
          faixa.appendChild(type);
          faixa.appendChild(bts);
          corpo.appendChild(faixa);
        })
      })
      .catch((err) => {
        console.error(err.message);
      });
  }else {
    alert("Você não possui privilegios de administrador.");
  }
}

function createMenu() {
  let data = new FormData();
  let label = document.getElementById("label").value;
  let href = document.getElementById("href").value;
  let icone = document.getElementById("icone").value;
  let iover = document.getElementById("iover").value;
  let type = document.getElementById("type").value;
  if (label != '' && href != '' && icone != '' && iover != '') {
    data.append("action", "create");
    data.append("label", label);
    data.append("href", href);
    data.append("icone", icone);
    data.append("iover", iover);
    data.append("type", type);
    xhr.addEventListener("readystatechange", function () {
      if (this.readyState === this.DONE) {
        let resp = JSON.parse(this.responseText);
        if (resp.hasOwnProperty("err")) {
          alert(resp.erro);
        } else {
          alert("Ítem de menu criado com sucesso.");
        }
        window.location.reload();
      }
    });
    xhr.open("POST", urlBase + 'route.menu.php');
    xhr.send(data);
  } else {
    alert("Preencha todos os campos obrigatórios");
  }
}

function editMenu(id) {
  let label = document.getElementById("label" + id);
  let href = document.getElementById("href" + id);
  let icone = document.getElementById("icone" + id);
  let iover = document.getElementById("iover" + id);
  let type = document.getElementById("type" + id);
  href.setAttribute("contenteditable", "true");
  icone.setAttribute("contenteditable", "true");
  iover.setAttribute("contenteditable", "true");
  type.setAttribute("contenteditable", "true");
  href.focus();
  let btEdit = document.getElementById("btEdit" + id);
  btEdit.setAttribute("src", "../assets/menus/send.png");
  btEdit.setAttribute("style", "margin-left:40px;");
  btEdit.setAttribute("title", "Enviar alteração");
  btEdit.setAttribute("onclick", `updateMenu(${id})`);
  document.getElementById("btDel" + id).remove();
}

function updateMenu(id) {
  let data = new FormData();
  let label = document.getElementById("label" + id).innerHTML;
  let href = document.getElementById("href" + id).innerHTML;
  let icone = document.getElementById("icone" + id).innerHTML;
  let iover = document.getElementById("iover" + id).innerHTML;
  let type = document.getElementById("type" + id).innerHTML;
  if (href != '' && icone != '' && iover != '' && type != '') {
    data.append("action", "update");
    data.append("label", label);
    data.append("href", href);
    data.append("icone", icone);
    data.append("iover", iover);
    data.append("type", type);
    xhr.addEventListener("readystatechange", function () {
      if (this.readyState === this.DONE) {
        let resp = JSON.parse(this.responseText);
        if (resp.hasOwnProperty("err")) {
          alert(resp.erro);
        } else {
          alert("Item de menu alterado com sucesso.");
        }
        window.location.reload();
      }
    });
    xhr.open("POST", urlBase + 'route.menu.php');
    xhr.send(data);
  } else {
    alert("Preencha todos os campos obrigatórios");
  }
}

function delMenu(id) {
  let data = new FormData();
  let label = document.getElementById("label" + id).innerHTML;
  data.append("action", "delete");
  data.append("label", label);
  if (window.confirm("Confirma Exclusão da mensagem item = " + label + " ?")) {
    xhr.addEventListener("readystatechange", function () {
      if (this.readyState === this.DONE) {
        let resp = JSON.parse(this.responseText);
        if (resp.hasOwnProperty("err")) {
          alert(resp.erro);
        }
        window.location.reload();
      }
    });
    xhr.open("POST", urlBase + 'route.menu.php');
    xhr.send(data);
  }
}