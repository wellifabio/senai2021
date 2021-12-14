import React from 'react'
import { View, Text, TouchableOpacity } from 'react-native'
import style from './style.js'

export default function Home({ navigation, route }) {
    const { login, detalhes } = route.params;
    return (
        <View>
        <TouchableOpacity style={style.card}>
            <View>
                <Text style={{ fontWeight: 'bold' }}>Login:</Text>
                <Text>{login}</Text>
            </View>
            <View>
                <Text style={{ fontWeight: 'bold' }}>Detalhes:</Text>
                <Text>Data:{detalhes}</Text>
            </View>
        </TouchableOpacity>
    </View>
    )
}