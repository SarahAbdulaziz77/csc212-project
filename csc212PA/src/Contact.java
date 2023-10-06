package mashael;

public class Contact implements Comparable<String>{
private String name;
private String phone_number;
private String email;
private String address;
private String birthday;
private String notes;
//Constructors
public Contact() {
	
}
public Contact(Contact c) {
	this.name = c.name;
	this.phone_number = c.phone_number;
	this.email = c.email;
	this.address = c.address;
	this.birthday = c.birthday;
	this.notes = c.notes;
}
public Contact(String name, String phone_number, String email, String address, String birthday, String notes) {
	super();
	this.name = name;
	this.phone_number = phone_number;
	this.email = email;
	this.address = address;
	this.birthday = birthday;
	this.notes = notes;
}
//setters and getters
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getNumber() {
	return phone_number;
}
public void setNumber(String number) {
	this.phone_number = number;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getBirthday() {
	return birthday;
}
public void setBirthday(String birthday) {
	this.birthday = birthday;
}
public String getNotes() {
	return notes;
}
public void setNotes(String notes) {
	this.notes = notes;
}
@Override
public String toString() {
	return "Contact info:\n Contact Name:" + name + ", PhoneNumber:" + phone_number + ", Email Address:" + email + ", Address:" + address + ", Birthday:"
			+ birthday + "\n notes:" + notes;
}
@Override
public int compareTo(String name2) {
	//if this.name precede name2 alphabetically it results negative number 
	return this.name.compareTo(name2);
}


}
