import React, { useState } from 'react'
import { View, Text, TouchableOpacity, TextInput } from 'react-native'
import style from './style.js'

export default function Login({ navigation }) {
    const [user, setUser] = useState("");
    const [pw, setPw] = useState("");
    const [msg, setMsg] = useState("");

    const login = () => {
       let url = "http://10.87.207.20:8080/api/login";

       let data = {
           "user": user,
           "senha": pw
       }

       fetch(url, {
            method: "POST",
            body: JSON.stringify(data)
       })
       .then(resp => { 
           if(resp.status == 200) {
               return resp.json();
           }else {
                setMsg("Usuario ou Senha invalidos");
           }
        })
       .then(data => {
            if(data != undefined) navigation.navigate("Home", data);
       })
       .catch(err => {console.log(err)})
    }

    return (
        <View style={style.page}>
            <View style={style.inputs}>
                <Text>Login:</Text>
                <TextInput style={style.in} placeholder="login" onChangeText={(value) => { setUser(value) }} />
            </View>
            <View style={style.inputs}>
                <Text>Senha:</Text>
                <TextInput style={style.in} secureTextEntry={true} onChangeText={ (value) => { setPw(value) } }/>
            </View>
            <Text>{ msg }</Text>
            <TouchableOpacity onPress={login}>
                <Text style={style.entrar} >Entrar</Text>
            </TouchableOpacity>
        </View>
    )
}