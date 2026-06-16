package stepbuilder;

public interface OptionalStep {
    OptionalStep setBody(String body);
    OptionalStep setQueryParams(String queryParams);
    OptionalStep setTimeout(String timeout);
    HTTP build();
}
