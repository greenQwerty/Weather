package Steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.bg.И;
import org.junit.Assert;


import java.util.Map;

import static Steps.RequestsSteps.getResponse;

public class ResponseSteps {

    @И("^проверили полученный ответ:$")
    public void checkResponse(DataTable params) {
        Map param = params.asMap(String.class, String.class);
        param.forEach((k, v) ->
                Assert.assertEquals("Значения не верны", v, getResponse().jsonPath().get((String) k).toString()));
    }
}
