const urlBase = "../../src/controll/routes/";
const xhr = new XMLHttpRequest();
const corpo = document.getElementById("corpo");

function loadFiles(path){
  fetch(urlBase+'route.file.php?path='+path)
  .then((resp)=>{
    if (!resp.ok)
      throw new Error("Erro ao executar requisição: " + resp.status);
    return resp.json();
  })
  .then((data)=>{
    let quadro = document.createElement("div");
    quadro.innerHTML = "../"+path+"/";
    data.forEach((val) => {
      let fileMng = document.createElement("div");
      let fname = document.createElement("label");
      let btDel = document.createElement("button");
      fname.innerHTML += val.file;
      fname.setAttribute("style", "margin-left:0px;");
      btDel.innerHTML = "x";
      btDel.setAttribute("style", "border: 1px solid #ccc;border-radius: 5px; margin-left:50px;cursor:pointer;");
      btDel.setAttribute("onclick",`delFile('${path}/${val.file}')`);
      fileMng.appendChild(btDel);
      fileMng.appendChild(fname);
      quadro.appendChild(fileMng);
    });
    corpo.appendChild(quadro);
  })
  .catch((err)=>{
    console.error(err.message);
  });
}

function sendFile(){
    let path = document.getElementById("path");
    let file = document.getElementById("file");
    let data = new FormData();
    data.append("action", "create");
    data.append("path", path.value);
    data.append("file", file.files[0]);
    if(file.value != ""){
        xhr.withCredentials = true;
        xhr.addEventListener("readystatechange", function () {
            if (this.readyState === this.DONE) {
                let resp = JSON.parse(this.responseText);
                if (resp.hasOwnProperty("err")) {
                  alert(resp.err);
                } else {
                  alert("Arquivo enviado com sucesso.");
                }
                window.location.reload();
            }
        });
        xhr.open("POST", urlBase + "route.file.php");
        //xhr.setRequestHeader("Content-Type", "multipart/form-data");
        xhr.send(data);
    }else{
        alert("Selecione um arquivo.");
    }
}

function delFile(file){
  let data = new FormData();
  data.append("action", "delete");
  data.append("path", file);
  if (window.confirm("Confirma Exclusão do arquivo " + file + " ?")) {
    xhr.addEventListener("readystatechange", function () {
      if (this.readyState === this.DONE) {
        let resp = JSON.parse(this.responseText);
        if (resp.hasOwnProperty("err")) {
          alert(resp.erro);
        }
        window.location.reload();
      }
    });
    xhr.open("POST", urlBase + 'route.file.php');
    xhr.send(data);
  }
}