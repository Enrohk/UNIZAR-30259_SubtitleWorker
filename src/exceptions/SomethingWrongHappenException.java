package exceptions;


import java.net.URL;

public class SomethingWrongHappenException extends Exception {

    private String errorCode = "Something impossible happen ";

    public String getErrorCode() {
        return this.errorCode;
    }

}