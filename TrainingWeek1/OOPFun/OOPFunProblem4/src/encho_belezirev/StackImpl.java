package encho_belezirev;

public class StackImpl implements Stack {
    private Object[] dataArray;
    private int lengthOfDataArr = 4;
    private int indexDataArr = 0;

    public StackImpl() {
        dataArray = new Object[lengthOfDataArr];
    }

    @Override
    public Object pushElement(Object objectToPush) {
        for (int i = 0; i < dataArray.length; i++) {
            if (dataArray[i] == objectToPush) {
                System.out.println("The element exists!");
                return null;
            }
        }
        this.dataArray[this.indexDataArr] = objectToPush;
        this.indexDataArr++;
        if (this.indexDataArr >= dataArray.length) {
            doubleSize();
        }
        return objectToPush;
    }

    @Override
    public Object popElement() {
        Object elementToreturn = null;
        int indexOfTheElement = 0;
        for (int i = dataArray.length - 1; i >= 0; i--) {
            if (dataArray[i] != null) {
                elementToreturn = dataArray[i];
                indexOfTheElement = i;
                break;
            }
        }
        dataArray[indexOfTheElement] = null;
        this.indexDataArr--;
        return elementToreturn;
    }

    @Override
    public Object peekElement() {
        Object elementToreturn = null;
        for (int i = dataArray.length - 1; i >= 0; i--) {
            if (dataArray[i] != null) {
                elementToreturn = dataArray[i];
                break;
            }
        }
        return elementToreturn;
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < dataArray.length; i++) {
            if (dataArray[i] != null) {
                return false;
            }
            
        }
        return true;
    }

    @Override
    public int size() {
        return this.indexDataArr+1;
    }

    @Override
    public void clear() {
        this.indexDataArr = 0;
        dataArray = new Object[lengthOfDataArr];

    }

    private void doubleSize() {
        this.lengthOfDataArr *= 2;
        Object[] tempArr = new Object[this.lengthOfDataArr];
        for (int i = 0; i < dataArray.length; i++) {
            tempArr[i] = dataArray[i];
        }
        dataArray = tempArr;
    }

}
