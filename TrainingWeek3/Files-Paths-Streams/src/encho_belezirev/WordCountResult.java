package encho_belezirev;

public class WordCountResult {
    private int words;
    private int lines;
    private int characters;
    
    public WordCountResult(int words, int lines, int characters) {
        this.setWordsCount(words);
        this.setLinesCount(lines);
        this.setCharactersCount(characters);
    }
    
    private void setWordsCount(int value){
        if (value < 0) {
            throw new IllegalArgumentException("Number of words in file should be  >= 0");
        }
        this.words = value;
    }
    
    public int getWordsCount(){
        return this.words;
    }
    
    private void setLinesCount(int value){
        if (value < 0) {
            throw new IllegalArgumentException("Number of lines in file shoudl be >= 0");
        }
        
        this.lines = value;
    }
    
    public int getLinesCount(){
        return this.lines;
    }
    
    private void setCharactersCount(int value){
        if (value < 0) {
            throw new IllegalArgumentException("Number of characters shoud be above 0");
        }
        this.characters = value;
    }
    
    public int getCharactersCount(){
        return this.characters;
    }
}

