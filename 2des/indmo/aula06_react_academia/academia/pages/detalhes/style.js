import { StyleSheet } from "react-native";
export default StyleSheet.create({
    pag: {
        backgroundColor: "#eee",
        flex: 1
    },
    inp: {
        borderWidth: 1,
        borderColor: '#ccc',
        borderRadius: 5,
        margin: 5,
        padding: 10,
        display: 'flex',
        flexDirection: 'row',
        justifyContent: 'space-around'
    },
    out: {
        borderWidth: 1,
        borderColor: '#ccc',
        borderRadius: 5,
        backgroundColor:'#f9f9f9',
        margin: 5,
        padding: 10,
        display: 'flex',
        flexDirection: 'row',
        justifyContent: 'space-around'
    },
    botoes:{
        display: 'flex',
        flexDirection: 'row',
        justifyContent: 'space-around'
    },
    botao: {
        backgroundColor: '#fefefe',
        borderWidth: 1,
        borderColor: '#999',
        borderRadius: 5,
        minWidth:150,
        margin: 5,
        padding: 10,
        textAlign: 'center'
    }
});