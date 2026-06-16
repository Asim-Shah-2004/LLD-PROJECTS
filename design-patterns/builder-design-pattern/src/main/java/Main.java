import simplebuilder.HTTP;
import simplebuilder.HTTPRequestBuilder;
import builderwithdirector.directors.CreateGetRequest;
import builderwithdirector.directors.CreatePostRequest;

public class Main {
    public static void main(String[] args) {
        //simple builder
        HTTP http = new HTTPRequestBuilder("https://google.com")
        .setMethod("GET")
        .setHeaders("Content-Type: application/json")
        .setQueryParams("q=google")
        .setTimeout("10000")
        .build();

        http.execute();

        //builder with director

        HTTPRequestBuilder httpRequestBuilder = new HTTPRequestBuilder("https://google.com");
        CreateGetRequest createGetRequest = new CreateGetRequest(httpRequestBuilder);
        createGetRequest.createGetRequest();
        HTTP http2 = httpRequestBuilder.build();
        http2.execute();

        HTTPRequestBuilder httpRequestBuilder2 = new HTTPRequestBuilder("https://google.com");
        CreatePostRequest createPostRequest = new CreatePostRequest(httpRequestBuilder2);
        createPostRequest.createPostRequest("{\"name\":\"john\",\"age\":30}");
        HTTP http3 = httpRequestBuilder2.build();
        http3.execute();

        // step builder

        stepbuilder.HTTPRequestBuilder httpRequestBuilder3 = new stepbuilder.HTTPRequestBuilder();
        stepbuilder.HTTP http4 = httpRequestBuilder3.withUrl("https://google.com")
        .setMethod("GET")
        .setHeaders("Content-Type: application/json")
        .setQueryParams("q=google")
        .setTimeout("10000")
        .build();
        http4.execute();

        stepbuilder.HTTPRequestBuilder httpRequestBuilder4 = new stepbuilder.HTTPRequestBuilder();
        stepbuilder.HTTP http5 = httpRequestBuilder4.withUrl("https://google.com")
        .setMethod("POST")
        .setHeaders("Content-Type: application/json")
        .setBody("{\"name\":\"john\",\"age\":30}")
        .build();
        http5.execute();
    }
}