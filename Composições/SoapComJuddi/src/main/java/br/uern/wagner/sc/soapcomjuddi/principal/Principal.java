package br.uern.wagner.sc.soapcomjuddi.principal;

import br.uern.wagner.sc.soapcomjuddi.juddi.encontrarJuddi;
import br.uern.wagner.sc.soapcomjuddi.modelo.Servico;
import java.net.MalformedURLException;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;




public class Principal {

	public static void main(String[] args) throws MalformedURLException, Exception {
		encontrarJuddi juddi = new encontrarJuddi();
		
		// Objetos
		Servico servico = new Servico();
        Servico servico2 = new Servico();
        Servico servico3 = new Servico();
               
        servico.setNome("server");
        servico2.setNome("WebService1");
        servico3.setNome("retornaTemperaturaHora");
        
        juddi.setServiceWSDLKey(servico, servico.getNome());
        juddi.setServiceWSDLKey(servico2, servico.getNome());
        juddi.setServiceWSDLKey(servico3, servico.getNome());
                
           
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient(servico.getWsdl());
        Object[] res = client.invoke("retornaCidade","59300000");
        String cidade = res[0].toString();
        
        client = dcf.createClient(servico2.getWsdl());
        res = client.invoke("retornaPopulacao",cidade);
        String populacao = res[0].toString();
        
        client = dcf.createClient(servico3.getWsdl());
        res = client.invoke("retornaTemperaturaHora",cidade);
        String temperatura = res[0].toString();
        
    	System.out.println("A cidade de "+cidade+" tem "+populacao+ " habitantes e está com "+temperatura+" graus!");
		
        
	}
}
