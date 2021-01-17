package com.miu.entity;

public class Persion {

    static class Person{
        String name = "No name";

        public Person(String name) {
            this.name = name;
        }
    }

    static class Employee extends Person{
        String empId = "0000";

        public Employee(String name) {
            super(name);
            empId = name;
        }
    }

    public static void main(String[] args) {
        Employee e = new Employee("123");
        System.out.println(e.empId);

    }

}
