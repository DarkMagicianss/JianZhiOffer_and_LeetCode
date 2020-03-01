package source.other.Annotation_test;

public class Stuff {
    private String StuffName;
    private int age;

    public Stuff(String stuffName, int age) {
        StuffName = stuffName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Stuff{" +
                "StuffName='" + StuffName + '\'' +
                ", age=" + age +
                '}';
    }

    public String getStuffName() {
        return StuffName;
    }

    public void setStuffName(String stuffName) {
        StuffName = stuffName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
