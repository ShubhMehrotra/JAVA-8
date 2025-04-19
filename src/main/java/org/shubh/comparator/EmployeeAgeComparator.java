package org.shubh.comparator;

import java.util.*;
//Demonstration to create a comparator using lambda expression
public class EmployeeAgeComparator {

   static class Employee{

        private String name;
        private int age ;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public Employee(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static void main(String[] args) {

       // Using lambda expression to create a comparator
        Comparator<Employee> comparator=(e1,e2)->{
            // Compare the ages of two employees based on the age in ascending order
            return e1.age>e2.age?1:(e1.age<e2.age?-1:0);
        };
//        Using an anonymous class to create a comparator
//        Comparator<Employee> comparator = new Comparator<Employee>() {
//            @Override
//            public int compare(Employee e1, Employee e2) {
//                return Integer.compare(e1.age, e2.age);
//            }
//        };

        // Using Comparator.comparing
        //employees.sort(Comparator.comparing(e -> e.age));

        // Using method reference
        //employees.sort(Comparator.comparing(Employee::getAge));
        //When we want to sort the list of employees based on age and name using Chaining comparators
//        employees.sort(Comparator.comparing(Employee::getAge)
//                .thenComparing(Employee::getName));


        List<Employee>employees=new ArrayList<>(Arrays.asList(
                new Employee("Shubh", 25),
                new Employee("Shubham", 22),
                new Employee("Shivam", 23),
                new Employee("Shivendra", 24)));
        System.out.println("Before sorting");
        System.out.println(employees);
        System.out.println("-------------------------------------");
        // Sort the employees list using the comparator ,passing the comparator as a parameter to the sort method to sort the list because the comparator is a functional interface and can be used as a lambda expression
        Collections.sort(employees,comparator);

        System.out.println("After sorting");
        System.out.println(employees);
    }

}
