//Adiciona um valor ao localstorage
localStorage.setItem("id", 35);

//Captura um valor do localStorage
let id = localStorage.getItem("id");

//Apaga um valor especifico do localStorage
localStorage.removeItem("id");

//Limpa todos os valores do localstorage
localStorage.clear();

let data = '{"nome":"Fulano","telefones":["199151515","1915151"]}';

console.log(data);

console.log(JSON.parse(data));

let obj = {
    id:15,
    nome:"Ciclano"
};

console.log(obj);

console.log(JSON.stringify(obj));