package dto;

public class Employe {
String empId;
String empName;
long empPhoneNumber;
String empAddress;
String empGender;
String empEmail;

@Override
public String toString() {
	return "Employe [empId=" + empId + ", empName=" + empName + ", empPhoneNumber=" + empPhoneNumber + ", empAddress="
			+ empAddress + ", empEmail=" + empEmail + ", empGender=" + empGender + "]";
}
public String getEmpId() {
	return empId;
}
public void setEmpId(String empId) {
	this.empId = empId;
}
public String getEmpName() {
	return empName;
}
public void setEmpName(String empName) {
	this.empName = empName;
}
public long getEmpPhoneNumber() {
	return empPhoneNumber;
}
public void setEmpPhoneNumber(long empPhoneNumber) {
	this.empPhoneNumber = empPhoneNumber;
}
public String getEmpAddress() {
	return empAddress;
}
public void setEmpAddress(String empAddress) {
	this.empAddress = empAddress;
}
public String getEmpGender() {
	return empGender;
}
public void setEmpGender(String empGender) {
	this.empGender = empGender;
}
public String getEmpEmail() {
	return empEmail;
}
public void setEmpEmail(String empEmail) {
	this.empEmail = empEmail;
}

}
