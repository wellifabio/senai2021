import React from 'react';
import {  View, Text, Image, Button } from 'react-native';
import style from './Style.js';

export default function Home({ navigation }) {
  const bita = require('../../assets/bita.jpg');

  const handleNavigate = () => {
    navigation.navigate('Formulario');
  };

  return (
    <View style={ style.container }>
      <Image style={ style.image } source={ bita } />
      <Image style={ style.image } source={ {uri:'https://envato-shoebox-0.imgix.net/6afe/1760-4011-4ece-8676-1567c130fb09/IMG_9464.jpg?auto=compress%2Cformat&fit=max&mark=https%3A%2F%2Felements-assets.envato.com%2Fstatic%2Fwatermark2.png&markalign=center%2Cmiddle&markalpha=18&w=700&s=734241e3ef2bd4bc0041346c7f4ec0ed'} } />
      <Text style={ style.texto }>Olá, mundo !</Text>
      <Button onPress={handleNavigate} title="Ir ao Formulario"/>
    </View>
  )
}