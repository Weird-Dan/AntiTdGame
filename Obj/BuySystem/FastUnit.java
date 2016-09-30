package name;

public class FastUnit extends Buy{
	private int unitCost = 70;
	private int speed = 15;
	
	public void doStuff(){
		// Methods for unit to do stuff
		System.out.println("I have also done stuff fast");
	}

	public int getUnitCost() {
		return unitCost;
	}

	public void setCost(int cost) {
		this.unitCost = cost;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	
}
