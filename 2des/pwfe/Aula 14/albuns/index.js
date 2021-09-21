var username = document.querySelector("#username");

username.innerHTML = localStorage.getItem("name");

const url = "https://jsonplaceholder.typicode.com/albums?userId=" + localStorage.getItem("id");

fetch(url)
.then(resp => {
    return resp.json();
})
.then(data => {
    console.log(data);
})
.catch(err => {
    console.log(err);
})