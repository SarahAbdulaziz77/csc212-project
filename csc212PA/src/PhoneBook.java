package CSC212_PA;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PhoneBook {
    public static Scanner keyboard = new Scanner(System.in);
//phone book methods for interacting with contacts list(when adding,searching,deleting)
//MASHAEL OLD
    public static void printContactsByFirstName(LinkedList<Contact> ContactsList) {
    	LinkedList<Contact> matching_contacts =new LinkedList<Contact>();
    	String contact_fullName;
        System.out.print("\nEnter the first name:");
        String firstName=keyboard.next();
        //if empty
        if(ContactsList.isEmpty()) {
        	System.out.println("\nNo Contacts found inside this phonebook.\n");
        	return;
        }
        //search
        ContactsList.FindFirst();
        while(!ContactsList.last()) {
             contact_fullName= ContactsList.Retrieve().getFullName();
            if(contact_fullName.substring(0,contact_fullName.indexOf(' ')).equalsIgnoreCase(firstName))
                matching_contacts.insert( ContactsList.Retrieve() );
            ContactsList.FindNext();
            }
            // check last element
            contact_fullName= ContactsList.Retrieve().getFullName();
            if(contact_fullName.substring(0,contact_fullName.indexOf(' ')).equalsIgnoreCase(firstName)) 
                matching_contacts.insert( ContactsList.Retrieve() );
            
            //result
            if(matching_contacts.isEmpty())
            	System.out.println("\nNo Contacts were found by this name.\n");
            	else {
            		System.out.println("\nContacts found!");
            		//print list
            		matching_contacts.FindFirst();
                    while (!matching_contacts.last()) {
                        System.out.println(matching_contacts.Retrieve());
                        matching_contacts.FindNext();
                    }
                    // print last
                    System.out.println(matching_contacts.Retrieve());
            	    }
    }
    //MASHAEL 
    public static void print_Events(LinkedList<Event> EventsList) {
	    //events were inserted by alphabetical order
        if(!EventsList.isEmpty()) {
        EventsList.FindFirst();
        while (!EventsList.last()) {
            System.out.println(EventsList.Retrieve()+"\n");
            EventsList.FindNext();
        }
        // print last
        System.out.println(EventsList.Retrieve());
    }
    }
  
//SARAH
   /* public static Contact SearchForName(LinkedList<Contact> ContactsList, String name) {
            if (ContactsList.isEmpty()) {
                return null;
            } else {
                ContactsList.FindFirst();
                while (!ContactsList.last()) {
                    if (ContactsList.Retrieve().getFullName().equalsIgnoreCase(name)) {
                        return ContactsList.Retrieve();
                    }
                    ContactsList.FindNext();
                }
                if (ContactsList.Retrieve().getFullName().equalsIgnoreCase(name))
                    return ContactsList.Retrieve();
                return null;
            }
        }

        public static Contact SearchForPhoneNumber(LinkedList<Contact> ContactsList, String number) {
            if (ContactsList.isEmpty()) {
                return null;
            } else {
                ContactsList.FindFirst();
                while (!ContactsList.last()) {
                    if (ContactsList.Retrieve().getFullName().equalsIgnoreCase(number)) {
                        return ContactsList.Retrieve();
                    }
                    ContactsList.FindNext();
                }
                if (ContactsList.Retrieve().getFullName().equalsIgnoreCase(number))
                    return ContactsList.Retrieve();
                return null;
            }
        }

        public static LinkedList<Contact> SearchForEmail(LinkedList<Contact> ContactsList, String email) {
            LinkedList<Contact> EmailFound = new LinkedList<Contact>();
            if (ContactsList.isEmpty()) {
                return EmailFound;
            } else {
                ContactsList.FindFirst();
                while (!ContactsList.last()) {
                    if (ContactsList.Retrieve().getEmail().equalsIgnoreCase(email))
                        EmailFound.insert(ContactsList.Retrieve());
                    ContactsList.FindNext();
                }
                if (ContactsList.Retrieve().getEmail().equalsIgnoreCase(email))
                    EmailFound.insert(ContactsList.Retrieve());

                return EmailFound;
            }
        }

        public static LinkedList<Contact> SearchForAddress(LinkedList<Contact> ContactsList, String address) {
            LinkedList<Contact> AddressFound = new LinkedList<Contact>();
            if (ContactsList.isEmpty()) {
                return AddressFound;
            } else {
                ContactsList.FindFirst();
                while (!ContactsList.last()) {
                    if (ContactsList.Retrieve().getAddress().equalsIgnoreCase(address))
                        AddressFound.insert(ContactsList.Retrieve());
                    ContactsList.FindNext();
                }
                if (ContactsList.Retrieve().getAddress().equalsIgnoreCase(address))
                    AddressFound.insert(ContactsList.Retrieve());

                return AddressFound;
            }
        }

        public static LinkedList<Contact> SearchForBirthday(LinkedList<Contact> ContactsList, String birthday) {
            LinkedList<Contact> BirthdayFound = new LinkedList<Contact>();
            if (ContactsList.isEmpty()) {
                return BirthdayFound;
            } else {
                ContactsList.FindFirst();
                while (!ContactsList.last()) {
                    if (ContactsList.Retrieve().getBirthday().equalsIgnoreCase(birthday))
                        BirthdayFound.insert(ContactsList.Retrieve());
                    ContactsList.FindNext();
                }
                if (ContactsList.Retrieve().getBirthday().equalsIgnoreCase(birthday))
                    BirthdayFound.insert(ContactsList.Retrieve());

                return BirthdayFound;
            }
        }
*///sarah searches^^
	//SearchEventByContactName method
      /*  public static Event SearchEbyName (LinkedList<Event> Events, String name) {
            if (Events.isEmpty()){
                return null; }
            else {
                Events.FindFirst();
                while (!Events.last()) {
                    if (Events.Retrieve().getContact_name().equalsIgnoreCase(name))
                        return Events.Retrieve();
                    Events.FindNext();
                }
                if (Events.Retrieve().getContact_name().equalsIgnoreCase(name))
                        return Events.Retrieve();

                        return null;
                }

        }*/

        //SearchEventByTitle method
        public static Event SearchEbyTitle (LinkedList<Event> Events, String title) {
            if (Events.isEmpty()) {
                return null;
            } else {
                Events.FindFirst();
                while (!Events.last()) {
                    if (Events.Retrieve().getTitle().equalsIgnoreCase(title))
                        return Events.Retrieve();
                    Events.FindNext();
                }
                if (Events.Retrieve().getTitle().equalsIgnoreCase(title))
                    return Events.Retrieve();

                    return null;


            }
        }

	 /*public static void ContactsShareEvent (Event event) {
		 LinkedList<Contact> ContactsList = event.getEvent_contacts();
		 if (!ContactsList.isEmpty()) {
			 ContactsList.FindFirst();
			 while(!ContactsList.last()) {
				 System.out.println("contact name : " + ContactsList.Retrieve().getFullName())  ;
				 ContactsList.FindNext();
			 }
			 System.out.println("contact name : " + ContactsList.Retrieve().getFullName())  ;
		 }
           
        }
	 
	 */
	/* public static void PrintListForAllContacts(LinkedList<Contact> ContactsList){
            if (ContactsList.isEmpty()){
                System.out.println("Sorry, the list is empty");
            }
            else {
                ContactsList.FindFirst();
                while (!ContactsList.last()){
                    ContactsList.Retrieve().printContact();
                    System.out.println("\n");
                    ContactsList.FindNext();
                }
                ContactsList.Retrieve().printContact();
                System.out.println("\n");

            }

        }
*/
        //MASHAEL
	 public static void deleteMatchingContactEventsForEventsList(String name, LinkedList<Event> Events) {
		 if(Events.isEmpty()) {
			 return ;
		 }
		 //delete by appointment or event case
			 Events.FindFirst();
			 Event event;
			 //loop through all events of user and then for the last one repeat the code
			 while(!Events.last()) {
				 event = Events.Retrieve();
				 if(event.getType()=='E') {
					 while (!event.getEvent_contacts().last()) {
					 if (event.getEvent_contacts().Retrieve().getFullName().equalsIgnoreCase(name)) {
					   	 //moves current and delete contact
						  event.getEvent_contacts().Remove();
						  //if he was the only one in this event
						  if(event.getEvent_contacts().isEmpty())
							  Events.Remove();
					     }
					 }//end inner while for the contacts of one event
				     //check last contact in this event 'E'
					 event = Events.Retrieve();
				     if (!Events.isEmpty() && event.getEvent_contacts().Retrieve().getFullName().equalsIgnoreCase(name)) {
					   	 //moves current and delete contact
							  event.getEvent_contacts().Remove();
							  //if he was the only one in this event
							  if(event.getEvent_contacts().isEmpty())
								  Events.Remove();
						     }	
				 }//end event 'E' Case 
				 else if(event.getType()=='A') {
					 //only look for first one in list cause there is only one
				      if (event.getEvent_contacts().Retrieve().getFullName().equalsIgnoreCase(name)) {
				   	 //moves current and delete
					  Events.Remove();
				      }
				 }//end appointment 'A' Case
                 //no matching found continue and move current
				 else if(!Events.isEmpty())
				      Events.FindNext();
		     }//end outer while
			 
			 //check last event/app in all event list
			 event = Events.Retrieve();
			 if(event.getType()=='E') {
				 while (!event.getEvent_contacts().last()) {
				 if (event.getEvent_contacts().Retrieve().getFullName().equalsIgnoreCase(name)) {
				   	 //moves current and delete contact
					  event.getEvent_contacts().Remove();
					  //if he was the only one in this event
					  if(event.getEvent_contacts().isEmpty())
						  Events.Remove();
				     }
				 }//end inner while for the contacts of one event
			     //check last contact in this event 'E'
				 event = Events.Retrieve();
			     if (!Events.isEmpty() && event.getEvent_contacts().Retrieve().getFullName().equalsIgnoreCase(name)) {
				   	 //moves current and delete contact
						  event.getEvent_contacts().Remove();
						  //if he was the only one in this event
						  if(event.getEvent_contacts().isEmpty())
							  Events.Remove();
					     }	
			 }//end event 'E' Case 
			 else if(event.getType()=='A') {
				 //only look for first one in list cause there is only one
			      if (event.getEvent_contacts().Retrieve().getFullName().equalsIgnoreCase(name)) {
			   	 //moves current and delete
				  Events.Remove();
			      }
			 }//end appointment 'A' Case
	 }//end method

	 
        public static boolean scheduleEvent(ContactBST Contactstree,LinkedList<Event> eventsList,LinkedList<Contact> contactsList, Event event) {
        	//check if contactsList empty 
        	if ( contactsList.isEmpty())
        		return false;
        	
        	//check if contact exist in phone book bst
        	contactsList.FindFirst();
             while (!contactsList.last()) {
                 if (!(Contactstree.findkey(contactsList.Retrieve().getFullName())))
                     return false;
                 contactsList.FindNext();
             }
             if (!(Contactstree.findkey(contactsList.Retrieve().getFullName())))
            	//System.out.println("The even was not added due to contact(s) unavailability");
                 return false;
             
             
             //if event exists
             Event existingEvent = SearchEbyTitle(eventsList,event.getTitle()); //same title
             //same time and location
             if (event.getType() == 'E' && existingEvent.getDateAndTime().equals(event.getDateAndTime()) && existingEvent.getLocation().equals(event.getLocation()))  {
            	 if ( contactsList.isEmpty())
                		return false;
             	
                	
            	 contactsList.FindFirst();
                     while (!contactsList.last()) {
                     	event.getEvent_contacts().insert(contactsList.Retrieve());
                     	contactsList.FindNext();
                     }
                     event.getEvent_contacts().insert(contactsList.Retrieve());
                     //System.out.println("added contacts to an exisiting event");
                     return true;
                
             }
            	 
             
             
        }
 
        	
        	
        	
        	/*Contact contact = ContactsList(contactsList,event.getContact_name());
        	if(contact==null) return false;
        	
        	Event existingEvent = SearchEbyTitle(eventsList,event.getTitle()) ;
        	if( existingEvent !=null ) {
        		existingEvent.getEvent_contacts().insert(contact); 
        	    existingEvent.setContact_name(contact.getFullName());
        	    contact.getContact_events().insert(existingEvent);
        	    return true;
        	}

        	
        	int ch1 , ch2;
        	// If the eventsList is empty
        	if ( eventsList.isEmpty() ) {
        	    eventsList.insert(event);
        	    event.getEvent_contacts().insert(contact); 
        	    event.setContact_name(contact.getFullName());
        	    contact.getContact_events().insert(event);
        	    return true;
        	} 
        	else {
        		eventsList.FindFirst();
            	//the new event should be inserted at the beginning
        		ch1=event.getTitle().charAt(0);
        		ch2=eventsList.Retrieve().getTitle().charAt(0);
        		if(ch1>= 97)
        			ch1=ch1-32;
        		if(ch2>= 97)
        			ch2=ch2-32;
            	if(ch1 < ch2 ) {
            			Event moved_event=eventsList.Retrieve();
            			eventsList.update(event);
            			eventsList.insert(moved_event);
                	    event.getEvent_contacts().insert(contact); 
                	    event.setContact_name(contact.getFullName());
                	    contact.getContact_events().insert(event);
            			return true;
            		}
            	
        	    eventsList.FindFirst();
        	    // Iterate through the list to find the correct position to insert the event in middle
        	    while (!eventsList.last()) {
            		ch1=event.getTitle().charAt(0);
            		ch2=eventsList.Retrieve().getTitle().charAt(0);
            		if(ch1>= 97)
            			ch1=ch1-32;
            		if(ch2>= 97)
            			ch2=ch2-32;
        	    	if(ch2>ch1) {
            			Event moved_event=eventsList.Retrieve();
            			eventsList.update(event);
            			eventsList.insert(moved_event);
                	    event.getEvent_contacts().insert(contact); 
                	    event.setContact_name(contact.getFullName());
                	    contact.getContact_events().insert(event);
                	    return true;
        	    	}		
        	        eventsList.FindNext();
        	    } 
        	    //check last to insert before it
        		ch1=event.getTitle().charAt(0);
        		ch2=eventsList.Retrieve().getTitle().charAt(0);
        		if(ch1>= 97)
        			ch1=ch1-32;
        		if(ch2>= 97)
        			ch2=ch2-32;
        	    if(ch2>ch1) {
        			Event moved_event=eventsList.Retrieve();
        			eventsList.update(event);
        			eventsList.insert(moved_event);
            	    event.getEvent_contacts().insert(contact); 
            	    event.setContact_name(contact.getFullName());
            	    contact.getContact_events().insert(event);
            	    return true;
            	}	
        	    //if it should be last
    			eventsList.insert(event);
    			event.setContact_name(contact.getFullName());
        	    event.getEvent_contacts().insert(contact); 
        	    contact.getContact_events().insert(event);
    			return true;
        	}
        }
        */
             
       public static boolean addContactstoExistEvent(Event event, LinkedList<Contact> contacts) { 
    	   if ( contacts.isEmpty())
       		return false;
    	
       	
    	   contacts.FindFirst();
            while (!contacts.last()) {
            	event.getEvent_contacts().insert(contacts.Retrieve());
            	contacts.FindNext();
            }
            event.getEvent_contacts().insert(contacts.Retrieve());
            return true;
       
       }
             
             
        //Futun
        public static boolean isConflict(Event event, LinkedList<Event> Events) {
        	//if the list is empty then there is no conflict
        	if (Events.isEmpty()) {
        		return false;
        	}
        	Events.FindFirst();
        	while (! Events.last()) {
        		if ( Events.Retrieve().getDateAndTime().equals(event.getDateAndTime())) {
        			if( Events.Retrieve().getTitle().equals(event.getTitle())){
        				//the event already exists so we will just add the contact in it
        				return false;	
        			}
        			else 
        				return true;
	
        		}
        		Events.FindNext();
        	}//end of while
        		
        		//checking the last element
        		if ( Events.Retrieve().getDateAndTime().equals(event.getDateAndTime())) {
        			if( Events.Retrieve().getTitle().equals(event.getTitle())){
        				//the event already exists so we will just add the contact in it
        				return false;	
        			}
        			else 
        				return true;
        		
        	}
        		//all the list have been checked
        		return false;
        }
        public static boolean validateDateAndTime(String dateAndTime) {
        	//validate date format before
            // Define the desired date and time format using the java function
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
            try {
                // Parse the input date and time
                Date parsedDate = dateFormat.parse(dateAndTime);
                return true;
            } catch (ParseException e) {
                // Handle invalid date format
            	System.out.println("\nInvalid date and time format. Please enter in MM/DD/YYYY HH:MM format.\n");
            	return false;
            }
        }
    //main method
    public static void main(String[] args) {

        ContactBST ContactsList = new ContactBST();
        LinkedList<Event> EventsList = new LinkedList<Event>();
        System.out.println("\nWelcome to the Linked Tree PhoneBook!");
        int choice = 0;
        do {
            System.out.println("Please choose an option:");
            System.out.println("1.Add a contact");
            System.out.println("2.Search for a contact");
            System.out.println("3.Delete a contact");
            System.out.println("4.Schedule an event");
            System.out.println("5.Print event details");
            System.out.println("6.Print contacts by first name");
            System.out.println("7.Print all events alphabetically");
            System.out.println("8.Exit\n");
            System.out.print("Enter your choice:");
            try {
            choice = keyboard.nextInt();
            switch(choice) {
                case 1:{
                	 System.out.print("\nEnter the contact's name:");
                     // remove garbage
                     keyboard.nextLine();
                     String name = keyboard.nextLine();
                     if(name.indexOf(' ')== -1)
                    	name= name.concat(" ");
                     System.out.print("Enter the contact's phone number:");
                     String phone_number = keyboard.next();
                     System.out.print("Enter the contact's email address:");
                     String email = keyboard.next();
                     System.out.print("Enter the contact's address:");
                     // remove garbage
                     keyboard.nextLine();
                     String address = keyboard.nextLine();
                     System.out.print("Enter the contact's birthday:");
                     String birthday = keyboard.next();
                     System.out.print("Enter any notes for the contact:");
                     // remove garbage
                     keyboard.nextLine();
                     String notes = keyboard.nextLine();
                     // create a contact
                     
                     Contact new_contact = new Contact(name, phone_number, email, address, birthday, notes);
                    if(ContactsList.insert(name,new_contact))
                    	System.out.println("\nContact added successfully!\n");
                    else 
                    	System.out.println("\nContact already exists.\n");
                    break;
                }
		/*SARAH 
                 case 2: {
                            LinkedList<Contact> Contactfound = new LinkedList<Contact>();
                            int SearchChoice=0;
                            do {

                                System.out.println("Enter search criteria: ");
                                System.out.println("1.Name");
                                System.out.println("2.Phone Number");
                                System.out.println("3.Email Address ");
                                System.out.println("4.Address ");
                                System.out.println("5.Birthday");
                                System.out.println("Enter your choice: ");
                                SearchChoice = keyboard.nextInt();
                                switch (SearchChoice) {
                                    case 1:
                                        System.out.println("\nEnter the contact's name: ");
                                        //remove garbage
                                        keyboard.nextLine();
                                        String name = keyboard.nextLine();
                                        Contact Namefound = SearchForName(ContactsList, name);
                                        if (Namefound==null){
                                            System.out.println("Sorry,this Contact name is not exist!");
                                        }
                                        else {
                                            System.out.println("Contact found!");
                                            Namefound.printContact();
                                        }
                                        break;
                                    case 2:
                                        System.out.println("\nEnter the contact's Phone Number: ");
                                        //remove garbage
                                        keyboard.nextLine();
                                        String PhoneNumber = keyboard.nextLine();
                                        Contact Phonefound= SearchForPhoneNumber(ContactsList, PhoneNumber);
                                        if (Phonefound==null){
                                            System.out.println("Sorry,this phone number is not exist! ");
                                        }
                                        else {
                                            Phonefound.printContact();
                                        }

                                        break;
                                    case 3:
                                        System.out.println("\nEnter the contact's Email Address: ");
                                        //remove garbage
                                        keyboard.nextLine();
                                        String Email = keyboard.nextLine();
                                            Contactfound = SearchForEmail(ContactsList, Email);
                                            if (Contactfound.isEmpty()){
                                                System.out.println("Contact is NOT found ");
                                            }
                                            else {
                                                PrintListForAllContacts(Contactfound);
                                            }
                                        break;
                                    case 4:
                                        System.out.println("\nEnter the contact's Address: ");
                                        //remove garbage
                                        keyboard.nextLine();
                                        String Address = keyboard.nextLine();
                                        Contactfound = SearchForAddress(ContactsList, Address);
                                        if (Contactfound.isEmpty()){
                                            System.out.println("Contact is NOT found ");
                                        }
                                        else {
                                            PrintListForAllContacts(Contactfound);
                                        }

                                        break;
                                    case 5:
                                        System.out.println("\nEnter the contact's Birthday date: ");
                                        //remove garbage
                                        keyboard.nextLine();
                                        String Birthday = keyboard.nextLine();
                                        Contactfound = SearchForBirthday(ContactsList, Birthday);
                                        if (Contactfound.isEmpty()){
                                            System.out.println("Contact is NOT found ");
                                        }
                                        else {
                                            PrintListForAllContacts(Contactfound);
                                        }
                                        break;
                                    default:
                                        System.out.println("Incorrect number please choose from 1-5!\n");
                                } //close inner switch
                            } while (SearchChoice <=0 || SearchChoice>6);
                            break;
                        }// close case2

                */
           //MASHAEL
               case 3:{
            	   boolean deleted=false;
                    //delete a contact and delete his appointments or his name if he exist in event
            	   //i need to check here if he can delete by number
                    System.out.print("Enter the contact's name: ");
                    // remove garbage
                    keyboard.nextLine();
                    String name = keyboard.nextLine();
                    //1.remove from contacts list
                    
                    if(ContactsList.removeKey(name) )
                    	deleted=true;
                    //2.remove from events list
                    deleteMatchingContactEventsForEventsList(name, EventsList);
                    
                  
                    if (deleted == true) {
                        System.out.println("\nThe contact is deleted successfully!");
                    }else {
                        System.out.println("\nThe contact is not found");
                    }


                    break;
                }
                 case 4:{
                     do {
                         System.out.println("\nEnter type: ");
                         System.out.println("1.event");
                         System.out.println("2.appointment");
                         char type = keyboard.next().charAt(0);
                         String title,location,dateAndTime;
                         String contact_name;
                         boolean validDateAndTime;
                         LinkedList<Contact> givenContacts=new LinkedList<Contact>();
                            switch (type) {
                            
                               case 1: //event
                               //check if event already exist just add the contact to the list otherwise create it
                                    System.out.print("\nEnter event title:");
                                    // remove garbage
                                    keyboard.nextLine();
                                    title = keyboard.nextLine();
                                    System.out.print("Enter contacts name separated by a comma:");
                                    contact_name = (String) keyboard.nextLine();
                                    givenContacts.insert(ContactsList.getContact(contact_name));
                                    for (String name : contact_name.split(", ")) {
                                    	givenContacts.insert(ContactsList.getContact(contact_name));
                                    }
                                    
                                    
                                    do {
                                       System.out.print("Enter event date and time(MM/DD/YYYY HH:MM):");
                                       dateAndTime = keyboard.nextLine();
                                       }while( validateDateAndTime(dateAndTime)  ) 
                                    System.out.print("Enter event location:");
                                    location = keyboard.nextLine();
                                    break;
                                       
                                    
                               case 2: //appointment
                                    System.out.print("\nEnter appointment title:");
                                    // remove garbage
                                    keyboard.nextLine();
                                    title = keyboard.nextLine();
                                    System.out.print("Enter contact name:");
                                    contact_name = keyboard.nextLine();
                                    //i will be searching for the contact from the tree
                                    givenContacts.insert(ContactsList.getContact(contact_name)); //missing info to create contact object
                                    do {
                                       System.out.print("Enter event date and time(MM/DD/YYYY HH:MM):");
                                       dateAndTime = keyboard.nextLine();
                                       }while( validateDateAndTime(dateAndTime) )
                                    System.out.print("Enter appointment location:");
                                    location = keyboard.nextLine();
                                    break; 
                                    
                              default:
                                    System.out.println("Incorrect number please choose from 1-2!\n");
                            }//close inner switch
                            
                    Event event= new Event(type,title,givenContacts, dateAndTime, location);
                    
                    
                   
                    //isConflict !!!THIS METHOD SHOULD BE CHANGED ONLY CHECK IF IT HAS CONFLICT WITH ANOTHER EVENT/APP THE USER HAVE IN TIME 
                    if(!(PhoneBook.isConflict(event,EventsList))) {
                    	//scheduleEvent checks if the contact exists then adds the event
                    	if( scheduleEvent(ContactsList,EventsList,givenContacts,event) )
                    		
                    		
                    		
                    		
                    		
                    		System.out.println("\nEvent scheduled successfully!\n");
                    	else
                    		System.out.println("\nCouldnt schedule, contact not found.\n");
                    }else
                    	System.out.println("Couldnt schedule, There is a conflict.");
                    // if there is a conflict the method isConflict will explain the conflict with a print method
                    
                    	break;
                    }
                  
                 case 5: {
                  //print all events or appointments that share the same title or contact name
                            int SearchChoice2=0;
                            do {
                                System.out.println("Enter search criteria: ");
                                System.out.println("1.Contact name");
                                System.out.println("2.Event title");
                                SearchChoice2 = keyboard.nextInt();
                                switch (SearchChoice2) {
                                    case 1:
                                    /*
                                        System.out.println("\nEnter the contact name: ");
                                        //remove garbage
                                        keyboard.nextLine();
                                        String ContactName = keyboard.nextLine();
                                        Event EventfoundS = SearchEbyName(EventsList, ContactName);
                                        if (EventfoundS == null) {
                                            System.out.println(" Sorry Event not found. ");
                                        } else {
                                            System.out.println("Event found!");
                                            printEventDetails(EventfoundS);
                                        }
                                        */
                                        break;
                                        
                                    case 2:
                                        System.out.println("\nEnter the event title: ");
                                        //remove garbage
                                        keyboard.nextLine();
                                        String EventTitle = keyboard.nextLine();
                                        Event Eventfoundt = SearchEbyTitle(EventsList, EventTitle);
                                        if (Eventfoundt == null) {
                                            System.out.println(" Sorry Event not found. ");
                                        } else {
                                            System.out.println("Event found!");
                                            System.out.print(Eventfoundt);
                                        }
                                        break; 
                                    default:
                                        System.out.println("Incorrect number please choose from 1-2!\n");

                                }//close inner switch
                            }while (SearchChoice2 <=0 || SearchChoice2>2);

                            break;
                        } //close case 5
                
                /*case 6:{
                    //Print contacts by first name
                	printContactsByFirstName(ContactsList);
                    break;
                }*/
                case 7:{
                	System.out.println("\nAll Events list:\n");
                	print_Events(EventsList);
                    break;
                }
                case 8:{
                    System.out.println("GoodBye!");
                    break;
                }
                default:
                {
                    System.out.println("Incorrect number please try again and choose from 1-8!\n");
                }
            }//close switch
            } catch(InputMismatchException e) {
                // Handle incorrect input
                System.out.println("Invalid input please try again and enter a number from 1-8.\n");
                keyboard.next(); // Consume the invalid input
            }
        }while(choice!=8);
        
        
    }//end main

}
