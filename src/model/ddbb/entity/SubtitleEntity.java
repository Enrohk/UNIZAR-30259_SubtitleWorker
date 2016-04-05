package model.ddbb.entity;

import java.io.InputStream;
import java.sql.Clob;

public class SubtitleEntity
{

    private int id;
    private String title;
    private String type;
    private Clob content;
    private String language;

    public String getLanguage ()
    {
        return language;
    }

    public void setLanguage (String language)
    {
        this.language = language;
    }

    public int getId ()
    {
        return id;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    public Clob getContent ()
    {
        return content;
    }

    public void setContent (Clob content)
    {
        this.content = content;
    }
}
