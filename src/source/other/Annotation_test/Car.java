package source.other.Annotation_test;

import java.lang.reflect.Field;

public class Car {
    @CarNameTarget(name = "2333")
    private String name;

    @CarTypeTarget(carType = CarType.benchi)
    private CarType type;

    @CarStuffTarget(StuffName = "hh",age = 2)
    private Stuff stuff;

    public Car() {
        Class clazz = Car.class;
        Field[] fields = clazz.getDeclaredFields();
        for (Field field:fields) {
            field.setAccessible(true);
            if(field.isAnnotationPresent(CarNameTarget.class)){
                CarNameTarget carNameTarget = field.getAnnotation(CarNameTarget.class);
                this.name = carNameTarget.name();
                //System.out.println(this.name);
            }else if(field.isAnnotationPresent(CarTypeTarget.class)){
                CarTypeTarget carTypeTarget = field.getAnnotation(CarTypeTarget.class);
                this.type = carTypeTarget.carType();
                //System.out.println(this.type.toString());
            }else if(field.isAnnotationPresent(CarStuffTarget.class)){
                CarStuffTarget carStuffTarget = field.getAnnotation(CarStuffTarget.class);
                this.stuff = new Stuff(carStuffTarget.StuffName(),carStuffTarget.age());
                //System.out.println(this.stuff.toString());
            }
        }
    }

    public Car(String name, CarType type, Stuff stuff) {
        this.name = name;
        this.type = type;
        this.stuff = stuff;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CarType getType() {
        return type;
    }

    public void setType(CarType type) {
        this.type = type;
    }

    public Stuff getStuff() {
        return stuff;
    }

    public void setStuff(Stuff stuff) {
        this.stuff = stuff;
    }
}
