package model.ddbb.entity;

import java.io.InputStream;
import java.util.List;

public class WorkEntity
{

    private int id;
    private String tittle;
    private InputStream description;
    private List<SubtitleEntity> subtitleList;

    public int getId ()
    {
        return id;
    }

    public String getTittle ()
    {
        return tittle;
    }

    public void setTittle (String tittle)
    {
        this.tittle = tittle;
    }

    public InputStream getDescription ()
    {
        return description;
    }

    public void setDescription (InputStream description)
    {
        this.description = description;
    }

    public List<SubtitleEntity> getSubtitleList ()
    {
        return subtitleList;
    }

    public void setSubtitleList (List<SubtitleEntity> subtitleList)
    {
        this.subtitleList = subtitleList;
    }
}
