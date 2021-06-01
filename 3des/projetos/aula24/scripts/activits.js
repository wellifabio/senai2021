const urlBase = "../../src/controll/routes/";
const xhr = new XMLHttpRequest();
const corpo = document.getElementById("corpo");

function loadActivities() {
  if (window.localStorage.getItem("type") === 'admin') {
    let formCriacao = document.createElement("div");
    formCriacao.setAttribute("class","faixa");
    formCriacao.setAttribute("style","background-image: url('../assets/back2.png'); background-size: 100%; height:120px;");
    formCriacao.innerHTML ="<input type='text' id='label' placeholder='Descrição da Atividade' style='border: 1px solid #ccc;border-radius: 5px;width:320px; height:100%;'/>";
    formCriacao.innerHTML += "<input type='text' id='href' placeholder='Link da descrição da atividade no [GitHub] ou outro' style='border: 1px solid #ccc;border-radius: 5px;width:470px; height:100%;' />";
    formCriacao.innerHTML += "<input type='date' id='date' placeholder='Data de Entrega' style='border: 1px solid #ccc;border-radius: 5px;width:150px; height:100%;' />";
    let alunos = document.createElement("select");
    alunos.setAttribute("multiple","true");
    alunos.setAttribute("id","alunos");
    alunos.setAttribute("style","border: 1px solid #ccc;border-radius: 5px;width:200px; height:100%;");
    fetch(urlBase + 'route.user.php')
      .then((resp) => {
        if (!resp.ok)
          throw new Error("Erro ao executar requisição: " + resp.status);
        return resp.json();
      })
      .then((data) => {
        data.forEach((val) => {
            if(val.type === 'aluno'){
                let option = document.createElement("option");
                option.setAttribute("value",val.email);
                option.innerHTML = val.email;
                alunos.appendChild(option);
            }
        })
      })
      .catch((err) => {
        console.error(err.message);
      });
    let btCriar = document.createElement("img");
    btCriar.setAttribute("src","../assets/menus/send.png");
    btCriar.setAttribute("style","margin-left:20px;cursor:pointer;height:50px;align-self:center;");
    btCriar.setAttribute("onclick","createActivity()");
    btCriar.setAttribute("title","Criar Atividade");
    formCriacao.appendChild(alunos);
    formCriacao.appendChild(btCriar);
    corpo.appendChild(formCriacao);
    
    fetch(urlBase + 'route.activity.php')
      .then((resp) => {
        if (!resp.ok)
          throw new Error("Erro ao executar requisição: " + resp.status);
        return resp.json();
      })
      .then((data) => {
        data.forEach((val) => {
          let faixa = document.createElement("div");
          let cabecalho = document.createElement("tr");
          let linhaImpar = document.createElement("tr");
          let linhaPar = document.createElement("tr");
          let bts = document.createElement("td");
          let id = document.createElement("td");
          let email = document.createElement("td");
          let label = document.createElement("td");
          let href = document.createElement("td");
          let grade = document.createElement("td");
          let result = document.createElement("td");
          let dat = document.createElement("td");
          cabecalho.innerHTML = "<td align='center'>Detalhes da Atividade:<a href='"+val.href+"' target='blank'><img src='../assets/menus/send.png' width='30px'></a></td>";
          cabecalho.innerHTML += "<td>Id, Descrição da solução e/ou Link<br />[GitHub][Google Drive][Snag.gy]</td>";
          cabecalho.innerHTML += "<td>Endereço do link da Atividade:</td>";
          cabecalho.innerHTML += "<td>E-mail e Data da Entrega</td>";
          cabecalho.innerHTML += "<td>Nota</td>";
          cabecalho.innerHTML += "<td>.</td>";
          faixa.setAttribute("class", "faixaAtvs");
          if(val.result != null){
              if(val.grade != null){
                  faixa.setAttribute("style", "background: #bca;");
              }else{
                  faixa.setAttribute("style", "background: #fee;");
              }
          }else{
              faixa.setAttribute("style", "background: #ffe;");
          }
          bts.setAttribute("rowspan", "2");
          bts.setAttribute("style", "display:wrap;");
          bts.setAttribute("id", "bts" + val.id);
          bts.innerHTML += "<img class='botao' id='btEdit" + val.id + "' onclick='editActivity(" + val.id + ")' src='../assets/menus/editar.png' title='Editar'/>";
          bts.innerHTML += "<img class='botao' id='btDel" + val.id + "' onclick='delActivity(" + val.id + ")' src='../assets/menus/excluir.png' title='Excluir'/>";
          id.innerHTML = val.id;
          id.setAttribute("id", "id" + val.id);
          id.setAttribute("style", "border: 1px solid #ccc;border-radius: 5px;height:50px;");
          email.innerHTML = val.email;
          email.setAttribute("id", "email" + val.id);
          email.setAttribute("style", "border: 1px solid #ccc;border-radius: 5px;height:50px;max-width:30ch;overflow: hidden;");
          label.innerHTML = val.label;
          label.setAttribute("id", "label" + val.id);
          label.setAttribute("rowspan","2");
          label.setAttribute("style", "border: 1px solid #ccc;border-radius:5px;height:100px;max-width:15ch;overflow: hidden;font-weight: bold;");
          href.setAttribute("id", "href" + val.id);
          href.setAttribute("style", "border: 1px solid #ccc;border-radius:5px;height:100px;max-width:50ch;overflow: hidden;");
          href.innerHTML = val.href;
          href.setAttribute("rowspan", "2");
          result.setAttribute("id", "result" + val.id);
          result.setAttribute("style", "border: 1px solid #ccc;border-radius: 5px;height:50px;max-width:30ch;overflow: hidden;color:red;");
          result.innerHTML = val.result;
          dat.setAttribute("id", "date" + val.id);
          dat.setAttribute("style", "border: 1px solid #ccc;border-radius: 5px;height:50px;");
          dat.innerHTML = val.date;
          grade.setAttribute("id", "grade" + val.id);
          grade.setAttribute("rowspan","2");
          grade.setAttribute("style", "border: 1px solid #ccc;border-radius: 5px;height:100px;color:red;");
          grade.innerHTML = val.grade;
          linhaImpar.appendChild(label);
          linhaImpar.appendChild(id);
          linhaImpar.appendChild(href);
          linhaImpar.appendChild(email);
          linhaImpar.appendChild(grade);
          linhaImpar.appendChild(bts);
          linhaPar.appendChild(result);
          linhaPar.appendChild(dat);
          faixa.appendChild(cabecalho);
          faixa.appendChild(linhaImpar);
          faixa.appendChild(linhaPar);
          corpo.appendChild(faixa);
        })
      })
      .catch((err) => {
        console.error(err.message);
      });
  } else if(window.localStorage.getItem("type") === 'aluno'){
          fetch(urlBase + 'route.activity.php?email='+window.localStorage.getItem("email"))
      .then((resp) => {
        if (!resp.ok)
          throw new Error("Erro ao executar requisição: " + resp.status);
        return resp.json();
      })
      .then((data) => {
        data.forEach((val) => {
          let faixa = document.createElement("div");
          let cabecalho = document.createElement("tr");
          let linhaImpar = document.createElement("tr");
          let bts = document.createElement("td");
          let email = document.createElement("td");
          let label = document.createElement("td");
          let grade = document.createElement("td");
          let result = document.createElement("td");
          let dat = document.createElement("td");
          cabecalho.innerHTML = "<td align='center'>(Acesse os detalhes da Atividade <br/> clicando aqui:<a href='"+val.href+"' target='blank'><img src='../assets/menus/send.png' width='30px'></a>)</td>";
          cabecalho.innerHTML += "<td>(Ao conluir preencha a solução e/ou cole o Link<br />[GitHub][Google Drive][Snag.gy])</td>";
          cabecalho.innerHTML += "<td>(Data da Entrega)</td>";
          cabecalho.innerHTML += "<td>(Nota)</td>";
          cabecalho.innerHTML += "<td>.</td>";
          faixa.setAttribute("class", "faixaAtvs");
          faixa.setAttribute("style", "background-image: url('../assets/back2.png'); background-size: 100%");
          bts.setAttribute("rowspan", "2");
          bts.setAttribute("style", "display:wrap;");
          bts.setAttribute("id", "bts" + val.id);
          bts.innerHTML += "<img class='botao' id='btEdit" + val.id + "' onclick='editSolution(" + val.id + ")' src='../assets/menus/editar.png' title='Editar'/>";
          label.innerHTML = val.label;
          label.setAttribute("id", "label" + val.id);
          label.setAttribute("rowspan","2");
          label.setAttribute("style", "border: 1px solid #ccc;border-radius:5px;height:100px;max-width:15ch;overflow: hidden;font-weight: bold;");
          result.setAttribute("id", "result" + val.id);
          result.setAttribute("style", "border: 1px solid #ccc;border-radius: 5px;height:50px;max-width:60ch;overflow: hidden;color:red;");
          result.innerHTML = val.result;
          dat.setAttribute("id", "date" + val.id);
          dat.setAttribute("style", "border: 1px solid #ccc;border-radius: 5px;height:50px;");
          dat.innerHTML = val.date;
          grade.setAttribute("id", "grade" + val.id);
          grade.setAttribute("rowspan","2");
          grade.setAttribute("style", "border: 1px solid #ccc;border-radius: 5px;height:100px;color:red;");
          grade.innerHTML = val.grade;
          linhaImpar.appendChild(label);
          linhaImpar.appendChild(result);
          linhaImpar.appendChild(dat);
          linhaImpar.appendChild(grade);
          linhaImpar.appendChild(bts);
          faixa.appendChild(cabecalho);
          faixa.appendChild(linhaImpar);
          corpo.appendChild(faixa);
        })
      })
      .catch((err) => {
        console.error(err.message);
      });
  } else {
    alert("Faça login para acessar este recurso.");
  }
}

