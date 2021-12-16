const express = require('express')
const app = express()
const cors = require('cors')
const mysql = require('mysql')
const con = mysql.createConnection({
    database: 'vps01entrega',
    host: 'localhost',
    user: 'root'
});

app.use(cors())
app.use(express.json())

app.get('/entregas/entregadores', (req, res) => {
    let string = 'select * from entregadores'
    con.query(string, (err, result) => {
        res.json(result)
    })
});

app.get('/entregas/entregadores/:id', (req, res) => {
    let id = req.params.id
    let string = `select * from entregas where id_entregador = ${req.params.id} and hora is null`
    con.query(string, (err, result) => {
        res.json(result)
    })
});

app.put('/entregas/entregues/:id', (req, res) => {
    let id = req.params.id
    try {
        id = Number(id)
        if (typeof id === 'object' || typeof id === 'string' || isNaN(id)) {
            res.json({ err: "ID Não informado" })
        } else {
            let string = `update entregas set hora = curtime() where id_entrega = ${id}`
            con.query(string, (err, result) => {
                if (result.affectedRows == 0) {
                    res.status(404).end()
                } else {
                    res.status(200).end()
                }
            })
        }
    } catch (err) {
        res.json(err)
    }

});

app.listen(3000, () => {
    console.log('listening on localhost:3000')
})