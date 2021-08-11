var table = document.querySelector("#data");
//var table = <tbody id="data"></tbody>;

function cadastrar() {
    let cadastrado = false;

    let carro = document.querySelector("#carro");
    let ano = document.querySelector("#ano");
    let preco = document.querySelector("#preco");

               // 0     1     2     
    let data = [carro.value, ano.value, preco.value];

    let rows = document.querySelectorAll("tr");
    
    for(let i = 0; i<rows.length; i++) {
        let cols = rows[i].querySelectorAll("td")[0];
        if(cols !== undefined) {
            if(cols.innerHTML === carro) {
                alert("Carro já Cadastrado");
                cadastrado = true;
                break;
            }
        }
    }

    /*let cols = document.querySelectorAll("td");
    
    for(let i = 0; i<cols.length; i+=3) {
        if(cols[i].innerHTML === carro) {
            console.log("Cadastrado");
            break;
        }
    }*/

    if(!cadastrado) {        
        let row = document.createElement("tr");
        //let row = <tr></tr>

        //i == 0
        for(let i = 0; i < 3; i++) {
            let col = document.createElement("td");
            //let col = <td></td>;

            col.innerHTML = data[i];
            //let col = <td>Carro</td>;

            row.appendChild(col);
            //let row = <tr><td>Carro</td></tr>
        }

        //cria um button para executar a acao de exclusao
        let button = document.createElement("button");
        button.innerHTML = "Apagar";

        button.addEventListener("click", () => {
            apagarButton(button);
        });

        let colButton = document.createElement("td");
        colButton.appendChild(button);

        row.appendChild(colButton);

        table.appendChild(row);
        //table = <tbody id="data"><tr><td>Carro</td></tr></tbody>
    }

    carro.value = "";
    ano.value = "";
    preco.value = "";
}


/*function cadastrar() {
    let carro = document.querySelector("#carro").value;
    let ano = document.querySelector("#ano").value;
    let preco = document.querySelector("#preco").value;

    let row = document.createElement("tr");

    let colCarro = document.createElement("td");
    colCarro.innerHTML = carro;

    row.appendChild(colCarro);
    
    let colAno = document.createElement("td");
    colAno.innerHTML = ano;

    row.appendChild(colAno);
    
    let colPreco = document.createElement("td");
    colPreco.innerHTML = preco;

    row.appendChild(colPreco);

    table.appendChild(row);
}*/

//Apaga registro pelo input
function apagar() {
    let busca = document.querySelector("#busca");

    let rows = document.querySelectorAll("tr");
    
    for(let i = 0; i<rows.length; i++) {
        let cols = rows[i].querySelectorAll("td")[0];
        if(cols !== undefined) {
            if(cols.innerHTML === busca.value) {
                cols.parentNode.remove();
                break;
            }
        }
    }
}

//Apaga registro pelo button
function apagarButton(element) {
    console.log(element);
    element.parentNode.parentNode.remove();
}   