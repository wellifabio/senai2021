const express = require('express')
const router = express.Router()
const controller = require('../controllers/funcionarios.js')

router.get('/irrf/read',controller.doGet)
router.get('/irrf/read/:matricula',controller.doGet)
router.post('/irrf/create',controller.doPost)
router.put('/irrf/update',controller.doPut)
router.delete('/irrf/delete/:matricula',controller.doDelete)

module.exports = router