package controller.ddbb.dto;

import controller.ddbb.DataBaseManager;
import controller.ddbb.QueryStrings;
import controller.security.PassCrypt;
import exceptions.DBException;
import model.ddbb.entity.User;
import java.util.List;
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

    public boolean validateUser () throws DBException {

        if(inputPass != null && inputPass.length() > 0)
            if(PassCrypt.checkPassword(inputPass,getCryptPassFromDB()))
            return true;
        return false;
    }


    private String getCryptPassFromDB() throws DBException {
        return getUserFromDBByName(name).getPass();
    }

    public static boolean isValidName(String name) {

        try {
            getUserFromDBByName(name);
            return true;
        }
        catch (DBException e)
        {
            return false;
        }
    }

    private static User getUserFromDBByName (String name) throws DBException {

        String query = QueryStrings.GET_USER_BY_NAME  + "'" + name + "'";
        List dbResultList = DataBaseManager.getListByQuery(query);
        if(dbResultList != null && dbResultList.size()==1)
        {
            return ((User) dbResultList.get(0));
        }
        throw new DBException("User not found");

    }
}
