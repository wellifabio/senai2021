import React from 'react';
import { View } from 'react-native';

export default function Equipe({ navigation, route }) {
    const { id } = route.params;

    console.log(id);

    return (
        <View></View>
    );
}