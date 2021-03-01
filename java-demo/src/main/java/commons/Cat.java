package commons;

import java.util.Objects;

public class Cat extends Felid {

    private int id;
    private String name;
    private String color;
    private int age;

    public Cat() {
    }

    public Cat(int id, String name, String color, int age) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.age = age;
    }

    //静态方法
    public static void staticWhoCat(Cat cat) {
        System.out.println("静态方法::我的名字是" + cat.name + ",我今年" + cat.age + "岁了");
    }

    public void whoCat(Cat cat) {
        System.out.println("成员方法::我的名字是" + cat.name + ",我今年" + cat.age + "岁了");
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", age=" + age +
                '}';
    }

}
