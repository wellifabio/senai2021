//JSON (JavaScript Object Notation)
/*let data = 
[
    {
        "nome":"Fulano Da Silva Sauro",
        "idade":30,
        "doc":123456789,
        "cursos":["Ensino Medio", "Faculdade", "Pós"], 
        "residencia":{
            "bairro":"Jd Andrada",
            "rua":"Rua das Cores",
            "numero":55,
            "cep":1111111
        }
    },
    {
        "nome":"Beltrano dos Santos",
        "idade":25,
        "doc":987654321,
        "cursos":["Ensino Medio", "Faculdade"], 
        "residencia":{
            "bairro":"Jd das Ruas",
            "rua":"Rua das Avenidas",
            "numero":2,
            "cep":01010101
        }
    },
    {
        "nome":"Ciclano dos Trotes",
        "idade":25,
        "doc":1245783265,
        "cursos":["Ensino Medio", "Faculdade"], 
        "residencia":{
            "bairro":"Jd das Flores",
            "rua":"Rua do asfalto",
            "numero":3,
            "cep":222222222
        }
    }
];

data.forEach(item => {
    console.log(item.nome);
    item.cursos.forEach(curso => {
        console.log(curso);
    });
    console.log(item.residencia.cep);
});*/

var nome = document.querySelector("#nome");
var idade = document.querySelector("#idade");
var documento = document.querySelector("#documento");

function salvar() {
    let data = {
        "nome":nome.value,
        "idade":idade.value,
        "documento":documento.value,
    }

    console.log(data);

    //Envio data para o back
    //Segundo documentacao 
    //cod 35 Sucesso
    //cod 40 DB Offline
    //cod 47 Documento Invalido
    let result = {
        "cod":47
    }

    if(result.cod === 35) {
        alert("Cadastrado com Sucesso !");
    }else if(result.cod === 47) {
        alert("Documento invalido");
    }
}