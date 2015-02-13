
package webservices;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;


@WebService(serviceName = "TwitterImmobilierWS")
public class TwitterImmobilierWS {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "operation")
    public String operation(@WebParam(name = "parameter") String parameter, @WebParam(name = "parameter1") String parameter1) {
        //TODO write your implementation code here:
        return null;
    }
}
