package encho_belezirev;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Program {

    public static void main(String[] args) throws Exception {
        FileUtils utility = FileUtils.getInstance();
//        Path p = Paths.get("C:\\Users\\Belezirev\\Desktop\\testJAVA.txt");
//        String result1 = utility.readFrom(p);
//        //String result = utility.readFrom(new File("C:\\Users\\Belezirev\\Desktop\\testJAVA.txt"));
//        System.out.println(result1);
//        
//        String content = "Text to write in file!";
//        utility.writeTo(content, new File("C:\\Users\\Belezirev\\Desktop\\testJAVA.txt"));
//        utility.writeTo("Test test test", p);
//        Path p = Paths.get("C:\\Users\\Belezirev\\Desktop\\test.properties");
//        String content = "# this=comment\na1=b1\na2 =b2\na3    =    b3\n   a4 = b4\na5=b6=b7=b8\na6=b9 #comment\na7==b10";
//        utility.setUp(content, p);
//        List<String> list = new ArrayList<>();
//        list.add("# this=comment");
//        list.add("a1=b1");
//        list.add("a2 =b2");
//        list.add("a3    =    b3");
//        list.add("   a4 = b4");
//        list.add("a5=b6=b7=b8");
//        list.add("a6=b9 #comment");
        //list.add("a7==b10");
//        Map<String, String> map = utility.parseProperties(p);
//        System.out.println(map.get("a2"));
//        utility.tearDown(p);
        Path p = Paths.get("C:\\Users\\Belezirev\\Desktop\\test.comp");
        Path p1 = Paths.get("C:\\Users\\Belezirev\\Desktop\\javaEncoding.comp");
        Path p2 = Paths.get("C:\\Users\\Belezirev\\Desktop\\lost.s04e11.hdtv.xvid-2hd.srt");
        Path p3 = Paths.get("C:\\Users\\Belezirev\\Desktop");
//        System.out.println(utility.wordCount(p).getLinesCount());
//        System.out.println(utility.wordCount(p).getCharactersCount());
//        System.out.println(utility.wordCount(p).getWordsCount());
        //utility.findBrokenLinks(p2);
        //utility.fixEncoding(p2);
        
        //utility.compress(p);
//        utility.decompress(p1);
//        utility.serializeHashMap();
//        utility.deserializeMap();
        //utility.compress(p);
        utility.decompress(p);
    }
}
