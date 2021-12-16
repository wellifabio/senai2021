import React, { useState, useEffect } from 'react'
import { View, Text, Image, TouchableOpacity } from 'react-native'
import style from './style.js'
export default function Home({ navigation }) {

    const [entregadores, setEntregadores] = useState([{
        "id_entregador": 1,
        "nome": "Roberval"
    }])

    useEffect(() => {
        fetch("http://localhost:3000/entregas/entregadores", {
            "method": "GET",
            "headers": {
                Accept: 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(resp => {
            return resp.json()
        }).then(data => {
            setEntregadores(data);
        }).catch(err => {
        });
    }, [entregadores]);

    return (
        <View style={style.pag}>
            {entregadores.map((item, index) =>
                <TouchableOpacity style={style.menu} key={index} onPress={() => { navigation.navigate('Listar entregas', item) }}>
                    <Image style={style.icone} source={require('../../assets/favicon.png')}></Image>
                    <Text>{item.nome}</Text>
                </TouchableOpacity>
            )}
        </View>
    )
}