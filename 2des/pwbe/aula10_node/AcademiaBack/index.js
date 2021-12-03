const express = require('express');
const app = express();
const cors = require('cors');
const mysql = require('mysql');
const con = mysql.createConnection({
    database:'academia',
    host:'localhost',
    user: 'root'
});

//iniciador de dependências
app.use(cors());
app.use(express.json());

app.get('/api/',(req, res)=>{
    let string = 'select * from alunos'
    con.query(string,(err, result)=>{
        if(err) throw err;
        res.json(result);
    })
});

app.get('/id/:id',(req, res)=>{
    let string = 'select * from alunos where id = '+req.params.id;
    con.query(string,(err, result)=>{
    if(err) throw err;
    res.json(result);
    });
});

app.listen(3000,()=>{
    console.log('Rodando na porta 3000')
});