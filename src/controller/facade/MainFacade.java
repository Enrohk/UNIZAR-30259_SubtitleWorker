package controller.facade;


import exceptions.SomethingWrongHappenException;

import javax.swing.*;

public class MainFacade
{

    public static void closeProgram (int closeOption) throws SomethingWrongHappenException
    {
        switch (closeOption)
        {
            case JOptionPane.YES_OPTION:
                //Sure we must do more shit
                System.exit(1);
                break;

            case JOptionPane.NO_OPTION:
                //DO nothing
                break;

            case JOptionPane.CLOSED_OPTION:
                //Do nothing
                break;

            default:
                throw new SomethingWrongHappenException();
        }
    }


}
