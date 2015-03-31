package encho_belezirev;

public class LinkedArrayList implements LinkedArrayListInterface {
    private int elementsLength = 4;
    private Node[] elements;
    private int elementsIndex = 0;

    public LinkedArrayList() {
        this.elements = new Node[this.elementsLength];
    }

    @Override
    public void add(int element) {
        Node lastNode = null;
        Node newNode = null;
        for (int i = elements.length - 1; i >= 0; i--) {

            if (elements[i] != null) {
                if (this.elements[i].getValue() != element) {
                    lastNode = elements[i];
                    break;
                } else {
                    System.out.println("The element exists! Adding process terminated!");
                    return;
                }

            }
        }
        if (lastNode == null) {
            newNode = new Node(element, 1, 0);
        } else {
            newNode = new Node(element, lastNode.getNextIndex() + 1, lastNode.getNextIndex());
        }
        this.elements[this.elementsIndex] = newNode;
        this.elementsIndex++;
        if (this.elementsIndex >= elementsLength) {
            DoubleSize();
        }
    }

    @Override
    public void removeELement(int element) {
        for (int i = 0; i < this.elements.length; i++) {
            if (this.elements[i].getValue() == element) {
                reArrangeElements(i + 1);
                this.elements[i] = null;
                this.elementsIndex--;
                break;
            }
        }
    }

    @Override
    public void removeElementByIndex(int index) {
        Node nodeToRemove = null;
        for (int i = 0; i < this.elements.length; i++) {
            if (this.elements[i].getPreviousIndex() == index) {
                nodeToRemove = this.elements[i];
                reArrangeElements(i + 1);
                this.elements[i] = null;
                this.elementsIndex--;
                break;
            }
        }

    }

    @Override
    public int size() {
        return this.elementsIndex;
    }

    @Override
    public int get(int elementIndex) {
        Node foundNode = null;
        for (int i = 0; i < this.elements.length; i++) {
            if (this.elements[i].getPreviousIndex() == elementIndex) {
                foundNode = this.elements[i];
                break;
            }
        }

        return foundNode.getValue();
    }

    @Override
    public int getHead() {
        return this.elements[0].getValue();
    }

    @Override
    public int getTail() {
        return this.elements[this.elementsIndex - 1].getValue();
    }

    private void reArrangeElements(int startIndex) {
        for (int j = startIndex; j < elements.length; j++) {
            if (this.elements[j] != null) {
                this.elements[j].setNextIndex(this.elements[j].getNextIndex() - 1);
                this.elements[j].setPreviousIndex(this.elements[j].getPreviousIndex() - 1);
            }
        }
    }

    private void DoubleSize() {
        this.elementsLength *= 2;
        Node[] tempArr = new Node[this.elementsLength];
        for (int i = 0; i < this.elements.length; i++) {
            tempArr[i] = this.elements[i];
        }
        this.elements = tempArr;
    }

}
