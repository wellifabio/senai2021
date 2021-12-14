import React from 'react';
import { View, Text, Image, TouchableOpacity } from 'react-native';
import style from './style.js'; export default function Detalhes({ navigation, route }) {
    const { idServico, prestador, valorHora, horasTrabalhadas, subTotal, iss, total } = route.params;
    return (
        <View>
            <TouchableOpacity style={style.card}>
                <View>
                    <Text style={{ fontWeight: 'bold' }}>Id do Servico:</Text>
                    <Text>{idServico}</Text>
                </View>
                <View>
                    <Text style={{ fontWeight: 'bold' }}>Prestador:</Text>
                    <Text>{prestador}</Text>
                </View>
                <View>
                    <Text style={{ fontWeight: 'bold' }}>Valor da hora:</Text>
                    <Text>{valorHora}</Text>
                </View>
                <View>
                    <Text style={{ fontWeight: 'bold' }}>Horas trabalhadas:</Text>
                    <Text>{horasTrabalhadas}</Text>
                </View>
                <View>
                    <Text style={{ fontWeight: 'bold' }}>Subtotal&emsp;Imposto (iss)&emsp;Total:</Text>
                    <Text>R$ {subTotal} &emsp; R$ {iss} &emsp; R$ {total}</Text>
                </View>
            </TouchableOpacity>
            <Image source={{uri: 'https://blog.telhanorte.com.br/wp-content/uploads/2021/04/torneira-agua-cozinha-pia-monocomando-scaled-e1617799366556.jpg'}} style = {style.img}/>
        </View>
    );
}
