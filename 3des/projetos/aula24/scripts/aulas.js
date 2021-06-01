const urlBase = "http://wellifabio.000webhostapp.com/src/controll/routes/"; //"../../src/controll/routes/"
const menuAulas = document.getElementById("menuAulas");
const boxMsg = document.createElement("div");
const links = document.getElementById("links");
boxMsg.setAttribute("class", "boxMsg");
const messages = document.createElement("label");
messages.setAttribute("class", "paragraph");

function loadMenu() {
  fetch(urlBase + "route.menu.php?type=aulas")
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
        link.setAttribute("target","iFrame");
        link.innerHTML = `<img src='${val.icone}' onmouseover="altimg(this,'${val.iover}','${val.label}')" onmouseout="altimg(this,'${val.icone}','')">`;
        menuAulas.appendChild(link);
        menuAulas.innerHTML += "<hr style='margin-left:20px;margin-right:20px;' color='red'>"
      });
      boxMsg.appendChild(messages);
      menuAulas.appendChild(boxMsg);
    })
    .catch((err) => {
      console.error(err.message);
    });
}

function altimg(e, arg, msg) {
  e.setAttribute("src", arg);
  messages.innerHTML = msg;
}

function loadLinks(type){
  fetch(urlBase+'route.link.php?type='+type)
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