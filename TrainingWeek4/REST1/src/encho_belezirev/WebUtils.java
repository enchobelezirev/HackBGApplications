package encho_belezirev;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class WebUtils {
    private static WebUtils instance = null;
    private Map<String, Integer> visitedUrls = null;
    private List<String> allLinksInPage = null;
    private String baseURL = null;
    private final String urlAddressStudents = "https://hackbulgaria.com/api/students";
    private final String urlAddressChekins = "https://hackbulgaria.com/api/checkins";

    private WebUtils() {
        this.visitedUrls = new HashMap<>();
    }

    public static WebUtils initialize() {
        if (instance == null) {
            instance = new WebUtils();
        }
        return instance;
    }

    private List<String> getAllLinks(String content) {
        List<String> resultList = new ArrayList<>();
        String regex = "<a.*?href=\"((?!javascript).*?)\".*?>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            resultList.add(matcher.group(1));
        }
        return resultList;
    }

    private String webCrawlerMethod(String urlAddress, String needle) throws MalformedURLException, IOException {
        StringBuilder pageBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(urlAddress).openStream(), "UTF-8"))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                pageBuilder.append(line);
                pageBuilder.append(System.getProperty("line.separator"));
            }
        }
        int searchResult = pageBuilder.toString().indexOf(needle);
        if (searchResult != -1) {
            return urlAddress;
        }

        return null;
    }

    public String webCrawler(URL urlAddress, String needle) throws IOException {
        if (baseURL == null) {
            baseURL = urlAddress.toString();
        }
        StringBuilder pageBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(urlAddress.openStream(), "UTF-8"))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                pageBuilder.append(line);
            }
        }
        if (pageBuilder.toString().indexOf(needle) != -1) {
            return urlAddress.toString();
        }
        if (allLinksInPage == null) {
            allLinksInPage = getAllLinks(pageBuilder.toString());
        }
        for (String urlString : allLinksInPage) {
            if (urlString.charAt(0) == '.') {
                continue;
            }
            if (!visitedUrls.containsKey(baseURL + urlString)) {
                visitedUrls.put(baseURL + urlString, 1);
                String foundWord = webCrawlerMethod(baseURL + urlString, needle);
                if (foundWord != null) {
                    return baseURL + urlString;
                }
            }
        }
        return null;
    }

    public void downloadPicture() throws IOException {
        URL url = new URL("http://d3dsacqprgcsqh.cloudfront.net/photo/aozrdx0_700b.jpg");
        BufferedInputStream bis = new BufferedInputStream(url.openStream());
        File fileToDownload = new File("C:\\Users\\Belezirev\\Desktop\\downloadedPic.jpg");
        FileOutputStream fos = new FileOutputStream(fileToDownload);
        byte[] buffer = new byte[1024];
        int count = 0;
        while ((count = bis.read(buffer, 0, 1024)) != -1) {
            fos.write(buffer, 0, count);
        }
        fos.close();
        bis.close();
    }

    public void countingPeopleVisits() throws JSONException {
        Map<String, Integer> userCheckins = new HashMap<>();
        HttpClient getStudentsClient = new HttpClient();
        GetMethod getMethodStudents = new GetMethod(urlAddressChekins);
        getMethodStudents.getParams().setParameter(HttpClientParams.RETRY_HANDLER,
                new DefaultHttpMethodRetryHandler(3, false));
        getMethodStudents.getParams().setParameter("http.protocol.content-charset", "UTF-8");
        try {
            int statusCode = getStudentsClient.executeMethod(getMethodStudents);
            if (statusCode != HttpStatus.SC_OK) {
                System.err.println("Get method failed: " + getMethodStudents.getStatusLine());
            }
            byte[] responseArray = getMethodStudents.getResponseBody();
            String responseAsString = new String(responseArray, "UTF-8");
            JSONArray objectArr = new JSONArray(responseAsString);
            for (int i = 0; i < objectArr.length(); i++) {
                JSONObject object = objectArr.getJSONObject(i);
                String name = (String) object.get("student_name");
                if (!userCheckins.containsKey(name.toString())) {
                    userCheckins.put(name.toString(), 1);
                } else {
                    userCheckins.put(name.toString(), userCheckins.get(name.toString()) + 1);
                }
            }
            
            System.out.println(userCheckins);
        } catch (HttpException e) {
            System.err.println("Fatal http exception: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Fatal IO exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void findPeopleWIthMoreThanOneCourse() throws JSONException {
        HttpClient getStudentsClient = new HttpClient();
        GetMethod getMethodStudents = new GetMethod(urlAddressStudents);
        getMethodStudents.getParams().setParameter(HttpClientParams.RETRY_HANDLER,
                new DefaultHttpMethodRetryHandler(3, false));
        getMethodStudents.getParams().setParameter("http.protocol.content-charset", "UTF-8");
        try {
            int statusCode = getStudentsClient.executeMethod(getMethodStudents);
            if (statusCode != HttpStatus.SC_OK) {
                System.err.println("Get method failed: " + getMethodStudents.getStatusLine());
            }
            byte[] responseArray = getMethodStudents.getResponseBody();
            String responseAsString = new String(responseArray, "UTF-8");
            JSONArray objectArr = new JSONArray(responseAsString);
            System.out.println("People cisiting more than one course: ");
            for (int i = 0; i < objectArr.length(); i++) {
                JSONObject object = objectArr.getJSONObject(i);
                JSONArray coursesArray = object.getJSONArray("courses");
                if (coursesArray.length() >= 2) {
                    System.out.println(object.get("name"));
                }
            }
        } catch (HttpException e) {
            System.err.println("Fatal http exception: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Fatal IO exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
