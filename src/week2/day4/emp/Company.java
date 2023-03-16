package week2.day4.emp;

public class Company {
    public static void main(String[] args) {
        Employee[] employees =
                new Employee[]{
                        new Secretary("Duke",1,"secretary",800)
                        ,new Sales("Tuxi",2,"sales",1200)
                };
        printEmployee(employees,false);
        for (Employee e:employees) {
            if(e instanceof Bonus){
                ((Bonus) e).incentive(100);
            }
        }
        printEmployee(employees,true);
    }

    public static void printEmployee(Employee[] emp,boolean isTax){
        System.out.printf("%10s %10s %10s %10s %10s\n","name","department","salary",isTax?"tax":"","extrapay");
        System.out.println("-".repeat(55));
        for (Employee e:emp) {
            System.out.printf("%10s %10s %10d %10s %10s\n", e.getName(),e.getDepartment(),e.getSalary(),isTax?e.tax() + " ":" ",e instanceof Sales?((Sales) e).getExtraPay() + "":"");
        }
        System.out.println();
    }
}
