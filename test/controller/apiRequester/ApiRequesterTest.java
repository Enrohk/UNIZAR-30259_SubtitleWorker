package controller.apiRequester;


import org.junit.Test;

import java.net.MalformedURLException;


public class ApiRequesterTest {

    @Test(expected = MalformedURLException.class)
    public void testRequestWithNullParam() throws Exception
    {
        controller.apiRequester.ApiRequester.request(null);
    }
}