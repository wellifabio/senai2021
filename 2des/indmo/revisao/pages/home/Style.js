import { StyleSheet } from 'react-native';

export default StyleSheet.create(
{
    container: {
        flex: 1,
        alignItems: 'center',
        justifyContent: 'center',
    },
    texto: {
        fontSize: 30,
        color: 'red',
    },
    image: {
        width: 300,
        height: 210,
    },
    equipe: {
        border: "1px solid #000",
        flexDirection: "row",
        alignItems: "center",
        justifyContent: "space-between",
        margin: 5,
        padding: 5,
        width: 250,
        height: 50,
    }
})