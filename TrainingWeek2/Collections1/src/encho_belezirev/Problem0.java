package encho_belezirev;

public class Problem0 {
    public static boolean isExpressionValid(String expression){
        int countBreackets = 0;
        
        if (expression.charAt(0) != '(' || expression.charAt(expression.length()-1) != ')') {
            return false;
        }
        for (int i = 0; i < expression.length(); i++) {
            char currentSymbol = expression.charAt(i);
            if (currentSymbol == '(') {
                countBreackets++;
            }
            
            if (currentSymbol == ')') {
                countBreackets--;
                if (countBreackets < 0) {
                    return false;
                }
            }
        }
        
        return countBreackets == 0;
    }
}
