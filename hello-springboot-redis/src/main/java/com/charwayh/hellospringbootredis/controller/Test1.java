package com.charwayh.hellospringbootredis.controller;

import java.util.HashSet;
import java.util.Objects;

/**
 * @author: create by CharwayH
 * @description: com.charwayh.hellospringbootredis.controller
 * @date:2022/2/20
 */
public class Test1 {
    public static void main(String[] args) {
        HashSet<Object> set = new HashSet<>();
        set.add(new Employee(12,"Herry",new MyDate(2022,11,11)));
        set.add(new Employee(12,"Jerry",new MyDate(2022,11,11)));
        set.add(new Employee(12,"Jerry",new MyDate(2022,11,11)));
        for (Object o : set) {
            System.out.println((Employee)o);
        }
    }
}


class Employee{
    private int age;
    private String name;
    private MyDate date;

    public Employee(int age, String name, MyDate date) {
        this.age = age;
        this.name = name;
        this.date = date;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyDate getDate() {
        return date;
    }

    public void setDate(MyDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && name.equals(employee.name) && date.equals(employee.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name, date);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}

class MyDate{
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        MyDate myDate = (MyDate) o;
//        return year == myDate.year && month == myDate.month && day == myDate.day;
//    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }

    @Override
    public String toString() {
        return year + "-" + month + "-" + day;
    }
}