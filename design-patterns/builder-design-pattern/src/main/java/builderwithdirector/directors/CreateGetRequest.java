package builderwithdirector.directors;

import simplebuilder.HTTPRequestBuilder;

public class CreateGetRequest {

    HTTPRequestBuilder httpRequestBuilder;
    
    public CreateGetRequest(HTTPRequestBuilder httpRequestBuilder){
        this.httpRequestBuilder = httpRequestBuilder;
    }
    
    public void createGetRequest(){
        this.httpRequestBuilder.setMethod("GET");
        this.httpRequestBuilder.setHeaders("Content-Type: application/json");
    }
}
