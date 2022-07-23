package reflection.api;

import java.util.Set;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.InvocationTargetException;

public class InvestigateReflect implements Investigator {

    private Class clazz;



    @Override
    public void load(Object anInstanceOfSomething) {
        this.clazz= anInstanceOfSomething.getClass();
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

        return extendedClass != null && !extendedClass.getName().equals("java.lang.Object");
    }

    @Override
    public String getParentClassSimpleName() {
        Class extendedClass= clazz.getSuperclass();
        String parentSimpleName= null;

        if (extendedClass != null)
        {
            parentSimpleName= extendedClass.getSimpleName();
        }

        return parentSimpleName;
    }

    @Override
    public boolean isParentClassAbstract() {
        Class extendedClass= clazz.getSuperclass();
        int modifier;
        boolean isParentAbstract = false;

        if (extendedClass != null)
        {
            modifier= extendedClass.getModifiers();
            if (Modifier.isAbstract(modifier))
            {
                isParentAbstract = true;
            }
        }

        return isParentAbstract;
    }

    @Override
    public Set<String> getNamesOfAllFieldsIncludingInheritanceChain() {

        return null;
    }

    @Override
    public int invokeMethodThatReturnsInt(String methodName, Object... args) {
       Method[] methods= clazz.getDeclaredMethods();
        Method methodThatReturnsInt= null;
        int i = 0;

        while (i< methods.length)
        {
            if (methods[i].getReturnType().getName().equals("int"))
            {
                methodThatReturnsInt= methods[i];
                break;
            }
            i++;
        }



        return 0;
    }

    @Override
    public Object createInstance(int numberOfArgs, Object... args) {
        Constructor[] constructors= clazz.getDeclaredConstructors();
        Object newInstance= null;
        try {
            for (Constructor constructor : constructors) {
                if (constructor.getParameterCount() == numberOfArgs) {
                    newInstance = constructor.newInstance(args);
                    break;
                }
            }
        }catch (InstantiationException e) {
        }
        catch (IllegalAccessException e) {
        }
        catch (IllegalArgumentException e) {
        }
        catch (InvocationTargetException e){
        }

        return newInstance;
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
