package controller.apiRequester;


import exceptions.ApiRequesterException;

import java.net.MalformedURLException;
import java.net.URL;

public class ApiRequester {

    public static boolean request(String api) throws ApiRequesterException, MalformedURLException{
        URL apiURL = new URL(api);
        return true;
    }

}
