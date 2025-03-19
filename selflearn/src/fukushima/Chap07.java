package fukushima;
public class Chap07 {
	public static void main(String[] args) {
		BankAccount[] bankAccounts = {
			new BankAccount(1,"花子",10000),
			new BankAccount(2,"太郎",1000)
		};
		bankAccounts[0].withdraw(1000);
		bankAccounts[1].deposit(1000);
		for (var bankAccount:bankAccounts) {
			System.out.println(bankAccount.toString());
		}
	}
}
class BankAccount {
	private int id;
	private String name;
	private int balance;
	public BankAccount(int id,String name,int balance) {
		this.id=id;
		this.name=name;
		this.balance=balance;
	}
	/**
	 * 口座番号を取得する
	 * @return 口座番号
	 */
	public int getId() {
		return id;
	}
	/**
	 * 口座の名義を取得する
	 * @return 名義
	 */
	public String getName() {
		return name;
	}
	/**
	 * 口座の残高を取得する
	 * @return 残高
	 */
	public int getBalance() {
		return balance;
	}
	/**
	 * 口座にお金を預け入れる
	 * @param amount
	 */
	public void deposit(int amount) {
		balance+=amount;
	}
	/**
	 * 口座からお金を（可能なら）引き出す
	 * @param amount 引き出す金額
	 * @return trueで成功、falseで失敗
	 */
	public boolean withdraw(int amount) {
		if (amount>balance) return false;
		balance-=amount;
		return true;
	}
	/**
	 * 
	 */
	@Override
	public String toString() {
		return String.format("%d %s %d",id,name,balance);
	}
}