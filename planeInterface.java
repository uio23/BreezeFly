//Imports ArrayList class to store list of plane objects
import java.util.ArrayList;

class planeInterface{
  // Initializing static variable
  private static ArrayList<plane> planes = new ArrayList<>();

  // Defining identifyPlane method
  public static plane identifyPlane(String planeID){
    // Go through list of planes and identify plane with given ID
    for(plane p : planes){
      if(p.getPlaneID().equals(planeID)){
        return p;
      } // End of if block
      
    } // End of for loop
    return null;
  } // End of identifyPlane method


  // Defining identifyPassanger method
  public static passanger identifyPassanger(String passangerID, plane p){
		// Go through list of passangers in given plane and identify planepassanger with given ID
    for (passanger passanger : p.getPassangerList()){
      if(passanger.getPassangerID().equals(passangerID)){
        return passanger;
      } // End of if statment 
      
    } // End of for loop
    return null;
  } // End of identifyPassanger method


  // Defining displayPlaneDetails method
  public static String displayPlaneDetails(plane p){
    // Defining local variables
    String full = (p.getFull()) ? "Full" : "Not full";
    String dispatched = (p.getDispatched()) ? "Dispatched" : "Not dispatched";
		
    // Return information about particular plane, in a sentence
    return "A " + p.getPlaneModel() + " with the identifier of " + p.getPlaneID()  + " is departing at " + p.getTimeOfDeparture() + " with " +  (p.getTotalSeats() - p.getOccupiedSeats()) + " of " + p.getTotalSeats() + " seats available.\n" + " Status: " + full + ", " + dispatched + ".";
  } // End of displayPlaneDetails method


  // Defining displayPassangerList method
  public static String displayPassangerList(plane p){
    // Declaring local variables
    String passangerList = "";
    
    // Return all passangers of given plane in a list
    for (passanger passanger : p.getPassangerList()){
      passangerList = passangerList + "Name: " + passanger.getPassangerName() + ", ID: "+ passanger.getPassangerID() + "\n";
    }
    return passangerList;
  } // End of displayPlaneDetails method

  
	// Defining registerPlane method
  public static boolean registerPlane(int totalSeats, String planeID, String planeModel, double timeOfDeparture){
    // Create new plane object with given parameters
    if (planes.add(new plane(totalSeats, planeID, planeModel, timeOfDeparture))) {
      return true;
    } // End of if statment
    return false;
  } // End of registerPlane method


  // Defining addPassanger method
  public static boolean addPassanger(String passangerName, plane p){
		// Creat a new passanger with given name
    if (p.setPassangerList(new passanger(passangerName))){
      return true;
    } // End of if statment
    return false;
  } // End of addPassanger method

  // Defining removePassanger method
  public static boolean removePassanger(passanger passanger, plane p){
		// Remove passanger with given ID
    if (p.setPassangerList(passanger, "remove")){
      return true;
    } // End of if statment
    return false;
  } // End of removePassanger method


  // Defining dispatchPlane method
  public static void dispatchPlane(plane p){
		// Set given plane's status to dispatched
    p.dispatch();
  } // End of dispatchPlane method

} // End of class planeInterface
