package project;

import java.util.Scanner;

public class MakeChange {
	public static void main(String[] args) {
		MakeChange obj = new MakeChange();
		obj.runMakeChange();
	}

	public void runMakeChange() {
		Scanner key = new Scanner(System.in);
		double price;
		double paidAmt;

		boolean keepGoing = true;
		while (keepGoing) {

			System.out.println("Welcome to the Automated Cash Register!");

			System.out.print("Please enter the total price:  ");
			price = key.nextDouble();

			System.out.print("\nPlease enter the amount you paid with: ");
			paidAmt = key.nextDouble();

			printNoChange(price, paidAmt, key);
			printTens(price, paidAmt);
			keepGoing = newTransaction(key);
		}
		key.close();

	}
	
	
	public boolean newTransaction(Scanner key){

		System.out.println("Would you like to continue (y/n)");
		String yesNo = key.next();

		if (!yesNo.equalsIgnoreCase("y")) {
			System.out.println("Peace out SUCKAH!!!");
			return false;
		}
		
		return true;
	}

	public void printNoChange(double cost, double paid, Scanner key) {
		// Scanner key = new Scanner(System.in);

		while (paid <= cost) {
			if (paid < cost) {
				System.out.print("Error! You've entered an amount less than the total price");
			} else {
				System.out.print("\nYou have paid with exact change. No change needed");
				break;
			}

			System.out.println("Please try again!");
			paid = key.nextDouble();
			printTens(cost, paid);

		}

		// key.close();
	}

	public void printTens(double cost, double paid) {
		int paidBills = (int) (paid * 100);
		int costBills = (int) (cost * 100);
		int totalChange = paidBills - costBills;
		int ten = 1000;

		if (!(ten > totalChange)) {
			int printTens = totalChange / ten;
			System.out.println("$10 bills: " + printTens);
			int remainderTen = totalChange % ten;
			printFives(remainderTen);
		} else {

			printFives(totalChange);

		}

	}

	public void printFives(int remainder) {

		int five = 500;
		if (!(five > remainder)) {

			int printFives = remainder / five;
			System.out.println("$5 bills: " + printFives);
			int remainderFive = remainder % five;
			printOnes(remainderFive);

		} else {

			printOnes(remainder);
		}

	}

	public void printOnes(int remainder) {

		int ones = 100;
		if (!(ones > remainder)) {

			int printOnes = remainder / ones;
			System.out.println("$1 bills: " + printOnes);
			int remainderOne = remainder % ones;
			printQuarters(remainderOne);

		} else {
			printQuarters(remainder);
		}
	}

	public void printQuarters(int remainder) {
		int quarters = 25;
		if (!(quarters > remainder)) {

			int printQuarters = remainder / quarters;
			System.out.println("Quarters: " + printQuarters);
			int remainderQuarter = remainder % quarters;
			printDimes(remainderQuarter);

		}

		else {

			printDimes(remainder);
		}

	}

	public void printDimes(int remainder) {
		int dimes = 10;

		if (!(dimes > remainder)) {

			int printDime = remainder / dimes;
			System.out.println("Dimes: " + printDime);
			int remainderDimes = remainder % dimes;
			printNicks(remainderDimes);
		} else {

			printNicks(remainder);
		}

	}

	public void printNicks(int remainder) {
		int nickles = 5;

		if (!(nickles > remainder)) {
			int printNicks = remainder / nickles;
			System.out.println("Nickles: " + printNicks);
			int remainderNicks = remainder % nickles;
			printPennies(remainderNicks);
			nickles = remainder;
		} else {

			printPennies(remainder);
		}

	}

	public void printPennies(int remainder) {
		int pennies = 1;
		if (!(pennies > remainder)) {
			// do{remainder
			int printPennies = remainder / pennies;
			System.out.println("Pennies: " + printPennies);

		}

	}

}
