package mission.hospital.tests;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import mission.hospital.pojo.Hospital;
import mission.hospital.pojo.Patient;
import mission.hospital.services.Services;

public class TestCases {
	Services services =new Services();
	Date todayDateCalendar;
	Date yesterdayDate;
	
  @BeforeTest
  public void prepareData() {
	  Calendar calendar = Calendar.getInstance();
	  todayDateCalendar = calendar.getTime();
	  yesterdayDate = getDate(-1);
	  services.addHospital("Bang001", "BangHosp1", "Bangalore", "Marathhalli");
	  List<Patient> bangHosp1Patients = new ArrayList<Patient>();
	  bangHosp1Patients.add(new Patient("Patient001", "Patient001", "Bangalore", 21, todayDateCalendar));
	  bangHosp1Patients.add(new Patient("Patient002", "Patient002", "Udupi", 22, yesterdayDate));
	  bangHosp1Patients.add(new Patient("Patient003", "Patient003", "Mysore", 23, todayDateCalendar));
	  bangHosp1Patients.add(new Patient("Patient004", "Patient004", "Udupi", 24, yesterdayDate));
	  services.addPatientsToHospital("Bang001", bangHosp1Patients);
	  
	  services.addHospital("Bang002", "BangHosp2", "Bangalore", "Majestic");
	  List<Patient> bangHosp2Patients = new ArrayList<Patient>();
	  bangHosp2Patients.add(new Patient("Patient001", "Patient001", "Bangalore", 21, yesterdayDate));
	  bangHosp2Patients.add(new Patient("Patient002", "Patient002", "Udupi", 22, yesterdayDate));
	  bangHosp2Patients.add(new Patient("Patient003", "Patient003", "Mysore", 23, todayDateCalendar));
	  bangHosp2Patients.add(new Patient("Patient004", "Patient004", "Udupi", 24, yesterdayDate));
	  services.addPatientsToHospital("Bang002", bangHosp2Patients);
	  
	  services.addHospital("Mysore001", "Mysore001", "Mysore", "Majestic");
	  List<Patient> mysore001Patients = new ArrayList<Patient>();
	  mysore001Patients.add(new Patient("Patient001", "Patient001", "Bangalore", 21, todayDateCalendar));
	  mysore001Patients.add(new Patient("Patient002", "Patient002", "Udupi", 22, yesterdayDate));
	  mysore001Patients.add(new Patient("Patient003", "Patient003", "Mysore", 23, todayDateCalendar));
	  
	  services.addPatientsToHospital("Mysore001", mysore001Patients);
  }
  
  @Test
  public void verifyNumOfTotalHospitals() {
	  System.out.println("###################");
	  System.out.println("verify number of total hospitals");
	  List<Hospital> allHospitals = services.getAllHospitals();
	  System.out.println("Hospital Names are as below");
	  for (Hospital hospital : allHospitals) {
		System.out.println(hospital.getHospitalName());
	  }
	  System.out.println("-------actual total hospitals------"+allHospitals.size());
	  Assert.assertEquals(allHospitals.size(), 3, "number of hospitals does not match");
  }
  
  @Test
  public void verifyNumOfTotalPatients() {
	  System.out.println("###################");
	  System.out.println("verify number of total patients");
	  List<Hospital> allHospitals = services.getAllHospitals();
//	  System.out.println("Patient Names are as below");
	  int totalPatients = 0;
	  for (Hospital hospital : allHospitals) {
		System.out.println(hospital.getHospitalName());
		totalPatients +=hospital.getPatients().size();
	  }
	  System.out.println("-------actual total patients------"+totalPatients);
	  Assert.assertEquals(totalPatients, 11, "number of patients does not match");
  }

  @Test
  public void getPatientsVisitedInBangalore() {
	  System.out.println("###################");
	  System.out.println("verify number of total patients visited bangalore");
	  int totalPatients = services.getNumberOfPatientsVisitedBangalore();
	  System.out.println("-------actual total patients visited bangalore------"+totalPatients);
	  Assert.assertEquals(totalPatients, 8, "number of patients visited bangalore does not match");
  }
  
  @Test
  public void getPatientsVisitedInBangaloreToday() {
	  System.out.println("###################");
	  System.out.println("verify number of total patients visited bangalore today");
	  int totalPatients = services.getNumberOfPatientsVisitedBangalore(new Date());
	  System.out.println("-------actual total patients visited bangalore today------"+totalPatients);
	  Assert.assertEquals(totalPatients, 3, "number of patients visited bangalore today does not match");
  }
  
  @Test
  public void getPatientsVisitedInBangaloreYesterday() {
	  System.out.println("###################");
	  System.out.println("verify number of total patients visited bangalore yesterday");
	  int totalPatients = services.getNumberOfPatientsVisitedBangalore(yesterdayDate);
	  System.out.println("-------actual total patients visited bangalore yesterday------"+totalPatients);
	  Assert.assertEquals(totalPatients, 5, "number of patients visited bangalore yesterday does not match");
  }
  
  @Test
  public void getPatientsVisitedOutOfBangalore() {
	  System.out.println("###################");
	  System.out.println("verify number of total patients visited outof bangalore");
	  int totalPatients = services.getNumberOfPatientsVisitedOutofBangalore();
	  
	  System.out.println("-------actual total patients visited outof bangalore------"+totalPatients);
	  Assert.assertEquals(totalPatients, 3, "number of patients visited outof bangalore does not match");
  }
  
  @Test
  public void getPercentageOfPatientsVisit() {
	  System.out.println("###################");
	  System.out.println("get the percentage of patients visit");
	  int totalPatients = services.getTotalNumberOfPatients();
	  int visitedBangalore = services.getNumberOfPatientsVisitedBangalore();
	  int visitedNonBangalore = services.getNumberOfPatientsVisitedOutofBangalore();
	  
	  System.out.println("Total patients visited-"+totalPatients+" out of which visited bangalore-"
	  +visitedBangalore+" visited out of bangalore-"+visitedNonBangalore);
	  
  }
  
  @Test
  public void getPercentageOfPatientsVisitForDate() {
	  System.out.println("###################");
	  System.out.println("get the percentage of patients visited for particular date");
	  int totalPatients = services.getTotalNumberOfPatients(todayDateCalendar);
	  int visitedBangalore = services.getNumberOfPatientsVisitedBangalore(todayDateCalendar);
	  int visitedNonBangalore = services.getNumberOfPatientsVisitedOutofBangalore(todayDateCalendar);
	  
	  System.out.println("For a date-"+todayDateCalendar+"Total patients visited-"+totalPatients+" out of which visited bangalore-"
	  +visitedBangalore+" visited out of bangalore-"+visitedNonBangalore);
	  
  }
  
  private Date getDate(int daysToAddOrSub) {
	Calendar cal = Calendar.getInstance();
	cal.add(Calendar.DAY_OF_MONTH, daysToAddOrSub);
	return cal.getTime();
  }
}
