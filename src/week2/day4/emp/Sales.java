package week2.day4.emp;

public class Sales extends Employee implements Bonus{

    public Sales() {
        super();
    }

    public Sales(String name, int number, String department, int salary) {
        super(name, number, department, salary);
    }

    @Override
    public double tax() {
        return getSalary() * 0.13;
    }
    @Override
    public void incentive(int pay) {
        setSalary(getSalary() + (int)(pay * 1.2));
    }

    public double getExtraPay(){
        return getSalary() * 0.03;
    }
}
