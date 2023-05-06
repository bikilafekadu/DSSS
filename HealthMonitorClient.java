/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hospital;

/**
 *
 * @author Abi
 */
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;
public class HealthMonitorClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost");
            HealthMonitor healthMonitor = (HealthMonitor) registry.lookup("HealthMonitor");
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("\nChoose an option:");
                System.out.println("1. Add patient");
                System.out.println("2. Delete patient");
                System.out.println("3. Update patient status");
                System.out.println("4. Get patient status");
                System.out.println("5. Get all patients");
                System.out.println("6. Exit");
                int option = scanner.nextInt();
                scanner.nextLine();
                switch (option) {
                    case 1:
                        System.out.print("Enter patient name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter patient age: ");
                        int age = scanner.nextInt();
                        System.out.print("Enter date: ");
                        int date = scanner.nextInt();
                        System.out.print("Enter month: ");
                        int month = scanner.nextInt();
                        System.out.print("Enter year: ");
                        int year = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter doctor name: ");
                        String doctorName = scanner.nextLine();
                        System.out.print("Enter patient case: ");
                        String patientCase = scanner.nextLine();
                        System.out.print("Enter duration in hospital: ");
                        int duration = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter patient status: ");
                        String status = scanner.nextLine();
                        healthMonitor.addPatient(name, age, date, month, year, doctorName, patientCase, duration, status);
                        break;
                    case 2:
                        System.out.print("Enter patient name: ");
                        String nameToDelete = scanner.nextLine();
                        healthMonitor.deletePatient(nameToDelete);
                        break;
                    case 3:
                        System.out.print("Enter patient name: ");
                        String nameToUpdate = scanner.nextLine();
                        System.out.print("Enter new status: ");
                        String newStatus = scanner.nextLine();
                        healthMonitor.updatePatientStatus(nameToUpdate, newStatus);
                        break;
                    case 4:
                        System.out.print("Enter patient name: ");
                        String nameToGetStatus = scanner.nextLine();
                        System.out.println(healthMonitor.getPatientStatus(nameToGetStatus));
                        break;
                    case 5:
                        List<Patient> patients = healthMonitor.getAllPatients();
                        patients.forEach((patient) -> {
                            System.out.println(patient.toString());
                });
                        break;
                    case 6:
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid option!");
                        break;
                }
            }
        } catch (NotBoundException | RemoteException e) {
            System.out.println("Client exception: " + e.getMessage());
        }
    }
}