package controller.ddbb.dto;

import controller.ddbb.DataBaseManager;
import controller.security.PassCrypt;
import exceptions.DBException;
import model.ddbb.entity.User;

public class UserDTO {

    private String name;
    private String inputPass;
    private String mail;

    public UserDTO (String name, String inputPass, String mail)
    {
        this.name = name;
        this.inputPass = inputPass;
        this.mail = mail;
    }

    public boolean registerUser () throws DBException {
        User user = new User();
        user.setEmail(mail);
        user.setPass(PassCrypt.cryptPassword(inputPass));
        user.setUsername(name);
        try{
            DataBaseManager.saveOrDeleteSingleObject(user,true);
        }
        catch (Exception e)
        {
            throw new DBException("Register fail");
        }

        return true;
    }

    public boolean validateUser ()
    {

        if(inputPass != null && inputPass.length() > 0)
            if(PassCrypt.checkPassword(inputPass,getCryptPassFromDB()))
            return true;
        return false;
    }


    private String getCryptPassFromDB() {
        return "1";
    }

    public static boolean isValidName(String name) {

        return true;
    }
}
