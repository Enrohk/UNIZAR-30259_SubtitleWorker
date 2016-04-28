package controller.functions;

import controller.ddbb.dto.SubtitleDTO;
import controller.ddbb.dto.WorkDTO;
import exceptions.DBException;

import java.util.ArrayList;
import java.util.List;


public class Mocker {

public static WorkDTO work;
public static List<SubtitleDTO> subtitles;
    public static void generateMocks()
    {

        work = new WorkDTO();
        work.setTitle("Mock Work Title");
        work.setId(0);
        work.setDescription(new String("Mock Work Description").getBytes());
        getSubtitles();

        work.setSubtitleList(subtitles);

    }

    private static void getSubtitles()
    {
        subtitles = new ArrayList<SubtitleDTO>();
        SubtitleDTO s;
        for (int i = 0; i<5; i++)
        {
            s = new SubtitleDTO();
            s.setTitle("Mock subtitle "+i );
            s.setWorkIdWork(0);
            subtitles.add(s);
        }


    }

}
