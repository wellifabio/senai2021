const { con } = require('../dao/connectiondb.js')
const model = require('../models/servico.js')
var string;

const doGet = (req, res) => {
    //Recebendo o id_serviço através de parâmetro na URL
    string = 'select * from servicos where id_servico = ' + req.params.id
    con.query(string, (err, result) => {
        if (result != "") {
            res.json(model.servico(result[0]))
        } else {
            res.status(404).end()
        }
    })
}

const doGetAll = (req, res) => {
    string = 'select * from servicos'
    con.query(string, (err, result) => {
        let vetor = []
        let total_geral = 0
        result.forEach(e => {
            vetor.push(model.servico(e))
            total_geral += model.servico(e).total
        })
        vetor.push({ "total_geral ": total_geral.toFixed(2) })
        res.json(vetor)
    })
}

const doPost = (req, res) => {
    let prestador = '\'' + req.body.prestador + '\''
    let valorHora = req.body.valor_hora
    let horasTrab = req.body.horas_trabalhadas
    // com if ternario: Se receber o não receber o id utiliza auto_increment do BD
    string = `insert into servicos value (${req.body.id_servico === undefined ? 'default' : req.body.id_servico},${prestador},${valorHora},${horasTrab})`
    /*
    // com if comum: Se receber o não receber o id utiliza auto_increment do BD
    if (req.body.id_servico === undefined) {
        string = `insert into servicos value (default,${prestador},${valorHora},${horasTrab})`
    } else {
        string = `insert into servicos value (${req.body.id_servico},${prestador},${valorHora},${horasTrab})`
    }
    */
    con.query(string, (err, result) => {
        if (err == null) {
            req.body.id_servico = result.insertId
            res.status(201).json(model.servico(req.body)).end()
        } else {
            res.status(400).json(err.sqlMessage).end()
        }
    })
}

const doPut = (req, res) => {
    let id = req.body.id_servico
    let prestador = '\'' + req.body.prestador + '\''
    let valorHora = req.body.valor_hora
    let horasTrab = req.body.horas_trabalhadas
    string = `update servicos set prestador = ${prestador}, valor_hora = ${valorHora}, horas_trabalhadas = ${horasTrab} where id_servico = ${id}`
    con.query(string, (err, result) => {
        if (result.affectedRows > 0) {
            res.status(200).json(model.servico(req.body)).end()
        } else {
            res.status(404).json(result).end()
        }
    })
}

const doDelete = (req, res) => {
    //Recebendo o id_serviço através da query
    string = 'delete from servicos where id_servico = ' + req.query.id_servico
    con.query(string, (err, result) => {
        if (result.affectedRows > 0) {
            res.status(200).end()
        } else {
            res.status(404).end()
        }
    })
}


module.exports = {
    doGet, doGetAll, doPost, doPut, doDelete
}