// Importing Java scanner
import java.util.Scanner; 

// Declaring class UI
class UI {
  // Initializing instance variable
  private boolean validInput = true;
	// Declaring instance variable
  private Scanner scanner;

  // Defining constructor
  public UI() {
	 // Display welcome message and initialize a scanner
    System.out.println("Welcome to BreezeFly flight management system");
    this.scanner = new Scanner(System.in);
  } // End of constructor


  // Defining login method
  public void login(){
		// Start main program or exit depending on input
    do {
      this.validInput = true;
      System.out.print("Log in? y/n \n> ");
      char input = this.scanner.nextLine().charAt(0);
      if (input == 'y') {
        interface();
      } // End of if statment
      else if (input == 'n') {
        System.out.println("Shutting down");
        System.exit(0);
      } // End of else if statment
      else {
        this.validInput = false;
        System.out.println("Invalid input!");
      } // End of else statment
      
    } while(!validInput); // End of do loop
    
  } // End of login method

  
	// Defining interface method
  public void interface(){
    // Declaring local variable
    String planeIdentifier;
    
		//Propmt user for input and preform according tasks until user logs out
    while(true) {
      System.out.print("1. View a plane \n" + 
                       "2. Register a new plane \n" + 
                       "3. Manage a plane \n" + 
                       "100. Log off \n> "
                      );
      int choice = Integer.parseInt(scanner.nextLine());
      if (choice == 100) {
        System.exit(0);
      } // End of if statment, exit choice
        
      else if (choice == 1){
        System.out.print("Enter plane ID \n> ");
        planeIdentifier = scanner.nextLine();
        System.out.println(planeInterface.displayPlaneDetails(planeInterface.identifyPlane(planeIdentifier)));
      } // End of else if statment, 1st choice

      else if (choice == 2) {
        System.out.println("Enter values line-by-line in the following order: \ntotalSeats | planeID | planeModel | timeOfDeparture");
        
        // Initializing local variables
        int totalSeats = Integer.parseInt(scanner.nextLine());
        String planeID = scanner.nextLine();
        String planeModel = scanner.nextLine();
        double timeOfDeparture = Double.parseDouble(scanner.nextLine());
        
        // Attempt to register a new plane, return message depending on outcome
        if (planeInterface.registerPlane(totalSeats, planeID, planeModel, timeOfDeparture)) {
          System.out.println("Plane successfuly registered");
        } // End of if statment
        else {
          System.out.println("An error occurred, failed to register plane");
        } // End of else statment
        
      } // End of else if statment, 2nd choice
      
      else if (choice == 3) {
        System.out.print("Enter plane ID \n> ");

        // Initializing local variable
        planeIdentifier = scanner.nextLine();
				// Declaring local variables
        int managmentChoice;
        String passangerName;
        String passangerID;

        // Locate plane with given ID and perform requested action
        System.out.println("Managing " + planeInterface.identifyPlane(planeIdentifier).getPlaneID());
        System.out.print("1. Add passanger \n" + 
												 "2. Remove passanger \n" + 
												 "3. View passanger list \n" + 
												 "4. Dispatch plane \n> "
												); 
        managmentChoice = Integer.parseInt(scanner.nextLine());
        do {
					this.validInput = true;
					
          if (managmentChoice == 1){
            System.out.print("Enter new passanger name \n> ");
            passangerName = scanner.nextLine();
            if (planeInterface.addPassanger(passangerName, planeInterface.identifyPlane(planeIdentifier))) {
            	System.out.println("Successfully registered " + passangerName + " to plane " + planeInterface.identifyPlane(planeIdentifier).getPlaneID());  
            } // End of if statment
            else {
              System.out.println("An error occurred, failed to register passanger");
            } // End of else statment
						
          } // End of if statment, 1st managmentChoice
					
          else if (managmentChoice == 2){
            System.out.print("Enter passanger ID \n> ");
            passangerID = scanner.nextLine();
            if (planeInterface.removePassanger(planeInterface.identifyPassanger(passangerID, planeInterface.identifyPlane(planeIdentifier)), planeInterface.identifyPlane(planeIdentifier))) {
            System.out.println("Successfully removed " + passangerID + " from plane " + planeInterface.identifyPlane(planeIdentifier).getPlaneID());  
            } // End of if statment
            else {
              System.out.println("An error occurred, failed to remove passanger");
            } // End of else statment
            
          } // End of else if statment, 2nd managmentChoice
					
          else if (managmentChoice == 3) {
            System.out.println("Passangers registered for " + planeInterface.identifyPlane(planeIdentifier).getPlaneID() + ": ");
          	System.out.print(planeInterface.displayPassangerList(planeInterface.identifyPlane(planeIdentifier)));
          } // End of else if statment, 3rd managmentChoice
					
          else if (managmentChoice == 4) {
						boolean Choice4ValidInput = true;
            do {
              System.out.print(" Dispatch plane? y/n \n> ");
              char input = this.scanner.nextLine().charAt(0);
              if (input == 'y') {
                planeInterface.dispatchPlane(planeInterface.identifyPlane(planeIdentifier));
                System.out.println("Plane "+ planeInterface.identifyPlane(planeIdentifier).getPlaneID() + " was successfully dispatched");
              } // End of if statment
              else if (input == 'n') {
                System.out.println("Dispatch of " + planeInterface.identifyPlane(planeIdentifier).getPlaneID() + " was cancelled");
                continue;
              } // End of else if statment
              else {
                Choice4ValidInput = false;
                System.out.println("Invalid input!");
              } // End of else statment
      
            } while(!Choice4ValidInput); // End of do loop
            
          } // End of 4th managmentChoice else if statment
					
          else {
            validInput = false;
            System.out.println("Invalid input!");
          } // End of else statment, invlaid managmentChoice input
					
        } while(!validInput); // End of do loop
        
      } // End of else if statment, 3rd choice
			else {
				System.out.println("Invalid input!");
			} // End of else statment, invalid choice input
			
    } // End of while loop
    
  } // End of interface method
  
} // End of class UI
