const express = require('express')
const router = express.Router()

const funcionarioControll = require('../controllers/FuncionarioController.js')
router.get('/irrf/funcionarios', funcionarioControll.getFuncionarios)
router.get('/irrf/funcionarios/:matricula', funcionarioControll.getFuncionarioMatricula)
router.post('/irrf/funcionarios/create', funcionarioControll.postFuncionario)
router.put('/irrf/funcionarios/update', funcionarioControll.putFuncionario)
router.delete('/irrf/funcionarios/delete/:matricula', funcionarioControll.deleteFuncionario)

module.exports = router