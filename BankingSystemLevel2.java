// Level - 2 Proof Of Concept(POC)

import java.util.*;

class BankingSystemLevel2
{
	static Scanner sc = new Scanner(System.in);
	
	double deposit(double balance, double depositAmount){
		return balance += depositAmount;
	}
	
	double withdrawMoney(double balance, double withDrawAmount){
		if(withDrawAmount <= balance){
			return balance -=withDrawAmount;
		}
		else{
			System.out.println("Insuffient Balance");
			return balance;
		}
	}
	
	void currentBalance(double balance){
		System.out.println("Current Balance : "+balance+"\n");
	}
	
	double interest(double balance, double interestRate, int time){
		return (balance * interestRate * time) / 100;
	}
	
	boolean loanEligibility(double balance, double monthlyIncome){
		return ((balance >= 10000) && (monthlyIncome>=25000));
	}
	
	void accountDetails(String name, int accountNumber, double balance, double monthlyIncome, boolean status) 
	{
		System.out.println("============================================");
		System.out.println("============= Account Details ==============");
		System.out.println("============================================");
		System.out.println("Name           : " + name);
		System.out.println("Account Number : " + accountNumber);
		System.out.println("Balance        : " + balance);
		System.out.println("Monthly Income : " + monthlyIncome);
		System.out.println("Loan Status    : " + (status ? "Approved" : "Not Approved"));
		System.out.println("============================================");
	}
	
	public static void main(String [] args)
	{
		// Initial Data 
		System.out.print("Customer Name : ");
		String name = sc.next();
		System.out.print("Account Number : ");
		int accountNumber = sc.nextInt();
		System.out.print("Initial Balance : ");
		double balance = sc.nextDouble();
		System.out.print("Monthly Income : ");
		double monthlyIncome = sc.nextDouble();
		
		// object creation
		BankingSystemLevel2 obj = new BankingSystemLevel2();
		
		// Deposit Amount
		System.out.print("Deposit : ");
		double depositAmount = sc.nextDouble();
		balance = obj.deposit(balance,depositAmount);
		System.out.println("Updated Balance : "+balance+"\n");
		
		// WithDraw Money
		System.out.print("With Draw Amount : ");
		double withDrawAmount = sc.nextDouble();
		balance = obj.withdrawMoney(balance,withDrawAmount);
		System.out.println("Updated Balance : "+balance+"\n");
		
		// Current Balance
		obj.currentBalance(balance);
		
		// Simple interest
		System.out.print("Interest Rate : ");
		double interestRate = sc.nextDouble();
		System.out.print("Number of Years : ");
		int time = sc.nextInt();
		double simpleInterest = obj.interest(balance, interestRate, time);
		System.out.println("Simple Interest : "+simpleInterest+"\n");
		
		// Loan Eligibility
		boolean status = obj.loanEligibility(balance, monthlyIncome);
		if(status)	System.out.println("Eligible for Loan\n");
		else	System.out.println("Not Eligible for Loan\n");
		
		// Account Summary
		obj.accountDetails(name, accountNumber, balance, monthlyIncome, status);
		
	}
	
}