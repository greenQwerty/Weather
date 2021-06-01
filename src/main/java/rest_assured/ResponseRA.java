package rest_assured;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;


public class ResponseRA {
    private final Specification spec = new Specification();

    public Response getResponse(String url, Map headers, String endpoint, RequestMethod methodName, Map<String, ?> params) throws Exception {
        RequestSpecification requestSpecification = spec.getSpecification(url, headers, params);
        return reflectionOperation(requestSpecification, endpoint, methodName);
    }

    public Response getResponse(String url, Map headers, String endpoint, RequestMethod methodName, String body, Map<String, ?> params, String login, String pass) throws Exception {
        RequestSpecification requestSpecification = spec.getSpecification(url, headers, params, body, pass, login);
        return reflectionOperation(requestSpecification, endpoint, methodName);
    }

    private Response reflectionOperation(RequestSpecification requestSpecification, String endpoint, RequestMethod methodName) throws NoSuchMethodException, URISyntaxException, InvocationTargetException, IllegalAccessException {
        Method method = requestSpecification.getClass().getDeclaredMethod(methodName.toString().toLowerCase(), URI.class);
        return (Response) method.invoke(requestSpecification, new URI(endpoint));
    }
}
