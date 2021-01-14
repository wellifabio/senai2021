const titulo = document.getElementById("titulo");
const patrocinadores = document.getElementById("patrocinadores");
const executores = document.getElementById("executores");
const gerentes = document.getElementById("gerentes");
const clientes = document.getElementById("clientes");
const prazo = document.getElementById("prazo");

function gerarTAP() {
    if (titulo.value !== '' && patrocinadores.value !== '' && executores.value !== '' && gerentes.value !== '' && clientes.value !== '' && prazo.value !== '') {
        var doc = new jsPDF();
        doc.addImage("./fundo.png", 'PNG', 0,0, 210, 297);
        doc.setFontSize(12);
        doc.text(titulo.value, 31, 49);
        doc.text(patrocinadores.value, 31, 68);
        doc.text(executores.value.replaceAll(", ","\n\n"), 73, 90);
        doc.text(gerentes.value, 73, 171);
        doc.text(patrocinadores.value, 73, 185);
        doc.text(clientes.value, 73, 197);
        doc.text(prazo.value, 73, 211);
        doc.save('tap.pdf');
    } else {
        alert("Preencha todos os campos obrigatórios.");
    }
}

function preencher(){
    titulo.innerHTML = "Sabonete íntimo 'Cracra, Crecre, Cricri, Crocro e Crucru'\nNão deixa os cabelos do saco enrolar, de pé, cair, dar nó e enroscar com os do cú.";
    patrocinadores.innerHTML = "TV Globo, TV SBT e Rede TV";
    executores.innerHTML = "Jacinto Mello, Silvana Santos, Hebe Camargo, Jair Rodrigues, Suzana Santos, Marcos Guedes, Adriana Medeiros";
    gerentes.innerHTML = "Renato Aragão e Dedé Santana";
    clientes.innerHTML = "Público masculino adulto";
    prazo.innerHTML = "De seis a oito mêses."
}