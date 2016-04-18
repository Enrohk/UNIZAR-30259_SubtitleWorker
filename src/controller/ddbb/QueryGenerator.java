package controller.ddbb;


public class QueryGenerator {

    public static final String GET_WORK_BY_NAME = "from Work where title=";
    public static final String GET_SUBTITLES_BY_WORK_ID = "from Subtitle where workIdWork=";
    public static final String GET_LANGUAGE_BY_NAME = "from Language where name=";
    public static final String GET_LANGUAGE_LIST = "from Language";

}
