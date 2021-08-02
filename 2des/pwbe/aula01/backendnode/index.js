const http = require('http'); //Importando a biblioteca que trata requisições HTTP
const url = require('url'); //Importando a biblioteca para tratar URLs

const server = http.createServer((req,res)=>{
    res.statusCode=200 //Retornando o código HTTP de sucesso
    let dados = req.url //Pegando os dados da URL método GET
    if(dados != "/"){ //Se chegarem dados
        let json = url.parse(dados,true).query //Transforma a URL em JSON
        let texto = json.entrada //Pega somente os dados enviados pelo parâmetro 'entrada'
        if(texto != null) //Se veio o parâmetro 'entrada' na URL
            res.end("Opa chegou o nome "+texto+" com "+texto.length+" caracteres")
    }else{
        res.end('Aguardando dados') //Se não veio nenhum parâmetro na URL
    }
});

server.listen(8081,()=>{ //Arrow function que mostra a mensagem de 'sucesso' ao ouvir requisições HTTP
    console.log("Sucesso");
});

/*
    Deve instalar o "node" via download normal versão LTS
    npm gerenciador de pacotes (Serve para instalar outras extenções via linha de comando)    
*/