package game.AntiTdGame.Obj.BuySystem;

public class LightUnit extends Buy{
	private int speed = 10;
	private int unitCost = 50;
	
	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(int unitCost) {
		this.unitCost = unitCost;
		System.out.println(unitCost);
	}

	public void doStuff(){
		// Methods for unit to do stuff
		
	}
	
}
