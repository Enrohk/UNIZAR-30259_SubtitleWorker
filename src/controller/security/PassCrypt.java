package controller.security;


import org.jasypt.util.password.StrongPasswordEncryptor;

public class PassCrypt {

    private static StrongPasswordEncryptor passCrypt= new StrongPasswordEncryptor ();

    public static boolean checkPassword(String nonCrypt, String crypt)
    {
        return passCrypt.checkPassword(nonCrypt, crypt);
    }

    public static String cryptPassword (String password)
    {
        return passCrypt.encryptPassword(password);
    }

}
