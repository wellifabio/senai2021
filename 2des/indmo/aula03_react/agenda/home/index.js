import React from 'react';
import { View, Text, Image, TouchableOpacity } from 'react-native';
import style from './style.js';

export default function Home({ navigation }) {
    const jsonArray = [
        {
            "Tarefa": "Alimentar o cachorro",
            "Data": "2021-12-09",
            "Descrição": "Abrir o saco de ração e colocar uma tigela no pote do cachorrinho",
            "Imagem":"https://s2.glbimg.com/nvjFq8VRjyrpdQqaOeywz-5DFwY=/e.glbimg.com/og/ed/f/original/2021/08/27/captura_de_tela_2021-08-27_as_11.01.15.png"
        },
        {
            "Tarefa": "Alimentar o gato",
            "Data": "2021-12-09",
            "Descrição": "Abrir o saco de ração e colocar uma tigela no pote do gatinho, obs: impedir o cachorro de comer a comida do gato",
            "Imagem":"https://super.abril.com.br/wp-content/uploads/2020/09/04-09_gato_SITE.jpg?quality=70&strip=info"
        },
        {
            "Tarefa": "Tomar o café da manhã",
            "Data": "2021-12-09",
            "Descrição": "Comer pão com manteiga e tomar leite com nescau, enquanto o cachorro olha pedindo",
            "Imagem":"https://blog.appegada.com/thumb/blog/1/780/500/1a09bacc2740e0f8e3c2b10bd5bf01ae.jpg"
        }
    ]
    return (
        <View style={style.pag}>
            {jsonArray.map((item, index) =>
                <TouchableOpacity style={style.card} key={index} onPress={()=>{navigation.navigate('Detalhes',item)}}>
                    <Image style={style.icone} source={require('../assets/icone.png')}></Image>
                    <Text>{item.Tarefa}</Text>
                    <Text>{item.Data}</Text>
                </TouchableOpacity>
            )}
        </View>
    );
}