// Importing Java ArrayList class
import java.util.ArrayList;

// Definign class plane
class plane{
  // Declaring/initializing instance variables
  private int occupiedSeats = 0;
  private int totalSeats;
  private boolean full;
  private String planeID;
  private String planeModel;
  private double timeOfDeparture;
  private boolean dispatched = false;
  private ArrayList<passanger> passangerList = new ArrayList<>();

  // Defining overloaded constructor 
  public plane(int totalSeats, String planeID, String planeModel, double timeOfDeparture)
  {
    this.totalSeats = totalSeats;
    this.planeID = planeID;
    this.planeModel = planeModel;
    this.timeOfDeparture = timeOfDeparture;
  } // End of overloaded constructer 
  
  // Defining getter method
  public int getOccupiedSeats(){
    return this.occupiedSeats;
  } // End of getter method

  
  // Defining getter method
  public int getTotalSeats(){
    return this.totalSeats;
  } // End of getter method

  
  // Defining getter method
  public boolean getFull(){
   return this.full; 
  } // End of getter method

  
  // Defining getter method
  public String getPlaneID(){
    return this.planeID;
  } // End of getter method


  // Defining getter method
  public String getPlaneModel(){
    return this.planeModel;
  } // End of getter method

  
  // Defining getter method
  public double getTimeOfDeparture(){
    return this.timeOfDeparture;
  } // End of getter method


  // Defining getter method
  public ArrayList<passanger> getPassangerList(){
    return this.passangerList;
  } // End of getter method

  // Defining getter method
  public boolean getDispatched(){
    return this.dispatched;
  } // End of getter method
  

  // Defining setter method
  public void dispatch(){
    this.dispatched = true;
  } // End of setter method


  // Defining overloaded setter method
  public boolean setPassangerList(passanger passanger){
		// Add a new passanger object to plane's passanger object list
    if (occupiedSeats< totalSeats){
      if(this.passangerList.add(passanger)){
      occupiedSeats++;
      return true;
      } // End of if statment
    } // End of if statment
    return false;
  } // End of overloaded setter method


  // Defining overloaded setter method
  public boolean setPassangerList(passanger passanger, String remove){
		// Remove passanger object from plane's passanger object list
    if (this.passangerList.remove(passanger)){
      occupiedSeats--;
      return true;
    } // End of if statment
    return false;
  } // End of overloaded setter method
  
} // End of class plane
