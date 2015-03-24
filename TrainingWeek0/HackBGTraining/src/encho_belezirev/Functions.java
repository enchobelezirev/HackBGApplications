package encho_belezirev;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.StringUtils;

public class Functions {
    // Problem 1
    public static boolean isOdd(int n) {
        if (n % 2 != 0) {
            return true;
        }
        return false;
    }

    // Problem2
    public static boolean isPrime(int N) {
        Double limit = Math.sqrt(N);
        for (int i = 2; i < limit.intValue(); i++) {
            if (N % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Problem 3
    public static int min(int... array) {
        int minElement = array[0];
        for (int i = 0; i < array.length; i++) {
            if (minElement > array[i]) {
                minElement = array[i];
            }
        }
        return minElement;
    }

    // Problem 4
    public static int kthMin(int k, int[] array) {
        int minimumElement = 0;
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int swap = array[i];
                    array[i] = array[j];
                    array[j] = swap;
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            counter++;
            if (counter == k) {
                minimumElement = array[i];
            }
        }
        return minimumElement;
    }

    // Problem 5
    public static int getAverage(int[] array) {
        int average = 0;
        int elemetsSum = 0;
        for (int i = 0; i < array.length; i++) {
            elemetsSum += array[i];
        }
        average = elemetsSum / array.length;
        return average;
    }

    // Problem 6
    public static long doubleFac(int n) {
        int factoriel = 1;
        int doubleFact = 1;
        for (int i = 1; i <= n; i++) {
            factoriel *= i;
        }
        for (int i = 1; i <= factoriel; i++) {
            doubleFact *= i;
        }

        return doubleFact;
    }

    // Problem7
    public static long kthFac(int k, int n) {
        long fact = 1;
        for (int i = n; i >= 1; i = i - k) {
            fact *= i;
        }
        return fact;
    }

    // 8. Smallest multiple - think faster...
    private static boolean isDevideable(long number, int upperBound) {
        int count = 0;
        for (int i = 2; i <= upperBound; i++) {
            if (number % i == 0) {
                count++;
            }
            else{
                return false;
            }
        }
        if (count == upperBound) {
            return true;
        }
        return false;
    }

    public static long getSmallestMultiple(int upperBound) {
        long number = 1;
        boolean isDevideable = false;
        while (true) {
            isDevideable = isDevideable(number, upperBound);
            if (isDevideable) {
                break;
            }
            number++;
        }
        return number;
    }

    // Problem 9
    private static boolean isPalindrome(long N) {
        boolean isPalindrome = false;
        ArrayList<Long> digits = new ArrayList<Long>();
        while (N > 0) {
            digits.add(N % 10);
            N = N / 10;
        }
        for (int i = 0; i < digits.size(); i++) {
            if (digits.get(i) == digits.get(digits.size() - i - 1)) {
                isPalindrome = true;
            } else {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }

    public static long getLargestPalindrome(long N) {
        long largestNumber = 0;
        for (long i = N - 1; i >= 1; i--) {
            boolean isPalindrome = isPalindrome(i);
            if (isPalindrome) {
                largestNumber = i;
                break;
            }
        }
        return largestNumber;
    }

    // Problem 10
    private static boolean isNumberExist(int number, int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i == number && array[i] != 0) {
                return true;
            }
        }
        return false;
    }

    public static int[] histogram(short[][] image) {
        ArrayList<Short> numbersInImages = new ArrayList<Short>();
        int[] foundElements = new int[256];
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image.length; j++) {
                foundElements[image[i][j]] += 1;
            }
        }

//        int count = 1;
//        for (int i = 1; i < numbersInImages.size(); i++) {
//            short numberToFind = numbersInImages.get(i - 1);
//            if (isNumberExist(numberToFind, foundElements))
//                continue;
//            for (int j = i; j < numbersInImages.size(); j++) {
//                short nextNumber = numbersInImages.get(j);
//                if (numberToFind == nextNumber) {
//                    count++;
//                }
//            }
//            foundElements[numberToFind] = count;
//            count = 1;
//        }
        return foundElements;
    }

    // Problem 11 - HW

