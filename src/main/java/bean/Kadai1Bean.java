package bean;


import java.io.Serializable;


public class Kadai1Bean implements Serializable{
	private int money; // 金額を保持する
	private double rate; // 消費税率を保持する
	private int tax; // 消費税を保持する
	private int withTax; // 税込金額を保持する
 
	public Kadai1Bean() { 
		// とりあえず初期値は全て 0 にしておく
		this.money = 0;
		this.rate = 0;
		this.tax = 0;
		this.withTax = 0;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}
	
	public int getMoney() {
		return this.money;
	}
	
	public void setRate(double rate) {
		this.rate = rate;
	}
	
	public double getRate() {
		return this.rate;
	}
	
	public void setTax(int tax) {
		this.tax = tax;
	}
	
	public int getTax() {
		return this.tax;
	}
	
	public void setWithTax(int withtax) {
		this.withTax = withtax;
	}
	
	public int getWithTax() {
		return this.withTax;
	}
		
	public String gethyoujiRate() {
		return String.format("%.1f%%",this.rate * 100);
	}
}
	
	
