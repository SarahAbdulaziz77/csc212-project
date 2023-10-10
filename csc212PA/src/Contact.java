package mashael;

public class Contact implements Comparable<String>{
private String fullname;
private String phone_number;
private String email;
private String address;
private String birthday;
private String notes;
private LinkedList<Event> contact_events= new LinkedList<Event>();
//Constructors
public Contact() {
	
}
public Contact(Contact c) {
	this.fullname = c.fullname;
	this.phone_number = c.phone_number;
	this.email = c.email;
	this.address = c.address;
	this.birthday = c.birthday;
	this.notes = c.notes;
}
public Contact(String fullname, String phone_number, String email, String address, String birthday, String notes) {
	super();
	this.fullname = fullname;
	this.phone_number = phone_number;
	this.email = email;
	this.address = address;
	this.birthday = birthday;
	this.notes = notes;
}
//setters and getters
public String getFullName() {
	return fullname;
}
public void setFullName(String fullname) {
	this.fullname = fullname;
}
public String getPhoneNumber() {
	return phone_number;
}
public void setPhoneNumber(String number) {
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
public LinkedList<Event> getContact_events() {
	return contact_events;
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
	return "\nName:" + fullname + "\nPhoneNumber:" + phone_number + "\nEmail Address:" + email + "\nAddress:" + address + "\nBirthday:"
			+ birthday + "\nNotes:" + notes;
}
@Override
public int compareTo(String fullname2) {
	//if this.name precede name2 alphabetically it results negative number 
	return this.fullname.compareTo(fullname2);
}


}
