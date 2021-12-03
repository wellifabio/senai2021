const { con } = require('./dbconnect.js')
const model = require('../models/funcionario.js')

const doGet = (req, res) => {
    let string
    if (req.params.matricula === undefined) {
        string = 'select * from funcionarios'
        con.query(string, (err, result) => {
            let array = []
            result.forEach(e => {
                array.push(model.Funcionario(e))
            })
            res.json(array)
        })
    } else {
        let matricula = req.params.matricula
        string = `select * from funcionarios where matricula = ${matricula}`
        con.query(string, (err, result) => {
            if (result != "") {
                res.json(model.Funcionario(result[0])).end()
            } else {
                res.status(404).end()
            }

        })
    }
}

const doPost = (req, res) => {
    let string
    let nome = '\'' + req.body.nome_completo + '\''
    let salario = req.body.ultimo_salario
    let data_desligamento = '\'' + req.body.data_desligamento + '\''
    if (req.body.matricula === undefined)
        string = `insert into funcionarios values (default,${nome},${data_desligamento},${salario})`
    else
        string = `insert into funcionarios values (${req.body.matricula},${nome},${data_desligamento},${salario})`
    con.query(string, (err, result) => {
        if (err == null) {
            req.body.matricula = result.insertId
            res.status(201).json(req.body).end()
        } else {
            res.status(400).json(err.sqlMessage).end()
        }
    })
}

const doPut = (req, res) => {
    let matricula = req.body.matricula
    let nome_completo = '\'' + req.body.nome_completo + '\''
    let ultimo_salario = req.body.ultimo_salario
    let data_desligamento = '\'' + req.body.data_desligamento + '\''
    let string = `update funcionarios set nome_completo = ${nome_completo}, data_desligamento = ${data_desligamento}, ultimo_salario = ${ultimo_salario} where matricula = ${matricula}`
    con.query(string, (err, result) => {
        if (result.affectedRows > 0) {
            res.status(200).json(req.body).end()
        } else {
            res.status(404).json(result).end()
        }
    })
}

const doDelete = (req, res) => {
    let string = 'delete from funcionarios where matricula = ' + req.params.matricula
    con.query(string, (err, result) => {
        if (result.affectedRows > 0) {
            res.status(200).end()
        } else {
            res.status(404).end()
        }
    })
}

module.exports = {
    doGet, doPost, doPut, doDelete
}