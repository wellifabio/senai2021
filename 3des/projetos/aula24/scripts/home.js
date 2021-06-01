const urlBase = "http://wellifabio.000webhostapp.com/src/controll/routes/"; //"../../src/controll/routes/"
const xhr = new XMLHttpRequest();
const redes = document.getElementById("redes");
const links = document.getElementById("links");
const name = document.getElementById("name");
const message = document.getElementById("message");
const button = document.getElementById("button");

function loadContatos() {
  fetch(urlBase+'route.link.php?type=contato')
    .then((resp)=>{
      if (!resp.ok)
        throw new Error("Erro ao executar requisição: " + resp.status);
      return resp.json();
    })
    .then((data)=>{
      data.forEach((val) => {
        let link = document.createElement("a");
        link.setAttribute("href", val.href);
        link.setAttribute("class", "lnkContato");
        link.setAttribute("target", "blanck");
        link.innerHTML = `<img src='${val.img}' title='${val.label}' style='margin-top:30px;width:120px'>`;
        redes.appendChild(link);
      })
    })
    .catch((err)=>{
      console.error(err.message);
    });
}

function loadLinks(){
  fetch(urlBase+'route.link.php?type=destaque')
  .then((resp)=>{ 
    if (!resp.ok)
      throw new Error("Erro ao executar requisição: " + resp.status);
    return resp.json();
  })
  .then((data)=>{
    data.forEach((val) => {
      let postit = document.createElement("div");
      let link = document.createElement("a");
      link.setAttribute("href", val.href);
      link.setAttribute("target", "blanck");
      link.setAttribute("class", "linkPostit");
      link.innerHTML = val.label;
      postit.setAttribute("class", "postit");
      postit.setAttribute("style", `background-image: url("${val.img}");background-size: cover;`);
      postit.appendChild(link);
      links.appendChild(postit);
    })
  })
  .catch((err)=>{
    console.error(err.message);
  });
}

function sendMessage() {
  if (name.value != "" && message.value != "") {
    let data = new FormData();
    let email = window.localStorage.getItem("email");
    data.append("action", "create");
    data.append("name", name.value);
    if(email !== null && email !== '') data.append("email", email);
    else data.append("email", "outro@aluno.com");
    data.append("message", message.value);
    xhr.addEventListener("readystatechange", function () {
      if (this.readyState === this.DONE) {
        let resp = JSON.parse(this.responseText);
        if (resp.hasOwnProperty("err")) {
          alert(resp.err);
        } else {
          alert("Assim que eu ler sua mensagem te darei um retorno.");
          window.location.reload();
        }
      }
    });
    xhr.open("POST", urlBase+"route.message.php");
    xhr.send(data);
  } else {
    alert("Favor preencher o nome completo e a mensagem.");
  }
}