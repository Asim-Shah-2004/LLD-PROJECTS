package stepbuilder;

public class HTTPRequestBuilder implements URLStep, MethodStep, HeaderStep, OptionalStep {

    private String url;
    private String method;
    private String headers;
    private String body;
    private String queryParams;
    private String timeout;

    @Override
    public MethodStep withUrl(String url) {
        this.url = url;
        return this;
    }

    @Override
    public HeaderStep setMethod(String method) {
        this.method = method;
        return this;
    }

    @Override
    public OptionalStep setHeaders(String headers) {
        this.headers = headers;
        return this;
    }

    @Override
    public OptionalStep setBody(String body) {
        this.body = body;
        return this;
    }

    @Override
    public OptionalStep setQueryParams(String queryParams) {
        this.queryParams = queryParams;
        return this;
    }

    @Override
    public OptionalStep setTimeout(String timeout) {
        this.timeout = timeout;
        return this;
    }

    public HTTP build(){
        
        if(this.url == null || this.url.isBlank()){
            throw new IllegalStateException("URL is required");
        }

        if(this.method == null || this.method.isBlank()){
            throw new IllegalStateException("Method is required");
        }

        HTTP http = new HTTP();
        http.url = this.url;
        http.method = this.method;
        http.headers = this.headers;
        http.body = this.body;
        http.queryParams = this.queryParams;
        http.timeout = this.timeout;
        return http;
    }
}
