var body = document.querySelector("body");

function loadData(e) {
    let fr = new FileReader();

    fr.onload = () => {
        generateHTML(JSON.parse(fr.result));
    }

    fr.readAsText(e.files[0]);
}

function generateHTML(data) {
    let card = document.querySelector(".card").cloneNode(true);
    card.classList.remove("model");

    card.querySelector("img").src = data.foto;
    card.querySelector("#title").innerHTML = `${data.nome} - ${data.ano}`;
    card.querySelector("#genero").innerHTML = data.genero;

    body.appendChild(card);
}