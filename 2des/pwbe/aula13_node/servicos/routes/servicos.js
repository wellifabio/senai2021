const express = require('express')
const router = express.Router()
const controller = require('../controllers/servicos.js')

router.get('/servicos',  controller.doGet)
router.post('/servicos', (req, res) => { res.json("Oi sou o Node POST") })
router.put('/servicos', (req, res) => { res.json("Oi sou o Node PUT") })
router.delete('/servicos', (req, res) => { res.json("Oi sou o Node DELETE") })

module.exports = router