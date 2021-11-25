//Equivalente ao Servlet ou View em Java MVC
const express = require('express')
const router = express.Router()

const aluno_controll = require('../controll/aluno_controll')
router.get('/academia/alunos/', aluno_controll.get_alunos)
router.get('/academia/alunos/imc/', aluno_controll.get_alunos_imc)
router.get('/academia/aluno/:id', aluno_controll.get_id)
router.get('/academia/aluno/imc/:id', aluno_controll.get_imc_id)
module.exports = router