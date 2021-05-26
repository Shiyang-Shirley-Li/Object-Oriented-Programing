/**
 * @author Shiyang Li, Driving Cost Calculator 
 */
package a1;
import javax.swing.JOptionPane;
/**
 *Driving Cost Calculator, which is used to calculate the driving cost.
 */
public class DrivingCostCalculator {	
	
	/**
	 * computes and returns the cost of the trip 
	 * @param distanceToDrive, mpg, pricePerGallon
	 * @return costOfTrip
	 */
	public static double calculateTripCost(double distanceToDrive, double mpg, double pricePerGallon) {
		double numberOfGallonsUsed = distanceToDrive/mpg;
		double costOfTrip = numberOfGallonsUsed * pricePerGallon;
		return costOfTrip;
	}
	
	/**
	 * displays a text banner
	 */
	public static void displayBanner() {
		System.out.println("*****************************************");
		System.out.println("*          Driving Cost Calculator      *"); 
		System.out.println("*****************************************");
	}
	
	/**
	 * repeatedly call JOptionPane.showInputDialog with useful text prompts to the user to get the following information
	 * call the calculateTripCost method with the information collected from the user
	 * calling the displayBanner method and then displaying the cost of the trip and explanatory text to the console 
	 */
	public static void main(String[] args) {
		double distance;
		double eff;
		double price;
		String drivingDistance = JOptionPane.showInputDialog("What is the driving distance?");
		String efficiency = JOptionPane.showInputDialog(" What is the efficiency?");
		String costOfGas = JOptionPane.showInputDialog(" What is the cost of gas?");
		distance = Double.parseDouble(drivingDistance);
		eff = Double.parseDouble(efficiency);
		price = Double.parseDouble(costOfGas);
		double money = calculateTripCost(distance, eff, price);
		String formattedNumber = String.format("%.2f", money);
		displayBanner();
		System.out.println("The cost of the trip is $" + formattedNumber + ".");
	}
}
