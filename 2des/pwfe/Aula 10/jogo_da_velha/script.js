var title = document.querySelector("#msg");

var imgs = ["url('./img/cross.png')","url('./img/circle.png')"];
var char = ["X", "O"];
var player = false;
var arr = [["","",""],["","",""],["","",""]];

function markBox(e) {
  let id = e.id;
  let selected = (player = !player) ? 0 : 1;

  e.style.backgroundImage = imgs[selected];
  e.onclick = function() {}
  
  arr[Number(id.charAt(0))][Number(id.charAt(1))] = String(selected);
  
  let tmpX = "", tmpY = "";
  let tmpT1 = "", tmpT2 = "";
  let cntT1 = 0, cntT2 = 0;
  let cntX = 0, cntY = 0;
  let cont = 2;
  for(let i = 0; i < 3; i++) {
    let posX = arr[Number(id.charAt(0))][i];
    let posY = arr[i][Number(id.charAt(1))];
    let posT1 = arr[i][i];
    let posT2 = arr[i][cont--];

    if(posX != '' && posX == tmpX) cntX++;
    if(posY != '' && posY == tmpY) cntY++;
    if(posT1 != '' && posT1 == tmpT1) cntT1++;
    if(posT2 != '' && posT2 == tmpT2) cntT2++;

    tmpX = posX;
    tmpY = posY;
    tmpT1 = posT1;
    tmpT2 = posT2;
  }

  if(cntX == 2 || cntY == 2 || cntT1 == 2 || cntT2 == 2) {
    disableBoxes();
    title.innerHTML = `${char[selected]} Foi o vencedor`;
  }
}

function disableBoxes() {
  document.querySelectorAll(".box").forEach(item => {
    item.onclick = function() {};
  })
}