    // Problem 12 - fix
    public static int getOddOccurrence(int... array) {
        ArrayList<Integer> foundElements = new ArrayList<Integer>();
        int countElement = 1;
        int uniqueElement = 0;
        for (int i = 0; i < array.length; i++) {
            int currentElement = array[i];
            if (foundElements.contains(currentElement))
                continue;
            for (int j = i + 1; j < array.length; j++) {
                int nextElemet = array[j];
                if (currentElement == nextElemet) {
                    countElement++;
                }
            }
            boolean isOdd = isOdd(countElement);
            if (isOdd) {
                uniqueElement = currentElement;
                break;
            }
            foundElements.add(currentElement);
            countElement = 1;
        }

        return uniqueElement;
    }

    // Problem 13 
    public static long maximalScalarSum(int[] a, int[] b){
        Arrays.sort(a);
        Arrays.sort(b);
        int result = 0;
        for (int i = 0; i < b.length; i++) {
            result += a[i]*b[i];
        }
        return result;
    }

    // Problem 14 - think of another way...
    public static int maxSpan(int[] numbers) {
        ArrayList<Integer> numbersList = new ArrayList<Integer>(numbers.length);
        ArrayList<Integer> spansList = new ArrayList<Integer>();
        int spanCount = 1;
        for (int i = 0; i < numbers.length; i++) {
            numbersList.add(numbers[i]);
        }
        for (int i = 0; i < numbers.length; i++) {
            int lastIndexOfCurrentElement = numbersList.lastIndexOf(numbers[i]);
            for (int j = i; j < lastIndexOfCurrentElement; j++) {
                spanCount++;
            }
            spansList.add(spanCount);
            spanCount = 1;
        }
        Collections.sort(spansList);
        Collections.reverse(spansList);
        return spansList.get(0);
    }

    // Problem 15
    public static boolean canBalance(int[] numbers) {
        int arrayMiddle = numbers.length / 2;
        int approximateMiddle = numbers.length / 2;
        boolean canBalance = false;
        int leftSum = 0, rightSum = 0;
        while (true) {
            for (int i = 0; i < approximateMiddle; i++) {
                leftSum += numbers[i];
            }
            for (int i = approximateMiddle; i < numbers.length; i++) {
                rightSum += numbers[i];
            }
            if (leftSum == rightSum) {
                canBalance = true;
                break;
            } else {
                if (leftSum > rightSum) {
                    approximateMiddle -= 1;
                } else {
                    approximateMiddle += 1;
                }
            }
            if (approximateMiddle <= 0 || approximateMiddle >= numbers.length || approximateMiddle == arrayMiddle) {
                canBalance = false;
                break;
            }
            leftSum = 0;
            rightSum = 0;
        }
        return canBalance;
    }

    // Problem 16 - HW
    public static int[][] rescale(int[][] original, int newWidth, int newHeight) {

        return original;
    }

    // Problem 17
    public static String reverseMe(String argument) {
        String reversedString = new String();
        for (int i = argument.length() - 1; i >= 0; i--) {
            reversedString += argument.charAt(i);
        }
        return reversedString;
    }

    // Problem 18 - fix
    private static String reverseWord(String word) {
        String reversedWord = new String();
        for (int i = word.length() - 1; i >= 0; i--) {
            reversedWord += word.charAt(i);
        }
        return reversedWord;
    }

    public static String reverseEveryChar(String arg) {
        String reversedString = new String();
        for (int i = 0; i < arg.length(); i++) {
            String word = new String();
            int j = i;
            while (arg.charAt(j) != ' ') {
                word += arg.charAt(j);

                j++;
                if (j >= arg.length()) {
                    break;
                }
            }
            i = j;
            reversedString += reverseWord(word) + " ";

        }
        return reversedString;
    }

    // Problem 19
    public static boolean isPalindrome(String argument) {
        for (int i = 0; i < argument.length(); i++) {
            if (argument.charAt(i) == argument.charAt(argument.length() - i - 1)) {
                return true;
            } else {
                break;
            }
        }
        return false;
    }

    // Problem 20
    public static boolean isPalindrome(int argument) {
        String numberString = String.valueOf(argument);
        for (int i = 0; i < numberString.length(); i++) {
            if (numberString.charAt(i) == numberString.charAt(numberString.length() - i - 1)) {
                return true;
            } else {
                break;
            }
        }
        return false;
    }

