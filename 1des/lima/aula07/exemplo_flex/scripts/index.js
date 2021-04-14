var container = document.getElementById("container");
var items = document.getElementsByClassName("items");
var oas = document.getElementsByClassName("as");
var jcc = document.getElementById("jcc");
var jcfe = document.getElementById("jcfe");
var jcsb = document.getElementById("jcsb");
var jcsa = document.getElementById("jcsa");
var jcse = document.getElementById("jcse");
var ais = document.getElementById("ais");
var aie = document.getElementById("aie");
var aic = document.getElementById("aic");
var aist = document.getElementById("aist");
var aibl = document.getElementById("aibl");

var itemselected = 0;
var aiselected = 0;

for (let i = 0; i < 5; i++) {
  oas[i].onclick = () => {
    displayas();
  }
  items[i].onclick = () => {  
    items[itemselected].style.backgroundColor = "rgb(180, 87, 0)";
    items[i].style.backgroundColor = "rgb(192, 130, 71)";
    itemselected = i;
    displayas();
  };
}

function displayjc(val) {  
  container.style.justifyContent = "flex-start";
  switch (val) {
    case 1:
      if(jcfe.checked) container.style.justifyContent = "flex-end";
      break;
    case 2:
      if(jcc.checked) container.style.justifyContent = "center";
      break;
    case 3:
      if(jcsb.checked) container.style.justifyContent = "space-between";
      break;
    case 4:
      if(jcsa.checked) container.style.justifyContent = "space-around";
      break;
    case 5:
      if(jcse.checked) container.style.justifyContent = "space-evenly";
      break;
  }
}

function displayai(val) {  
  aiselected = val;

  container.style.alignItems = "flex-start";
  for (let item of items) {
    item.style.height = "15vh";
    if(val > 2) item.style.height = "auto";
  }

  items[itemselected].style.height = "15vh";
  switch (val) {
    case 1:
      if(aie.checked) container.style.alignItems = "flex-end";
      break;
    case 2:
      if(aic.checked) container.style.alignItems = "center";
      break;
    case 3:
      if(aist.checked) {
        container.style.alignItems = "stretch";
      } 
      break;
    case 4:
      if(aibl.checked) container.style.alignItems = "baseline";
      break;
    case 5:
      if(jcse.checked) container.style.justifyContent = "space-evenly";
      break;
  }
}

function displayas() {
  let i = 0;
  for(let op of oas) {
    if(i != itemselected) {
      items[i].style.removeProperty('align-self');
      //items[i].style.alignSelf = "flex-start";
      if(aiselected < 3)  items[i].style.height = "15vh";
    }
    if(op.checked) {
      items[itemselected].style.alignSelf = op.value;
      if(op.value === "stretch" || op.value === "baseline") items[itemselected].style.height = "auto";//items[itemselected].style.removeProperty('height');//
      else items[itemselected].style.height = "15vh";
    }
    i++;
  }
}