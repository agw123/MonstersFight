import java.util.Optional;

public interface Character {
	 public String getPower();
	 public int getLife();
	 public int getDamage(int h);
	 public void setName(String name);
	 public String getName();
	 public void attack(Character c);
	 public void attack(Character c, boolean moon);
}

