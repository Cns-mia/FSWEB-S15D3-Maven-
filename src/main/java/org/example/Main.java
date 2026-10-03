package org.example;

import org.example.entity.Employee;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new LinkedList<>();
        employees.add(new Employee(1, "Dogancan", "Kinik"));
        employees.add(new Employee(1, "Dogancan", "Kinik"));
        employees.add(new Employee(2, "Seyyit Battal", "Arvas"));
        employees.add(new Employee(2, "Seyyit Battal", "Arvas"));
        employees.add(new Employee(3, "Anil", "Ensari"));
        employees.add(new Employee(3, "Anil", "Ensari"));
        employees.add(new Employee(4, "Burak", "Cevizli"));

        System.out.println("Duplicates: " + findDuplicates(employees));
        System.out.println("Uniques: " + findUniques(employees));
        System.out.println("Removed duplicates: " + removeDuplicates(employees));
        System.out.println(WordCounter.calculateWord());
    }

    public static List<Employee> findDuplicates(List<Employee> list) {
        Map<Integer, Employee> seen = new HashMap<>();
        List<Employee> duplicates = new LinkedList<>();
        for (Employee employee : list) {
            if (employee == null) continue;
            if (seen.containsKey(employee.getId())) {
                if (!duplicates.contains(employee)) {
                    duplicates.add(employee);
                }
            } else {
                seen.put(employee.getId(), employee);
            }
        }
        return duplicates;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> list) {
        Map<Integer, Employee> uniques = new HashMap<>();
        for (Employee employee : list) {
            if (employee == null) continue;
            uniques.putIfAbsent(employee.getId(), employee);
        }
        return uniques;
    }

    public static List<Employee> removeDuplicates(List<Employee> list) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (Employee employee : list) {
            if (employee == null) continue;
            counts.merge(employee.getId(), 1, Integer::sum);
        }
        List<Employee> result = new LinkedList<>();
        for (Employee employee : list) {
            if (employee != null && counts.get(employee.getId()) == 1) {
                result.add(employee);
            }
        }
        return result;
    }
}
