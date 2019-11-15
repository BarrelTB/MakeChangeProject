
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class MakeChangeApp {

	public Scanner kb = new Scanner(System.in);

	public double price;

	public double paid;

	public double change;

	public boolean cashReg;
	
	public void promptUser() {
		
		System.out.print("Please enter the total price: ");
		price = kb.nextDouble();
		
		System.out.print("Please enter the total tender amount: ");
		paid = kb.nextDouble();
		amountPaid();
		returnChange();
	}

	public double amountPaid() {

		if (paid < price) {
			System.out.println("The customer did not provide enough money.");
			System.out.println("--------------------------------------------------");
			System.exit(0);
		}
		if (paid == price) {
			System.out.println("The customer provided exact change.");
			System.out.println("---------------------------------------------------");
			System.exit(0);
		}
		return paid;
	}

	public void returnChange() {


		System.out.println("Your total change back is: ");
		DecimalFormat df = new DecimalFormat("#.##");
		change = paid - price;

		BigDecimal a = new BigDecimal(change);
		BigDecimal b = a.setScale(2, RoundingMode.HALF_EVEN);
		change = b.doubleValue();
		Double.parseDouble(df.format(change));

		System.out.println(change);
		int change1 = (int) change;
		
		double change2 = (change - change1 + 0.001) * 100;

		int change3 = (int) change2;


		System.out.println();

		boolean reChange = true;

		while (reChange) {
			if (change1 >= 20) {
				int x = (change1 / 20);
				if (x > 1) {
					System.out.println(x + " twenty dollar bills");
				} else {
					System.out.println(x + " twenty dollar bill");
				}
				change1 = change1 - (x * 20);
			} else if (change1 >= 10) {
				int x = (change1 / 10);
				if (x > 1) {
					System.out.println(x + " ten dollar bills");
				} else {
					System.out.println(x + " ten dollar bill");
				}
				change1 = change1 - (x * 10);

			} else if (change1 >= 5) {
				int x = (change1 / 5);
				if (x > 1) {
					System.out.println(x + " five dollar bills");
				} else {
					System.out.println(x + " five dollar bill");
				}
				change1 = change1 - (x * 5);
			} else if (change1 >= 1) {
				int x = (change1 / 1);
				if (x > 1) {
					System.out.println(x + " one dollar bills");
				} else {
					System.out.println(x + " one dollar bill");
				}
				change1 = change1 - (x * 1);
			} else {
				reChange = false;
			}
		}

		boolean reChange2 = true;

		while (reChange2) {

			if (change3 >= 25) {
				int y = change3 / 25;
				if (y > 1) {
					System.out.println(y + " quarters");
				} else {
					System.out.println(y + " quarter");
				}
				change3 = change3 - (y * 25);
			} else if (change3 >= 10) {
				int y = change3 / 10;
				if (y > 1) {
					System.out.println(y + " dimes");
				} else {
					System.out.println(y + " dimes");
				}
				change3 = change3 - (y * 10);
			} else if (change3 >= 5) {
				int y = change3 / 5;
				if (y > 1) {
					System.out.println(y + " nickels");
				} else {
					System.out.println(y + " nickel");
				}
				change3 = change3 - (y * 5);
			} else if (change3 >= 1) {
				int y = change3 / 1;
				if (y > 1) {
					System.out.println(y + " pennies");
				} else {
					System.out.println(y + " penny");
				}
				change3 = change3 - (y * 1);
			}
			else {
				reChange2 = false;
			}
		}
	}
}