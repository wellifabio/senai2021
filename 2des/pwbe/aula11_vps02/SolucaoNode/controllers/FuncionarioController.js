//Equivalente a Classe DAO em Java MVC
const { con } = require("./ConnectionDB.js")
const model = require('../models/FuncionarioModel.js')

// READ All
const getFuncionarios = (req, res) => {
    let string = 'select * from funcionarios'
    con.query(string, (err, result) => {
        let array = []
        result.forEach(e => {
            array.push(model.funcionarioModel(e))
        })
        res.json(array)
    })
}

// READ por Matricula
const getFuncionarioMatricula = (req, res) => {
    let string = 'select * from funcionarios where matricula = ' + req.params.matricula
    con.query(string, (err, result) => {
        if(result != ""){
            res.json(model.funcionarioModel(result[0]))
        }else{
            res.status(404).end()
        }
        
    })
}

//CREATE
const postFuncionario = (req, res) => {

    let matricula = req.body.matricula
    let nome_completo = '\'' + req.body.nome_completo + '\''
    let data_desligamento = '\'' + req.body.data_desligamento + '\''
    let ultimo_salario = req.body.ultimo_salario

    let string = `insert into funcionarios(matricula, nome_completo, data_desligamento, ultimo_salario) values (${matricula},${nome_completo},${data_desligamento},${ultimo_salario})`
    con.query(string, (err, result)=>{
        if(err != null){
            res.status(400).end()
        }else{
            res.status(201).end()
        }
    })
}

//UPDATE
const putFuncionario = (req, res) => {

    let matricula = req.body.matricula
    let nome_completo = '\'' + req.body.nome_completo + '\''
    let data_desligamento = '\'' + req.body.data_desligamento + '\''
    let ultimo_salario = req.body.ultimo_salario

    let string = `update funcionarios set nome_completo = ${nome_completo}, data_desligamento = ${data_desligamento}, ultimo_salario = ${ultimo_salario} where matricula = ${matricula}`
    con.query(string, (err, result)=>{
        if(result.affectedRows == 0 ){
            res.status(404).end()
        }else{
            con.query('select * from funcionarios where matricula = ' + matricula,(err, result)=>{
                res.json(model.funcionarioModel(result[0]))
            })
        }
    })
}

//DELETE
const deleteFuncionario = (req, res) => {
    let string = 'delete from funcionarios where matricula = ' + req.params.matricula
    con.query(string, (err, result)=>{
        if(result.affectedRows == 0 ){
            res.status(404).end()
        }else{
            res.status(200).end()
        }
    })
}

module.exports = {
    getFuncionarios,
    getFuncionarioMatricula,
    postFuncionario,
    putFuncionario,
    deleteFuncionario
}