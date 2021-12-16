import React, { useState, useEffect } from 'react';
import {  View, Text, Image, Button, ScrollView } from 'react-native';
import { TouchableOpacity } from 'react-native-web';
import style from './Style.js';

export default function Home({ navigation }) {
  const [equipes, setEquipes] = useState([]);

  useEffect(() => {
    let url = "http://10.87.202.135:8080/api/equipe";

    fetch(url)
    .then(resp => { return resp.json() })
    .then(data => { setEquipes(data) });
  }, []);

  return (
    <View style={ style.container }>
      <Button title="Cadastrar Nova Equipe" onPress={ () => { navigation.navigate("Formulario") } } />
      <ScrollView>
        {
          equipes.map((item, index) => {
            return(
              <TouchableOpacity style={ style.equipe } key={ index } onPress={ () => {navigation.navigate("Equipe", {id:item.id})} }>
                <Text>{item.nomeEquipe}</Text>
                <Text>{item.nomeCoach}</Text>
              </TouchableOpacity>
            )
          })
        }
      </ScrollView>
    </View>
  )
}