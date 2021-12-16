import { StyleSheet } from 'react-native';

export default StyleSheet.create({
    container : {
        flex: 1,
    },
    inputText: {
        border: "1px solid #000",
        fontFamily: "helvetica",
        height: 30,
        textAlign: "center",
        margin: 5,
        borderRadius: 5,
        fontStyle: "italic",
    },
    addJogador: {
        flexDirection: "row",
        alignItems: "center",
        justifyContent: "space-between",
    },
    listItem: {
        flexDirection: "row",
        alignItems: "center",
        margin: 5,
    },
    image: {
        width: 30, 
        height:30
    },
    text: {
        marginLeft: 10,
        fontWeight: "bold",
        fontSize: 18,
    },
    btn: {
        margin: 5,
        padding: 10,
        backgroundColor: "#0390FC",
        borderRadius: 5,
        alignItems: "center",
        justifyContent: "center",
    },
    textBtn: {
        fontWeight: "bold",
        color: "#FFF",
    }
});