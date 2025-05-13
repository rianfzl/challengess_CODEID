package ChallengeJava04_Faizal;

import ChallengeJava04_Faizal.hr.Employee;
import ChallengeJava04_Faizal.hr.Programmer;
import ChallengeJava04_Faizal.hr.Sales;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        IEmployee empInf = new EmployeeImpl();

        List<Employee> employees = empInf.initListEmployee();


        //generate salary
        empInf.generateSalary(employees);

        empInf.displayEmployees(employees);
    }
}