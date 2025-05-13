package ChallengeJava04_Faizal.hr;

import ChallengeJava04_Faizal.hr.Roles;
import ChallengeJava04_Faizal.ISalary;
import ChallengeJava04_Faizal.salary.Commission;
import ChallengeJava04_Faizal.salary.Overtime;

import java.time.LocalDate;

public class Sales extends Employee implements ISalary {

    private Commission commision;
    private Overtime makan;


    public Sales(int empId, String fullName, LocalDate hireDate, Roles role, double salary, Commission commision,
                 Overtime makan) {
        super(empId, fullName, hireDate, role, salary);
        this.commision = commision;
        this.makan = makan;
    }

    @Override
    public void calculateTotalSalary() {
        setTotalSalary(getSalary()+ commision.getComision()+ commision.getBonus()+ makan.getMakan());
    }
}