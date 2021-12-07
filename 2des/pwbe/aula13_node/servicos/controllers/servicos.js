const { con } = require('./connectiondb.js')
const model = require('../models/servico.js')
var string;

const doGet = (req, res) => { 
    string = "select * from servicos"
    con.query(string,(err,result)=>{
        let vetor = []
        result.forEach( e => {
            vetor.push(model.servico(e))
        })
    })
}

module.exports = {
    doGet
}