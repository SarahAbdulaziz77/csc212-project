
public class Event {
	private String title;
	private String contact_name;
	private String dateAndTime;
	private String location;
	private LinkedList<Contact> event_contacts = new LinkedList<Contact>();

	public Event(String title, String last_contactInvolved, String dateAndTime, String location) {
		super();
		this.title = title;
		this.contact_name = last_contactInvolved;
		this.dateAndTime = dateAndTime;
		this.location = location;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContact_name() {
		return contact_name;
	}

	public void setContact_name(String last_contactInvolved) {
		this.contact_name = last_contactInvolved;
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
		return "Event title:" + title + "\nContact name:" + contact_name + "\nEvent date and time" + dateAndTime  
				+ "Event location:" + location ;
	}
	
}
