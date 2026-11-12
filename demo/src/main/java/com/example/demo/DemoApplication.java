package com.example.demo;

import com.example.demo.exceptionclasss.MyCustomException;
import com.example.demo.serlizable.StudentSer;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.naming.InterruptedNamingException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
@Getter
@ToString
class Employee {
    int id;
    String name;
    String department;
    double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public Employee() {
    }


}




@Getter
@ToString
class Student implements Comparable<Student> {

    String name;
    int age;
    int className;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getClassName() {
        return className;
    }


    public Student(String name, int age, int className) {
        this.name = name;
        this.age = age;
        this.className = className;
    }

    @Override
    public int compareTo(Student o) {

        int result = Integer.compare(o.getAge(), this.getAge());

        if (result == 0) {

            return this.getName().compareTo(o.getName());

        }

        return result;
    }
}


@Slf4j
@SpringBootApplication(scanBasePackages = {"com.example"})
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

        List<String> names = Arrays.asList("Java", "Spring", "SQL");

        Map<String, Integer> result = names.stream()
                .collect(Collectors.toMap(
                        Function.identity(),
                        String::length
                ));

        System.out.println(result);


        List<Integer> numbers = Arrays.asList(
                10, 20, 30, 10, 40, 50, 20, 60, 70
        );

        Map.Entry<Integer, Long> mm = numbers.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > 1)
                .findFirst()
                .orElse(null);

        System.out.println(mm);


    }


//        String stringLongEntry = Arrays.stream(s.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().filter(e -> e.getValue() == 1).map(Map.Entry::getKey).findFirst().get();
//
//        System.out.println(stringLongEntry);
//
//
//       List<Employee> list = new ArrayList<>();
//       list.add(new Employee(101,"mohit","HR",8000));
//        list.add(new Employee(102,"ravi","IT",2000));
//       list.add(new Employee(103,"bijju","QA",5000));
//        list.add(new Employee(104,"yogi","AUDIT",6000));
//       list.add(new Employee(104,"yogiIII","AUDIT",5000));
//
//        Map<String, List<Employee>> collect = list.stream().collect(Collectors.groupingBy(Employee::getDepartment));
//
//        System.out.println(collect);


//        Map<Boolean, List<Employee>> collect =
//                list.stream().collect(Collectors.partitioningBy(e -> e.getSalary() > 5000));

//        List<Employee> highEarners = collect.get(true);
//        List<Employee> lowEarners = collect.get(false);
//
//        System.out.println(highEarners);
//        System.out.println(lowEarners);


//
//        Set<Integer> set = new HashSet<>();
//
//        Map<Integer, Long> collect = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//
//        System.out.println(collect);


    // to find map with student name and key will be class name
//        List<Student> students = new ArrayList<>();
//        students.add(new Student("rohit", 5, 1));
//        students.add(new Student("yogita", 10, 4));
//        students.add(new Student("mohit", 20, 12));
//        students.add(new Student("biju", 15, 4));
//
//        Map<Integer, List<String>> collect = students.stream().collect(Collectors.groupingBy(Student::getClassName,Collectors.mapping(Student::getName,Collectors.toList())));
//        System.out.println(collect);


    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        // Optional: Configure ModelMapper settings if needed
        // e.g., modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        return modelMapper;

    }


    public static void m1(String values) throws ClassNotFoundException, InterruptedNamingException, MyCustomException {


        if (values.equals("classx")) {
            System.out.println("handling in m1");
            throw new ClassNotFoundException("class cast exception");

        } else if (values.equals("secondx")) {

            System.out.println("handilng second ex");

            throw new InterruptedNamingException("InterruptedNamingException");

        } else {

            System.out.println("only else is running");
            throw new MyCustomException("message my custom exception");


        }


    }

}












