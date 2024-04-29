import java.util.Optional;

public class Hero implements Human {

	protected int power;
	protected int lifes = 2;
	protected int damage;
	public String name;

	public Hero() {
		this.power = 10;
		this.lifes = 2;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		 this.name = name;
	}


	@Override
	public String getPower() {
		// TODO Auto-generated method stub
		return "The power remaining for "+name+" The Hero: " + power;
	}

	@Override
	public int getLife() {
		// TODO Auto-generated method stub
		return lifes;
	}

	@Override
	public void attack(Character c) {
		if (lifes > 0) {
			fight();
			//c.getDamage(c.getDamage(damage));
		} else {
			System.out.println(name + " The Hero lost all his lifes!");
		}
	}

	@Override
	public void fight() {
		if (power>0) {
			power = power - 3;
			damage = damage + 3;
			System.out.println(name + " The Hero: CLANG!!" + damage);
		} else if (power <= 0 && damage > 10) {
			System.out.println(name + " The Hero " + "has no power left, 1 life lost");
			lifes -= 1;
		}
	}

	@Override
	public int getDamage(int d) {
		// TODO Auto-generated method stub
		return damage = power - d;
	}

	@Override
	public String toString() {
		return name + " The Hero [power=" + power + ", lifes=" + lifes + ", damage=" + damage + "]";
	}

	@Override
	public void attack(Character c, boolean moon) {
		// TODO Auto-generated method stub
		
	}	
}
