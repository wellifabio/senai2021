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
    data.forEach((val) => {
      let pessoal = document.createElement("div");
      let link = document.createElement("a");
      pessoal.setAttribute("class","linkPessoal");
      link.setAttribute("href", val.href);
      link.setAttribute("target", "blanck");
      link.setAttribute("class", "tit1");
      link.setAttribute("style", "text-decoration: none; color:#000;");
      link.innerHTML = `<img src='${val.img}' style='width:100%;' align='top'>`;
      link.innerHTML += val.label;
      pessoal.appendChild(link);
      corpo.appendChild(pessoal);
    })
  })
  .catch((err)=>{
    console.error(err.message);
  });
}