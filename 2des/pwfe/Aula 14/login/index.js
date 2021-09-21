function login() {
    let email = document.querySelector("#email").value;

    let url = "https://jsonplaceholder.typicode.com/users?email=" + email;

    fetch(url)
    .then(resp => {
        return resp.json();
    })
    .then(data => {
        let user = data[0];
        localStorage.setItem("id", user.id);
        localStorage.setItem("name", user.name);
        window.location.href = "/home";
    })
    .catch(err => {
        console.log(err);
    });
}