import React from 'react';
import { View, Text, TouchableOpacity } from 'react-native';

import styles from './Style.js'

export default function App() {
  const restaurantes = [
    {
      nome:"Paris 6",
      nota:2
    },
    {
      nome:"Outback",
      nota:4.5
    },
    {
      nome:"Gordinho Paloma",
      nota:7
    },
    {
      nome:"Lindoya Lanches",
      nota:4.7
    }
  ];

  return (
    <View style={styles.container}>

      {
        restaurantes.map(item => {
          return (
            <TouchableOpacity style={styles.card}>
              <Text>{item.nome}</Text>
              <Text>{item.nota}</Text>
            </TouchableOpacity>
          )
        })
      }
      
    </View>
  );
}