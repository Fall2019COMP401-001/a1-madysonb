package a1;

import java.util.Scanner;

public class A1Novice {
		
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Assume all inputs are valid
		
		// Read in number of customers
		int count = scan.nextInt();
		
		// New array to hold the customers
		String[] list = new String[count];
		
		/* For loop to input the names and number of items for each customer
		 * into the array 
		 */
		for (int i=0; i < list.length; i++) {
			String firstName = scan.next();
			String lastName = scan.next();
			int numItems = scan.nextInt();
			char firstInitial = firstName.charAt(0);
			
			
			/* Initialize total to 0 and loop through each item
			 * adding it to the price
			 */
			double total = 0.00;
			for (int k=0; k < numItems; k++) {
				int numObj = scan.nextInt();
				String obj = scan.next();
				double price = scan.nextDouble();
				total = total + (numObj * price);
			}
			
			// Convert total into a string so we can control decimal accuracy
			String strTotal = String.format("%.2f", total);
			
			// Compile needed information into the array
			list[i] = firstInitial + ". " + lastName + ": " + strTotal;
		}
		
		scan.close();
		
		// Loop through list of customers and print out information
		for (int l = 0; l < count; l++) {
			System.out.println(list[l]);
		}
	}
}
