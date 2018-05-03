package com.example.syl.person.model;

public class Employee extends Person {

    String job;
    double salary;

    public Employee(String name, int age, String job, double salary) {
        super(name, age);
        this.job = job;
        this.salary = salary;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}