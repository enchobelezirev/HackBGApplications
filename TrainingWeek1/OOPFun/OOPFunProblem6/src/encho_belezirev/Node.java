package encho_belezirev;

public class Node {
    private int nextIndex;
    private int previousIndex;
    private int value;

    public Node(int val, int nIndex, int pIndex) {
        this.value = val;
        this.nextIndex = nIndex;
        this.previousIndex = pIndex;
    }

    public int getNextIndex() {
        return this.nextIndex;
    }

    public void setNextIndex(int nextIndex) {
        this.nextIndex = nextIndex;
    }

    public int getPreviousIndex() {
        return this.previousIndex;
    }

    public void setPreviousIndex(int previousIndex) {
        this.previousIndex = previousIndex;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
