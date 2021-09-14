function markAlert(e) {
    let card = e.parentNode.style;

    /*if(card.backgroundColor === "rgba(219, 32, 32, 0.5)") {
        card.backgroundColor = "#FFFFFF";
    }else {                     
        card.backgroundColor = "rgba(219, 32, 32, 0.5)";
    }*/

    (card.backgroundColor === "rgba(219, 32, 32, 0.5)") ? card.backgroundColor = "#FFFFFF" : card.backgroundColor = "rgba(219, 32, 32, 0.5)";

}

function removeTask(e) {
    e.parentNode.remove();
}

function newTask() {
    let tarefa = document.querySelector("#nova").value;
    
    let card = document.querySelector(".card").cloneNode(true);
    card.querySelector("p").innerHTML = tarefa;

    document.querySelector(".lista").appendChild(card);
}