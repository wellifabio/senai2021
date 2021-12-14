import React, { useState } from 'react'
import { View, Text, TextInput, TouchableOpacity } from 'react-native'
import style from './style.js'

export default function Home({ navigation }) {

    const [nome, setNome] = useState('')
    const [peso, setPeso] = useState('')
    const [altura, setAltura] = useState('')
    const [nascimento, setNascimento] = useState('')

    const [aluno, setAluno] = useState('')
    const [erro, setErro] = useState('Preencha todos os campos')

    const enviar = () => {
        setAluno(
            {
                "nome":nome,
                "peso":peso,
                "altura":altura,
                "nascimento":nascimento
            }
        )
        console.log(aluno)
    }

    return (
        <View style={style.pag}>
            <TextInput style={style.input} placeholder='Nome completo' value={nome} onChange={(e) => { setNome(e.target.value) }} />
            <TextInput style={style.input} placeholder='Peso ex: 72.5' value={peso} onChange={(e) => { setPeso(e.target.value) }}/>
            <TextInput style={style.input} placeholder='Altura ex: 1.63' value={altura} onChange={(e) => { setAltura(e.target.value) }}/>
            <TextInput style={style.input} placeholder='Nascimento Ano-Mês-Dia' value={nascimento} onChange={(e) => { setNascimento(e.target.value) }}/>
            <TouchableOpacity style={style.botao} onPress={enviar}>
                <Text>Enviar dados</Text>
            </TouchableOpacity>
            <Text style={style.input}>{erro}</Text>
        </View>
    )
}