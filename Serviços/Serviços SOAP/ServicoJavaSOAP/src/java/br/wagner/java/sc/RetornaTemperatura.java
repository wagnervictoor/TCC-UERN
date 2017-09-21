/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.wagner.java.sc;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author wellisonraul
 */
@WebService(serviceName = "RetornaTemperatura")
public class RetornaTemperatura {

    /**
     * This is a sample web service operation
     * @param cidade
     * @return 
     */
    @WebMethod(operationName = "retornaTemperatura")
     public String retornaTemperaturHora(@WebParam(name = "name") String cidade) {
        HttpURLConnection connection = null;
        
        String resp ,temp = "";
        StringBuilder sb;
        try{
            URL url =null;
            switch (cidade) {
                case "CAICO":
                    url = new URL("http://api.openweathermap.org/data/2.5/weather?id=3404117&appid=2c27513777c8318b929014f4fcf3a9cd&units=metric&lang=pt&mode=xml");
                    break;
                case "SANTA CRUZ":
                    url = new URL("http://api.openweathermap.org/data/2.5/weather?id=3389673&appid=2c27513777c8318b929014f4fcf3a9cd&units=metric&lang=pt&mode=xml");
                    break;
                case "CURRAIS NOVOS":
                    url = new URL("http://api.openweathermap.org/data/2.5/weather?id=3401283&appid=2c27513777c8318b929014f4fcf3a9cd&units=metric&lang=pt&mode=xml");
                    break;
                case "JARDIM DO SERIDO":
                    url = new URL("http://api.openweathermap.org/data/2.5/weather?id=3397560&appid=2c27513777c8318b929014f4fcf3a9cd&units=metric&lang=pt&mode=xml");
                    break;
                case "JARDIM DE PIRANHA":
                    url = new URL("http://api.openweathermap.org/data/2.5/weather?id=3397562&appid=2c27513777c8318b929014f4fcf3a9cd&units=metric&lang=pt&mode=xml");
                    break;
                default:
                    break;
            }
            connection = (HttpURLConnection)url.openConnection();
            InputStream content = connection.getInputStream();
            int data = content.read();
            
            int ch;
            sb = new StringBuilder();
            while((ch = content.read()) != -1) sb.append((char)ch);

            System.out.println(sb);
            
            resp = sb.toString();
            
            for (int i = 0; i < resp.length(); i++)
                {
                    if (resp.charAt(i)==118 && resp.charAt(i+1)==97)
                    {
                        System.out.println(resp.charAt(i)+resp.charAt(i+1));
                        temp = "" + resp.charAt(i + 7) + resp.charAt(i + 8);
                        break;
                    }
                }
        }catch(Exception e){
            System.out.println("Não possível receber informações da API!");
        }
        
        return temp;
    }
}
