package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Assume all inputs are valid
		
		// Establish number of items in the store
		int count = scan.nextInt();
		
		// Establish an array to hold name and price of each item
		String[] listItems = new String[count];
		double[] listPrices = new double[count];
		for (int i = 0; i < count; i++) {
			String item = scan.next();
			double price = scan.nextDouble();
			listItems[i] = item;
			listPrices[i] = price;
		}
		
		// Establish customer count
		int numCustomers = scan.nextInt();
		
		// Establish array to compare total costs later
		double[] totalCosts = new double[numCustomers];
		
		
		
		// Store needed information about each customer in an array
		String[] customers = new String[numCustomers];
		for (int k=0; k < numCustomers; k++) {
			String firstName = scan.next();
			String lastName = scan.next();
			int numItems = scan.nextInt();
			
			// Loop through each item to determine total cost
			totalCosts[k] = 0;
			for (int j=0; j < numItems; j++) {
				int numObj = scan.nextInt();
				String obj = scan.next();
				
				// Find the price of each item and add to total
				for (int l=0; l < listItems.length; l++) {
					if (obj.equals(listItems[l])) {
						totalCosts[k] = totalCosts[k] + (numObj * listPrices[l]);
					} 
				}	
			}
			
			// Change total to a string to control decimal accuracy
			String strTotal = String.format("%.2f", totalCosts[k]);
			customers[k] = firstName + " " + lastName + " (" + strTotal + ")";
		}
		
		scan.close();
		
		
		
		/* Loop through the totalCosts array to determine who spent the most
		 * 1. Determine the most money spent
		 * 2. Determine index where this occurs
		 * 3. Enter the index into the list of customers to find the information about that customer
		 */
		double max = -1;
		int index = 0;
		for (int m=0; m < totalCosts.length; m++) {
			if (totalCosts[m] > max) {
				max = totalCosts[m];
				index = m;
			} 
		}
		String biggest = customers[index];
		
		// Same process, but finding the minimum spent
		
		double min = Double.POSITIVE_INFINITY;
		int spot = 0;
		for (int r=0; r< totalCosts.length; r++) {
			if (totalCosts[r] < min) {
				min = totalCosts[r];
				spot = r;
			}
		}
		String smallest = customers[spot];
		
		// Determining average cost
		double customersTotal = 0;
		for (int w = 0; w < totalCosts.length; w++) {
			customersTotal = customersTotal + totalCosts[w];
		}
		
		double average = customersTotal / numCustomers;
		// Change average to a string to control decimal accuracy
		String strAverage = String.format("%.2f", average);
		
		// Print out results
		System.out.println("Biggest: " + biggest);
		System.out.println("Smallest: " + smallest);
		System.out.println("Average: " + strAverage);
	}
}
