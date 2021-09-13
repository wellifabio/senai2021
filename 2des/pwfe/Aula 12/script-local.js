//guardar uma informação
localStorage.setItem("name", "Fulano da Silva");

//recuperar uma informação
let nome = localStorage.getItem("name");

let data = {
    id: 53,
    nome: "Beltrano Perdido"
};

//De obj JSON para String
//console.log(JSON.stringify(data));

//De String para obj JSON
//console.log(JSON.parse(`{"nome":"ciclano", "idade":18}`));

localStorage.setItem("info", JSON.stringify(data));

let dataUser = JSON.parse(localStorage.getItem("info"));

//console.log(dataUser);

//Zera as informações do localStorage
localStorage.clear();

//Remove um item especifico
localStorage.removeItem("info");

console.log(localStorage.getItem("teste"));

if(localStorage.getItem("data") === null) {
    //Não autorizado
}