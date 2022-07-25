package reflection.api;

public class Main {
    public static void main(String args[])
    {
        InvestigateReflect a= new InvestigateReflect();
        String str= new String("test");
        a.load(new Rectangle());
        System.out.println(a.getTotalNumberOfMethods());
        System.out.println(a.getTotalNumberOfConstructors());
        System.out.println(a.getTotalNumberOfFields());
        System.out.println(a.getAllImplementedInterfaces());
        System.out.println(a.getCountOfConstantFields());
        System.out.println(a.getCountOfStaticMethods());
        System.out.println(a.isExtending());
        System.out.println(a.getParentClassSimpleName());
        System.out.println(a.isParentClassAbstract());
        System.out.println(a.getNamesOfAllFieldsIncludingInheritanceChain());
        System.out.println("now: "+a.invokeMethodThatReturnsInt("calcArea"));
        Object b = a.createInstance(3, "a", "b", "c");
        Class<?>[] classes= new Class<?>[2];
        Integer x= 3;
        classes[0]= x.getClass();
        classes[1]= x.getClass();
        System.out.println(a.elevateMethodAndInvoke("goo",classes, 44, 55));
        System.out.println(a.getInheritanceChain("-><"));
    }
}
