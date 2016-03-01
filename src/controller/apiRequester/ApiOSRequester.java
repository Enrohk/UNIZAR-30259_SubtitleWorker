package controller.apiRequester;


import exceptions.ApiRequesterException;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import sun.misc.BASE64Decoder;

public class ApiOSRequester {



    public static void load() throws MalformedURLException, XmlRpcException {

        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://api.opensubtitles.org/xml-rpc"));
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);
        Object username = "xxx";
        Object password = "xxx";
        Object language = "pob";
        Object useragent = "Enrohk";
        Object[] params = new Object[] { username, password, language, useragent };
        Map result = (Map) client.execute("LogIn", params);
        String status = (String) result.get("status");
        String token = (String) result.get("token");

    }

    public static boolean request(String api) throws ApiRequesterException, MalformedURLException{
        URL apiURL = new URL(api);
        return true;
    }

}


/**
 * package movies.backend;

 import java.io.BufferedReader;
 import java.io.ByteArrayInputStream;
 import java.io.IOException;
 import java.io.InputStreamReader;
 import java.io.StringWriter;
 import java.net.URL;
 import java.util.HashMap;
 import java.util.Map;
 import java.util.zip.GZIPInputStream;

 import org.apache.commons.io.IOUtils;
 import org.apache.xmlrpc.XmlRpcException;
 import org.apache.xmlrpc.client.XmlRpcClient;
 import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

 import sun.misc.BASE64Decoder;

 public class SubtitleSearchService {


public static void main(String[] args) throws XmlRpcException, IOException {
    XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
    config.setServerURL(new URL("http://api.opensubtitles.org/xml-rpc"));
    XmlRpcClient client = new XmlRpcClient();
    client.setConfig(config);
    Object username = "xxx";
    Object password = "xxx";
    Object language = "pob";
    Object useragent = "OS Test User Agent";
    Object[] params = new Object[] { username, password, language, useragent };
    Map result = (Map) client.execute("LogIn", params);
    String status = (String) result.get("status");
    String token = (String) result.get("token");

    Object imdbQuery = "true blood";
    params = new Object[] { token, imdbQuery  };
    result = (Map) client.execute("SearchMoviesOnIMDB", params);

    System.out.println(result);

    Object[] data = (Object[])result.get("data");
    Map dataMap = (Map)data[0];
    Object id = dataMap.get("id");
    Object title = dataMap.get("title");

    Map movieQuery = new HashMap();
    movieQuery.put("sublanguageid", "pob");
    movieQuery.put("imdbid", id);

    Object[] listQuery = {movieQuery};

    params = new Object[] { token, listQuery   };
    result = (Map) client.execute("SearchSubtitles", params);

    System.out.println(result);

    data = (Object[])result.get("data");
    dataMap = (Map)data[0];

    System.out.println(dataMap.get("SubFileName"));
    //SubDownloadLink=http://dl.opensubtitles.org/en/download/filead/1953590867.gz/sid-ojl76mmpi89o8tvpb3ebl45d83
    System.out.println(dataMap.get("SubDownloadLink"));

    String downloadLink = (String)dataMap.get("SubDownloadLink");
    downloadLink = downloadLink.replaceFirst("http://dl.opensubtitles.org/en/download/filead/", "");
    Object subFileId = downloadLink.substring(0, downloadLink.indexOf(".gz"));

    Map listOfSubtitles = new HashMap();
    listOfSubtitles.put("data", subFileId);
    params = new Object[] { token, listOfSubtitles    };
    result = (Map) client.execute("DownloadSubtitles", params);

    System.out.println(result);

    data = (Object[])result.get("data");
    dataMap = (Map)data[0];

    System.out.print(dataMap.get("data"));

    BASE64Decoder decoder = new BASE64Decoder();
    byte[] gzip = decoder.decodeBuffer((String)dataMap.get("data"));

    GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(gzip));
    StringWriter sw = new StringWriter();

    IOUtils.copy(gis, sw);
    sw.flush();
    sw.close();
    gis.close();

    System.out.println(sw.toString());

    params = new Object[] { token };
    client.execute("LogOut", params);

}

}
 */
