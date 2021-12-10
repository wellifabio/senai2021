import React from 'react';
import { View, Text, Image, TouchableOpacity } from 'react-native';
import style from './style.js';

export default function Detalhes({ navigation, route }) {
    const { Tarefa, Data, Descrição, Imagem } = route.params;
    return (
        <View>
            <TouchableOpacity style={style.card}>
                <View>
                    <Text style={{ fontWeight: 'bold' }}>Tarefa:</Text>
                    <Text>{Tarefa}</Text>
                </View>
                <View>
                    <Text style={{ fontWeight: 'bold' }}>Data:</Text>
                    <Text>Data:{Data}</Text>
                </View>
                <View>
                    <Text style={{ fontWeight: 'bold' }}>Descrição:</Text>
                    <Text>Descrição:{Descrição}</Text>
                </View>
            </TouchableOpacity>
            <Image source={{uri: Imagem}} style = {style.img}/>
        </View>
    );
}