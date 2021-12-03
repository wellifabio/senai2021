const cors = require('cors')
const express = require('express')

const router = express.Router()
const app = express()
app.use(cors())
app.use(express.json())

const alunos = require('./routes/alunos.js')
app.use(alunos)

app.use('/', router)
app.listen(3001, ()=>{
    console.log('listening on localhost:3001')
})