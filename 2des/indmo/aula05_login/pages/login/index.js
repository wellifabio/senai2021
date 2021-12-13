import React, {useState} from 'react'
import { View, Text, TouchableOpacity, TextInput } from 'react-native'
import style from './style.js'

const usuarios = [
    {
        "login": "zeroberto",
        "senha": "1234",
        "detatlhes":"Sou um cara legal"
    },
    {
        "login": "humberto",
        "senha": "1234",
        "detatlhes":"Esse cara sou eu"
    },
    {
        "login": "doisberto",
        "senha": "1234",
        "detatlhes":"Apenas mais um cara"
    }
]

export default function Login({ navigation }) {

    const [user, setUser] = useState('')
    const [password, setPassword] = useState('')
    
    const validarLogin = () =>{
        console.log(user)
        console.log(password)
    }

    return (
        <View style={style.page}>
            <View style={style.inputs}>
                <Text>Login:</Text>
                <TextInput style={style.in} placeholder="login" value={user} onChange={(e)=>{setUser(e.target.value);}}/>
            </View>
            <View style={style.inputs}>
                <Text>Senha:</Text>
                <TextInput style={style.in} secureTextEntry={true} value={password} onChange={(e)=>{setPassword(e.target.value);}} />
            </View>
            <TouchableOpacity onPress={validarLogin}>
                <Text style={style.entrar} >Entrar</Text>
            </TouchableOpacity>
        </View>
    )
}