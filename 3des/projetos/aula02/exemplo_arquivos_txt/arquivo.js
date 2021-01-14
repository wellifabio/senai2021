//Função que carrega um arquivo de texto 
function loadArquivo () {
    //Checa se suporta o formato do arquivo
    if (window.File && window.FileReader && window.FileList && window.Blob) {
        var fileSelected = document.getElementById('arquivo');
        fileSelected.addEventListener('change', function (e) {
            //Configura a extenção do arquivo para .txt
            var fileExtension = /text.*/;
            //Pega o arquivo lido
            var fileTobeRead = fileSelected.files[0];
            //Check of the extension match
            if (fileTobeRead.type.match(fileExtension)) {
                //Initialize the FileReader object to read the 2file
                var fileReader = new FileReader();
                fileReader.onload = function (e) {
                    var fileContents = document.getElementById('filecontents');
                    fileContents.innerText = fileReader.result;
                }
                fileReader.readAsText(fileTobeRead);
            }
            else {
                alert("Por favor selecione arquivo de texto");
            }
        }, false);
    }
    else {
        alert("Arquivo(s) não suportado(s)");
    }
}
//Chamada da função ao carregar a Janela
window.onload = loadArquivo();
