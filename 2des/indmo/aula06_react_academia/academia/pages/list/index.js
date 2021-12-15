import React, { useState, useEffect } from 'react'
import { View, Text, Image, TouchableOpacity } from 'react-native'
import style from './style.js'
export default function Listar({ navigation }) {

    const [lista, setlista] = useState([
        {
            "id": 0,
            "nome": "Não foi possível carregar dados"
        }
    ])

    var [abaixo, setAbaixo] = useState(0)
    var [normal, setNormal] = useState(0)
    var [acima, setAcima] = useState(0)
    var [obeso, setObeso] = useState(0)

    const resumir = () => {
        abaixo = 0
        normal = 0
        acima = 0
        obeso = 0
        lista.forEach(e => {
            if (e.status == 'Só o chassi do grilo') setAbaixo(abaixo++)
            else if (e.status == 'Ta baum') setNormal(normal++)
            else if (e.status == 'Fofinho') setAcima(acima++)
            else if (e.status == 'Procure um médico') setObeso(obeso++)
            else console.log(e)
        })
    }

    useEffect(() => {
        fetch("http://localhost:3000/academia/alunos/imc", {
            "method": "GET",
            "headers": {
                Accept: 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(resp => {
            return resp.json()
        }).then(data => {
            setlista(data)
        }).catch(err => {
        })
    }, [lista])

    return (
        <View style={style.pag}>
            <TouchableOpacity style={style.resumo}>
                <View style={style.linha}>
                    <Text>Alunos abaixo do peso:</Text><Text>{abaixo}</Text>
                </View>
                <View style={style.linha}>
                    <Text>Alunos com peso normal:</Text><Text>{normal}</Text>
                </View>
                <View style={style.linha}>
                    <Text>Alunos acima do peso:</Text><Text>{acima}</Text>
                </View>
                <View style={style.linha}>
                    <Text>Alunos obesos:</Text><Text>{obeso}</Text>
                </View>
                <TouchableOpacity style={style.item} onPress={resumir}>
                    <Text>Resumir</Text>
                </TouchableOpacity>
            </TouchableOpacity>
            {lista.map((item, index) =>
                <TouchableOpacity key={index} style={style.item} onPress={() => { navigation.navigate('Detalhes', item) }}>
                    <Text>{item.id}</Text>
                    <Text>{item.nome}</Text>
                    <Image style={style.icone} source={require('../../assets/favicon.png')} />
                </TouchableOpacity>
            )}
        </View>
    )
}