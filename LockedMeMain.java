package pack;

import java.util.Scanner;

public class LockedMeMain
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		//The following print statements represent what we should expect for the welcome menu to start
		System.out.println("\n==========================================\n");
		System.out.println("        LOCKEDME.COM  FILE MANAGER");
		System.out.println("\n==========================================");
		System.out.println("\n                 WELCOME!");
		
		int firstMenuSelection = 3;
		int secondMenuSelection = 4;
		
		//Since we know we want to do this until the user hits the quit button, we can use a do while loop
		do
		{
			System.out.println("\nPLEASE MAKE YOUR CHOICE BELOW:\n");
			System.out.println("\t1. View Files in ascending order\n");
			System.out.println("\t2. Modify files\n");
			System.out.println("\t3. Close Application\n");
			
			firstMenuSelection = scan.nextInt();
			
			switch(firstMenuSelection)
			{
				case(1):
					System.out.println("\nShowing files in ascending order.");
					break;
					
				//Uses a do while loop within the current one to act as a submenu until user decides to back-out to main menu
				case(2):
					do
					{
						System.out.println("\n           Modifying files.");
						System.out.println("What would you like to do?:\n");
						System.out.println("\t1. Add file\n");
						System.out.println("\t2. Delete file\n");
						System.out.println("\t3. Search for a file\n");
						System.out.println("\t4. Return to main menu\n");
						secondMenuSelection = scan.nextInt();
						
						switch(secondMenuSelection)
						{
							case(1):
								System.out.println("\nAdding a file\n");
								break;
							case(2):
								System.out.println("\nDeleting a file\n");
								break;	
							case(3):
								System.out.println("\nSearching for a file\n");
								break;	
							case(4):
								System.out.println("\nQuiting to main menu\n");
								break;	
							default:
								System.out.println("Invalid choice please try again.\n");
								break;
						}
					
					}
					while(secondMenuSelection != 4);
					break;
				case(3):
					System.out.println("\nQuitting.");
					break;
				default:
					System.out.println("\nInvalid selection. Please Try Again.\n");
					break;
			}
		}
		while(firstMenuSelection != 3);
		
	}
}
