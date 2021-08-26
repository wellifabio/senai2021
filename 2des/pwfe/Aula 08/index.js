var nome = document.querySelector("#nome");
var doc = document.querySelector("#doc");
var origem = document.querySelector("#origem");
var destino = document.querySelector("#destino");
var poltronas = document.querySelector(".poltronas");

var data = {
    "aeroportos":[
        "São Paulo Cumbica/GRU",
        "Brasília/BSB",
        "Congonhas/CGH",
        "Rio de Janeiro Santos Dumont/SDU",
        "Recife/REC",
        "Belo Horizonte Confins/CNF"
    ]
};

for(let i = 0; i < 120; i++) {
    let check = document.createElement("input");
    check.type = "checkbox";
    check.id = i;
    poltronas.appendChild(check);
}

data.aeroportos.forEach(item => {
    let op = document.createElement("option");
    //<option></option>

    op.innerHTML = item;
    //<option>São Paulo Cumbica/GRU</option>
    
    origem.appendChild(op.cloneNode(true));
    //<select id="origem">
    //  <option>São Paulo Cumbica/GRU</option>
    //</select>
    destino.appendChild(op);
});

function comprar() {
    let valorfinal = 0;
                //vip,executiva,economica
    let preco = [1200,800,400];
    let assentos = 0;

    let checks = document.querySelectorAll("input[type=checkbox]");
    let arr = [];

    //0 - 9 VIP
    //10 - 41 Executiva
    //42 > Economica 

    checks.forEach(check => {
        if(check.checked) {
            assentos++;
            //Adiciona valor ao array
            arr.push(check.id);
            let cod = Number(check.id);
            if(cod <= 9) {
                valorfinal += preco[0];
            }else if(cod <= 41) {
                valorfinal += preco[1];
            }else {
                valorfinal += preco[2];
            }
        }
    });

    let output = {
        "nome":nome.value,
        "document":doc.value,
        "origem":origem.value,
        "destino":destino.value,
        "assentos":arr,
        "valor":valorfinal
    };

    console.log(output);
}