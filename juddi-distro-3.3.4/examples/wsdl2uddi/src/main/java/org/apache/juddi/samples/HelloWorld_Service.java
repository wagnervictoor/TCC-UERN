/*
 * Copyright 2001-2010 The Apache Software Foundation.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package org.apache.juddi.samples;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;

import org.apache.juddi.v3.client.ClassUtil;


/**
 * The Hello World Service registered using WSDL2UDDI
 * 
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "HelloWorld", targetNamespace = "http://samples.juddi.apache.org/", wsdlLocation = "src/main/resources/wsdl/helloworld.wsdl")
public class HelloWorld_Service
    extends Service
{

    private final static URL HELLOWORLD_WSDL_LOCATION;
    
    private final static QName HELLOWORLD_QNAME = new QName("http://samples.juddi.apache.org/", "HelloWorld");

    static {
    	HELLOWORLD_WSDL_LOCATION = ClassUtil.getResource("/wsdl/helloworld.wsdl",HelloWorld_Service.class);
    }

    public HelloWorld_Service() {
        super(__getWsdlLocation(), HELLOWORLD_QNAME);
    }

    public HelloWorld_Service(URL wsdlLocation) {
        super(wsdlLocation, HELLOWORLD_QNAME);
    }

    public HelloWorld_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    /**
     * 
     * @return
     *     returns HelloWorld
     */
    @WebEndpoint(name = "HelloWorldImplPort")
    public HelloWorld getHelloWorldImplPort() {
        return super.getPort(new QName("http://samples.juddi.apache.org/", "HelloWorldImplPort"), HelloWorld.class);
    }

    private static URL __getWsdlLocation() {
        return HELLOWORLD_WSDL_LOCATION;
    }

}