function createActivity() {
  let emails = document.getElementById("alunos");
  let label = document.getElementById("label").value;
  let href = document.getElementById("href").value;
  let dat = document.getElementById("date").value;
  if (label != '' && href != '' && dat != '') {
      if(emails.value){
          for (i = 0; i < emails.length; i++) {
              if (emails[i].selected == true) {
                createSimpleActivity(emails[i].value,label,href,dat);
              }
          }
      }else{
          alert("Escolha um ou mais alunos.");
      }
  }else{
    alert("Preencha todos os campos obrigatórios");
  }
  window.location.reload();
}

function createSimpleActivity(tmpMail,tmpLabel,tmpHref,tmpDate){
  const xhr2 = new XMLHttpRequest();
  xhr2.withCredentials = true;
  let data = new FormData();
  let resp;
    data.append("action", "create");
    data.append("email", tmpMail);
    data.append("label", tmpLabel);
    data.append("href", tmpHref);
    data.append("date", tmpDate);
    xhr2.addEventListener("readystatechange", function () {
        if (this.readyState === this.DONE) {
            resp = JSON.parse(this.responseText);
            if (resp.hasOwnProperty("err")) {
                alert(resp.err);
            } else {
                alert(resp.msg+"email "+tmpMail);
            }
        }
    });
    xhr2.open("POST", urlBase + 'route.activity.php');
    xhr2.send(data);
}


