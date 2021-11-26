//Equivalente ao Servlet ou View em Java MVC
const express = require('express')
const router = express.Router()

const aluno_controll = require('../controll/aluno_controll')
router.get('/academia/alunos', aluno_controll.get_alunos)
router.get('/academia/alunos/imc', aluno_controll.get_alunos_imc)
router.get('/academia/aluno/:id', aluno_controll.get_id)
router.get('/academia/aluno/imc/:id', aluno_controll.get_id_imc)
router.post('/academia/aluno/create', aluno_controll.post_aluno)
router.delete('/academia/aluno/delete/:id', aluno_controll.delete_aluno)
router.put('/academia/aluno/update', aluno_controll.put_aluno)

module.exports = router