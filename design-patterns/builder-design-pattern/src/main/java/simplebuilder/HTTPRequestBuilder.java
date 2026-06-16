package simplebuilder;

public class HTTPRequestBuilder {

    private HTTP http = new HTTP();

    public HTTPRequestBuilder(String url){
        this.http.url = url;
    }

    public HTTPRequestBuilder setMethod(String method){
        this.http.method = method;
        return this;
    }

    public HTTPRequestBuilder setBody(String body){
        this.http.body = body;
        return this;
    }

    public HTTPRequestBuilder setHeaders(String headers){
        this.http.headers = headers;
        return this;
    }

    public HTTPRequestBuilder setQueryParams(String queryParams){
        this.http.queryParams = queryParams;
        return this;
    }

    public HTTPRequestBuilder setTimeout(String timeout){
        this.http.timeout = timeout;
        return this;
    }

    public HTTP build(){

        if(this.http.url == null || this.http.url.isBlank()){
            throw new IllegalStateException("URL is required");
        }

        if(this.http.method == null || this.http.method.isBlank()){
            throw new IllegalStateException("Method is required");
        }

        return this.http;
    }
}
