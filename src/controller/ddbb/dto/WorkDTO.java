package controller.ddbb.dto;

import java.util.*;

import controller.ddbb.DataBaseManager;
import controller.ddbb.QueryStrings;
import exceptions.DBException;
import model.ddbb.entity.*;

public class WorkDTO {

    private int id;
    private String title;
    private byte[] description;
    private List<Subtitle> subtitleList;

    public String getTitle() {
        return title;
    }

    public byte[] getDescription() {
        return description;
    }

    public WorkDTO(String name) throws DBException {
        try {
            String query = QueryStrings.GET_WORK_BY_NAME + "'" + name + "'";
            List workList = DataBaseManager.getListByQuery(query);
            if (workList.size() == 1) {
                Work work = (Work) workList.get(0);
                this.description = work.getDescription();
                this.title = work.getTitle();
                this.id = work.getIdWork();
                query = QueryStrings.GET_SUBTITLES_BY_WORK_ID + "'" + this.id + "'";
                this.subtitleList = (List<Subtitle>) DataBaseManager.getListByQuery(query);
            }

        } catch (Exception e) {
            throw new DBException("Cant build WOrkDTO for " + name);
        }

    }

    public List<Subtitle> getSubtitleList() {
        return subtitleList;
    }

    public static List<String> getWorkTitleList () throws DBException
    {
        try {
            String query = QueryStrings.GET_WORK_LIST;
            List workList = DataBaseManager.getListByQuery(query);
            List<String> workTitleList = new ArrayList<String>();
            String title;
            for (Object o : workList)
            {
                title = ((Work)o).getTitle();
                workTitleList.add(title);
            }
            return workTitleList;



        } catch (Exception e) {

             throw new DBException();
        }

    }
}
