const mysql = require('mysql')
const con = mysql.createConnection({
    'database': 'irrf',
    'host': 'localhost',
    'user': 'root'
})

module.exports = {
    con
}