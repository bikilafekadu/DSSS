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
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class HealthMonitorImpl extends UnicastRemoteObject implements HealthMonitor {
    private static final long serialVersionUID = 1L;
    private final Map<String, Patient> patientMap;

    public HealthMonitorImpl() throws RemoteException {
        super();
        patientMap = new HashMap<>();
    }

    @Override
    public void addPatient(String name, int age, int date, int month, int year, String doctorName, String patientCase, int duration, String status) throws RemoteException {
        Patient patient = new Patient(name, age, date, month, year, doctorName, patientCase, duration, status);
        patientMap.put(name, patient);
        System.out.println("Patient " + name + " added successfully!");
    }

    @Override
    public String getPatientStatus(String name) throws RemoteException {
        Patient patient = patientMap.get(name);
        if (patient == null) {
            return "Patient not found!";
        } else {
            return patient.toString();
        }
    }

    @Override
    public void updatePatientStatus(String nameToUpdate, String newStatus) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletePatient(String nameToDelete) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Patient> getAllPatients() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
