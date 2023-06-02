package kh.lclass.opp.sample;

public class Sonata extends Car {
//	private int price;
//	
//	public int getPrice() {
//		return price;
//	}
//	
//	public void setPrice(int price) {
//		this.price = price;
//	}
	public Sonata() {
		super(4000);
	}
//	public int getPrice() {
//		return super.getPrice();
//	}
//	public void moveSonata() {
//		System.out.println("Sonata moveSonata");
//	}
	
	@Override
	public void moveCar() {
		System.out.println("Sonata moveAvante");
	}
}
