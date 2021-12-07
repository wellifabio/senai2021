const express = require('express')
const router = express.Router()
const controller = require('../controllers/servicos.js')

router.get('/servicos/:id',  controller.doGet)
router.get('/servicos',  controller.doGetAll)
router.post('/servicos', controller.doPost)
router.put('/servicos', controller.doPut)
router.delete('/servicos', controller.doDelete)

module.exports = router