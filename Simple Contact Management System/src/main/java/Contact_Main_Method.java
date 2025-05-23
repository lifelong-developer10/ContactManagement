import java.util.ArrayList;
import java.util.Scanner;

public class Contact_Main_Method {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Contact_Model cm = new Contact_Model();
		boolean res =true;
		
		
		while(res){
			System.out.println("\n====== Contact Management System =====");
			System.out.println("Choice 1 for Adding Contact");
			System.out.println("Choice 2 for View Contacts");
			System.out.println("Choice 3 for Updating Contacts");
			System.out.println("Choice 4 for Deleting Contact");
			System.out.println("Choice 5 for Exit");
			System.out.println();
			System.out.println("Enter Your Choice Here:");
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1:{
				System.out.println("Enter the Name:");
				String name = sc.next();
				System.out.println("Enter the Contact Number:");
		        String contact = sc.next();
				System.out.println("Enter the Email Id:");
		        String email = sc.next();
		        cm.addContact(name,contact,email);
		        break;
			}
			case 2:{
				ArrayList<Contact> contact = cm.getContact();
				if(contact.isEmpty()) {
					System.out.println("No Contact Number is Found");
					
				}else {
					for(Contact c: contact) 
						System.out.println(c);
				}break;
			}
			case 3:{
				System.out.println("Enter the Id for Updating:");
				int uid = sc.nextInt();
				System.out.println("Enter the Name:");
				String newName = sc.next();
				System.out.println("Enter the Contact Number:");
				String newNumber = sc.next();
				System.out.println("Enter the Email :");
				String newEmail = sc.next();
		         cm.updateContact(uid,newName,newNumber,newEmail);
		         
				break;
			}
			case 4:{
				System.out.println("Enter the ID to Delete:");
				int did = sc.nextInt();
				cm.deleteContact(did);
				break;
			}
			case 5:{
				System.out.println("Exiting...");
				 sc.close();
                 System.exit(0);
                 res=false;
                 break;
			}
			default:
				System.out.println("Invalid Choice");
				
		}
	
		if (res) {
		    System.out.println("\n=======================================================================================\n");
		    System.out.println("Do you want to continue:");
		    System.out.println("If Yes, type true. If No, type false.");
		    System.out.println();
		    System.out.println("Enter Your Choice:");
		    
		    if (sc.hasNextBoolean()) {
		        res = sc.nextBoolean();
		        sc.nextLine();
		    } else {
		        System.out.println("Invalid input! Exiting...");
		        break;
		    }

		} else {
		    System.out.println("Exiting...");
		    break;
		}

		}
		
			
		}
	

	
	}
	


