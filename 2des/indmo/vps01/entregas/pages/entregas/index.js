import React, { useState, useEffect } from 'react'
import { View, Text, Image, TouchableOpacity } from 'react-native'
import style from './style.js'

export default function Entregas({ navigation, route }) {

    const { id_entregador } = route.params;

    const [entregas, setEntregas] = useState([{
        "id_entregador": 1,
        "nome": "Roberval"
    }])

    useEffect(() => {
        fetch("http://10.87.202.131:3000/entregas/entregadores/"+id_entregador, {
            "method": "GET",
            "headers": {
                Accept: 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(resp => {
            return resp.json()
        }).then(data => {
            setEntregas(data);
        }).catch(err => {
        });
    }, [entregas]);

    return (
        <View style={style.pag}>
            {entregas.map((item, index) =>
                <TouchableOpacity style={style.menu} key={index} onPress={() => { navigation.navigate('Detalhes', item) }}>
                    <Image style={style.icone} source={require('../../assets/favicon.png')}></Image>
                    <Text>{item.endereco}</Text>
                </TouchableOpacity>
            )}
        </View>
    )
}