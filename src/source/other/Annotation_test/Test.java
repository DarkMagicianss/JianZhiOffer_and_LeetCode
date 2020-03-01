package source.other.Annotation_test;

public class Test {
    public static void main(String[] args) {
        Car car = new Car();
        System.out.println(car.getName()+" "+car.getType());
        System.out.println(car.getStuff().getStuffName()+" "+car.getStuff().getAge());
    }
}
