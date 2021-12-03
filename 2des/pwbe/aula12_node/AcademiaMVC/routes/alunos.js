const express = require('express')
const router = express.Router()
const controller = require('../controller/alunos.js')

router.get('/academia/read',controller.doGet)
router.get('/academia/read/:id',controller.doGet)
router.post('/academia/create',controller.doPost)
router.put('/academia/update',controller.doPut)
router.delete('/academia/delete/:id',controller.doDelete)

module.exports = router