/**
 * 
 */
package mission.hospital.pojo;

import java.util.List;

/**
 * @author Arun
 *
 */
public class Hospital {

	String hospitalId;
	String hospitalName;
	String cityName;
	String area;
	List<Patient> patients;

	/**
	 * @return the hospitalId
	 */
	public String getHospitalId() {
		return hospitalId;
	}
	/**
	 * @param hospitalId the hospitalId to set
	 */
	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}
	/**
	 * @return the hospitalName
	 */
	public String getHospitalName() {
		return hospitalName;
	}
	/**
	 * @param hospitalName the hospitalName to set
	 */
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	/**
	 * @return the cityName
	 */
	public String getCityName() {
		return cityName;
	}
	/**
	 * @param cityName the cityName to set
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	/**
	 * @return the area
	 */
	public String getArea() {
		return area;
	}
	/**
	 * @param area the area to set
	 */
	public void setArea(String area) {
		this.area = area;
	}
	/**
	 * @return the patients
	 */
	public List<Patient> getPatients() {
		return patients;
	}
	/**
	 * @param patients the patients to set
	 */
	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}
	
	public Hospital(String id, String name, String city, String area, List<Patient> patients) {
		setHospitalId(id);
		setHospitalName(name);
		setCityName(city);
		setArea(area);
		setPatients(patients);
	}
}


