package controller.ddbb.dto;

import java.util.*;

import controller.ddbb.DataBaseManager;
import controller.ddbb.QueryGenerator;
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
            String query = QueryGenerator.GET_WORK_BY_NAME + "'" + name + "'";
            List workList = DataBaseManager.getListByQuery(query);
            if (workList.size() == 1) {
                Work work = (Work) workList.get(0);
                this.description = work.getDescription();
                this.title = work.getTitle();
                this.id = work.getIdWork();
                query = QueryGenerator.GET_SUBTITLES_BY_WORK_ID + "'" + this.id + "'";
                this.subtitleList = (List<Subtitle>) DataBaseManager.getListByQuery(query);
            }

        } catch (Exception e) {
            throw new DBException("Cant build WOrkDTO for " + name);
        }

    }

    public List<Subtitle> getSubtitleList() {
        return subtitleList;
    }
}
