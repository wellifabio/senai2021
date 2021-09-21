var body = document.querySelector("body");

fetch("https://jsonplaceholder.typicode.com/photos")
.then((response) => {
    return response.json();
})
.then((obj) => {
    let img = document.createElement("img");
    img.src = obj[0].url;
    body.appendChild(img);
    console.log(obj[0])
})
.catch((err) => {
    console.log(err);
});