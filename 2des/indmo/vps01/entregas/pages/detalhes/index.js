import React from 'react'
import { View, Text, TouchableOpacity } from 'react-native'
import style from './style.js'
export default function Detalhes({ navigation, route }) {

    const { id_entregador, id_entrega, cliente, produto, valor } = route.params;
    
    const entregador = { "id_entregador": id_entregador }
    
    const confirmar = () => {
        let url = "http://localhost:3000/entregas/entregues/" + id_entrega;
        fetch(url, {
            method: "PUT"
        })
            .then(resp => { return resp.status })
            .then(data => { if (data == 200) navigation.navigate('Listar entregas',entregador) })
    }

    return (
        <View style={style.pag}>
            <View style={style.detalhe}>
                <View style={style.linha}><Text>Id da Entrega:</Text><Text>{id_entrega}</Text></View>
                <View style={style.linha}><Text>Cliente:</Text><Text>{cliente}</Text></View>
                <View style={style.linha}><Text>Produto:</Text><Text>{produto}</Text></View>
                <View style={style.linha}><Text>Valor:</Text><Text>{valor}</Text></View>
            </View>
            <TouchableOpacity style={style.botao} onPress={confirmar}>
                <Text style={{fontWeight: "bold", color: "#fff"}}>Confirmar entrega</Text>
            </TouchableOpacity>
        </View>
    )
}