package encho_belezirev;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FileUtils {
    private static FileUtils instance = null;
    private Map<String, Integer> encodingScheme = null;

    private FileUtils() {

    }

    public static FileUtils getInstance() {
        if (instance == null) {
            instance = new FileUtils();
        }
        return instance;
    }

    public WordCountResult wordCount(Path path) throws FileNotFoundException, IOException {
        return this.wordCount(path.toFile());
    }

    public Path reduceFilePath(Path path) {
        return path.normalize();
    }

    public void findBrokenLinks(Path path) throws IOException {
        File[] allFilesAndDirs = path.toFile().listFiles();
        for (File file : allFilesAndDirs) {
            String p = file.getAbsolutePath();
            if (Files.isSymbolicLink(Paths.get(p))) {
                Path symbolikLinkPath = Files.readSymbolicLink(Paths.get(p));
                if (!Files.exists(symbolikLinkPath)) {
                    System.out.println(Paths.get(p) + " is broken!");
                }
                if (file.isDirectory()) {
                    findBrokenLinks(file.toPath());
                }
            }

        }

    }

    public void serializeEncodingKey(Map<String, Integer> key, File file) throws FileNotFoundException, IOException {
        FileOutputStream byteOut = new FileOutputStream(file);
        ObjectOutputStream out = new ObjectOutputStream(byteOut);
        out.writeObject(key);
        out.close();
        byteOut.close();
    }

    public Map<String, Integer> deserializeEncodingKey(File file) throws IOException, ClassNotFoundException {
        FileInputStream byteIn = new FileInputStream(file);
        ObjectInputStream oba = new ObjectInputStream(byteIn);
        Map<String, Integer> deserializedKey = (Map<String,Integer>)oba.readObject();
        oba.close();
        byteIn.close();
        return deserializedKey;
    }

    public void fixEncoding(Path path) throws IOException {

        File file = path.toFile();
        byte[] encoded = Files.readAllBytes(Paths.get(file.getAbsolutePath()));

        File newFile = new File("C:\\Users\\Belezirev\\Desktop\\encoded.srt");
        if (!newFile.exists()) {
            newFile.createNewFile();
        }

        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(newFile), "UTF-8"))) {
            bw.write(new String(encoded, "Windows-1251"));
        }

    }

    private String getKeyFormValue(int value) {
        String key = null;
        for (Entry<String, Integer> elementScheme : this.encodingScheme.entrySet()) {
            if (elementScheme.getValue().equals(value)) {
                key = elementScheme.getKey();
                break;
            }
        }
        return key;
    }

    public void decompress(Path filePath) throws Exception {
        encodingScheme = this.deserializeEncodingKey(filePath.toFile());
        if (encodingScheme == null) {
            throw new Exception("The decoding cannot be done because the is no key found!");
        }
        String line = null;
        StringBuilder compressedFileText = new StringBuilder();
        String textWithoutLinkingQuotes = null;
        try (BufferedReader compressedFileReader = new BufferedReader(new FileReader(filePath.toFile()))) {
            while ((line = compressedFileReader.readLine()) != null) {
                compressedFileText.append(line);
            }
        }
        String textWithoutSerialization = compressedFileText.toString().substring(compressedFileText.indexOf("&"), compressedFileText.length());
        textWithoutLinkingQuotes = textWithoutSerialization.toString().replace("&", "");
        for (int i = 0; i < textWithoutLinkingQuotes.length(); i++) {
            if (encodingScheme.containsValue(textWithoutLinkingQuotes.charAt(i) - '0')) {
                String key = getKeyFormValue(textWithoutLinkingQuotes.charAt(i) - '0');
                textWithoutLinkingQuotes = textWithoutLinkingQuotes.replace("" + textWithoutLinkingQuotes.charAt(i),
                        key);
            }
        }
        this.writeTo(textWithoutLinkingQuotes, Paths.get("C:\\Users\\Belezirev\\Desktop\\"+filePath.getFileName().toString().substring(0, filePath.getFileName().toString().indexOf('.'))+".txt"), false);
    }

    public void compress(Path filePath) throws IOException {
        StringBuilder textFromFile = new StringBuilder();
        String line = null;
        encodingScheme = new HashMap<>();
        String encodedText = null;
        int indexElement = 0;
        try (BufferedReader readerFilee = new BufferedReader(new FileReader(filePath.toFile()))) {
            while ((line = readerFilee.readLine()) != null) {
                textFromFile.append(line);
            }
        }
        String simpleText = textFromFile.toString().replaceAll("[!?,.]", "");
        String[] wordsFromText = simpleText.split("\\s+");
        for (int i = 0; i < wordsFromText.length; i++) {
            if (!encodingScheme.containsKey(wordsFromText[i])) {
                encodingScheme.put(wordsFromText[i], indexElement);
                indexElement++;
            }
        }

        encodedText = textFromFile.toString();

        for (Entry<String, Integer> encodingEntry : encodingScheme.entrySet()) {
            encodedText = encodedText.replaceAll("\\b" + encodingEntry.getKey() + "\\b", "&"
                    + encodingEntry.getValue().toString());
        }

        Path pathCompressedFile = Paths.get("C:\\Users\\Belezirev\\Desktop\\"+filePath.getFileName().toString().substring(0, filePath.getFileName().toString().indexOf('.'))+".comp");
        serializeEncodingKey(encodingScheme, pathCompressedFile.toFile());
        
        this.writeTo(encodedText, pathCompressedFile, true);
    }

    public WordCountResult wordCount(File file) throws FileNotFoundException, IOException {
        int lineNumbers = 0;
        int wordsCount = 0;
        int numberOfCharacters = 0;
        try (Scanner fileReader = new Scanner(new BufferedReader(new FileReader(file)))) {
            while (fileReader.hasNextLine()) {
                lineNumbers++;
                String line = fileReader.nextLine();
                numberOfCharacters += line.length();
                wordsCount += new StringTokenizer(line, " ").countTokens();
            }
        }
        try (FileReader reader = new FileReader(file)) {

            while ((reader.read()) != -1) {
                numberOfCharacters++;
            }
        }
        return new WordCountResult(wordsCount, lineNumbers, numberOfCharacters);
    }

    public String readFrom(File file) throws IOException {
        StringBuilder builderResult = new StringBuilder();
        FileReader fileForReading = new FileReader(file);
        String currentLine = null;
        try (BufferedReader fileReader = new BufferedReader(fileForReading)) {
            while ((currentLine = fileReader.readLine()) != null) {
                builderResult.append(currentLine + System.getProperty("line.separator"));
            }
        }
        return builderResult.toString();
    }

    public String readFrom(Path path) throws IOException {
        return this.readFrom(new File(path.toString()));
    }

    public void writeTo(String textToWrite, File file, boolean append) throws IOException {
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file.getAbsoluteFile(), append);
        BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
        bufferWriter.write(textToWrite);
        bufferWriter.close();
        System.out.println("Done writing to file");
    }

    public void writeTo(String content, Path path, boolean appendAfter) throws IOException {
        this.writeTo(content, new File(path.toString()),appendAfter);
    }

    public void setUp(String content, Path path, boolean append) throws IOException {
        this.writeTo(content, path, append);
    }

    public Map<String, String> parseProperties(Path path) throws IOException {
        String resultFromProp = this.readFrom(path);
        List<String> list = Arrays.asList(resultFromProp.split(System.getProperty("line.separator")));
        Map<String, String> buildMap = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            String line = list.get(i);
            if (line.charAt(0) == '#') {
                continue;
            } else {
                StringBuilder key = new StringBuilder();
                StringBuilder value = new StringBuilder();
                int indexOfFirstEqS = line.indexOf('=');
                for (int j = 0; j < indexOfFirstEqS; j++) {
                    if (line.charAt(j) != ' ') {
                        key.append(line.charAt(j));
                    }

                }
                for (int j = indexOfFirstEqS + 1; j < line.length(); j++) {
                    if (line.charAt(j) != ' ') {
                        value.append(line.charAt(j));
                    }
                }
                buildMap.put(key.toString(), value.toString());
            }
        }
        return buildMap;
    }

    public void tearDown(Path path) throws IOException {
        Files.delete(path);
    }
}
