import React, {useState} from 'react'
import { View, Text, TouchableOpacity, TextInput } from 'react-native'
import style from './style.js'

export default function Login({ navigation }) {

    const usuarios = [
        {
            "login": "zeroberto",
            "senha": "1234",
            "detalhes":"Sou um cara legal"
        },
        {
            "login": "humberto",
            "senha": "1234",
            "detalhes":"Esse cara sou eu"
        },
        {
            "login": "doisberto",
            "senha": "1234",
            "detalhes":"Apenas mais um cara"
        }
    ]

    const [user, setUser] = useState('')
    const [password, setPassword] = useState('')
    const [erro, setErro] = useState('Preencha os dados e clique em "Entrar"')

    const validarLogin = () =>{
        let encontrado = -1;
        for(let i = 0; i < usuarios.length; i++){
            if(user === usuarios[i].login && password === usuarios[i].senha){
                encontrado = i;
            }
        }
        if(encontrado === -1){
            setErro('Login ou senha inválidos')
        }else{
            navigation.navigate('Home',usuarios[encontrado])
            setErro('Preencha os dados e clique em "Entrar"')
        }
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
            <View style={style.inputs}>
                <Text>{erro}</Text>
            </View>
        </View>
    )
}