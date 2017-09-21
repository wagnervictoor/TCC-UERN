package br.uern.wagner.sc.soapcomjuddi.principal;

import br.uern.wagner.sc.soapcomjuddi.modelo.Servico;
import java.net.MalformedURLException;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

public class Principal {
    public static void main(String[] args) throws MalformedURLException, Exception {
        
        // OBJETOS PARA CONTER OS SERVIÇOS DA COMPOSIÇÕOS.
        Servico servico1 = new Servico(); 
        Servico servico2 = new Servico();
        Servico servico3 = new Servico();
       
        // SERVIÇO PHP  
        
        servico1.setWsdl("http://192.168.0.107/php/server.php?wsdl"); 
        servico1.setOperacao("retornaCidade");
        
        // SERVIÇO C#               
        servico2.setOperacao("retonaPopulacao");  
        servico2.setWsdl("http://localhost:52610/WebService1.asmx?WSDL");
        
        // SERVIÇO JAVA 
        servico3.setOperacao("retornaTemperaturaHora");
        servico3.setWsdl("http://localhost:11371/Temperatura/retornaTemperaturaHora?WSDL");
       
        // REALIZANDO REQUISÃO PARA SERVIÇO DINÂMICAMENTE USANDO O CXF.
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();      
        Client client = dcf.createClient(servico1.getWsdl()); 
        Object[] res = client.invoke(servico1.getOperacao(),"59300000");     
        String cidade = res[0].toString();
        
        client = dcf.createClient(servico2.getWsdl()); 
        res = client.invoke(servico2.getOperacao(),cidade);   
        String populacao = res[0].toString();
        
        client = dcf.createClient(servico3.getWsdl()); 
        res = client.invoke(servico3.getOperacao(),cidade);   
        String temperatura = res[0].toString();
        
    	System.out.println("A cidade de "+cidade+" tem "+populacao+ " habitantes e está com "+temperatura+" graus!");
                
    }
}
