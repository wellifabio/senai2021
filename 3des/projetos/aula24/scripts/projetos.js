const urlBase = "http://wellifabio.000webhostapp.com/src/controll/routes/"; //"../../src/controll/routes/"
const corpo = document.getElementById("corpo");

function loadLinks(type){
  fetch(urlBase+'route.link.php?type='+type)
  .then((resp)=>{ 
    if (!resp.ok)
      throw new Error("Erro ao executar requisição: " + resp.status);
    return resp.json();
  })
  .then((data)=>{
    const todos = document.createElement("div");
    todos.setAttribute("class","allLinks");
    data.forEach((val) => {
      let projeto = document.createElement("a");
      projeto.setAttribute("class","linkProj");
      projeto.setAttribute("href", val.href);
      projeto.setAttribute("target", "blanck");
      projeto.setAttribute("style", "text-decoration: none; color:#000");
      projeto.innerHTML = `<img src='${val.img}' class="imgProj">`;
      let link = document.createElement("label");
      link.setAttribute("class", "tit1");
      link.innerHTML += val.label;
      projeto.appendChild(link);
      todos.appendChild(projeto);
    });
    corpo.appendChild(todos);
  })
  .catch((err)=>{
    console.error(err.message);
  });
}