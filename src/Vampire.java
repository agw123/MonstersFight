import java.util.Optional;

public class Vampire implements Monster {

	protected int power;
	protected int damage = 3;
	protected int lifes = 3;
	public String name;

	public Vampire() {
		power = 15;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		 this.name = name;
	}


	@Override
	public String getPower() {
	 return "Power remaining for" + name +" The Vampire:" + power;
	 }

	@Override
	public int getLife() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void attack(Character c) {
		if (lifes > 0) {
			bite();
			c.getDamage(c.getDamage(damage));
		} else {
			System.out.println(name + " The Vampire lost all his lifes!");
		}
	}

	@Override
	public void bite() {
		if (power>0) {
			power = power - 2;
			damage += 2;
			System.out.println(name + " The Vampire: ZACHETE!!");
		} else if (power == 0 && damage > 10) {
			System.out.println(name + " The Vampire " + "has no power left, 1 life lost");
			lifes -= 1;
		}
	}

	
	
	@Override
	public String toString() {
		return name + " The Vampire [power=" + power + ", damage=" + damage + ", lifes=" + lifes + "]";
	}

	@Override
	public int getDamage(int d) {
		// TODO Auto-generated method stub
		return damage = power - d;
	}

	@Override
	public void attack(Character c, boolean moon) {
		// TODO Auto-generated method stub
		
	}
	
}
