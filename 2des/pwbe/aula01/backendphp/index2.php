<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BackEnd com PHP dentro do HTML</title>
</head>
<body>
    <form method='get'>
        <input type='text' placeholder='digite um nome' name='entrada'>
        <input type='submit' value='Enviar'>
    </form>
    <?php
        if(empty($_GET['entrada'])){
            echo "Aguardando dados";
        }else{
            $texto = $_GET['entrada'];
            $comprimento = strlen($texto);
            echo "Opa chegou o nome ".$texto;
            echo " com ".$comprimento." caracteres";  
        }
    ?>
</body>
</html>