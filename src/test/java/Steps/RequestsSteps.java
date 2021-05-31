package Steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.bg.И;
import io.restassured.response.Response;
import rest_assured.RequestMethod;
import rest_assured.ResponseRA;

import java.util.HashMap;
import java.util.Map;

public class RequestsSteps {
    private static Response response;
    private ResponseRA responseRA = new ResponseRA();
    private Map<String, ?> httpHeaders = new HashMap<>();

    public static Response getResponse() {
        return response;
    }

    @И("^проставили headers для отправки запроса:$")
    public void configRequestToMS(DataTable headersParam) throws Exception {
        httpHeaders = headersParam.asMap(String.class, String.class);
    }

    @И("^отправили запрос на URL - \"(.*)\", эндпоинт - \"(.*)\", метод = (GET|POST|PUT|DELETE) с параметрами:$")
    public void sendRequestWithParams(String url, String endpoint, RequestMethod method, DataTable params) throws Exception {
        Map param = params.asMap(String.class, String.class);
        response = responseRA.getResponse(url, httpHeaders, endpoint, method, param);
        response.prettyPrint();
    }
}
