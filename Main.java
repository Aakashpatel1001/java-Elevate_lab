package task7;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeDAO dao = new EmployeeDAO();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add Employee\n2. List Employees\n3. Update Salary\n4. Delete Employee\n0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Name: ");
                    String name = sc.next();
                    System.out.print("Designation: ");
                    String desig = sc.next();
                    System.out.print("Salary: ");
                    double salary = sc.nextDouble();
                    dao.addEmployee(new Employee(0, name, desig, salary));
                    break;
                case 2:
                    dao.listEmployees();
                    break;
                case 3:
                    System.out.print("Enter ID to update: ");
                    int idU = sc.nextInt();
                    System.out.print("New Salary: ");
                    double sal = sc.nextDouble();
                    dao.updateSalary(idU, sal);
                    break;
                case 4:
                    System.out.print("Enter ID to delete: ");
                    int idD = sc.nextInt();
                    dao.deleteEmployee(idD);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
            }
        } while (choice != 0);

        sc.close();
    }
}
