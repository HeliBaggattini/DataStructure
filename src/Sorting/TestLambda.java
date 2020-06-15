package Sorting;

import java.util.*;

public class TestLambda {

    private static class Developer {
        private String name;
        private int salary;
        private int age;

        public Developer(String n, int s, int a) {
            name = n;
            salary = s;
            age = a;
        }

        public int getAge() { return age; }

        @Override
        public String toString() { return name + ": " + salary + " (" + age + ")"; }
    } 

	public static void main(String[] args) {
		ArrayList<Developer> devs = new ArrayList<Developer>();

		devs.add(new Developer("mkyong", 70000, 33));
		devs.add(new Developer("alvinx", 80000, 20));
		devs.add(new Developer("jasonp", 10000, 10));
		devs.add(new Developer("irispa", 17000, 55));

		System.out.println("Before sort:");
		for (Developer developer : devs) {
			System.out.println(developer);
		}

		System.out.println("\nAfter sort:");

		// sort with lambda comparator
		devs.sort((o1, o2) -> (o1.getAge() - o2.getAge()));

		// print with lambda command
		devs.forEach((developer)->System.out.println(developer));
	}
}
