import React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';

import Login from './pages/login/index.js';
import Home from './pages/home/index.js';
import Equipe from './pages/equipe';

const Stack = createNativeStackNavigator();

export default function App() {
  return (
    <NavigationContainer>
      <Stack.Navigator>
        <Stack.Screen name="Login" component={Login} options={{title: 'Tela de Login'}} />
        <Stack.Screen name="Home" component={Home} />
        <Stack.Screen name="Equipe" component={Equipe} />
      </Stack.Navigator>
    </NavigationContainer>
  );
}
