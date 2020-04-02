package Test;

abstract public class Animal {
    String name;
    int age;


    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void eat(){
        System.out.println("eat something");
    }
    public void sleep(){
        System.out.println("sleeping");
    }
//    abstract void mate();
}
