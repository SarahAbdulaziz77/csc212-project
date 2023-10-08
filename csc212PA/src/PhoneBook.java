package CSC212_PA;

import java.util.Scanner;
public class PhoneBook {
//phone book methods 
	
	
//main method
	public static void main(String[] args) {
	Scanner keyboard = new Scanner(System.in);
	
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
	choice = keyboard.nextInt();
	switch(choice) {
	case 1:{
		System.out.print("\nEnter the contact's name:");
		keyboard.nextLine(); //garbage
		String name = keyboard.nextLine();
		//check by search name if unique method?? then ask user to retry maybe or say nothing
		System.out.print("Enter the contact's phone number:");
		String phone_number = keyboard.next();
		System.out.print("Enter the contact's email address:");
		String email = keyboard.next();
		System.out.print("Enter the contact's address:");
		keyboard.nextLine(); //garbage
		String address = keyboard.nextLine();
		System.out.print("Enter the contact's birthday:");
		String birthday = keyboard.next();
		System.out.print("Enter any notes for the contact:");
		keyboard.nextLine(); //garbage
		String notes = keyboard.nextLine();
		//add
		ContactsList.AddInOrder(new Contact(name,phone_number,email,address,birthday,notes));
		System.out.println("Contact added successfully!\n");
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
	{ //didnt check if he enters wrong multiple times 
		System.out.println("Incorrect number please choose from 1-8!");
		choice=keyboard.nextInt();
	}
	}//close switch
}while(choice!=8);
	
}//end main

}


