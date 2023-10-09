package CSC212_PA;
import java.util.Scanner;
public class PhoneBook {
    public static Scanner keyboard = new Scanner(System.in);
//phone book methods for interacting with contacts list(when adding,searching,deleting)
//MASHAEL
    public static boolean exist(LinkedList<Contact> ContactsList, Contact new_contact) {
    	if(ContactsList.isEmpty())return false;
    	
        String FullName1,Number1;  
        String FullName2 = new_contact.getFullName();
        String Number2 = new_contact.getPhoneNumber();
        
        ContactsList.FindFirst();
        
        while (!ContactsList.last()) {
            FullName1 = (ContactsList.Retrieve()).getFullName();
            Number1 = (ContactsList.Retrieve()).getPhoneNumber();

            if (FullName1.equals(FullName2) || Number1.equals(Number2)) {
                return true;
            }

            ContactsList.FindNext(); // Move to the next element in the list
        }
        
        // Check the last element outside the loop
        FullName1 = (ContactsList.Retrieve()).getFullName();
        Number1 = (ContactsList.Retrieve()).getPhoneNumber();

        if (FullName1.equals(FullName2) || Number1.equals(Number2)) {
            return true;
        }

        // If not found
        return false;
    }
//MASHAEL
    public static boolean addInOrder(LinkedList<Contact> ContactsList,Contact new_contact) {
     
        if (!exist(ContactsList, new_contact)) {
            if(ContactsList.isEmpty()) {
            	ContactsList.insert(new_contact);
            	return true;
            }
            // look for a suitable place
            ContactsList.FindFirst();
            while (!ContactsList.last()) {
                if ((ContactsList.Retrieve()).compareTo(new_contact.getFullName()) >= 0) {
                    ContactsList.insert(new_contact);
                    return true;
                }
                ContactsList.FindNext();
            }
            // add last if it's the biggest value
            ContactsList.insert(new_contact);
            return true;
        } else {
            return false;
        }
    }
//MASHAEL
    public static void printByFirstName(LinkedList<Contact> ContactsList) {
    	LinkedList<Contact> matching_contacts =new LinkedList<Contact>();
    	String contact_fullName;
        System.out.print("\nEnter the first name:");
        String firstName=keyboard.next();
        
        if(ContactsList.isEmpty()) {
        	System.out.println("\nNo Contacts found inside this phonebook.\n");
        	return;
        }
        
        ContactsList.FindFirst();
        while(!ContactsList.last()) {
             contact_fullName= ContactsList.Retrieve().getFullName();
            if(contact_fullName.substring(0,contact_fullName.indexOf(' ')).equals(firstName))
                matching_contacts.insert( ContactsList.Retrieve() );
            ContactsList.FindNext();
            }
        
            // check last element
            contact_fullName= ContactsList.Retrieve().getFullName();
            if(contact_fullName.substring(0,contact_fullName.indexOf(' ')).equals(firstName)) 
                matching_contacts.insert( ContactsList.Retrieve() );
            
            if(matching_contacts.isEmpty())
            	System.out.println("\nNo Contacts were found by this name.\n");
            	else {
            		System.out.println("\nContacts found!");
            		matching_contacts.FindFirst();
                    while (!matching_contacts.last()) {
                        System.out.println(matching_contacts.Retrieve());
                        matching_contacts.FindNext();
                    }
                    // print last
                    System.out.println(matching_contacts.Retrieve());
            	    }
    }
//SARAH
    public static Contact SearchForName(LinkedList<Contact> List,String name) {
        if(List.isEmpty()) {
            return null;
        }
        else {
            List.FindFirst();
            while(!List.last()) {
                if(List.Retrieve().getFullName().equalsIgnoreCase(name)) {
                    return List.Retrieve();}
                List.FindNext();
            }
            if(List.Retrieve().getFullName().equalsIgnoreCase(name))
                return List.Retrieve();
                return null;
        }
    }

    public static Contact SearchForPhoneNumber(LinkedList<Contact> List,String number) {
        if(List.isEmpty()) {
            return null;
        }
        else {
            List.FindFirst();
            while(!List.last()) {
                if(List.Retrieve().getFullName().equalsIgnoreCase(number)) {
                    return List.Retrieve();}
                List.FindNext();
            }
            if(List.Retrieve().getFullName().equalsIgnoreCase(number))
                return List.Retrieve();
            return null;
        }
    }

    public static LinkedList<Contact> SearchForEmail(LinkedList<Contact> List ,String email) {
        LinkedList<Contact> EmailFound = new LinkedList<Contact>();
        if (List.isEmpty()) {
            return EmailFound;} 
        else {
            List.FindFirst();
            while (!List.last()) {
                if (List.Retrieve().getEmail().equalsIgnoreCase(email))
                    EmailFound.insert(List.Retrieve());
                List.FindNext();
            }
            if (List.Retrieve().getEmail().equalsIgnoreCase(email))
                EmailFound.insert(List.Retrieve());
            
            return EmailFound;
        }
    }
    
    //main method
    public static void main(String[] args) {

        LinkedList<Contact> ContactsList = new LinkedList<Contact>();

        int choice = 0;
        do {
            System.out.println("Welcome to the Linked Tree PhoneBook!");
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
                    if(addInOrder(ContactsList,new_contact) )
                    	System.out.println("\nContact added successfully!\n");
                    else 
                    	System.out.println("\nContact already exists.\n");
                    break;
                }
                case 2:{

                    break;
                }
                case 3:{
                    //delete a contact
                    System.out.print("Enter the contact's name or phone number");
                    String nameOrNumber = keyboard.nextLine();
                    //when the contact is deleted, the variable deleted will be true
                    boolean deleted = ContactsList.deleteContact(nameOrNumber);
                    if (deleted == true) {
                        System.out.print("\nThe contact is deleted successfully!");
                    }else {
                        System.out.print("\nThe contact is not found");
                    }


                    break;
                }
                case 4:{

                    break;
                }
                case 5:{

                    break;
                }
                case 6:{
                    //Print contacts by first name
                	printByFirstName(ContactsList);
                    break;
                }
                case 7:{

                    break;
                }
                case 8:{
                    System.out.println("GoodBye!");
                    break;
                }
                default:
                {
                    System.out.println("Incorrect number please choose from 1-8!\n");
                }
            }//close switch
            } catch(Exception e) {
                // Handle incorrect input
                System.out.println("Incorrect input. Please try again.\n");
                keyboard.next(); // Consume the invalid input
            }
        }while(choice!=8);
        
/*this is an extra print list test*/
        if(!ContactsList.isEmpty()) {
        ContactsList.FindFirst();
        while (!ContactsList.last()) {
            System.out.println(ContactsList.Retrieve());
            ContactsList.FindNext();
        }
        // print last
        System.out.println(ContactsList.Retrieve());}
        
    }//end main

}

