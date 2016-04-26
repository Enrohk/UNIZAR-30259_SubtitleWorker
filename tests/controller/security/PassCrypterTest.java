package controller.security;


import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;


public class PassCrypterTest {


    @Test
    public void testEncryptDecrypt ()
    {
        String passToCrypt = "passStrange@-.12321RW";
        String crypt = PassCrypt.cryptPassword (passToCrypt);
        assertTrue ( PassCrypt.checkPassword(passToCrypt, crypt));
    }

    @Test
    public void testEncryptDecryptFalse ()
    {
        String passToCrypt = "passStrange@-.12321RW";
        String falsePass = "passStrange@-.12321RW-FALSE";
        String crypt = PassCrypt.cryptPassword (passToCrypt);
        assertFalse ( PassCrypt.checkPassword(falsePass, crypt));
    }
}