function editActivity(id){
  let label = document.getElementById("label" + id);
  let href = document.getElementById("href" + id);
  let result = document.getElementById("result" + id);
  let grade = document.getElementById("grade" + id);
  let dat = document.getElementById("date" + id);
  label.setAttribute("contenteditable", "true");
  href.setAttribute("contenteditable", "true");
  result.setAttribute("contenteditable", "true");
  grade.setAttribute("contenteditable", "true");
  dat.setAttribute("contenteditable", "true");
  label.focus();
  let btEdit = document.getElementById("btEdit" + id);
  btEdit.setAttribute("src","../assets/menus/send.png");
  btEdit.setAttribute("style","margin-left:40px;");
  btEdit.setAttribute("title","Enviar alteração");
  btEdit.setAttribute("onclick", `updateActivity(${id})`);
  document.getElementById("btDel" + id).remove();
}

function editSolution(id){
  let result = document.getElementById("result" + id);
  result.setAttribute("contenteditable", "true");
  result.focus();
  let btEdit = document.getElementById("btEdit" + id);
  btEdit.setAttribute("src","../assets/menus/send.png");
  btEdit.setAttribute("style","margin-left:40px;");
  btEdit.setAttribute("title","Enviar alteração");
  btEdit.setAttribute("onclick", `updateSolution(${id})`);
  document.getElementById("btDel" + id).remove();
}

function updateSolution(id){
  let data = new FormData();
  let result = document.getElementById("result"+id).innerHTML;
  if (result != ''){
    data.append("action", "update");
    data.append("id", id);
    data.append("result", result);
    xhr.addEventListener("readystatechange", function () {
      if (this.readyState === this.DONE) {
        let resp = JSON.parse(this.responseText);
        if (resp.hasOwnProperty("err")) {
          alert(resp.erro);
        } else {
          alert("Atividade concluída com sucesso.");
        }
        window.location.reload();
      }
    });
    xhr.open("POST", urlBase + 'route.activity.php');
    xhr.send(data);
  }else{
    alert("Preencha a solução da atividade.");
  }
}

function updateActivity(id){
  let data = new FormData();
  let email = document.getElementById("email"+id).innerHTML;
  let label = document.getElementById("label"+id).innerHTML;
  let href = document.getElementById("href"+id).innerHTML;
  let result = document.getElementById("result"+id).innerHTML;
  let grade = document.getElementById("grade"+id).innerHTML;
  let dat = document.getElementById("date"+id).innerHTML;
  if (label != '' && href != '') { 
    data.append("action", "update");
    data.append("id", id);
    data.append("email", email);
    data.append("label", label);
    data.append("href", href);
    data.append("result", result);
    data.append("grade", grade);
    data.append("date", dat);
    xhr.addEventListener("readystatechange", function () {
      if (this.readyState === this.DONE) {
        let resp = JSON.parse(this.responseText);
        if (resp.hasOwnProperty("err")) {
          alert(resp.erro);
        } else {
          alert("Atividade alterada com sucesso.");
        }
        window.location.reload();
      }
    });
    xhr.open("POST", urlBase + 'route.activity.php');
    xhr.send(data);
  }else{
    alert("Preencha todos os campos obrigatórios");
  }
}

function delActivity(id) {
  let data = new FormData();
  data.append("action", "delete");
  data.append("id", id);
  if (window.confirm("Confirma Exclusão da atividade id = " + id + " ?")) {
    xhr.addEventListener("readystatechange", function () {
      if (this.readyState === this.DONE) {
        let resp = JSON.parse(this.responseText);
        if (resp.hasOwnProperty("err")) {
          alert(resp.erro);
        }
        window.location.reload();
      }
    });
    xhr.open("POST", urlBase + 'route.activity.php');
    xhr.send(data);
  }
}