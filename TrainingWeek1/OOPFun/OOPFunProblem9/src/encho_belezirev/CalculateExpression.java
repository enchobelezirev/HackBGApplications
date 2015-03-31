package encho_belezirev;

public class CalculateExpression {
    public static int numberOfBrackets = 0;
    public static int countNumbers = 0;

    public static boolean checkBrackets(String expression) {
        int countOpenClosingBrackets = 0;
        boolean isBracketsExist = false;
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') {
                countOpenClosingBrackets++;
                isBracketsExist = true;
                CalculateExpression.numberOfBrackets++;
            }
            if (expression.charAt(i) == ')') {
                countOpenClosingBrackets--;
            }
            if (expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
                countNumbers++;
            }
        }
        numberOfBrackets *= 2;
        return countOpenClosingBrackets == 0 && isBracketsExist;
    }

    // Finish with the checks
    public static boolean checkOperators(String expression) {
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '+' || expression.charAt(i) == '*' || expression.charAt(i) == '*'
                    || expression.charAt(i) == '/') {
                if (i > 0) {
                    if (expression.charAt(i - 1) < '0' || expression.charAt(i - 1) > '9') {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void calculateExpession(String expression) {
        double result = 0.0;
        int[] bracketsIndexes = new int[numberOfBrackets];
        int[] numbersInExpression = new int[countNumbers];
        int j = 0;
        int h = 0;
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') {
                bracketsIndexes[j] = i;
                j++;
            }
            if (expression.charAt(i) == ')') {
                bracketsIndexes[j] = i;
                j++;
            }
            if (expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
                numbersInExpression[h] = Character.getNumericValue(expression.charAt(i));
                h++;
               
            }
        }
        int startIndex = numberOfBrackets / 2 - 1;
        int endIndex = numberOfBrackets / 2;
        double tempResult = 0;
        int innerIndex = 0;
        for (int i = bracketsIndexes[startIndex]; i < bracketsIndexes[endIndex]; startIndex--,endIndex++) {
            char currentSymbol = expression.charAt(i);
            while(true){
                char nextSymbol = expression.charAt(innerIndex);
                switch (nextSymbol) {
                    case '*':
                        
                        break;
                    case '/':break;
                    case '+':break;
                    case '-':break;
                }
                innerIndex++;
            }
            
        }

    }
}
