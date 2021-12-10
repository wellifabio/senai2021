/*let arr = document.querySelectorAll("p");

arr.forEach(item => {
    console.log(item.innerHTML);
})

texto.innerHTML = "Olá, Mundo !";*/

/*var valor1 = document.querySelector("#v1");
var valor2 = document.querySelector("#v2");
var result = document.querySelector("h2");

function somar() {
    let v1 = valor1.value;
    let v2 = valor2.value;

    let res = Number(v1) + Number(v2);

    result.innerHTML = res;

    if(res <= 5) {
        result.style.color = "red";
    }else {
        result.style.color = "blue";
    }
}*/

let div = document.querySelector("div");
let divGerada = document.createElement("div");
let body = document.querySelector("body");

console.log(div.parentNode);

body.appendChild(divGerada);

/*div.classList.add("div1");
div.classList.add("backColor");
div.classList.remove("backColor");*/
div.className = "div1";
div.addEventListener("click", () => {
    div.classList.toggle("backColor");
})

//div.remove();

divGerada.className = "div2";

var clone = document.querySelector("#clone");

var temp = clone.cloneNode(true);

temp.querySelector("h3").innerHTML = "FUI CLONADO";
temp.querySelector("input").value = "Nome da Pessoa";

body.appendChild(temp);

var data = new Date();

console.log(data);
console.log(data.getDate());
console.log(data.getMonth()+1);
console.log(data.getFullYear());
console.log(data.getHours());
console.log(data.getMinutes());

console.log(data.getDate() + "/" + (data.getMonth() + 1) + "/" + data.getFullYear());