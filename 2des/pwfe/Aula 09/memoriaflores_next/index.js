//Definido um vetor com o nome de todas as imagens repeditas duas vezes
const verso = "background-image: url('./assets/verso.png')"

//Um vetor de estilos css com as imagens duplicadas
var styles = [
    "background-image: url('./assets/buque.jpg');",
    "background-image: url('./assets/buque.jpg');",
    "background-image: url('./assets/vaso.jpg');",
    "background-image: url('./assets/vaso.jpg');",
    "background-image: url('./assets/rosa.jpg');",
    "background-image: url('./assets/rosa.jpg');",
    "background-image: url('./assets/presente.jpg');",
    "background-image: url('./assets/presente.jpg');"
]

//Define um objeto para todas as frentes das cartas
var cards = {}

//Vira a carta ao clicar nela
function viraCarta(e) {
    if (cards[e.id][2]) {
        e.setAttribute("style", verso)
        cards[e.id][2] = false
    } else {
        e.setAttribute("style", cards[e.id][1])
        cards[e.id][2] = true
    }
}

function mostarTodas(){
    for(i = 1; i <= 8; i++){
        cards["bt"+i][0].setAttribute("style", cards["bt"+i][1])
        cards["bt"+i][2] = true
    }
}
function esconderTodas(){
    for(i = 1; i <= 8; i++){
        cards[("bt"+i)][0].setAttribute("style", verso)
        cards["bt"+i][2] = false
    }
}

//Embaralha as cartas
function embaralhar(){
    styles = shuffleArray(styles)
    cards = {
        "bt1": [document.getElementById("bt1"),styles[0], false],
        "bt2": [document.getElementById("bt2"),styles[1], false],
        "bt3": [document.getElementById("bt3"),styles[2], false],
        "bt4": [document.getElementById("bt4"),styles[3], false],
        "bt5": [document.getElementById("bt5"),styles[4], false],
        "bt6": [document.getElementById("bt6"),styles[5], false],
        "bt7": [document.getElementById("bt7"),styles[6], false],
        "bt8": [document.getElementById("bt8"),styles[7], false]
    }
    mostarTodas()
}

//Função útil que Embaralha um vetor
function shuffleArray(arr) {
    // Loop em todos os elementos
    for (let i = arr.length - 1; i > 0; i--) {
        // Escolhendo elemento aleatório
        const j = Math.floor(Math.random() * (i + 1));
        // Reposicionando elemento
        [arr[i], arr[j]] = [arr[j], arr[i]]
    }
    // Retornando array com aleatoriedade
    return arr
}