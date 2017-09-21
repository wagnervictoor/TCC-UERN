package br.uern.wagner.sc.restsemjuddi.principal;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class Principal {

	public static void main(String[] args) {
		
		String cep = "59300000";
		
		// CONSULTA SERVIÇO PHP
		Client cliente = ClientBuilder.newClient();
		WebTarget caminho = cliente.target("http://localhost:30301/ServicoPHPRest/retornacidade/").path(cep);
		Response resposta = null;
		
		try{
			// RECEBE CIDADE
			resposta = caminho.request().get(); 	
			String cidade = resposta.readEntity(String.class);
			
			// CONSULTA SERVIÇO JAVA
			caminho = cliente.target("http://localhost:44801/ServicoJavaRest/webresources/generic/").path(cidade);
			resposta = caminho.request().get(); 
			String temperatura = resposta.readEntity(String.class);
                        
            // CONSULTA SERVIÇO C#
			caminho = cliente.target("http://localhost:50009/api/retornaPopulacao/retornaPopulacao/").path(cidade);
			resposta = caminho.request().get(); 
			String populacao = resposta.readEntity(String.class);
			
			System.out.println("A cidade de "+cidade+" tem "+populacao+ " habitantes e está com "+temperatura+" graus!");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Houve problema na composição");
		}
	}
}
