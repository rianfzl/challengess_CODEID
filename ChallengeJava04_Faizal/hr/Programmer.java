package ChallengeJava04_Faizal.hr;

import ChallengeJava04_Faizal.hr.Roles;
import ChallengeJava04_Faizal.ISalary;
import ChallengeJava04_Faizal.salary.Overtime;
import ChallengeJava04_Faizal.salary.Transportasi;

import java.time.LocalDate;

public class Programmer extends  Employee implements ISalary {

    private Transportasi transport;
    private Overtime makan;

    public Programmer(int empId, String fullName, LocalDate hireDate, Roles role, double salary,
                      Transportasi transport, Overtime makan) {
        super(empId, fullName, hireDate, role, salary);
        this.transport = transport;
        this.makan = makan;
    }

    @Override
    public void calculateTotalSalary() {
        setTotalSalary(getSalary()+ transport.getBensin()+ transport.getSpj()+ transport.getTransportasi()+ makan.getMakan());
    }
}