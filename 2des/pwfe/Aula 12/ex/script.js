var body = document.querySelector("body");

function loadData(e) {
    let fr = new FileReader();

    fr.onload = () => {
        generateHTML(JSON.parse(fr.result));
    }

    fr.readAsText(e.files[0]);
}

function generateHTML(data) {
    data.forEach(item => {
        let card = document.querySelector(".card").cloneNode(true);
        card.classList.remove("model");
    
        card.querySelector("img").src = item.foto;
        card.querySelector("#title").innerHTML = `${item.nome} - ${item.ano}`;
        card.querySelector("#genero").innerHTML = item.genero;
    
        body.appendChild(card);
    })
}