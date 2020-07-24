package com.pxf.project.jdk8;

import sun.lwawt.macosx.CPrinterDevice;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamApiTest {

    public static void main(String[] args) {

        //1.
        List<String> data = new ArrayList<String>();
        data.add("hello");
        data.add("stream");
        data.add("good night");

        // 流式编程 包含 链式编程 、函数式接口、lambda表达式 ，相互配合
        long count = data.stream().filter((s) -> s.length() > 5).count();
        long count1 = data.stream().filter(s -> s.length() > 5).count();
        System.out.println("----->"+count);

        //2.
        int[] array = new int[]{1,2,3,4};
        IntStream stream = Arrays.stream(array);
        long count2 = stream.filter(i -> i > 2).count();
        System.out.println("----->"+count2);
        
        //3.
        List<Myuser>  myusers = new ArrayList<Myuser>();
        myusers.add(new Myuser("zhangsan",23,10020));
        myusers.add(new Myuser("lisi",28,12000));
        myusers.add(new Myuser("wangwu",27,20000));
        myusers.add(new Myuser("wangwu",32,24000));

        Stream<Myuser> myuserStream = myusers.stream().filter(myuser -> myuser.getAge() > 25);
        
        myuserStream.forEach(myuser -> System.out.println("----->"+myuser));
        System.out.println("=========================");

        myusers.stream().distinct().forEach(myuser -> System.out.println("----->"+myuser));
        System.out.println("=========================");

        myusers.stream().skip(1).forEach(myuser -> System.out.println("----->"+myuser));
        System.out.println("=========================");
        myusers.stream().skip(2).forEach(System.out::println);

        System.out.println("=========================");
        myusers.stream().limit(2).forEach(System.out::println);


        //map 映射
        System.out.println("=========================");
        Stream<String> stringStream = myusers.stream().map(myuser -> myuser.getName()).distinct();
        stringStream.forEach(System.out::println);

        System.out.println("=========================");
        Stream<String> stringStream2 = myusers.stream().map(Myuser::getName).map(String::toUpperCase);
        stringStream2.forEach(System.out::println);

        System.out.println("=========================");
        Stream<Integer> stringStream3 = myusers.stream().map(Myuser::getAge).sorted();
        stringStream3.forEach(System.out::println);


        System.out.println("=========================");
        Optional<Myuser> max = myusers.stream().max((o1, o2) -> o1.getAge() - o2.getAge());
        System.out.println("----->"+max);

        //串行 并行
        System.out.println("=========================");
        int num = 1000000;
        List<String> stringList = new ArrayList<String>();
        for (int i = 0; i <num ; i++) {
            stringList.add(UUID.randomUUID().toString());
        }

        //串行
        long startTime  = System.currentTimeMillis();
        long count3 = stringList.stream().sorted().count();
        System.out.println("----->"+count3);
        System.out.println("----->"+(System.currentTimeMillis()-startTime));

        //并行
        startTime  = System.currentTimeMillis();
        count3 = stringList.parallelStream().sorted().count();
        System.out.println("----->"+count3);
        System.out.println("----->"+(System.currentTimeMillis()-startTime));


    }

    
}


class Myuser{

    private String name;

    private int age;

    private int salary;

    public Myuser() {
    }

    public Myuser(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Myuser myuser = (Myuser) o;
        return Objects.equals(name, myuser.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Myuser{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}