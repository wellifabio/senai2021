import React, { useState, useEffect } from 'react';
import { View, Text, TouchableOpacity } from 'react-native';

export default function Home({ navigation, route }) {
    const [lista, setLista] = useState([]);

    const { id, nome } = route.params;

    useEffect(() => {
        let url = "http://10.87.207.20:8080/api/equipe";

        fetch(url)
        .then((response) => { return response.json(); })
        .then(data => { setLista(data); })
    }, []);

    return (
        <View>
            {
                lista.map((item, index) => {
                    return(
                        <TouchableOpacity key={index} onPress={ () => { navigation.navigate("Equipe", {id: item.id}) } } >
                            <Text> { item.nomeEquipe } </Text>
                            <Text> { item.nomeCoach } </Text>
                        </TouchableOpacity>
                    )
                })
            }
        </View>
    );
}