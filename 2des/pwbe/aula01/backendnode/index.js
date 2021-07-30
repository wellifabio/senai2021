const http = require('http');

const server = http.createServer((req,res)=>{
    res.statusCode=200
    res.end('Backend respondendo')
});

server.listen(8081,function(){
    console.log("Sucesso");
});

/*
    Deve instalar o node via download normal LTS
    npm gerenciador de pacotes (Serve para instalar outras extenções via linha de comando)    
*/