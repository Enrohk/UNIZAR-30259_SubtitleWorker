package controller.functions;


import controller.ddbb.DataBaseManager;
import controller.ddbb.dto.UserDTO;
import controller.facade.GuiFacade;
import controller.facade.GuiItems;
import controller.facade.MainFacade;
import controller.security.PassCrypt;
import exceptions.DBException;
import gui.factory.FactoryDialog;

public class LogFunctions {

    public static boolean logIn() throws DBException {

        UserDTO userDto = getUserInput(false);

        if (userDto.validateUser()) {
            start(userDto);
            return true;
        } else {
            FactoryDialog.invalidLogin();
            return false;
        }


    }

    public static boolean registerPanel() throws DBException {
        int registerClickResponse = FactoryDialog.registerGUIDialog();

        if (registerClickResponse == 0) {
            UserDTO registerUser = getUserInput(true);
            if (registerUser != null) {
                try{
                    registerUser.registerUser();
                }
                catch (DBException e)
                {
                    System.out.println(e);
                    System.exit(-1);
                }

                start(registerUser);
                return true;
            }
        }
        return false;

    }

    private static UserDTO getUserInput(boolean isRegisterInput) {
        String name, pass, mail, pass2;
        name = GuiItems.getLogInNameJTF().getText();
        pass = GuiItems.getLogInPassJTF().getText();
        if (isRegisterInput) {
            pass2 = GuiItems.getRegisterPassJTF().getText();
            mail = GuiItems.getRegisterEmailJTF().getText();

            if (validDataInput(pass, pass2, mail,name, isRegisterInput))
            {
                return new UserDTO(name, pass, mail);
            }

            else
                return null;
        } else {
            return new UserDTO(name, pass, "");
        }
    }

    private static boolean validDataInput(String pass1, String pass2, String mail, String name, boolean isRegisterInput) {
        if (Functions.isValidMail(mail))
            if (pass1.equals(pass2))
                if (isRegisterInput)
                {
                    if(!UserDTO.isValidName(name))
                        return true;
                    else
                        FactoryDialog.nameErrorRegister();
                }
                else
                {
                    if(!UserDTO.isValidName(name))
                        return true;
                    else
                        FactoryDialog.nameErrorRegister();
                }
            else
                FactoryDialog.passErrorRegister();
        else
            FactoryDialog.mailErrorRegister();
        return false;
    }

    private static void start(UserDTO userDto) {

        if (GuiItems.isKeepLogged())
        {
            MainFacade.logged(userDto, true);
        }
        else{
            MainFacade.logged(userDto,false);
        }
        GuiFunctions.showGUI();
    }

    public static void updateUser() throws DBException {
        UserDTO updateUser = getUserInput(true);
        DataBaseManager.saveOrDeleteSingleObject(updateUser.generateUser(),true);
    }
}
