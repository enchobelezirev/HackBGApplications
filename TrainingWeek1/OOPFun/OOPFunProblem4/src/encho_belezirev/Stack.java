package encho_belezirev;

public interface Stack {
    Object pushElement(Object objectToPush);
    Object popElement();
    Object peekElement();
    boolean isEmpty();
    int size();
    void clear();
}
