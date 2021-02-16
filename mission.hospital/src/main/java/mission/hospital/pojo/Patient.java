/**
 * 
 */
package mission.hospital.pojo;

import java.util.Date;

/**
 * @author Arun
 *
 */
public class Patient {

	String patientId;
	String name;
	String address;
	int age;
	Date hospitalVisiteDate;
	

	
	/**
	 * @return the patientId
	 */
	public String getPatientId() {
		return patientId;
	}
	/**
	 * @param patientId the patientId to set
	 */
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the hospitalVisiteDate
	 */
	public Date getHospitalVisiteDate() {
		return hospitalVisiteDate;
	}
	/**
	 * @param hospitalVisiteDate the hospitalVisiteDate to set
	 */
	public void setHospitalVisiteDate(Date hospitalVisiteDate) {
		this.hospitalVisiteDate = hospitalVisiteDate;
	}
	
	public Patient(String id, String name, String address, int age, Date date) {
		setPatientId(id);
		setName(name);
		setAddress(address);
		setAge(age);
		setHospitalVisiteDate(date);
	}	

}
