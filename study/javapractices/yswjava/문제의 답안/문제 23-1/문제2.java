package study.javapractices.yswjava.문제의

import java.util.HashSet;
import java.util.Objects;

class Person {
    private String name;
    private int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public String toString() {
        return name + "(" + age + "��)";
    }
    
    public int hashCode() {
        return Objects.hash(name, age);
    }
    
    public boolean equals(Object obj) {
        Person comp = (Person)obj;
        
        if(comp.name.equals(name) && (comp.age == age))
            return true;
        else
            return false;
    }
}

class PersonORDemo {
    public static void main(String[] args) {
        HashSet<Person> hSet = new HashSet<Person>();
        hSet.add(new Person("LEE", 10));
        hSet.add(new Person("LEE", 10));
       	hSet.add(new Person("PARK", 35));
        hSet.add(new Person("PARK", 35));

        System.out.println("����� ������ ��: " + hSet.size());
        System.out.println(hSet);
    }
}