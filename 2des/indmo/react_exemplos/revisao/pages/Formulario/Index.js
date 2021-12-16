import React, { useState } from 'react';
import { View, Text, TextInput, Picker, TouchableOpacity, Image } from 'react-native';

import style from './Style.js';

const top = require('../../assets/top.png');
const sup = require('../../assets/sup.png');
const mid = require('../../assets/mid.png');
const jg = require('../../assets/jg.png');
const adc = require('../../assets/adc.png');
const add = require('../../assets/add.png');

export default function Formulario({ navigation }) {
    const [nomeEquipe, setNomeEquipe] = useState("");
    const [nomeTreinador, setNomeTreinador] = useState("");
    const [nomeJogador, setNomeJogador] = useState("");
    const [posicao, setPosicao] = useState("top");
    const [lista, setLista] = useState({
        top:"",
        mid:"",
        jg:"",
        sup:"",
        adc:""
    });

    const handleAddJogador = () => {
        setLista({ ...lista, [posicao] : nomeJogador });
    }

    const handleSalvarEquipe = () => {
        let body = {
            "nomeEquipe": nomeEquipe,
            "nomeCoach": nomeTreinador,
            "jogadores": [
                {
                    "posicao": "top",
                    "jogador": lista.top
                },
                {
                    "posicao": "mid",
                    "jogador": lista.mid
                },
                {
                    "posicao": "jg",
                    "jogador": lista.jg
                },
                {
                    "posicao": "adc",
                    "jogador": lista.adc
                },
                {
                    "posicao": "sup",
                    "jogador": lista.sup
                }
            ]
        }

        let url = "http://10.87.202.135:8080/api/equipe";

        fetch(url, {
            method: "POST",
            body: JSON.stringify(body)
        })
        .then(resp => { return resp.status })
        .then(data => { 
            if(data == 200) navigation.navigate("Home");
         });

    }

    return (
        <View style={style.container}>
            <TextInput value={nomeEquipe} onChange={ ({target}) => { setNomeEquipe(target.value) } } placeholder="Nome da Equipe" style={ style.inputText }/>
            <View style={ style.addJogador }>
                <TextInput placeholder="Nome do Jogador" style={ style.inputText } value={ nomeJogador } onChange={ (e) => { setNomeJogador(e.target.value) } } />
                <Picker selectedValue={ posicao } onChange={ (e) => { setPosicao(e.target.value) } } style={ style.inputText }>
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
                <Text style={ style.text }> { lista.top } </Text>
            </View>
            <View style={style.listItem}>
                <Image style={ style.image } source={mid} />
                <Text style={ style.text }> { lista.mid } </Text>
            </View>
            <View style={style.listItem}>
                <Image style={ style.image } source={jg} />
                <Text style={ style.text }> { lista.jg } </Text>
            </View>
            <View style={style.listItem}>
                <Image style={ style.image } source={adc} />
                <Text style={ style.text }> { lista.adc } </Text>
            </View>
            <View style={style.listItem}>
                <Image style={ style.image } source={sup} />
                <Text style={ style.text }> { lista.sup } </Text>
            </View>
            <TextInput value={ nomeTreinador } onChange={(({target}) => { setNomeTreinador(target.value) })} style={ style.inputText } placeholder="Nome do treinador"/>
            <TouchableOpacity style={ style.btn } onPress={ handleSalvarEquipe }>
                <Text style={ style.textBtn }>Salvar Equipe</Text>
            </TouchableOpacity>
        </View>
    )
}