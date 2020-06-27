import java.util.*;
class Bank_Account
{
	String name,address;
	int account_number;
	double account_balance;
	Bank_Account()
	{
		name="";
		address="";
		account_number=0;
		account_balance=0.0;
	}
	Bank_Account(String n,String a,int anm,double b)
	{
		name=n;
		address=a;
		account_number=anm;
		account_balance=b;
	}
	public double get_Balance()
	{
		return(account_balance);
	}
	public void display()
	{
	   System.out.println("Name of customer is"+name);
	   System.out.println("Address of customer is"+address);
	   System.out.println("The account number is"+account_number);
	   System.out.println("The account balance is"+account_balance);
	}
	public void deposit()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter amount to be entered in Rupees");
		double deposit=sc.nextDouble();
		account_balance=account_balance+deposit;
		System.out.println(account_balance);
	}
	public void withdraw()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println(" Enter amount to be withdrawn in rupees");
		double w_amt=sc.nextDouble();
		if(w_amt<account_balance)
		{
			System.out.println("Transaction allowed");
			account_balance=account_balance-w_amt;
		}
		else
		{
			System.out.println("Transaction not allowed. Low Balance");
		}
		System.out.println(account_balance);
	}
}
class Current_Account extends Bank_Account
{
	Current_Account(String n,String a,int num,double b)
	{
		super(n,a,num,b);
	}
public void check() {
	super.display();
	if(account_balance < 1000)
	{
		System.out.println("Imposing a penalty of 5% as service charge due to insufficient balance...");
		account_balance = account_balance - (account_balance * 5) / 100;
    	System.out.println("Final account balance is"+account_balance+"Withdrawal is restricted");
	}

	}
}
class Savings_Account extends Bank_Account
{
	int m,t;
	double j;
	Savings_Account(String n,String a,int num,double b,double rate,int comp,int time)
	{
		super(n,a,num,b);
		j=rate;
		m=comp;
		t=time;
	}
	double S,I;
	public void computeInterest()
	{
		super.display();
	    S=account_balance*Math.pow(((1+(j/(m*100)))),(m*t));
		I=S-account_balance;
		
	}
	public void printSavingsBalance()
	{
		System.out.println("The amount is Rs."+S);
		System.out.println("The interest is Rs."+I);
	}
	
}
public class Account_Details {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the name of the customer");
		String nm=sc.next();
		System.out.println("Enter the address of the customer");
		String add=sc.next();
		System.out.println("Enter the account number of the customer");
		int acn=sc.nextInt();
		System.out.println("Enter the number of years the principal is kept in bank");
		int yr=sc.nextInt();
		System.out.println("Enter the number of times the interest is compounded");
		int c=sc.nextInt();
		Savings_Account saver1=new Savings_Account(nm,add,acn,50000.0,4.2,c,yr);
		
		saver1.computeInterest();
		saver1.printSavingsBalance();
		Savings_Account saver2=new Savings_Account(nm,add,acn,80000.0,4.2,c,yr);
		saver2.computeInterest();
		
		saver2.printSavingsBalance();
		System.out.println("Enter balance for current account");
		double bal=sc.nextDouble();
		Current_Account Current1=new Current_Account(nm,add,acn,bal);
		Current1.check();
		Current1.deposit();
		Current1.withdraw();
		
	}

}
