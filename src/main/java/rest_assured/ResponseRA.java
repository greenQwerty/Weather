package rest_assured;

import io.restassured.response.Response;
import io.restassured.specification.RequestSenderOptions;
import io.restassured.specification.RequestSpecification;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;


public class ResponseRA {
    Specification spec = new Specification();

    public Response getResponse(String url, Map headers, String endpoint, RequestMethod methodName, Map<String, ?> params) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, URISyntaxException {
        RequestSpecification requestSpecification = spec.getSpecification(url, headers, params);
        Method method = requestSpecification.getClass().getDeclaredMethod(methodName.toString().toLowerCase(), URI.class);
        return (Response) method.invoke(requestSpecification, new URI(endpoint));
    }

    public Response getResponse(String url, Map headers, String endpoint, RequestMethod methodName, String body, Map<String, ?> params, String login, String pass) throws Exception {
        RequestSpecification requestSpecification = spec.getSpecification(url, headers, params, body, pass, login);
        Method method = RequestSenderOptions.class.getDeclaredMethod(methodName.toString().toLowerCase(), URI.class);
        return (Response) method.invoke(requestSpecification, new URI(endpoint));
    }
}
