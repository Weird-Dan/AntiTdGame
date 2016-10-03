package game.AntiTdGame.Obj.BuySystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Buy {
	private static ArrayList<Object> listUnits;
	static Buy[] buyUnit;
	static int money = 200;

	// Objects
	static LightUnit lUnit = new LightUnit();
	static HeavyUnit hUnit = new HeavyUnit();
	static FastUnit fUnit = new FastUnit();

	public static void main(String[] args) {
		// TODO code goes here...
		listUnits = new ArrayList<Object>();
		buyUnit = new Buy[4];
		
		/*
		buyUnit[0] = lUnit;
		buyUnit[1] = hUnit;
		buyUnit[2] = fUnit;
		*/
		
		listUnits.add(lUnit);
		listUnits.add(hUnit);
		listUnits.add(fUnit);
		
		System.out.print("Choose between 1 or 2 or 3 ");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt(); 
		sc.close();
		
		int lUnitCost = lUnit.getUnitCost();
		int hUnitCost = hUnit.getUnitCost();
		int fUnitCost = fUnit.getUnitCost();
		
		switch(choice){
		case 1: 
			if(money > lUnitCost){
				System.out.println("Light unit Bought!");
			}
			else{
				System.out.println("Insufficient funds");
			}
			break;
		
		case 2:
			if(money > hUnitCost){
				System.out.println("Heavy unit Bought!");
			}
			else{
				System.out.println("Insufficient funds");
			}
			break;
		
		case 3: 
			if(money > fUnitCost){
				System.out.println("Fast unit Bought!");
			}
			else{
				System.out.println("Insufficient funds");
			}
			break;
			
		default: 
			System.out.println("Oh look a error! Im just as surprised as you are :D");
			break;
		}		
		
	}
}
