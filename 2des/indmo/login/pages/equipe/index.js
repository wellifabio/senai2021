import React, { useState, useEffect } from 'react';
import { View, Text } from 'react-native';

export default function Equipe({ route }) {
    const [equipe, setEquipe] = useState([]);

    const { id } = route.params;

    useEffect(() => {
        let url = "http://10.87.207.20:8080/api/equipe/"+id;

        fetch(url)
        .then(resp => { return resp.json(); })
        .then(data => { setEquipe(data); })
    }, []);

    return(
        <View>
            <Text>{ equipe.nomeEquipe }</Text>
        </View>
    )
}