const aluno_model = (id, nome, peso, altura, nascimento) => {
    let data = (nascimento + "").split('T')
    let json = {
        "id": id,
        "nome": nome,
        "peso": peso,
        "altura": altura,
        "nascimento": data[0],
        "imc": (peso / (altura * altura)).toFixed(2),
    }
    let imc = peso / (altura ** 2)
    if (imc < 18.5) {
        json.status = 'Só o chassi do grilo'
    } else if (imc < 25) {
        json.status = 'Ta baum'
    } else if (imc < 30) {
        json.status = 'Fofinho'
    } else {
        json.status = 'Procure um médico'
    }
    return json;
}

module.exports = {
    aluno_model
}