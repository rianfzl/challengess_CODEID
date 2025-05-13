package ChallengeJava04_Faizal;

import ChallengeJava04_Faizal.hr.Roles;
import ChallengeJava04_Faizal.hr.Employee;
import ChallengeJava04_Faizal.hr.Programmer;
import ChallengeJava04_Faizal.hr.Qa;
import ChallengeJava04_Faizal.hr.Sales;
import ChallengeJava04_Faizal.salary.Commission;
import ChallengeJava04_Faizal.salary.Transportasi;
import ChallengeJava04_Faizal.salary.Overtime;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeImpl implements IEmployee{
    @Override
    public List<Employee> initListEmployee() {
        List<Employee> employees = new ArrayList<>();

        Programmer emp1 = new Programmer(100,"Anton",
                LocalDate.of(2020,4,2), Roles.PROGRAMMER,8_000_000,
                new Transportasi(LocalDate.now(),500_000,150_000,100_00), new Overtime(LocalDate.now(),50_000)
        );

        Programmer emp2 = new Programmer(101,"Budi",
                LocalDate.of(2021,4,2), Roles.PROGRAMMER,7_000_000,
                new Transportasi(LocalDate.now(),100_000,50_000,100_00), new Overtime(LocalDate.now(),50_000)
        );

        Sales emp3 = new Sales(102,"Cindy",
                LocalDate.of(2022,1,7), Roles.SALES,5_000_000,
                new Commission(LocalDate.now(),100_000,50_000), new Overtime(LocalDate.now(), 50_000)
        );

        Qa emp4 = new Qa(104,"Dendi",
                LocalDate.of(2021,4,10), Roles.QA,5_000_000, new Overtime(LocalDate.now(), 50_000)
        );

        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);
        employees.add(emp4);

        return employees;
    }

    @Override
    public void displayEmployees(List<Employee> employees) {
        for(Employee emp : employees){
            System.out.println(emp.toString());
        }
    }

    @Override
    public void generateSalary(List<Employee> employees) {
        for(Employee emp : employees){
            emp.calculateTotalSalary();
        }
    }
}