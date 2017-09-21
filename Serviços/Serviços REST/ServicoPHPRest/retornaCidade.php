<?php

	
require 'Slim/Slim.php';

\Slim\Slim::registerAutoloader();

	
$app = new \Slim\Slim();

	

$app->get('/retornacidade/:dados', function($dados) {
	
		
	if($dados==59300000){

			
		echo "CAICO";	

		
	}else if($dados==59200000){
	
		
		echo "SANTA CRUZ";
		

	} else if($dados == 59380000){
			

		echo "CURRAIS NOVOS";
		

	}else if($dados== 59343000){
			

		echo "JARDIM DO SERIDO";
		

	}else if($dados== 59324000){
			

		echo "JARDIM DE PIRANHA";
		

	}else{
			

		echo "cidade $dados  nao cadastrada";
		

	}
});


	

$app->run();

?>
