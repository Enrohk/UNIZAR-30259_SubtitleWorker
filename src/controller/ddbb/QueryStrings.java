package controller.ddbb;


import controller.functions.Literals;

public class QueryStrings {

    public static final String GET_WORK_BY_NAME = "from Work where title=";
    public static final String GET_SUBTITLES_BY_WORK_ID = "from Subtitle where workIdWork=";
    public static final String GET_LANGUAGE_BY_NAME = "from Language where name=";
    public static final String GET_LANGUAGE_LIST = "from Language";
    public static final String GET_WORK_LIST = "from Work";
    public static final String GET_USER_BY_NAME = "from User where username=";
    public static final String getComentsBySubtitleId = "from UserComentSubtitle where subtitleIdSubtitle=" ;

    public static String getSubtitleQuery (int workId, String lang)
    {
        if(lang.equals(Literals.LIST_FIRST_ITEM))
        {
            return QueryStrings.GET_SUBTITLES_BY_WORK_ID + "'" + workId + "'";
        }
        else
        {
            return "select subtitle from Subtitle subtitle, Language language where subtitle.languageIdLanguage = language.idLanguage and language.name='"+lang+"' and subtitle.workIdWork='"+workId+"'";
        }
    }


}
