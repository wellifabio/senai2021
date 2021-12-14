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
    
    useEffect(()=>{
        fetch("http://localhost:3000/academia/alunos", {
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
    },[lista])

    return (
        <View style={style.pag}>
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