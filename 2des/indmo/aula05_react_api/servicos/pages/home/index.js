import React, { useState, useEffect } from 'react';
import { View, Text, Image, TouchableOpacity } from 'react-native';
import style from './style.js';
export default function Home({ navigation }) {

    const [lista, setLista] = useState([
        {
            "id_servico": 0,
            "prestador": "Nome do Prestador",
            "valor_hora": 0,
            "horas_trabalhadas": 0
        }, {}
    ]);

    const erro = [
        {
            "id_servico": 0,
            "prestador": "Sem resposta do servidor",
            "valor_hora": 0,
            "horas_trabalhadas": 0
        }, {}
    ]

    useEffect(() => {
        fetch("http://localhost:4000/servicos", {
            "method": "GET",
            "headers": {
                Accept: 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(resp => {
            return resp.json()
        }).then(data => {
            setLista(data);
        }).catch(err => {
            setLista(erro);
        });
    }, [lista.pop()]);

    return (
        <View style={style.pag}>
            {lista.map((item, index) =>
                <TouchableOpacity style={style.card} key={index} onPress={() => { navigation.navigate('Detalhes', item) }}>
                    <Text>id: {item.idServico}</Text>
                    <Text>Prestador: {item.prestador}</Text>
                    <Image style={style.icone} source={require('../../assets/favicon.png')}></Image>
                </TouchableOpacity>
            )}
        </View>
    );
}