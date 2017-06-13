/**
 * @author nigelcyril
 */

import java.io.File;
import java.util.Scanner;

public class ATM {
	private int User;
	private Users[] account;

	public ATM() throws Exception {
		Scanner File = new Scanner(new File("accounts.txt"));
		int acc = File.nextInt();
		account = new Users[acc];
		int[] P = new int[acc];
		String[] N = new String[acc];
		double[] B = new double[acc];
		for (int i = 0; i < acc; i++) {
			N[i] = File.next();
			P[i] = File.nextInt();
			B[i] = File.nextDouble();
			account[i] = new Users(N[i], P[i], B[i]);
		}

	}

	public int UserInput() {
		while (true) {
			StdOut.print("Enter Username:");
			String user = StdIn.readString();
			StdOut.print("Enter Pin:");
			int pin = StdIn.readInt();
			for (int i = 0; i < account.length; i++) {
				if (user.equals(account[i].getName())
						&& pin == account[i].getPin()) {
					User = i;
					return i;

				}
				 if(user.equals("admin") && pin == 0000) {
					StdOut.println("*** Shutting Down ATM***");
					return -99;
				
				}
				
			}
			StdOut.println("Incorrect Username or Password, Please try again");
		}

	}

	public void deposit() {
		while (true) {
			StdOut.print("Please enter the amount you would like to deposit:");
			double x = StdIn.readDouble();
			if (x <= 0) {
				StdOut.println("Please enter sufficient amount");
			} else {

				account[User].Deposit(x);
				return;
			}

		}
	}

	public void withdrawl() {
		while (true) {
			StdOut.print("Please enter the amount you would like to take out:");
			double x = StdIn.readDouble();
			if (x > account[User].getBalance()) {
				StdOut.println("Don't try to steal... you don't have enough money... you're broke.");

			} else {

				account[User].Withdrawl(x);
				return;
			}
		}

	}

	public void CheckBalance() {
		StdOut.println("You have"+" "+"$"+account[User].CheckBalance());
	}

	public String toString() {
		String acc = "Account Receipt:\n";
		StdOut.println(acc += account[User].toString());
		return acc;
	}

	public int getMenuOption() {
		StdOut.println(" 1) Check Balance");
		StdOut.println(" 2) Withdraw Money");
		StdOut.println(" 3) Deposit Money");
		StdOut.println(" 4) LogOut");
		StdOut.println(" 5) Print Reciept");
		StdOut.print("What would you like to do? (1-4): ");
		int x = StdIn.readInt();
		return x;
	}

	public void runUser() {
		
		while (true) {
			int option = this.getMenuOption();
			if (option == 1) {
				this.CheckBalance();
			} else if (option == 2) {
				this.withdrawl();
			} else if (option == 3) {
				this.deposit();
			} else if (option == 4) {
				exitProgram();
				
				return;
			}else if(option==5){
				this.toString();
			} else {
				StdOut.println("Invalid option");
			}
		}
	}
	
	public void run(){
		StdOut.println("\n * Wecome to the Ithaca College Credit Union *");
		while (true){
			int userID  = this.UserInput();
			if (userID == -99) {
				System.out.println("Shutting Down");
				//write out data file
				return;
			}
			runUser();
		}

	}
	public static void exitProgram(){
		System.out.println("Thank you for using ATM! \n Goodbye! \n");	
	}

	public static void main(String[] args) throws Exception {
		ATM acc = new ATM();
		acc.run();
	}

}
