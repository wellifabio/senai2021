var table = document.querySelector("#data");
//var table = <tbody id="data"></tbody>;

//Documento
var carro = document.querySelector("#carro");
//Nome
var ano = document.querySelector("#ano");
//Turma
var preco = document.querySelector("#preco");

var btbombril = document.querySelector("#bombril");

function cadastrar() {
    /*Se o texto do botão for igual a cadastrar, executa a rotina que adiciona
    um linha a tabela*/
    if(btbombril.innerHTML === "Cadastrar") {
       
        let cadastrado = false;
                // 0     1     2     
        let data = [carro.value, ano.value, preco.value];

        let rows = document.querySelectorAll("tr");
        
        for(let i = 0; i<rows.length; i++) {
            let cols = rows[i].querySelectorAll("td")[0];
            if(cols !== undefined) {
                if(cols.innerHTML === carro.value) {
                    alert("Aluno já Cadastrado");
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

            let buttonedit = document.createElement("button");
            buttonedit.innerHTML = "Editar";

            buttonedit.addEventListener("click", () => {
                alterarCadastro(buttonedit);
            });

            let colEdit = document.createElement("td");
            colEdit.appendChild(buttonedit);

            row.appendChild(colEdit);

            table.appendChild(row);
            //table = <tbody id="data"><tr><td>Carro</td></tr></tbody>
        }

        carro.value = "";
        ano.value = "";
        preco.value = ""; 

    /*Caso o texto do botao seja igual a salvar alteração, executa a rotina
    de edição dos valores da tabela*/
    }else if (btbombril.innerHTML === "Salvar Alteração") {
        //Cria um vetor com os valores dos inputs, documento, nome e turma
        let data = [carro.value, ano.value, preco.value];

        //Localiza a linha com o id edit e retorna as suas colunas
        let cols = document.querySelector("#edit").querySelectorAll("td");

        //Atribui os valores dos inputs nas colunas da linha em edição
        cols[0].innerHTML = data[0];
        cols[1].innerHTML = data[1];
        cols[2].innerHTML = data[2];

        //Retorna ao texto original o botao
        btbombril.innerHTML = "Cadastrar";

        //Removo o id da linha, indicando o fim de uma edição
        document.querySelector("#edit").id = "";
        
        //Zera os valores dos inputs
        carro.value = "";
        ano.value = "";
        preco.value = ""; 
    }  
}

//Função para alterar dados da tabela
function alterarCadastro(element) {
    //Busca por id edit
    let edit = document.querySelector("#edit");
    
    //Caso não encontre permite efetuar a alteração dos dados
    if(edit === null) {
        //Localiza a linha baseado no botão que chamou a função
        let linha = element.parentNode.parentNode;
    
        //Atribui o id edit para linha em edição
        linha.id = "edit";
    
        //Busca as colunas da linha
        let cols = linha.querySelectorAll("td");
    
        //Separa em variaveis os dados da tabela
        let doc = cols[0].innerHTML;
        let nome = cols[1].innerHTML;
        let turma = cols[2].innerHTML;
    
        //Atribiu os dados da linha selecionada aos inputs
        carro.value = doc;
        ano.value = nome;
        preco.value = turma;
        
        //Altera o texto do botão
        btbombril.innerHTML = "Salvar Alteração";
    /*Caso localize o id edit no codigo
    informa ao usuário que já existe uma edição em andamento*/
    }else {
        alert("Edição em andamento");
    }
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
    element.parentNode.parentNode.remove();
}
