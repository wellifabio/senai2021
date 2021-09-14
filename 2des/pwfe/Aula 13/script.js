var body = document.querySelector("body");

function loadData(e) {
    let file = e.files[0];

    let fr = new FileReader();//S2

    fr.onload = () => {
        let data = JSON.parse(fr.result);

        generateHTML(data);
    }

    fr.readAsText(file);
}

function generateHTML(data) {
    let title = document.createElement("h2");
    title.innerHTML = data.titulo;

    let autor = document.createElement("h4");
    autor.innerHTML = data.autor;

    let capa = document.createElement("img");
    capa.src = data.capa;
    capa.style.width = "200px";

    body.appendChild(title);
    body.appendChild(autor);
    body.appendChild(capa);
}