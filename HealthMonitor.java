
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
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
public interface HealthMonitor extends Remote {
    public void addPatient(String name, int age, int date, int month, int year, String doctorName, String patientCase, int duration, String status) throws RemoteException;
    public String getPatientStatus(String name) throws RemoteException;

    public void updatePatientStatus(String nameToUpdate, String newStatus);

    public void deletePatient(String nameToDelete);

    public List<Patient> getAllPatients();
}
