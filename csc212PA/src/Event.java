package CSC212_PA;


public class Event {
	private char type;
	private String title;
	private String dateAndTime;
	private String location;
	private LinkedList<Contact> event_contacts = new LinkedList<Contact>();

	public Event(char type,String title, Contact contact, String dateAndTime, String location) {
		this.type=type;
		this.title = title;
		event_contacts.insert(contact);
		this.dateAndTime = dateAndTime;
		this.location = location;
	}
	
	public Event(char type,String title, LinkedList<Contact> contacts, String dateAndTime, String location) {
		this.type=type;
		this.title = title;
		event_contacts = contacts;
		this.dateAndTime = dateAndTime;
		this.location = location;
	}
	
	public char getType() {
		return type;
	}
	public void setType(char type) {
		this.type=type;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(String date) {
		this.dateAndTime = date;
	}


	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public LinkedList<Contact> getEvent_contacts() {
		return event_contacts;
	}

	public void setEvent_contacts(LinkedList<Contact> event_contacts) {
		this.event_contacts = event_contacts;
	}

	@Override
	public String toString() {
		String details ="";
		if(type=='E') {
			details= "Event title:" + title;
		    event_contacts.FindFirst();
		    if(!event_contacts.isEmpty()) {
		    	if(!event_contacts.last())
		    		details="\nContacts names:";
		    while(!event_contacts.last()) {
		    	details=details+"\nContact name: " + event_contacts.Retrieve().getFullName();
		    	event_contacts.FindNext();
		    }
		    //last contact
		    details=details+"\nContact name: " + event_contacts.Retrieve().getFullName();
		    }
		    details=details+"\nEvent date and time:" + dateAndTime  + "\nEvent location:" + location + "\n" ;	
		    return details;
		}
		else if(type=='A') {
			details= "Event title:" + title;
		    event_contacts.FindFirst();
		    if(!event_contacts.isEmpty()) {
		    //only contact
		    details=details+"\nContact name: " + event_contacts.Retrieve().getFullName();
		    }
		    details=details+"\nEvent date and time:" + dateAndTime  + "\nEvent location:" + location + "\n" ;	
		    return details;
		}//end A case
		else return "";
	}
	
}
	
