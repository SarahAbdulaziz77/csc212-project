package mashael;

public class Event {
	private String title;
	private Contact last_contactInvolved;
	private String dateAndTime;
	private String location;
	private LinkedList<Contact> event_contacts = new LinkedList<Contact>();
	
	public Event(String title, Contact last_contactInvolved, String dateAndTime, String location) {
		super();
		this.title = title;
		this.last_contactInvolved = last_contactInvolved;
		this.dateAndTime = dateAndTime;
		this.location = location;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Contact getLast_contactInvolved() {
		return last_contactInvolved;
	}

	public void setLast_contactInvolved(Contact last_contactInvolved) {
		this.last_contactInvolved = last_contactInvolved;
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
		return "Event title:" + title + "\nContact name:" + last_contactInvolved + "\nEvent date and time" + dateAndTime  
				+ "Event location:" + location ;
	}
	
}
