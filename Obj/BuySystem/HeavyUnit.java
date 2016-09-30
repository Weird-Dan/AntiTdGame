package name;

public class HeavyUnit extends Buy{
	private int unitCost = 100;
	private int speed = 5;
	
	public void doStuff(){
		// Methods for unit to do stuff
		System.out.println("I have also done stuff");
	}

	public int getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(int unitCost) {
		this.unitCost = unitCost;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	
}
