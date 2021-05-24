//Exemplo de Factory em https://www.youtube.com/watch?v=arAz2Ff8s88
//Exemplo 1 Factory
function fabricaObjeto(){
    let objeto = {}
    return objeto;
}

pessoa1 = fabricaObjeto()
pessoa2 = fabricaObjeto()

pessoa1.nome = "João"
pessoa2.nome = "Maria"

console.log(pessoa1)
console.log(pessoa2)

//Exemplo 2 Factory
function fabricarPessoa(nome, sobrenome){
    let pessoa = {}
    pessoa.nome = nome
    pessoa.sobrenome = sobrenome

    function nomeCompleto(){
        return `${pessoa.nome} ${pessoa.sobrenome}`
    }

    pessoa.nomeCompleto = nomeCompleto()
    return pessoa
}

let pessoaA = fabricarPessoa("Maria","Souza")
let pessoaB = fabricarPessoa("Marcos","Almeida")

console.log(pessoaA)
console.log(pessoaB)