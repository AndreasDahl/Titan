package logic.entity;

public class Unit extends Entity {
	private int hp_max, hp;
	private double speed, collision;
	
	public Unit(int speed) {
		super();
		this.speed = speed;
	}
	
	public double getSpeed() {
		return speed;
	}
	
	public void tryMove(double angle) {
		
	}
}
