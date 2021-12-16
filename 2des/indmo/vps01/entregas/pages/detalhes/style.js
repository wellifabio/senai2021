import { StyleSheet } from "react-native";
export default StyleSheet.create({
    pag: {
        backgroundColor: "#eee",
        flex: 1
    },
    detalhe: {
        backgroundColor: '#fefefe',
        borderWidth: 1,
        borderColor: '#ccc',
        margin: 5,
        padding: 5,
        display: 'flex',
        flexDirection: 'column',
    },
    linha: {
        backgroundColor: '#fefefe',
        borderWidth: 1,
        borderColor: '#ccc',
        margin: 5,
        padding: 5,
        display: 'flex',
        flexDirection: 'row',
        justifyContent: 'space-around'
    },
    botao: {
        backgroundColor: '#777',
        borderWidth: 1,
        borderColor: '#ccc',
        borderRadius: 5,
        margin: 5,
        padding: 10,
        textAlign: 'center'
    }
});