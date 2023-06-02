package kh.lclass.opp.sample;

public class Avante extends Car {
//	private int price;
//	
//	public int getPrice() {
//		return price;
//	}
//	
//	public void setPrice(int price) {
//		this.price = price;
//	}
	public Avante() {
		super();
		setPrice(3000);
	}
//	public void moveAvante() {
//		System.out.println("Avante moveAvante");
//	}
	
	@Override
	public void moveCar() {
		System.out.println("Avante moveAvante");
	}
}
