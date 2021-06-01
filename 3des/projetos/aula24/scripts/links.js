const urlBase = "http://wellifabio.000webhostapp.com/src/controll/routes/"; //"../../src/controll/routes/"
const xhr = new XMLHttpRequest();
const corpo = document.getElementById("corpo");

function loadLinks() {
  if (window.localStorage.getItem("type") === 'admin') {
    fetch(urlBase + 'route.link.php')
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
          let label = document.createElement("td");
          let href = document.createElement("td");
          let img = document.createElement("td");
          let type = document.createElement("td");
          faixa.setAttribute("class", "faixa");
          faixa.setAttribute("style", "background-image: url('../assets/back2.png'); background-size: 100%");
          bts.setAttribute("class", "botao");
          bts.setAttribute("id", "bts" + val.id);
          bts.innerHTML += "<img class='botao' id='btEdit" + val.id + "' onclick='editLink(" + val.id + ")' src='../assets/menus/editar.png' title='Editar'/>";
          bts.innerHTML += "<img class='botao' id='btDel" + val.id + "' onclick='delLink(" + val.id + ")' src='../assets/menus/excluir.png' title='Excluir'/>";
          id.setAttribute("id", "id" + val.id);
          id.setAttribute("style", "border: 1px solid #ccc;border-radius: 5px;width:30px; height:100%;");
          label.innerHTML = val.label;
          label.setAttribute("id", "label" + val.id);
          label.setAttribute("style", "border: 1px solid #ccc;border-radius: 5px;width:250px; height:100%;");
          id.innerHTML = val.id;
          href.setAttribute("id", "href" + val.id);
          href.setAttribute("style", "border: 1px solid #ccc;border-radius: 5px;width:480px; height:100%;");
          href.innerHTML = val.href;
          img.setAttribute("id", "img" + val.id);
          img.setAttribute("style", "border: 1px solid #ccc;border-radius: 5px;width:270px; height:100%;");
          img.innerHTML = val.img;
          type.setAttribute("id", "type" + val.id);
          type.setAttribute("style", "border: 1px solid #ccc;border-radius: 5px;width:70px; height:100%;");
          type.innerHTML = val.type;
          faixa.appendChild(id);
          faixa.appendChild(label);
          faixa.appendChild(href);
          faixa.appendChild(img);
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

function createLink() {
  let data = new FormData();
  let label = document.getElementById("label").value;
  let href = document.getElementById("href").value;
  let img = document.getElementById("img").value;
  let type = document.getElementById("type").value;
  if (label != '' && href != '' && img != '') { 
    data.append("action", "create");
    data.append("label", label);
    data.append("href", href);
    data.append("img", img);
    data.append("type", type);
    xhr.addEventListener("readystatechange", function () {
      if (this.readyState === this.DONE) {
        let resp = JSON.parse(this.responseText);
        if (resp.hasOwnProperty("err")) {
          alert(resp.erro);
        } else {
          alert("Link criado com sucesso.");
        }
        window.location.reload();
      }
    });
    xhr.open("POST", urlBase + 'route.link.php');
    xhr.send(data);
  }else{
    alert("Preencha todos os campos obrigatórios");
  }
}

function editLink(id){
  let label = document.getElementById("label" + id);
  let href = document.getElementById("href" + id);
  let img = document.getElementById("img" + id);
  let type = document.getElementById("type" + id);
  label.setAttribute("contenteditable", "true");
  href.setAttribute("contenteditable", "true");
  img.setAttribute("contenteditable", "true");
  type.setAttribute("contenteditable", "true");
  label.focus();
  let btEdit = document.getElementById("btEdit" + id);
  btEdit.setAttribute("src","../assets/menus/send.png");
  btEdit.setAttribute("style","margin-left:40px;");
  btEdit.setAttribute("title","Enviar alteração");
  btEdit.setAttribute("onclick", `updateLink(${id})`);
  document.getElementById("btDel" + id).remove();  
}

function updateLink(id){
  let data = new FormData();
  let label = document.getElementById("label"+id).innerHTML;
  let href = document.getElementById("href"+id).innerHTML;
  let img = document.getElementById("img"+id).innerHTML;
  let type = document.getElementById("type"+id).innerHTML;
  if (label != '' && href != '' && img != '' && type != '') { 
    data.append("action", "update");
    data.append("id", id);
    data.append("label", label);
    data.append("href", href);
    data.append("img", img);
    data.append("type", type);
    xhr.addEventListener("readystatechange", function () {
      if (this.readyState === this.DONE) {
        let resp = JSON.parse(this.responseText);
        if (resp.hasOwnProperty("err")) {
          alert(resp.erro);
        } else {
          alert("Link alterado com sucesso.");
        }
        window.location.reload();
      }
    });
    xhr.open("POST", urlBase + 'route.link.php');
    xhr.send(data);
  }else{
    alert("Preencha todos os campos obrigatórios");
  }
}

function delLink(id) {
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
    xhr.open("POST", urlBase + 'route.link.php');
    xhr.send(data);
  }
}