var body = document.querySelector("body");
function loadData(e) {
    let file = e.files[0];

    let fr = new FileReader();

    fr.onload = () => {
        let data = JSON.parse(fr.result);
        generateHTML(data);
    };

    fr.readAsText(file);
}
function generateHTML(data) {
    let nome = document.createElement("h2");
    nome.innerHTML = data.nome;

    let genero = document.createElement("h5");
    genero.innerHTML = data.genero;

    let ano = document.createElement("h5");
    ano.innerHTML = data.ano

    let image = document.createElement("img");
    image.src = data.foto;

    body.appendChild(nome);
    body.appendChild(genero);
    body.appendChild(ano);
    body.appendChild(image);
}