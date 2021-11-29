const funcionarioModel = (objeto) => {
      
    let json = {
        "matricula": objeto.matricula,
        "nome_completo": objeto.nome_completo,
        "data_desligamento": objeto.data_desligamento+"".split('T')[0],
        "ultimo_salario": objeto.ultimo_salario,
    }

    if (objeto.ultimo_salario < 1890.90) {
        json.aliquota = (0).toFixed(2)*1
        json.irrf = (0).toFixed(2)*1
    } else if (objeto.ultimo_salario < 2940.85) {
        json.aliquota = (7.5 / 100).toFixed(2)*1
        json.irrf = (json.aliquota * objeto.ultimo_salario).toFixed(2)*1
    } else if (objeto.ultimo_salario < 3902.59) {
        json.aliquota = (15 / 100).toFixed(2)*1
        json.irrf = (json.aliquota * objeto.ultimo_salario).toFixed(2)*1
    } else if (objeto.ultimo_salario < 4853.13){
        json.aliquota = (22.5 / 100).toFixed(2)*1
        json.irrf = (json.aliquota * objeto.ultimo_salario).toFixed(2)*1
    }else{
        json.aliquota = (27.5 / 100).toFixed(2)*1
        json.irrf = (json.aliquota * objeto.ultimo_salario).toFixed(2)*1
    }
    return json;
}

module.exports = {
    funcionarioModel
}