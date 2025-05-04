package myapp;
import java.time.LocalDate;

public class User{
    private String name;
    private int age;
    private LocalDate joinDate;
    private double salary;

    public User(String name, int age, LocalDate joinDate, double salary) {
        this.name = name;
        this.age = age;
        this.joinDate = joinDate;
        this.salary = salary;
    }
    
    // Getters
    public String getName() { return name; }
    public int getAge() { return age; }
    public LocalDate getJoinDate() { return joinDate; }
    public double getSalary() { return salary; }

    @Override
    public String toString(){
        return name +" " + age + " " + joinDate + " " + salary;
    }

}