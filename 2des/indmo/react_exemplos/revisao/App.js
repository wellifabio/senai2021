import React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';

import Home from './pages/home';
import Formulario from './pages/Formulario';
import Equipe from './pages/Equipe';

export default function App() {
  const Stack = createNativeStackNavigator();

  return (
    <NavigationContainer>
      <Stack.Navigator>
        <Stack.Screen name="Home" component={Home} />
        <Stack.Screen name="Formulario" component={Formulario} />
        <Stack.Screen name="Equipe" component={Equipe} />
      </Stack.Navigator>
    </NavigationContainer>
  )
}