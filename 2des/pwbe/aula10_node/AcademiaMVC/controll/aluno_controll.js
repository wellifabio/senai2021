//Equivalente a Classe DAO em Java MVC
const { con } = require("./mysql_connect.js")
const model = require('../model/aluno_model.js')

// READ 4 Funções
//Listar todos da maneira que está no BD
const get_alunos = (req, res) => {
    let string = 'select * from alunos order by id desc'
    con.query(string, (err, result) => {
        res.json(result)
    })
}
//Read por ID da maneira que está no BD
const get_id = (req, res) => {
    let string = 'select * from alunos where id = ' + req.params.id
    con.query(string, (err, result) => {
        if(result == ''){
            res.status(404).end()
        }else{
            res.json(result)
        }
    })
}

//Listar todos utilizando o Model (MVC)
const get_alunos_imc = (req, res) => {
    let string = 'select * from alunos order by id desc'
    con.query(string, (err, result) => {
        let array = []
        result.forEach(e => {
            array.push(model.aluno_model(e))
        })
        res.json(array)
    })
}

//Read por ID utilizando o Model (MVC)
const get_id_imc = (req, res) => {
    let string = 'select * from alunos where id = ' + req.params.id
    con.query(string, (err, result) => {
        if(result == ''){
            res.status(404).end()
        }else{
            res.json(model.aluno_model(result[0]))
        }
    })
}

//CREATE
const post_aluno = (req, res) => {
    let body = req.body
    let string = 'insert into alunos(nome, peso, altura, nascimento) values (\'' + body.nome + '\',' + body.peso + ',' + body.altura + ',\'' + body.nascimento + '\')'
    con.query(string, (err, result)=>{
        if(err != null){
            res.status(400).end()
        }else{
            res.status(201).end()
        }
    })
}

//DELETE
const delete_aluno = (req, res) => {
    let string = 'delete from alunos where id = ' + req.params.id
    con.query(string, (err, result)=>{
        if(result.affectedRows == 0 ){
            res.status(404).end()
        }else{
            res.status(200).end()
        }
    })
}

//UPDATE
const put_aluno = (req, res) => {

    let id = req.body.id
    let nome = '\'' + req.body.nome + '\''
    let peso = req.body.peso
    let altura = req.body.altura
    let nascimento = '\'' + req.body.nascimento + '\''

    let string = `update alunos set nome = ${nome}, peso = ${peso}, altura = ${altura}, nascimento = ${nascimento} where id = ${id}`
    con.query(string, (err, result)=>{
        if(result.affectedRows == 0 ){
            res.status(404).end()
        }else{
            con.query('select * from alunos where id = ' + id,(err, result)=>{
                res.json(model.aluno_model(result[0]))
            })
        }
    })
}

module.exports = {
    get_alunos,
    get_alunos_imc,
    get_id,
    get_id_imc,
    post_aluno,
    delete_aluno,
    put_aluno
}