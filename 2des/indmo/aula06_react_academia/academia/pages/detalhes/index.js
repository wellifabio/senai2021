import React, { useState, useEffect } from 'react'
import { View, Text, TextInput, TouchableOpacity } from 'react-native'
import style from './style.js'

export default function Detalhes({ navigation, route }) {

    const { id } = route.params
    const [aluno, setAluno] = useState({
        "id": id,
        "nome": "",
        "peso": 0,
        "altura": 0,
        "nascimento": "0000-00-00",
        "imc": 0,
        "status": ""
    })
    const [nome, setNome] = useState(aluno.nome)
    const [peso, setPeso] = useState(aluno.peso)
    const [altura, setAltura] = useState(aluno.altura)
    const [nascimento, setNascimento] = useState(aluno.nascimento)
    const [erro, setErro] = useState('Se desejar, pode alterar os dados')
    const uri = 'http://localhost:3000/academia/aluno/imc/' + id

    useEffect(() => {
        fetch(uri, {
            "method": "GET",
            "headers": {
                Accept: 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(resp => {
            return resp.json()
        }).then(data => {
            setAluno(data)
            if (nome == "") {
                setNome(aluno.nome)
                setPeso(aluno.peso)
                setAltura(aluno.altura)
                setNascimento(aluno.nascimento.split('T')[0])
            }
        })
    }, [aluno])

    const excluir = () => {
        let url = 'http://localhost:3000/academia/aluno/delete/' + id
        fetch(url, {
            method: "DELETE"
        })
            .then(resp => { return resp.status })
            .then(data => {
                if (data == 200) navigation.navigate("Listar Todos");
            })
    }

    const alterar = () => {
        if (nome !== '' && !isNaN(peso) && !isNaN(altura) && nascimento.length === 10) {
            let novoAluno = {
                "id": id,
                "nome": nome,
                "peso": peso * 1,
                "altura": altura * 1,
                "nascimento": nascimento
            }
            let url = "http://localhost:3000/academia/aluno/update";
            fetch(url, {
                method: "PUT",
                "headers": { "Content-Type": "application/json" },
                body: JSON.stringify(novoAluno)
            })
                .then(resp => { return resp.status })
                .then(data => { if (data == 200) navigation.navigate('Listar Todos') })
        } else {
            setErro('Preecha conforme exemplo, não deixe em branco!')
        }
    }

    return (
        <View style={style.pag}>
            <View style={style.out}><Text>Id:</Text><Text>{aluno.id}</Text></View>
            <View style={style.inp}><Text>Nome:</Text><TextInput value={nome} onChange={(e) => { setNome(e.target.value) }} /></View>
            <View style={style.inp}><Text>Peso:</Text><TextInput value={peso} onChange={(e) => { setPeso(e.target.value) }} /></View>
            <View style={style.inp}><Text>Altura:</Text><TextInput value={altura} onChange={(e) => { setAltura(e.target.value) }} /></View>
            <View style={style.inp}><Text>Nascimento:</Text><TextInput value={nascimento} onChange={(e) => { setNascimento(e.target.value) }} /></View>
            <View style={style.out}><Text>IMC:</Text><Text> {aluno.imc}</Text></View>
            <View style={style.out}><Text>Classificação:</Text><Text>{aluno.status}</Text></View>
            <View style={style.botoes}>
                <TouchableOpacity style={style.botao} onPress={alterar}>
                    <Text>Atualizar Dados</Text>
                </TouchableOpacity>
                <TouchableOpacity style={style.botao} onPress={excluir}>
                    <Text>Excluir Aluno</Text>
                </TouchableOpacity>
            </View>
            <Text style={style.inp}>{erro}</Text>
        </View>
    )
}