import java.util.*;

class Mini_Banking_Transaction_System
{
	static Scanner sc = new Scanner(System.in);
	
	static double deposit(double balance, double amount){
		System.out.println("Balance = "+balance);
		System.out.println("Amount to deposit = "+amount);
		//balance += amount; // balance = balance + amount;
		return balance += amount;
	}
	
	static double withdraw(double balance, double withAmount){
		System.out.println("Initial Balance = "+balance);
		System.out.println("Amount to withdraw = "+withAmount);
		if(withAmount<=balance){
			System.out.println("Amount is drawn from the account");
			return balance -= withAmount;
		}
		else{
			System.out.println("Insuffient Balance.");
			return balance;
		}	
	}
	
	static void balance(double balance){
		System.out.println("Current Balance in your account = "+balance);
	}
	
	static double calculateInterest(double balance, double interest_rate, int years){
		double Interest = (balance * interest_rate * years) / 100;
		return Interest;
	}
	
	static boolean loanEligibility(double balance,double monthly_Income){
		boolean eligibility = (balance>=10000 && monthly_Income>=25000);
		return eligibility;
	}
	
	static void displayAccountDetails(String name, int accountNumber, double balance){
		System.out.println("===============================");
		System.out.println("========Account Details========");
		System.out.println("Name : "+name);
		System.out.println("Account Number : "+accountNumber);
		System.out.println("Balance : "+balance);
		System.out.println("================================");
	}
	
	public static void main(String [] args)
	{
		// Enter the Basic Details
		System.out.print("Enter your name = ");
		String name = sc.next();
		System.out.print("Enter your accountNumber = ");
		int accountNumber = sc.nextInt();
		System.out.print("Enter Inital Balance = ");
		double balance = sc.nextDouble();
		
		// Object 
		Mini_Banking_Transaction_System obj = new Mini_Banking_Transaction_System();
		
		// Depositing Amount to the account
		System.out.print("Enter the amount to deposit = ");
		double amount = sc.nextDouble();
		balance = obj.deposit(balance,amount);
		System.out.print("Total Balance : "+balance);
		
		// WithDraw the amount from the account
		System.out.print("Enter the amount to with-draw : ");
		double withAmount = sc.nextDouble();
		balance = obj.withdraw(balance,withAmount);
		System.out.print("After with-draw Total Balance : "+balance);
		
		// Check Balance
		obj.balance(balance);
		
		// Calculate the interest
		System.out.print("Enter the Interest Rate : ");
		double interest_rate = sc.nextDouble();
		int time = sc.nextInt();
		System.out.println(obj.calculateInterest(balance, interest_rate, time));
		
		// Loan Eligibility
		System.out.print("Enter Your Monthly Income : ");
		double monthly_Income = sc.nextDouble();
		if(obj.loanEligibility(balance, monthly_Income)){
			System.out.println("Your are Eligible for the loan.");
		}
		else{
			System.out.println("Your are not Eligible for the loan.");
		}
		
		// View Account Details
		displayAccountDetails(name,accountNumber,balance);
	}
}