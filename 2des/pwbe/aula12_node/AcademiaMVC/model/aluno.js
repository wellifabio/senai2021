const aluno = (objeto) => {
    let data = (objeto.nascimento + "").split('T')
    
    let json = {
        "id": objeto.id,
        "nome": objeto.nome,
        "peso": objeto.peso,
        "altura": objeto.altura,
        "nascimento": data[0],
        "imc": (objeto.peso / (objeto.altura * objeto.altura)).toFixed(2)
    }

    let imc = objeto.peso / (objeto.altura ** 2)
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
    aluno
}