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
            <Image style={style.img} source={{uri:'https://lh3.googleusercontent.com/proxy/MkI_c0TMjs-wMLdPIsP9EQxpwihS_cav6j7l5h0niZ13-YcswvC_lvyAsy7K2Apty-VOb-nNIKYYtxFCv5iZl3C695doQ1V0wQv8JwcB_bXrGXlR'}}/>
        </View>
    )
}