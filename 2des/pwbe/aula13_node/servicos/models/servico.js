const servico = (sqlJson) => {
    let json = {
        "idServico": sqlJson.id_servico,
        "prestador": sqlJson.prestador,
        "valorHora": sqlJson.valor_hora,
        "horasTrabalhadas": sqlJson.horas_trabalhadas,
        "subTotal": 0,
        "iss": 0,
        "total": 0
    }

    json.subTotal = (sqlJson.valor_hora * sqlJson.horas_trabalhadas).toFixed(2)
    json.iss = (json.subTotal * 2 / 100).toFixed(2)
    json.total = json.subTotal + json.iss

    return json
}

module.exports = { 
    servico 
}