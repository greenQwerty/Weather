package rest_assured;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;

class Specification {
    private RequestSpecification specification = new RequestSpecBuilder()
            .log(LogDetail.ALL)
            .setRelaxedHTTPSValidation()
            .setContentType(ContentType.JSON).build();


    RequestSpecification getSpecification(String url, Map<String, ?> headers, Map<String, ?> params, Object body, String login, String pass) {
        return given()
                .auth()
                .preemptive()
                .basic(login, pass)
                .spec(specification.baseUri(url).headers(headers).params(params).body(body));
    }

    RequestSpecification getSpecification(String url, Map<String, ?> headers, Map<String, ?> params) {
        return given().spec(specification.baseUri(url).headers(headers).params(params));
    }
}
