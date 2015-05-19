package encho_belezirev;

import java.lang.reflect.InvocationTargetException;

public class Program {

    public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException {
        ClassToTest c = new ClassToTest();
        TestFramework frameworkTest = new TestFramework(c.getClass());
        frameworkTest.test();
    }

}
