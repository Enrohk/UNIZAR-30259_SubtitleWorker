package controller.functions;


import model.ddbb.entity.Language;
import model.ddbb.entity.Work;

public class Functions {

    public static int getObjectIDByType (String type, Object o)
    {
        switch (type)
        {
            case Lirerals.LANGUAGE_TYPE :
                return ((Language) o).getIdLanguage();
            case Lirerals.WORK_TYPE :
                return ((Work) o ).getIdWork();

            default:
                return -1;
        }
    }

}
