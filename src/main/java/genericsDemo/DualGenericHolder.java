package genericsDemo;

public class DualGenericHolder <T, U>{
    T obj1;
    U obj2;

    DualGenericHolder (T obj1, U obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }
    public void display() {
        System.out.println(obj1);
        System.out.println(obj2);
    }
}
