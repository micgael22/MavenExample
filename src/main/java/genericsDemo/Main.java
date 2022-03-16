package genericsDemo;

public class Main {
    public static void main(String[] args) {
        SingleGenericHolder<Integer> iObj = new SingleGenericHolder<Integer>(10);
        System.out.println(iObj.getObj());

        SingleGenericHolder<String> sObj = new SingleGenericHolder<String>("Micgael-Code");
        System.out.println(sObj.getObj());
        
        DualGenericHolder<String, Integer> obj = new DualGenericHolder<String, Integer>("Micgael-Code", 10);
        obj.display();
    }
}
