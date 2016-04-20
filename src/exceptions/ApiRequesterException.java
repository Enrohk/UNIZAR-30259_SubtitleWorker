package exceptions;


import java.net.URL;

public class ApiRequesterException extends Exception {

    private String errorCode = "Can not request the required url ";

    public ApiRequesterException(String message, String errorCode, URL url) {
        super(message);
        this.errorCode = errorCode + url.getPath();

    }

    public String getErrorCode() {
        return this.errorCode;
    }
}
