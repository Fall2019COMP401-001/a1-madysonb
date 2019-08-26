package a1;

import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		

		//Assume all inputs are valid

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
		

		// Store needed information about each customer in an array
		String[] customers = new String[numCustomers];
		
		// Establishing array to hold count of times someone buys an item
		int[] timesBought = new int[count];
		
		// Establishing array to hold number of people who bought the item
		int[] numPeopleBought = new int[count];
		
		// Weed out data we don't need, extract number of times each item is bought
		for (int k=0; k < numCustomers; k++) {
			String firstName = scan.next();
			String lastName = scan.next();
			int numItems = scan.nextInt();
			
			// array of objects to compare later
			String[] list = new String[numItems];
			
			// Loop through each item
			for (int j=0; j < numItems; j++) {
				int numObj = scan.nextInt();
				String obj = scan.next();
				
				for (int l=0; l < listItems.length; l++ ) {
					// Finds the object and increments the times bought and who bought
					if (obj.equals(listItems[l])) {
						timesBought[l] = timesBought[l] + numObj;
						numPeopleBought[l] = numPeopleBought[l] + 1;
					
					/* Checks if the person already bought the item
					 * removes them from the count of people who bought if so.
					 * Creates a new value if the item has been checked.
					 */
					for (int p = 0; p < j; p++) {
						if (obj.equals(list[p])) {
							numPeopleBought[l] = numPeopleBought[l] - 1;
							list[p] = "checked";
						}
					}
					}
				}
				
				list[j] = obj;
			}
		}
		
		scan.close();
		
		// Turning count of buys into strings
		String[] strTimesBought = new String[timesBought.length];
		for (int q=0; q < strTimesBought.length; q++) {
			if (timesBought[q]==0) {
				strTimesBought[q] = " ";
			} else {
				strTimesBought[q] = " " + Integer.toString(timesBought[q]) + " ";
			}
		}
		
		// Turning times people bought into string
		String[] strNumPeopleBought = new String[numPeopleBought.length];
		for (int t=0; t < numPeopleBought.length; t++) {
			if (numPeopleBought[t] == 0) {
				strNumPeopleBought[t] = "No";
			} else {
				strNumPeopleBought[t] = Integer.toString(numPeopleBought[t]);
			}
		}
		
		// Creating printed outputs
		for (int b=0; b < count; b++) {
			System.out.println(strNumPeopleBought[b] + " customers bought" + strTimesBought[b] + listItems[b]);
		}
	}
}

		