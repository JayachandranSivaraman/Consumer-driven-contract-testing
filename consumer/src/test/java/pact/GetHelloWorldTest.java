package pact;

import au.com.dius.pact.consumer.*;
import au.com.dius.pact.model.PactFragment;
import org.junit.Rule;
import org.junit.Test;
import utils.Configuration;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class GetHelloWorldTest
{
    @Rule
    public PactRule rule = new PactRule(Configuration.MOCK_HOST, Configuration.MOCK_HOST_PORT, this);
    private DslPart employeeResults;
    private DslPart saleryResults;

    @Pact(state = "Employee", provider = "Employee_provider", consumer = "Employee_consumer")
    public PactFragment createEmployeeFragment(ConsumerPactBuilder.PactDslWithProvider.PactDslWithState builder)
    {
        employeeResults = new PactDslJsonBody()
                .id()
                .stringType("name")
                .stringType("employee_id")
                .stringType("department")
                .stringType("test")
                .asBody();

        return builder
                .uponReceiving("get hello world response")
                .path("/get-employees")
                .method("GET")
                .willRespondWith()
                .status(200)
                .headers(Configuration.getHeaders())
                .body(employeeResults)
                .toFragment();
    }

    @Pact(state = "Salery", provider = "Salery_provider", consumer = "Salery_consumer")
    public PactFragment createSaleryFragment(ConsumerPactBuilder.PactDslWithProvider.PactDslWithState builder)
    {
        saleryResults = new PactDslJsonBody()
                .stringType("basicPay")
                .stringType("allowances")
                .asBody();

        return builder
                .uponReceiving("get hello world response")
                .path("/get-salery")
                .method("GET")
                .willRespondWith()
                .status(200)
                .headers(Configuration.getHeaders())
                .body(saleryResults)
                .toFragment();
    }

    @Test
    @PactVerification("Employee")
    public void shouldGetEmployees() throws IOException
    {
        DummyConsumer restClient = new DummyConsumer(Configuration.SERVICE_URL);
        assertEquals(employeeResults.toString(), restClient.getHelloWorld("/get-employees"));
    }

    @Test
    @PactVerification("Salery")
    public void shouldGetSalery() throws IOException
    {
        DummyConsumer restClient = new DummyConsumer(Configuration.SERVICE_URL);
        assertEquals(saleryResults.toString(), restClient.getHelloWorld("/get-salery"));
    }
}
