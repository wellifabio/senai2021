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

body.appendChild(divGerada);

/*div.classList.add("div1");
div.classList.add("backColor");
div.classList.remove("backColor");*/
div.className = "div1";
div.addEventListener("click", () => {
    div.classList.toggle("backColor");
})

div.remove();

divGerada.className = "div2";
