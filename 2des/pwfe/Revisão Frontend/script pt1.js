/*
var - global
let - local
const - seu valor não pode ser alterado
*/

/*var a = 5;
var b = 10;

var soma = a ** b;

alert(soma);*/

/*
!== Estritamente Diferente
=== Estritamente iguais
!= Diferente
== Igual
>
<
>=
<=

var a = "10";
var b = "15";

alert(a !== b);*/

/*
&& - AND - E
|| - OR - OU
! - NOT - NAO
*/

/*const media = 5;
var backend = 6;
var frontend = 3;

console.log(backend >= media);
console.log(frontend >= media);
console.log(backend >= media && frontend >= media);

if(backend >= media && frontend >= media) {
    console.log("aprovado");
}else {
    console.log("reprovado");
}*/

/*var nota1 = 6;
var nota2 = 7;
var nota3 = 2;

var media = (nota1 + nota2 + nota3) / 3;

if(media > 5) {
    console.log("Aprovado", media);
}else {
    console.log("Reprovado", media);
}*/

var notas = [10, 6, 2, 5, 7];
var nota = 0;

/*for(let i = 0; i < notas.length; i++) {
    nota = nota + notas[i];
    //nota += notas[i];
}

var media = nota / notas.length;

console.log(media);*/

/*notas.forEach(item => {
    nota += item;
});

var media = nota / notas.length;

console.log(media);*/

/*var pos1 = 0;
var pos2 = 0;

notas.map((item, index) => {
    if(item == 10) {
        pos1 = index;
    }
    if(item == 5) {
        pos2 = index;
    }
})

console.log(notas);

var temp = notas[pos1];
notas[pos1] = notas[pos2];
notas[pos2] = temp;

console.log(notas);*/

/*var notas = [];
var nota = 0;

while(nota > -1) {
    nota = Number(prompt("Informe uma nota : "));
    if(nota>-1) notas.push(nota);
}

do {
    nota = Number(prompt("Informe uma nota : "));
    if(nota>-1) notas.push(nota);
}while(nota>-1);

console.log(notas);*/

