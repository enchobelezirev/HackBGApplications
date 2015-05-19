package encho_belezirev;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.ws.Action;

@TestClass
public class TestFramework {
    private Class<?> classToTest;
    private List<Method> methodsBefore;
    private List<Method> methodsExecute;
    private List<Method> methodsAfter;

    public TestFramework(Class<?> c) {
        this.classToTest = c.getClass();
        this.methodsBefore = new ArrayList<>();
        this.methodsAfter = new ArrayList<>();
        this.methodsAfter = new ArrayList<>();
    }

    public void test() throws InstantiationException, IllegalAccessException, IllegalArgumentException,
            InvocationTargetException {
        findAnnotations();
        executeMethods();
    }

    private void executeMethods() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException,
            InstantiationException {
        for (Method method : methodsBefore) {
            method.invoke(classToTest.newInstance());
        }
        for (Method method : methodsExecute) {
            method.invoke(classToTest.newInstance());
        }
        for (Method method : methodsAfter) {
            method.invoke(classToTest.newInstance());
        }
    }

    private void findAnnotations() {
        Method[] methods = classToTest.getDeclaredMethods();
        this.methodsBefore.addAll(Arrays.asList(methods));
        for (Method method : methods) {
            Annotation annotationBefore = method.getAnnotation(Action.class);
            if (annotationBefore != null) {
                this.methodsBefore.add(method);
                continue;
            }

            Annotation annotationExecute = method.getAnnotation(Execute.class);
            if (annotationExecute != null) {
                this.methodsBefore.add(method);
                continue;
            }

            Annotation annotationAfter = method.getAnnotation(After.class);
            if (annotationAfter != null) {
                this.methodsBefore.add(method);
                continue;

            }
            this.methodsBefore.add(method);

        }
    }
}
