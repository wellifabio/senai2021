<?php

/* 
    Para que este código funcione copie este arquivo para c:\xampp\htdocs\pasta
    Além disso você precisa abrir o XAMPP Control Panel e dar Start no Apache
    Para ver o resultado abra o navegador e digite http://localhost/pasta
*/

//Entrada de dados feita através de um formulário HTML
echo "<form method='get'>
        <input type='text' placeholder='digite um nome' name='entrada'>
        <input type='submit' value='Enviar'>
    </form>";

//Processamento dos dados vindos via GET em PHP
if(empty($_GET['entrada'])){
    echo "Aguardando dados";
}else{
    $texto = $_GET['entrada'];
    $comprimento = strlen($texto);
    echo "Opa chegou o nome ".$texto;
    echo " com ".$comprimento." caracteres";  
}  
?>
