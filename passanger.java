// Importing UUID class to create unique ID for every passanger
import java.util.UUID; // Importing class to creat unique IDs

// Defining class passanger
class passanger{
  // Declaring instance variables
  private String name;
  private String passangerID;
  
  // Defining overloaded constructor
  public passanger(String name){
    // Create unique 4-char ID and assign given String to name of object
    this.passangerID = UUID.randomUUID().toString().substring(9, 13);
    this.name = name;
  } // End of overloaded constructor

  
  // Defining getter method
  public String getPassangerName(){
    return this.name;
  } // End of getter method

  // Defining getter method
  public String getPassangerID(){
    return this.passangerID;
  } // End of getter method
  
} // End of class passanger
