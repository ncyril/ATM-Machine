
public class Users {
	private String name;
	private int pin;
	private double balance;
	
	public Users(String n, int p, double b){
		this.name=n;
		this.pin=p;
		this.balance=b;
	}
	public String getName(){
		return this.name;
	}
	public int getPin(){
		return this.pin;
	}
	public double getBalance(){
		return this.balance;
	}
	public void Withdrawl(double amt){
		this.balance-=amt;
	}
	public void Deposit(double amt){
		this.balance+=amt;
	}
	public double CheckBalance(){
		return this.balance;
	}
	public String toString(){
		return this.name+","+" "+"you have"+" "+"$"+this.balance;
	}
	public static void main(String[] args) {
		Users b1 = new Users("Doug", 5454, 12500.85);
		b1.Deposit(5000);
		System.out.println(b1);
		b1.CheckBalance();
		System.out.println(b1);
	}
}
