package br.uern.wagner.principal;

import br.uern.wagner.juddi.encontrarJuddi;
import br.uern.wagner.modelo.Servico;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class Principal {

	public static void main(String[] args){
		encontrarJuddi juddi = new encontrarJuddi();
		Servico servico = new Servico();
		
		servico.setNome("Servicename"); // NOME DO SERVIÇO QUE CONTÉM UM WSDL GERADO
		juddi.setServiceWSDLKey(servico, servico.getNome());
		String operacoes[] = new String[3]; // SERÃO CAPTURADOS 3 URIS
		operacoes = servico.getWsdl().split(";");
		
		String cep = "59300000";
		
		Client cliente = ClientBuilder.newClient();
		WebTarget caminho;
		Response resposta = null;
		
		try{
			caminho = cliente.target(operacoes[0]).path(cep);
			resposta = caminho.request().get();
			String cidade = resposta.readEntity(String.class);
			
			caminho = cliente.target(operacoes[1]).path(cidade);
			resposta = caminho.request().get();
			String temperatura = resposta.readEntity(String.class);
			
			caminho = cliente.target(operacoes[2]).path(cidade);
			resposta = caminho.request().get();
			String populacao = resposta.readEntity(String.class);
			
			System.out.println("A cidade de "+cidade+" tem "+populacao+ " habitantes e está com "+temperatura+" graus!");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Houve problema na composição");
		}
		
		
		
	}
}
