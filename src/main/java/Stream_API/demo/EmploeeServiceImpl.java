package Stream_API.demo;

import java.util.*;
import java.util.stream.Collectors;

public class EmploeeServiceImpl extends EmploeeService {

    private static Set<Emploee> emploees = new HashSet<>();

    @Override
    public Emploee maxSalary(Integer depId) {
        Emploee emploeeInDepartament = emploees.stream()
                .filter(emploee -> Objects.equals(emploee.getDepartmentNo(), depId))
                .max(Comparator.comparing(Emploee::getSalary))
                .orElseThrow(() -> new DepartmentNotFoundException("Department not found"));
        return emploeeInDepartament;
    }

    @Override
    public Emploee minSalary(Integer depId) {

        Emploee emploeeInDepartment = emploees.stream()
                .filter(emploee -> Objects.equals(emploee.getDepartmentNo(), depId))
                .min(Comparator.comparing(Emploee::getSalary))
                .orElseThrow(() -> new DepartmentNotFoundException("Department not found"));
        return emploeeInDepartment;
    }

    @Override
    public Set findEmploees(Integer depId) {
        if (depId == null) {
            return allEmploees();
        } else {
            return eploeesInDepartment(depId);
        }
    }

    @Override
    public Set eploeesInDepartment(Integer depId) {
        Set<Emploee> temp = emploees.stream()
                .filter(emploee -> Objects.equals(emploee.getDepartmentNo(), depId))
                .collect(Collectors.toSet());
        return temp;
    }

    @Override
    public Set allEmploees() {
        return emploees;
    }

    public static void emploeesAbOvo() {
        Emploee temp = new Emploee("Андрицкая", "Светлана", 1, 86811);
        emploees.add(temp);
        temp = new Emploee("Соболева", "Елена", 2, 80000);
        emploees.add(temp);
        temp = new Emploee("Некрасова", "Олеся", 3, 99100);
        emploees.add(temp);
        temp = new Emploee("Стяжкина", "Надежда", 4, 97600);
        emploees.add(temp);
        temp = new Emploee("Лампель", "Екатерина", 5, 84667);
        emploees.add(temp);
        temp = new Emploee("Смирнов", "Евгений", 5, 73000);
        emploees.add(temp);
        temp = new Emploee("Леуский", "Владислав", 4, 125400);
        emploees.add(temp);
        temp = new Emploee("Яковлев", "Андрей", 3, 95410);
        emploees.add(temp);
        temp = new Emploee("Хохлов", "Сергей", 1, 142000);
        emploees.add(temp);
        temp = new Emploee("Дудоров", "Олег", 1, 82000);
        emploees.add(temp);
    }
}
