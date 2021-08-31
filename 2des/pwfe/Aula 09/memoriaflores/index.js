//Array ou Vetor com todas as imagens das frentes
var frentes = [
    "background-image: url('./assets/cravo.png');",
    "background-image: url('./assets/cravo.png');",
    "background-image: url('./assets/orquidea.png');",
    "background-image: url('./assets/orquidea.png');",
    "background-image: url('./assets/rosas.png');",
    "background-image: url('./assets/rosas.png');",
    "background-image: url('./assets/tulipas.png');",
    "background-image: url('./assets/tulipas.png');"
]
const verso = "background-image: url('./assets/verso.png');"
//Embaralha o array
frentes = shuffleArray(frentes)

function virarCarta(e) {
    e.setAttribute("style",frentes[0]);
}

// Função para embaralhar array
function shuffleArray(arr) {
    // Loop em todos os elementos
    for (let i = arr.length - 1; i > 0; i--) {
        // Escolhendo elemento aleatório
        const j = Math.floor(Math.random() * (i + 1));
        // Reposicionando elemento
        [arr[i], arr[j]] = [arr[j], arr[i]];
    }
    // Retornando array com aleatoriedade
    return arr;
}
