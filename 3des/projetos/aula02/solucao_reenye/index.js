const input = document.getElementById("input");
const exercicio = document.getElementById("exer");
const file = document.getElementById("file");
const result = document.getElementById("resultado");

function exec() {
    switch(exercicio.value) {
        case "1":
            let jogo = "";
            input.value.split("\n").forEach(e => {
                let arr = e.split(" ");
                let numeros = [];
                let ger = 0;
                for(i = 0; i < parseInt(arr[1]); i++){
                    for(j = 0; j < parseInt(arr[0]); j++){
                        while( numeros.indexOf(ger = Math.floor(Math.random() * 59 + 1)) >= 0 );
                        numeros.push(ger);                        
                    }
                    jogo += numeros.sort(sortfunction).toString().replaceAll(",", " ") + "\n";
                    numeros = [];
                }
            });
            var blob = new Blob([jogo], {type: "text/plain;charset=utf-8"});
            saveAs(blob, "jogos.txt");
            break;
        case "2":
            var fileReader = new FileReader();
            var arq = file.files[0];
            var n6 = 0, n7 = 0, n8 = 0, n9 = 0, n10 = 0, total = 0;
            var res = "";
            fileReader.onload = function(fileLoadedEvent){
                var text = fileLoadedEvent.target.result;
                text.split("\n").forEach(item => {
                    let arr = item.split(" ");
                    if(arr.length == 6) {
                        n6 += 4.5;
                    }else if(arr.length == 7) {
                        n7 += 31.5;
                    }else if(arr.length == 8) {
                        n8 += 126.0;
                    }else if(arr.length == 9) {
                        n9 += 378.0;
                    }else if(arr.length == 10) {
                        n10 += 945.0;
                    }
                });
                total = n6 + n7 + n8 + n9 + n10;
                if(n6 > 0) {
                    res += n6 + "\n";
                }
                if(n7 > 0) {
                    res += n7 + "\n";
                }
                if(n8 > 0) {
                    res += n8 + "\n";
                }
                if(n9 > 0) {
                    res += n9 + "\n";
                }
                if(n10 > 0) {
                    res += n10 + "\n";
                }
                res += total;
                var blob = new Blob([res], {type: "text/plain;charset=utf-8"});
                saveAs(blob, "custo.txt");
            };
          
            fileReader.readAsText(arq, "UTF-8");
            break;
        case "3":
            var resultado = result.value;
            var acertos = 0;
            var fileReader = new FileReader();
            var arq = file.files[0];
            var ret = "";
            fileReader.onload = function(fileLoadedEvent){
                var text = fileLoadedEvent.target.result;
                text = text.substr(0,text.length-1);
                text.split("\n").forEach(item => {
                    item.split(" ").forEach(num => {
                        resultado.split(" ").forEach(n => {
                            if(parseInt(num) == parseInt(n)) {
                                acertos++;
                            }
                        })
                    });
                    if(acertos == 6) {
                        ret += "SENA\n";
                    }else if(acertos == 5) {
                        ret += "QUINA\n";
                    }else if(acertos == 4) {
                        ret += "QUADRA\n";
                    }else {
                        ret += acertos + " acertos\n";
                    }
                    acertos = 0;
                });
                var blob = new Blob([ret], {type: "text/plain;charset=utf-8"});
                saveAs(blob, "resultado.txt");
            };
            fileReader.readAsText(arq, "UTF-8");
            break;            
    }
}

function sortfunction(a, b){
    return (a - b);
}