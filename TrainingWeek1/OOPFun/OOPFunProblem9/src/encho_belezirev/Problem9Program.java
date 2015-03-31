package encho_belezirev;

import java.util.Scanner;

public class Problem9Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello!");
        while (true) {
            System.out.print("Enter expression:>");
            String line = scanner.nextLine();
            boolean isBracketsOK = CalculateExpression.checkBrackets(line);
            //boolean isOperatorsOK = CalculateExpression.checkOperators(line);
            
            if (!isBracketsOK ){//|| !isOperatorsOK) {
                System.out.println("Output:>Invalid input!");
                System.out.println("Bye!");
                return;
            }
            else{
                CalculateExpression.calculateExpession(line);
            }
            System.out.println("Output:>"+isBracketsOK);
            
        }

    }

}
