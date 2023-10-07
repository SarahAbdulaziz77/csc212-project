package CSC212_PA;

import java.util.Scanner;
public class PhoneBook {
//phone book methods 
	
	
//main method
	public static void main(String[] args) {
	Scanner keyboard = new Scanner(System.in);
	Contact user1 = new Contact("Mashael", "012", "gmail","house", "2003", "extranotes");
	LinkedList<Contact> phonebook = new LinkedList<Contact>();
	phonebook.AddInOrder(user1);
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
	choice = keyboard.nextInt();
	switch(choice) {
	case 1:{
		System.out.print("\nEnter the contact's name:");
		String name = keyboard.next();
		//check by search name if unique method?? then ask user to retry maybe or say nothing
		System.out.print("Enter the contact's phone number:");
		String phone_number = keyboard.next();
		System.out.print("Enter the contact's email address:");
		String email = keyboard.next();
		System.out.print("Enter the contact's address:");
		String address = keyboard.next();
		System.out.print("Enter the contact's birthday:");
		String birthday = keyboard.next();
		System.out.print("Enter any notes for the contact:");
		keyboard.nextLine();//garabage
		String notes = keyboard.nextLine();
		//add
		phonebook.AddInOrder(new Contact(name,phone_number,email,address,birthday,notes));
		System.out.println("Contact added successfully!\n1");
	break;
	}
	case 2:{
		
	break;
	}
	case 3:{
	
	break;
	}
	case 4:{
	
	break;
	}	
	case 5:{
	
	break;
	}	
	case 6:{
	
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
		System.out.println("Incorrect number please choose from 1-8!");
		choice=keyboard.nextInt();
	}
	}//close switch
}while(choice!=8);
	
}//end main

}
