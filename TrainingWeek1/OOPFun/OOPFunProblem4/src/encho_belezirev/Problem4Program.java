package encho_belezirev;

public class Problem4Program {

    public static void main(String[] args) {
        StackImpl myStack = new StackImpl();
        myStack.pushElement(1);
        myStack.pushElement(2);
        myStack.popElement();
        myStack.pushElement(3);
        myStack.pushElement(3);
        myStack.pushElement(10);
        System.out.println(myStack.size());
    }

}