    // Problem 21
    private static String MultipleTheChar(char c, int multipleTimes) {
        String multipledString = new String();
        for (int i = 0; i < multipleTimes; i++) {
            multipledString += c;
        }
        return multipledString;
    }

    public static String copyEveryChar(String input, int k) {
        String output = new String();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != ' ') {
                output += MultipleTheChar(input.charAt(i), k);
            } else {
                output += " ";
            }
        }

        return output;
    }

    // Problem 22
    public static int getPalindromeLength(String input) {
        int indexOfStar = input.lastIndexOf('*');
        int indexBeforeStar = indexOfStar - 1;
        int indexAfterStar = indexOfStar + 1;
        int countPalindrome = 0;
        while (true) {

            if (input.charAt(indexBeforeStar) == input.charAt(indexAfterStar)) {
                countPalindrome++;
            } else {
                break;
            }
            indexAfterStar++;
            indexBeforeStar--;
            if (indexBeforeStar < 0 || indexAfterStar >= input.length())
                break;
        }
        return countPalindrome;
    }

    // Problem 23
    public static int countOcurrences(String needle, String haystack) {
        return StringUtils.countMatches(haystack, needle);
    }

    // Problem 24
    public static String decodeUrl(String input) {
        try {
            return URLDecoder.decode(input, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Problem 25
    public static int sumOfNumbers(String input) {
        String number = "";
        int sum = 0;
        int index = 0;
        boolean numberFound = false;
        for (int i = 0; i < input.length(); i++) {
            index = i;
            while (input.charAt(index) >= '0' && input.charAt(index) <= '9') {
                number += input.charAt(index);
                numberFound = true;
                index++;
                if (index >= input.length()) {
                    break;
                }
            }

            if (number != "") {
                sum += Integer.parseInt(number);
                number = "";
                i = index - 1;
            }

        }
        return sum;
    }

    // Problem 26
    public static boolean anagram(String A, String B) {
        int countLetters = 0;
        StringBuilder secondString = new StringBuilder(B);
        boolean isAnagram = false;
        for (int i = 0; i < A.length(); i++) {
            char letterFromFirstString = A.charAt(i);
            for (int j = 0; j < secondString.length(); j++) {
                char letterFromSecondString = secondString.charAt(j);
                if (letterFromFirstString == letterFromSecondString) {
                    secondString.deleteCharAt(j);
                    break;
                }
            }

        }
        if (secondString.length() == 0) {
            isAnagram = true;
        } else {
            isAnagram = false;
        }
        return isAnagram;
    }

    // Problem 27 - Think later
    public static boolean hasAnagramOf(String A, String B) {
        for (int i = 0; i < A.length(); i++) {
//            if (B.contains(A.charAt(i)))) {
//                
//            }
        }
        return false;
    }

    // Problem 28
    private static int colorToRGB(int alpha, int red, int green, int blue) {

        int newPixel = 0;
        newPixel += alpha;
        newPixel = newPixel << 8;
        newPixel += red;
        newPixel = newPixel << 8;
        newPixel += green;
        newPixel = newPixel << 8;
        newPixel += blue;

        return newPixel;

    }

    public static void convertToGreyscale(String imgPath) {
        try {
            BufferedImage image = ImageIO.read(new File(imgPath));
            BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
            for (int i = 0; i < image.getHeight(); i++) {
                for (int j = 0; j < image.getWidth(); j++) {
                    int clr = image.getRGB(j, i);

                    int alpha = new Color(image.getRGB(j, i)).getAlpha();
                    int red = new Color(image.getRGB(j, i)).getRed(); // red
                    int green = new Color(image.getRGB(j, i)).getGreen(); // green
                    int blue = new Color(image.getRGB(j, i)).getBlue(); // blue

                    red = (int) (0.21 * red + 0.71 * green + 0.07 * blue);
                    int newColor = colorToRGB(alpha, red, red, red);
                    newImage.setRGB(j, i, newColor);

                }
            }
            File outputfile = new File("D:\\Sample.png");
            ImageIO.write(newImage, "jpg", outputfile);
        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
