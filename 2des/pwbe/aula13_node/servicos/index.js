const express = require('express') // HTTP - GET, POST, PUT, DELETE
const cors = require('cors') //FILTROS

const router = express.Router() 
const app = express()
app.use(cors())
app.use(express.json())

const servicos = require('./routes/servicos.js')
app.use(servicos)

app.use('/', router)
app.listen(4000, ()=>{
    console.log('listening on localhost:4000')
})