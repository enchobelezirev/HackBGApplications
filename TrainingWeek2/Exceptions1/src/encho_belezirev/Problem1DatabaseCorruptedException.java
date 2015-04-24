package encho_belezirev;

public class Problem1DatabaseCorruptedException extends RuntimeException {
    public Problem1DatabaseCorruptedException(String m){
        super(m);
    }
    
    public static void addUserException() throws Problem1DatabaseCorruptedException{
        throw new Problem1DatabaseCorruptedException("User is corrupted");
    }
}
