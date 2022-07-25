package reflection.api;

public class Main {
    public static void main(String args[])
    {
        InvestigateReflect a= new InvestigateReflect();
        String str= new String("test");
        a.load(new B());
        System.out.println(a.getTotalNumberOfMethods());
        System.out.println(a.getTotalNumberOfConstructors());
        System.out.println(a.getTotalNumberOfFields());
        System.out.println(a.getAllImplementedInterfaces());
        System.out.println(a.getCountOfConstantFields());
        System.out.println(a.getCountOfStaticMethods());
        System.out.println(a.isExtending());
        System.out.println(a.getParentClassSimpleName());
        System.out.println(a.isParentClassAbstract());
        // getNamesOfAllFieldsIncludingInheritanceChain()
        System.out.println("now: "+a.invokeMethodThatReturnsInt("foo", 2 ,3));
        Object b = a.createInstance(3, "a", "b", "c");
        // elevateMethodAndInvoke()
        System.out.println(a.getInheritanceChain("-><"));
    }
}
