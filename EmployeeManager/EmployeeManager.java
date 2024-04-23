package EmployeeManager;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManager {

    private static ArrayList<Employee> employee = new ArrayList<>();

    private static void initializeEmployee() {
        employee.add(new Employee(1, "Nguyen Van A", 20, "Security", "A1", 2.5));
        employee.add(new Employee(2, "Tran thi B", 35, "Sale", "A2", 4));
        employee.add(new Employee(3, "Luu Anh C", 27, "Sale", "A3", 4));
        employee.add(new Employee(4, "Nguyen Tung D", 42, "Marketing", "A4", 3.5));
        employee.add(new Employee(5, "Tran Kim E", 22, "Marketing", "A5", 3.5));
        employee.add(new Employee(6, "Le Dinh F", 29, "Marketing", "A6", 3.5));
        employee.add(new Employee(7, "Dang Quoc G", 40, "Marketing", "A7", 3.5));
        employee.add(new Employee(8, "Do Thi H", 32, "Marketing", "A8", 3.5));
        employee.add(new Employee(9, "Nguyen Duy I", 50, "It", "A9", 9));
        employee.add(new Employee(10, "Le Van K", 21, "It", "A10", 9));
    }

    private static void displayEmployee() {
        System.out.println("Danh sach nhan vien:");
        System.out.println("ID \t Name \t Age \t Department \t Code \t Salary Rate");
        for (Employee employee : employee) {
            System.out.println(employee.getId() + "\t" + employee.getName() + "\t" + employee.getAge() + "\t" + employee.getDepartment() + "\t" + "\t" + employee.getCode() + "\t" + employee.getSalaryRate());
            System.out.println();
        }
    }

    private static void addNewEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập thong tin nhan vien: ");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ dòng đầu tiên
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ dòng đầu tiên
        System.out.print("Department: ");
        String department = scanner.nextLine();
        System.out.print("Code: ");
        String code = scanner.nextLine();
        System.out.print("Salary Rate: ");
        double salaryRate = scanner.nextDouble();

        Employee newEmployee = new Employee(id, name, age, department, code, salaryRate);
        employee.add(newEmployee);
        System.out.println("Them thanh cong");
        scanner.close();
    }

    private static void removeEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap Id: ");
        int idToRemove = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        boolean found = false;
        for (int i = 0; i < employee.size(); i++) {
            if (employee.get(i).getId() == idToRemove) {
                employee.remove(i);
                System.out.println("Xoa thanh cong.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Khong tim thay nhan vien co id = " + idToRemove);
        }
        scanner.close();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize employees
        initializeEmployee();
        displayEmployee();

        int choice;
        do {
            // Display menu
            System.out.println("\nNhap chuc nang: ");
            System.out.println("1. Them moi nhan vien");
            System.out.println("2. Xoa nhan vien");
            System.out.println("3. Thoat");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addNewEmployee();
                    break;
                case 2:
                    removeEmployee();
                    break;
                case 3:
                    System.out.println("Thoat chuong trinh ...");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }
}
