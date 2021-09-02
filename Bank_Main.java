import java.util.Scanner;
class Customer extends Employee
{
	
	public void Check_Balance() {
		System.out.println("Enter The Account Number You Want To Check Balance : ");
		int no=sc.nextInt();
		if(name=="0000"&&Acc_No==0&&type=="0000"&&pin==0)
		{
			System.out.println("Account Deleted!So You Can't Check Balance Of This Account");
		}
		else
		{
			balance(no);
		}
		
	}

	private void balance(int no) {
		if(no==Acc_No)
		{
			System.out.println("Account Balance : "+bal);

		}
		else
		{
			System.out.println("Enter The Account Number Correctly : ");
			no=sc.nextInt();
			balance(no);
			
		}
		
	}
	
	public void Deposit() {
		System.out.println("Enter The Account Number You Want To Deposit: ");
		int no=sc.nextInt();
		if(name=="0000"&&Acc_No==0&&type=="0000"&&pin==0)
		{
			System.out.println("Account Deleted!So You Can't Deposit To This Account");
		}
		else
		{
			deposit(no);
		}
		
	}

	private void deposit(int no) {
		if(no==Acc_No)
		{
			System.out.println("Enter The Amount to Be Deposit : ");
			int amnt=sc.nextInt();

			bal=bal+amnt;
			System.out.println("Account Deposited Successfully!");

		}
		else
		{
			System.out.println("Enter The Account Number Correctly : ");
			no=sc.nextInt();
			deposit(no);
			
		}
		
	}
	
	public void Withdraw() {
		System.out.println("Enter The Account Number You Want To Withdraw From : ");
		int no=sc.nextInt();
		if(name=="0000"&&Acc_No==0&&type=="0000"&&pin==0)
		{
			System.out.println("Account Deleted!So You Can't Withdraw From This Account");
		}
		else
		{
			withdraw(no);
		}
		
	}

	private void withdraw(int no) {
		if(no==Acc_No)
		{
			System.out.println("Enter The Amount to Be Withdraw : ");
			int amnt=sc.nextInt();
			if(bal>amnt)
			{
				bal=bal-amnt;
				System.out.println("Account Withdrawn Successfully!");
			}
			
			else
			{
				System.out.println("You are Not Having Enough Balance to Withdraw!");
			}
		}
		else
		{
			System.out.println("Enter The Account Number Correctly : ");
			no=sc.nextInt();
			withdraw(no);
			
		}
		
	}


}


class Employee implements Bank_Account
{
	String name;
	String type;
	int bal;
	int pin;
	int Acc_No;
	Scanner sc=new Scanner(System.in);

	@Override
	public void Create_Account() {
		System.out.println("Enter The Account Holder Name :");
		name=sc.nextLine();
		System.out.println("Enter The Account Type Savings/Salary:");
		type=sc.nextLine();
		System.out.println("Enter The Amount You Want to Deposit Initially:");
		bal=sc.nextInt();
		System.out.println("Enter the 4-Digit Pin You Want to Set");
		pin=sc.nextInt();
		
		System.out.println("Account Created Successfully!");
		Acc_No=Account_Number();
		System.out.println("Your Account Number is : "+Acc_No);
	}

	private int Account_Number() {
		int num=0;
		num=(int)((Math.random()*(900000)+1000000));
		return (num);
	}
 
	@Override
	public void Delete_Account() {
		int no;
		System.out.println("Enter The Account Number You Want TO Delete :");
		no=sc.nextInt();
		delete(no);
	}
		public void delete(int no)
		{
		if(no==Acc_No)
		{
			name="0000";
			type="0000";
			bal=0;
			pin=0;
			Acc_No=0;
			System.out.println("Account Deleted Successfully!");
		}
		else
		{
			System.out.println("Enter The Account Number Correctly : ");
			no=sc.nextInt();
			delete(no);
			
		}
		}

	@Override
	public void Update_Account() {
		if(name=="0000"&&Acc_No==0&&type=="0000"&&pin==0)
		{
			System.out.println("Account Deleted!So You Can't Update This Account");
		}
		else
		{
			int ch=0;
			do
			{
			System.out.println("Select The Option You Want to Update :");
			System.out.println("1. Name");
			System.out.println("2. Pin");
			System.out.println("3. Exit");
			 ch=sc.nextInt();
			int no1;

			switch(ch)
			{
			case 1:
				System.out.println("Enter the Account Number You Want To Update Name : ");
				no1=sc.nextInt();
				Update_Name(no1);
				break;
			case 2:
				System.out.println("Enter the Account Number You Want To Update Pin : ");
				no1=sc.nextInt();
				Update_Pin(no1);
				break;
			}
			}while(ch<3);
		}
		
	}

	private void Update_Name(int no1) {
		if(no1==Acc_No)
		{
			System.out.println("Enter The Name To Be Update : ");
			String upname=sc.next();
			
			name=upname;
			System.out.println("Account Updated Successfully!");
		}
		else
		{
			System.out.println("Enter The Account Number Correctly : ");
			no1=sc.nextInt();
			Update_Name(no1);
			
		}
		
	}


	private void Update_Pin(int no1) {
		if(no1==Acc_No)
		{
			System.out.println("Enter The Pin To Be Update : ");
			int uppin=sc.nextInt();
			
			pin=uppin;
			System.out.println("Account Updated Successfully!");
		}
		else
		{
			System.out.println("Enter The Account Number Correctly : ");
			no1=sc.nextInt();
			Update_Name(no1);
			
		}
		
	}
	
	@Override
	public void Display_Account_Details() {
		if(name=="0000"&&Acc_No==0&&type=="0000"&&pin==0)
		{
			System.out.println("Account Deleted!So You Can't Access This Account");
		}
		else
		{
		System.out.println("Name : "+name+" Account Type : "+type+" Account Number : "+Acc_No+" Balance : "+bal+" Pin :"+pin);
		}
		
		
	}
		
	
}
class HDFC extends Customer
{

	
}

class IOB extends Customer
{
	
}

class SBI extends Customer
{
	
}

class AXIS extends Customer
{
	
}

class TMB extends Customer
{
	
}


public class Bank_Main {

	public static void main(String[] args) {
		
		HDFC b1=new HDFC();
		
		b1.Create_Account();
		b1.Display_Account_Details();

		b1.Delete_Account();
		b1.Display_Account_Details();
		
		b1.Update_Account();
		b1.Display_Account_Details();
		
		b1.Withdraw();
		b1.Display_Account_Details();
		
		b1.Deposit();
		b1.Display_Account_Details();
		
		b1.Check_Balance();
		
		AXIS b2=new AXIS();
		
		b2.Create_Account();
		b2.Display_Account_Details();
		
		b2.Update_Account();
		b2.Display_Account_Details();
		
		b2.Withdraw();
		b2.Display_Account_Details();
		
		b2.Deposit();
		b2.Display_Account_Details();
		
		b2.Check_Balance();
		
	
	}
}
