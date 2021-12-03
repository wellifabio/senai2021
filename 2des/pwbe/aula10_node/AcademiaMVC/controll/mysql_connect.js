//Equivalente a classe ConnectDB em Java MVC
const mysql = require('mysql')
const con = mysql.createConnection({
    'user': 'root',
    'database': 'academia',
    'host': 'localhost'
})

module.exports = {
    con
}