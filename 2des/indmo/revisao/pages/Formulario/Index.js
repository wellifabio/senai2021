import React, { useState } from 'react';
import { View, Text, TextInput, Picker, TouchableOpacity, Image } from 'react-native';

import style from './Style.js';

const top = require('../../assets/top.png');
const sup = require('../../assets/sup.png');
const mid = require('../../assets/mid.png');
const jg = require('../../assets/jg.png');
const adc = require('../../assets/adc.png');
const add = require('../../assets/add.png');

export default function Formulario() {
    const [nomeJogador, setNomeJogador] = useState("");
    const [posicao, setPosicao] = useState("");

    const handleAddJogador = () => {
        
    }

    return (
        <View style={style.container}>
            <TextInput placeholder="Nome da Equipe" style={ style.inputText }/>
            <View style={ style.addJogador }>
                <TextInput placeholder="Nome do Jogador" style={ style.inputText } value={ nomeJogador } onChange={ (e) => { setNomeJogador(e.target.value) } } />
                <Picker value={ posicao } onChange={ (e) => { setPosicao(e.target.value) } } style={ style.inputText }>
                    <Picker.Item label="Top" value="top" />
                    <Picker.Item label="Mid" value="mid" />
                    <Picker.Item label="Jungler" value="jg" />
                    <Picker.Item label="ADC" value="adc" />
                    <Picker.Item label="Suporte" value="sup" />
                </Picker>
                <TouchableOpacity onPress={ handleAddJogador } style={{marginRight: 5}}>
                    <Image style={ style.image } source={add}/>
                </TouchableOpacity>
            </View>
            <View style={style.listItem}>
                <Image style={ style.image } source={top} />
                <Text style={ style.text }> {  } </Text>
            </View>
            <View style={style.listItem}>
                <Image style={ style.image } source={mid} />
                <Text style={ style.text }> {  } </Text>
            </View>
            <View style={style.listItem}>
                <Image style={ style.image } source={jg} />
                <Text style={ style.text }> {  } </Text>
            </View>
            <View style={style.listItem}>
                <Image style={ style.image } source={adc} />
                <Text style={ style.text }> {  } </Text>
            </View>
            <View style={style.listItem}>
                <Image style={ style.image } source={sup} />
                <Text style={ style.text }> {  } </Text>
            </View>
            <TextInput style={ style.inputText } placeholder="Nome do treinador"/>
            <TouchableOpacity style={ style.btn }>
                <Text style={ style.textBtn }>Salvar Equipe</Text>
            </TouchableOpacity>
        </View>
    )
}