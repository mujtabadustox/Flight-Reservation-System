
public class BankAccount {
	private int id;
	private int balance;
	
	BankAccount(int i,int b){
		this.id=i;
		this.balance=b;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}

}
