package stepbuilder;

public class HTTP {

    String url;
    String method;
    String body;
    String headers;
    String queryParams;
    String timeout;
    
    HTTP(){}

    public void execute(){
        if(url == null || url.isBlank()){
            throw new IllegalStateException("URL is required");
        }

        if(method == null || method.isBlank()){
            throw new IllegalStateException("Method is required");
        }

        System.out.println("Executing HTTP request with URL: " + url);
        System.out.println("Method: " + method);
        System.out.println("Body: " + body);
        System.out.println("Headers: " + headers);
        System.out.println("Query Params: " + queryParams);
        System.out.println("Timeout: " + timeout);
    }

}