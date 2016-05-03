package controller.functions;


import controller.ddbb.dto.UserDTO;
import controller.facade.GuiFacade;
import controller.facade.GuiItems;
import controller.facade.MainFacade;
import controller.security.PassCrypt;
import exceptions.DBException;
import gui.factory.FactoryDialog;

public class LogFunctions {

    public static void logIn() throws DBException {

        UserDTO userDto = getUserInput(false);

        if (userDto.validateUser()) {
            start(userDto);
        } else {
            FactoryDialog.invalidLogin();
        }


    }

    public static void registerPanel() throws DBException {
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
            }
        } else if (registerClickResponse == 1)
            GuiFacade.start();
        else
            System.exit(0);


    }


    private static UserDTO getUserInput(boolean isRegisterInput) {
        String name, pass, mail, pass2;
        name = GuiItems.getLogInNameJTF().getText();
        pass = GuiItems.getLogInPassJTF().getText();
        if (isRegisterInput) {
            pass2 = GuiItems.getRegisterPassJTF().getText();
            mail = GuiItems.getRegisterEmailJTF().getText();

            if (validDataInput(pass, pass2, mail,name))
            {
                return new UserDTO(name, pass, mail);
            }

            else
                return null;
        } else {
            return new UserDTO(name, pass, "");
        }
    }

    private static boolean validDataInput(String pass1, String pass2, String mail, String name) {
        if (Functions.isValidMail(mail))
            if (pass1.equals(pass2))
                if(UserDTO.isValidName(name))
                    return true;
                else
                    FactoryDialog.nameErrorRegister();
            else
                FactoryDialog.passErrorRegister();
        else
            FactoryDialog.mailErrorRegister();
        return false;
    }

    private static void start(UserDTO userDto) {
        if (GuiItems.isKeepLogged()) MainFacade.logged(userDto, true);
        GuiFunctions.showGUI();
    }
}
