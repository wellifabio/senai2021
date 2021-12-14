import React from 'react'
import { View, Text, Image, TouchableOpacity } from 'react-native'
import style from './style.js'
export default function Home({ navigation }) {
    return(
        <View style={style.pag}>
            <TouchableOpacity style={style.menu} onPress={() => { navigation.navigate('Listar Todos') }}>
                <Image style={style.icone} source={require('../../assets/favicon.png')}/>
                <Text style={{margin:12,fontSize:16,fontWeight:'bold'}}>Todos os alunos</Text>
            </TouchableOpacity>
            <TouchableOpacity style={style.menu} onPress={() => { navigation.navigate('Cadastrar Novo') }}>
                <Image style={style.icone} source={require('../../assets/favicon.png')}/>
                <Text style={{margin:12,fontSize:16,fontWeight:'bold'}}>Cadastrar Aluno</Text>
            </TouchableOpacity>
            <Image style={style.img} source={{uri:'https://news.gympass.com/wp-content/uploads/2018/07/escolher-a-melhor-academia.jpg'}}/>
        </View>
    )
}