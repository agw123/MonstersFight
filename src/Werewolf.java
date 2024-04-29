import java.util.Optional;

public class Werewolf implements Human, Monster {

	protected boolean isHuman;
	protected int humanPower, monsterPower;
	protected int lifes = 4;
	protected int power;
	protected int damage;
	public String name;
	

	public Werewolf(boolean moon) {
		this.isHuman = moon;
		if (moon) {
			monsterPower = 15;
			humanPower = 0;
			lifes = 4;
			damage = 3;
		} else {
			monsterPower = 0;
			humanPower = 10;
			lifes = 2;
			damage = 2;
		}
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setIsHuman(boolean moon) {
		this.isHuman = moon;
	}
	
	@Override
	public String getPower() {
		// TODO Auto-generated method stub
		return "The power remaining for " + name + " The Werewolf: " + power;
	}

	@Override
	public int getLife() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void attack(Character c, boolean moon) {
		if (lifes > 0) {
			c.getDamage(c.getDamage(damage));
			if (moon) {
				bite();
			} else if (!moon) {
				fight();
			}
		} else {
			System.out.println(name + " The Werewolf lost all his lifes!");
		}
	}

	@Override
	public void bite() {
		if (monsterPower > 0) {
			monsterPower = monsterPower - 2;
			damage = damage + 2;
			System.out.println(name + " The Werewolf with the moon: ZACHETE!!");
		} else if (monsterPower == 0 && damage > humanPower) {
			System.out.println("No power left, 1 life lost");
			lifes -= 1;
		}
	}

	@Override
	public void fight() {
		if (humanPower>0) {
			humanPower = humanPower - 3;
			damage = damage + 3;
			System.out.println(name + " The Werewolf without the moon: CLANG!!" + damage);
		} else if (humanPower <= 0 && damage > humanPower) {
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
		return name + " The Werewolf [" + "humanPower=" + humanPower + ", monsterPower=" + monsterPower + ", lifes="
				+ lifes + ", damage=" + damage + "]";
	}


	@Override
	public void attack(Character c) {
		// TODO Auto-generated method stub
		
	}
}
