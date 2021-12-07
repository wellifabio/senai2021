const mysql = require('mysql');
const settings = require('./settings.json')
const con = mysql.createConnection(settings.mysql);

module.exports = {
    con
}