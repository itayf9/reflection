package reflection.api;

import java.util.Set;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class InvestigateReflect implements Investigator {

    private Class clazz;



    @Override
    public void load(Object anInstanceOfSomething) {
        this.clazz= anInstanceOfSomething.getClass();
        System.out.println("class type is" + clazz.getName());
    }

    @Override
    public int getTotalNumberOfMethods() {
        Method[] methods= clazz.getDeclaredMethods();

        return methods.length;
    }

    @Override
    public int getTotalNumberOfConstructors() {
        Constructor[] constructors= clazz.getDeclaredConstructors();

        return constructors.length;
    }

    @Override
    public int getTotalNumberOfFields() {
        Field[] fields= clazz.getDeclaredFields();

        return fields.length;
    }

    @Override
    public Set<String> getAllImplementedInterfaces() {
        return null;
    }

    @Override
    public int getCountOfConstantFields() {
        Field[] fields = clazz.getDeclaredFields();
        int modifier;
        int count = 0;
        boolean isFinal;

        for (Field field : fields) {
            modifier = field.getModifiers();
            isFinal = Modifier.isFinal(modifier);
            if (isFinal) {
                count++;
            }
        }

        return count;
    }

    @Override
    public int getCountOfStaticMethods() {
        Method[] methods= clazz.getDeclaredMethods();
        int modifier;
        int count = 0;
        boolean isStatic;

        for (Method method : methods) {

            modifier = method.getModifiers();
            isStatic = Modifier.isStatic(modifier);
            if (isStatic) {
                count++;
            }
        }

        return count;
    }

    @Override
    public boolean isExtending() {
        Class extendedClass= clazz.getSuperclass();
        System.out.println(extendedClass.getName());
        return extendedClass.getName().equals("java.lang.Object") ? false : true;
    }

    @Override
    public String getParentClassSimpleName() {
        return null;
    }

    @Override
    public boolean isParentClassAbstract() {
        return false;
    }

    @Override
    public Set<String> getNamesOfAllFieldsIncludingInheritanceChain() {
        return null;
    }

    @Override
    public int invokeMethodThatReturnsInt(String methodName, Object... args) {
        return 0;
    }

    @Override
    public Object createInstance(int numberOfArgs, Object... args) {
        return null;
    }

    @Override
    public Object elevateMethodAndInvoke(String name, Class<?>[] parametersTypes, Object... args) {
        return null;
    }

    @Override
    public String getInheritanceChain(String delimiter) {
        return null;
    }
}
