package ChallengeJava04_Faizal;

import ChallengeJava04_Faizal.hr.Employee;
import ChallengeJava04_Faizal.hr.Programmer;
import ChallengeJava04_Faizal.hr.Sales;

import java.util.List;

public interface IEmployee {
    List<Employee> initListEmployee();

    void displayEmployees(List<Employee> employees);

    void generateSalary(List<Employee> employees);
}