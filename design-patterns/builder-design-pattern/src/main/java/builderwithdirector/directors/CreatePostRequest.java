package builderwithdirector.directors;

import simplebuilder.HTTPRequestBuilder;

public class CreatePostRequest {

    HTTPRequestBuilder httpRequestBuilder;
    
    public CreatePostRequest(HTTPRequestBuilder httpRequestBuilder){
        this.httpRequestBuilder = httpRequestBuilder;
    }
    
    public void createPostRequest(String body){
        this.httpRequestBuilder.setMethod("POST");
        this.httpRequestBuilder.setHeaders("Content-Type: application/json");
        this.httpRequestBuilder.setBody(body);
    }
}
