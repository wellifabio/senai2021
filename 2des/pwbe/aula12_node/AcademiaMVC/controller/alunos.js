const { con } = require('./dbconnect.js')
const model = require('../model/aluno.js')

const doGet = (req, res) => {
    let string
    if (req.params.id === undefined) {
        string = 'select * from alunos'
        con.query(string, (err, result) => {
            let array = []
            result.forEach(e => {
                array.push(model.aluno(e))
            })
            res.json(array)
        })

    } else {
        string = 'select * from alunos where id = ' + req.params.id
        con.query(string, (err, result) => {
            if (result != "") {
                res.json(model.aluno(result[0]))
            } else { 
                res.status(404).end()
            }
        })
    }
}

const doPost = (req, res) => {
    let nome = '\'' + req.body.nome + '\''
    let peso = req.body.peso
    let altura = req.body.altura
    let nascimento = '\'' + req.body.nascimento + '\''
    let string = `insert into alunos values (default,${nome},${peso},${altura},${nascimento})`
    con.query(string, (err, result) => {
        if (err == null) {
            req.body.id = result.insertId
            res.status(201).json(req.body).end()
        } else {
            res.status(400).json(err).end()
        }
    })
}

const doPut = (req, res) => {
    let id = req.body.id
    let nome = '\'' + req.body.nome + '\''
    let peso = req.body.peso
    let altura = req.body.altura
    let nascimento = '\'' + req.body.nascimento + '\''
    let string = `update alunos set nome = ${nome}, peso = ${peso}, altura = ${altura}, nascimento = ${nascimento} where id = ${id}`
    con.query(string, (err, result) => {
        if (result.affectedRows > 0) {
            res.status(200).json(model.aluno(req.body)).end()
        } else {
            res.status(404).json(result).end()
        }
    })
}

const doDelete = (req, res) => {
    let string = 'delete from alunos where id = ' + req.params.id
    con.query(string, (err, result) => {
        if (result.affectedRows > 0) {
            res.status(200).end()
        } else {
            res.status(404).end()
        }
    })
}

module.exports = {
    doGet, doPost, doDelete, doPut
}