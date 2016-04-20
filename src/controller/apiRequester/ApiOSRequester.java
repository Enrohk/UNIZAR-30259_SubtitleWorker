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
        Object[] params = new Object[]{username, password, language, useragent};
        Map result = (Map) client.execute("LogIn", params);
        String status = (String) result.get("status");
        String token = (String) result.get("token");

    }

    public static boolean request(String api) throws ApiRequesterException, MalformedURLException {
        URL apiURL = new URL(api);
        return true;
    }

}


/**
 * package movies.backend;
 * <p>
 * import java.io.BufferedReader;
 * import java.io.ByteArrayInputStream;
 * import java.io.IOException;
 * import java.io.InputStreamReader;
 * import java.io.StringWriter;
 * import java.net.URL;
 * import java.util.HashMap;
 * import java.util.Map;
 * import java.util.zip.GZIPInputStream;
 * <p>
 * import org.apache.commons.io.IOUtils;
 * import org.apache.xmlrpc.XmlRpcException;
 * import org.apache.xmlrpc.client.XmlRpcClient;
 * import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
 * <p>
 * import sun.misc.BASE64Decoder;
 * <p>
 * public class SubtitleSearchService {
 * <p>
 * <p>
 * public static void main(String[] args) throws XmlRpcException, IOException {
 * XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
 * config.setServerURL(new URL("http://api.opensubtitles.org/xml-rpc"));
 * XmlRpcClient client = new XmlRpcClient();
 * client.setConfig(config);
 * Object username = "xxx";
 * Object password = "xxx";
 * Object language = "pob";
 * Object useragent = "OS Test User Agent";
 * Object[] params = new Object[] { username, password, language, useragent };
 * Map result = (Map) client.execute("LogIn", params);
 * String status = (String) result.get("status");
 * String token = (String) result.get("token");
 * <p>
 * Object imdbQuery = "true blood";
 * params = new Object[] { token, imdbQuery  };
 * result = (Map) client.execute("SearchMoviesOnIMDB", params);
 * <p>
 * System.out.println(result);
 * <p>
 * Object[] data = (Object[])result.get("data");
 * Map dataMap = (Map)data[0];
 * Object id = dataMap.get("id");
 * Object title = dataMap.get("title");
 * <p>
 * Map movieQuery = new HashMap();
 * movieQuery.put("sublanguageid", "pob");
 * movieQuery.put("imdbid", id);
 * <p>
 * Object[] listQuery = {movieQuery};
 * <p>
 * params = new Object[] { token, listQuery   };
 * result = (Map) client.execute("SearchSubtitles", params);
 * <p>
 * System.out.println(result);
 * <p>
 * data = (Object[])result.get("data");
 * dataMap = (Map)data[0];
 * <p>
 * System.out.println(dataMap.get("SubFileName"));
 * //SubDownloadLink=http://dl.opensubtitles.org/en/download/filead/1953590867.gz/sid-ojl76mmpi89o8tvpb3ebl45d83
 * System.out.println(dataMap.get("SubDownloadLink"));
 * <p>
 * String downloadLink = (String)dataMap.get("SubDownloadLink");
 * downloadLink = downloadLink.replaceFirst("http://dl.opensubtitles.org/en/download/filead/", "");
 * Object subFileId = downloadLink.substring(0, downloadLink.indexOf(".gz"));
 * <p>
 * Map listOfSubtitles = new HashMap();
 * listOfSubtitles.put("data", subFileId);
 * params = new Object[] { token, listOfSubtitles    };
 * result = (Map) client.execute("DownloadSubtitles", params);
 * <p>
 * System.out.println(result);
 * <p>
 * data = (Object[])result.get("data");
 * dataMap = (Map)data[0];
 * <p>
 * System.out.print(dataMap.get("data"));
 * <p>
 * BASE64Decoder decoder = new BASE64Decoder();
 * byte[] gzip = decoder.decodeBuffer((String)dataMap.get("data"));
 * <p>
 * GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(gzip));
 * StringWriter sw = new StringWriter();
 * <p>
 * IOUtils.copy(gis, sw);
 * sw.flush();
 * sw.close();
 * gis.close();
 * <p>
 * System.out.println(sw.toString());
 * <p>
 * params = new Object[] { token };
 * client.execute("LogOut", params);
 * <p>
 * }
 * <p>
 * }
 */
