/**
 * 
 */
package mission.hospital.services;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mission.hospital.pojo.Hospital;
import mission.hospital.pojo.Inventory;
import mission.hospital.pojo.Patient;

/**
 * @author Arun
 *
 */
public class Services {
	Inventory inventory =null;
	
	public Services() {
		// TODO Auto-generated constructor stub
		inventory = new Inventory();
	}
	/**
	 * add or register new hospital
	 * @param id
	 * @param name
	 * @param city
	 * @param area
	 * @param patients
	 */
	public void addHospital(String id, String name, String city, String area) {
		List<Patient> emptyPatientsList = new ArrayList<Patient>();
		Hospital newHospital = new Hospital(id, name, city, area, emptyPatientsList);
		Inventory.hospitals.add(newHospital);
	}
	
	/**
	 * add patients to particular hospital
	 * @param id
	 * @param patients
	 */
	public void addPatientsToHospital(String id, List<Patient> patients) {
		for (Hospital hospital : Inventory.hospitals) {
			if(hospital.getHospitalId().equalsIgnoreCase(id)) {
				List<Patient> existingPatients = hospital.getPatients();
				existingPatients.addAll(patients);
				hospital.setPatients(existingPatients);
			}
		}
	}
	
	/**
	 * get all the hospital list
	 * @return
	 */
	public List<Hospital> getAllHospitals() {
		return Inventory.hospitals;
	}
	
	/**
	 * get total number of patients visited
	 * @return
	 */
	public int getTotalNumberOfPatients() {
		int totalPatients =0;
		for (Hospital hospital : Inventory.hospitals) {
			totalPatients += hospital.getPatients().size();
		}
		return totalPatients;
	}
	
	/**
	 * get total number of patients visited for a particular date
	 * @return
	 */
	public int getTotalNumberOfPatients(Date date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		int totalPatients =0;
		for (Hospital hospital : Inventory.hospitals) {
			for (Patient patient : hospital.getPatients()) {
				if(simpleDateFormat.format(patient.getHospitalVisiteDate()).compareTo(simpleDateFormat.format(date))==0)
					totalPatients++;
			}
		}
		return totalPatients;
	}
	
	/**
	 * get only bangalore hospitals
	 * @return
	 */
	public List<Hospital> getBangaloreHospitals() {
		List<Hospital> bangaloreHospitals = new ArrayList<Hospital>();
		for (Hospital hospital : Inventory.hospitals) {
			if(hospital.getCityName().equalsIgnoreCase("bangalore")) {
				bangaloreHospitals.add(hospital);
			}
		}
		return bangaloreHospitals;
	}
	
	/**
	 * get only non bangalore hospital
	 * @return
	 */
	public List<Hospital> getOutOfBangaloreHospitals() {
		List<Hospital> outOfbangaloreHospitals = new ArrayList<Hospital>();
		for (Hospital hospital : Inventory.hospitals) {
			if(!hospital.getCityName().equalsIgnoreCase("bangalore")) {
				outOfbangaloreHospitals.add(hospital);
			}
		}
		return outOfbangaloreHospitals;
	}
	
	/**
	 * get number of patients visited bangalore hospitals
	 * @return
	 */
	public int getNumberOfPatientsVisitedBangalore() {
		int totalBangalorePatients =0;
		for (Hospital hospital : getBangaloreHospitals()) {
			totalBangalorePatients += hospital.getPatients().size();
		}
		return totalBangalorePatients;
	}
	
	/**
	 * get number of patients visited bangalore hospitals for a particular date
	 * @param date
	 * @return
	 */
	public int getNumberOfPatientsVisitedBangalore(Date date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		int totalBangalorePatients =0;
		for (Hospital hospital : getBangaloreHospitals()) {
			for (Patient patient : hospital.getPatients()) {
				if(simpleDateFormat.format(patient.getHospitalVisiteDate()).compareTo(simpleDateFormat.format(date))==0)
					totalBangalorePatients++;
			}
			
		}
		return totalBangalorePatients;
	}
	
	/**
	 * get number of patients visited non bangalore hospitals
	 * @return
	 */
	public int getNumberOfPatientsVisitedOutofBangalore() {
		int totalOutofBangalorePatients =0;
		for (Hospital hospital : getOutOfBangaloreHospitals()) {
			totalOutofBangalorePatients += hospital.getPatients().size();
		}
		return totalOutofBangalorePatients;
	}
	
	/**
	 * get number of patients visited non bangalore hospitals for a particular date
	 * @param date
	 * @return
	 */
	public int getNumberOfPatientsVisitedOutofBangalore(Date date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		int totalOutofBangalorePatients =0;
		for (Hospital hospital : getOutOfBangaloreHospitals()) {
			for (Patient patient : hospital.getPatients()) {
				if(simpleDateFormat.format(patient.getHospitalVisiteDate()).compareTo(simpleDateFormat.format(date))==0)
					totalOutofBangalorePatients++;
			}
		}
		return totalOutofBangalorePatients;
	}
	


}
