package encho_belezirev;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.codehaus.jettison.json.JSONException;

public class Program {
    public static void main(String[] args) throws MalformedURLException, IOException, JSONException{
        WebUtils webUtils = WebUtils.initialize();
//        String findWordFromAddress = webUtils.webCrawler(new URL("http://telerikacademy.com/"), "Уеб услуги и Cloud");
//        if (findWordFromAddress != null) {
//            System.out.println(findWordFromAddress);
//        }else{
//            System.out.println("No such word found!");
//        }
        //webUtils.findPeopleWIthMoreThanOneCourse();
        System.out.println(webUtils.webCrawler(new URL("http://ebusiness.free.bg/"), "Револвираща"));
    }
}
