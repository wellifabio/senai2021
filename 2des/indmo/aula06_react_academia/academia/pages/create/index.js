import React, { useState } from 'react'
import { View, Text, TextInput, TouchableOpacity } from 'react-native'
import style from './style.js'

export default function Create({ navigation }) {

    const [nome, setNome] = useState('')
    const [peso, setPeso] = useState('')
    const [altura, setAltura] = useState('')
    const [nascimento, setNascimento] = useState('')
    const [erro, setErro] = useState('Preencha todos os campos')
    var aluno = {}

    const enviar = () => {
        if (nome !== '' && !isNaN(peso) && !isNaN(altura) && nascimento.length === 10) {
            aluno = {
                "nome": nome,
                "peso": peso * 1,
                "altura": altura * 1,
                "nascimento": nascimento
            }

            let url = "http://localhost:3000/academia/aluno/create";
            fetch(url, {
                method: "POST",
                "headers": { "Content-Type": "application/json" },
                body: JSON.stringify(aluno)
            })
                .then(resp => { return resp.status })
                .then(data => { if (data == 201) navigation.navigate('Academia CRUD') })
        } else {
            setErro('Preecha conforme exemplo, não deixe em branco!')
        }
    }

    return (
        <View style={style.pag}>
            <TextInput style={style.input} placeholder='Nome completo' value={nome} onChange={(e) => { setNome(e.target.value) }} />
            <TextInput style={style.input} placeholder='Peso ex: 72.5' value={peso} onChange={(e) => { setPeso(e.target.value) }} />
            <TextInput style={style.input} placeholder='Altura ex: 1.63' value={altura} onChange={(e) => { setAltura(e.target.value) }} />
            <TextInput style={style.input} placeholder='Nascimento Ano-Mês-Dia' value={nascimento} onChange={(e) => { setNascimento(e.target.value) }} />
            <TouchableOpacity style={style.botao} onPress={enviar}>
                <Text>Enviar dados</Text>
            </TouchableOpacity>
            <Text style={style.input}>{erro}</Text>
        </View>
    )
}