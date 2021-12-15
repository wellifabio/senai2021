import { StyleSheet } from "react-native";
export default StyleSheet.create({
    pag: {
        backgroundColor: "#eee",
        flex: 1
    },
    item: {
        backgroundColor: '#fefefe',
        borderWidth: 1,
        borderColor: '#ccc',
        margin: 5,
        padding: 5,
        display: 'flex',
        flexDirection: 'row',
        justifyContent: 'space-around'
    },
    resumo:{
        backgroundColor: '#fefefe',
        borderWidth: 1,
        borderColor: '#ccc',
        margin: 5,
        padding: 5,
        display: 'flex',
        flexDirection: 'column',
    },
    linha:{
        display: 'flex',
        flexDirection: 'row',
        justifyContent: 'space-around'
    },
    icone: {
        width: 50,
        height: 50
    }
});