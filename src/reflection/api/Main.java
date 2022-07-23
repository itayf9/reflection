package reflection.api;

public class Main {
    public static void main(String args[])
    {
        InvestigateReflect a= new InvestigateReflect();
        String str= new String("test");
        a.load(new A());
        System.out.println(a.getTotalNumberOfMethods());
        System.out.println(a.getTotalNumberOfConstructors());
        System.out.println(a.getTotalNumberOfFields());
        // getAllImplementedInterfaces()
        System.out.println(a.getCountOfConstantFields());
        System.out.println(a.getCountOfStaticMethods());
        System.out.println(a.isExtending());
    }
}
