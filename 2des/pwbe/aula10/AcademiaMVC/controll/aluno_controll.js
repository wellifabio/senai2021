//Equivalente a Classe DAO em Java MVC
const {
    con
} = require("./mysql_controll.js")
const model = require('../model/aluno_model.js')

const get_alunos = (req, res) => {
    let string = 'select * from alunos'
    con.query(string, (err, result) => {
        res.json(result)
    })
}

const get_id = (req, res) => {
    let string = 'select * from alunos where id = ' + req.params.id
    con.query(string, (err, result) => {
        res.json(result)
    })
}

const get_alunos_imc = (req, res) => {
    let string = 'select * from alunos'
    con.query(string, (err, result) => {
        let array = []
        result.forEach(e => {
            array.push(model.aluno_model(e.id, e.nome, e.peso, e.altura, e.nascimento))
        })
        res.json(array)
    })
}

const get_imc_id = (req, res) => {
    let string = 'select * from alunos where id = ' + req.params.id
    con.query(string, (err, result) => {
        res.json(model.aluno_model(
            result[0].id,
            result[0].nome,
            result[0].peso,
            result[0].altura,
            result[0].nascimento
        ))
    })
}

module.exports = {
    get_alunos,
    get_alunos_imc,
    get_id,
    get_imc_id
}