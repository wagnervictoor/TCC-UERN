<?php
require_once('lib/nusoap.php');

// Criando instância do servidor
$server = new soap_server();
$server->configureWSDL('server', 'ServidorPHP');
$server->wsdl->schemaTargetNamespace = 'ServidorPHP';

//Registrando o metodo ''retonaCidade" para exposição
$server->register('retornaCidade',
         array('cep' => 'xsd:string'),   // parametros
         array('return' => 'xsd:string'),     // saida
         'ServidorPHP',                        // Nome do servidor
         'ServidorPHP#retornaCidadeServer',            // ação SOAP
         'rpc',                               // estilo
         'encoded',                           // usando
         'Just say retornaCidade');                   // descrição

//implementando o metodo "retornaCidade"como função PHP.
function retornaCidade($cep) {
	if($cep=="59300000"){
		return "CAICO";	
	}else if($cep==59200000){
		return "SANTA CRUZ";
	} else if($cep == 59380000){
		return "CURRAIS NOVOS";
	}else if($cep== 59343000){
		return "JARDIM DO SERIDO";
	}else if($cep== 59324000){
		return "JARDIM DE PIRANHA";
	}else{
		return 'Cep nao cadastrado: ' .$cep;	
	}
}

$server->service(file_get_contents("php://input"));
?>