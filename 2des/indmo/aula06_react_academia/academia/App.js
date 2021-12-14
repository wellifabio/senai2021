import React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import Home from './pages/home/index.js';
import List from './pages/list/index.js';
import Create from './pages/create/index.js';
import Detalhes from './pages/detalhes/index.js';

const Stack = createNativeStackNavigator();

export default function App() {
  return (
    <NavigationContainer>
      <Stack.Navigator>
        <Stack.Screen name="Academia CRUD" component={Home} />
        <Stack.Screen name="Listar Todos" component={List} />
        <Stack.Screen name="Cadastrar Novo" component={Create} />
        <Stack.Screen name="Detalhes" component={Detalhes} />
      </Stack.Navigator>
    </NavigationContainer>
  );
}