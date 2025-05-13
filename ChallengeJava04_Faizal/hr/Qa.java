package ChallengeJava04_Faizal.hr;

import ChallengeJava04_Faizal.hr.Roles;
import ChallengeJava04_Faizal.ISalary;
import ChallengeJava04_Faizal.salary.Overtime;

import java.time.LocalDate;

public class Qa extends Employee implements ISalary {
    private Overtime makan;

    public Qa(int empId, String fullName, LocalDate hireDate, Roles role, double salary, Overtime makan) {
        super(empId, fullName, hireDate, role, salary);
        this.makan = makan;
    }

    @Override
    public void calculateTotalSalary() {
        setTotalSalary(getSalary()+ makan.getMakan());
    }
}