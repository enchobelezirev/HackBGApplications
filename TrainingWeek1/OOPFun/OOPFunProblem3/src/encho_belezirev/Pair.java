package encho_belezirev;

final public class Pair {
    final private Object key;
    final private Object value;

    public Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public Object getKey() {
        return this.key;
    }

    public Object getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return "The key of the pair is: " + this.getKey() + ", the value of the pair is: " + this.getValue();
    }

    @Override
    public boolean equals(Object secondPair) {
        Pair pairToCompare = (Pair) secondPair;
        if (this.getKey() == pairToCompare.getKey() && this.getValue() == pairToCompare.getValue()) {
            return true;
        }
        return false;
    }
}
