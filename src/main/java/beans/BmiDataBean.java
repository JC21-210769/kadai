package beans;

import java.io.Serializable;

public class BmiDataBean implements Serializable {
	private String strHeight;
	private String strWeight;
	private double bmi;
	private String himando;

	public BmiDataBean() {
	}
	public void setStrHeight(String strHeight) {
		this.strHeight = strHeight;
	}
	
	public String getStrHeight() {
		return this.strHeight;
	}
	public void setStrWeight(String strWeight) {
		this.strWeight = strWeight;
	}
	
	public String getStrWeight() {
		return this.strWeight;
	}
	
	public void setBmi(double bmi) {
		this.bmi = bmi;
	}
	
	public double getBmi() {
		return this.bmi;
	}
	
	public void setHimando(String himando) {
		this.himando = himando;
	}
	
	public String getHimando() {
		return this.himando;
	}

}
