import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		// Implementare tutto il gioco, come meglio crediamo (aggiungendo funzionalità
		// se vogliamo) e portarlo su github
		// gestire danno, vita e forza, implementare main, usare classe Random:
		// si puo scegliere un personaggio che combatte con un'altro random,
		// oppure che tutte due sono Random
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		Character player;
		Character enemy;
		boolean start = true;

		while (start) {
			System.out.println("Choose your character: \n1. Hero \n2. Vampire \n3. Werewolf \n4. Random" + start);
			int choiceCharacter = scanner.nextInt();
			scanner.nextLine();
			player = getPlayer(choiceCharacter);
			System.out.println("Name your character:");
			String name = scanner.nextLine();
			player.setName(name);

			System.out.println(player);

			System.out.println("Choose your enemy: \n1. Hero \n2. Vampire \n3. Werewolf \n4. Random");
			int choiceEnemy = scanner.nextInt();
			scanner.nextLine();
			enemy = getPlayer(choiceEnemy);
			ArrayList<String> enemyNames = new ArrayList<>(Arrays.asList("Amy", "Johnny", "Danny", "Marisol", "Ronja"));
			enemy.setName(enemyNames.get(random.nextInt(enemyNames.size())));
			System.out.println("Fight between " + player + " and " + enemy + " shall began!");

			System.out.println("Start the fight: \n1. yes \n2. no (return to start)");
			int combat = scanner.nextInt();
			scanner.nextLine();
			start = combat == 1 ? true : false;
			
			while (combat == 1 && (player.getLife() == 0 || enemy.getLife() == 0)) {
				System.out.println("FIGHT!");
				combat(player, enemy);
				System.out.println("Result of this fight: \n" + player + "\n" + enemy);
				System.out.println("Do you want to fight again: \n1. yes!attack! \n2. no, return to start");
				combat = scanner.nextInt();
				scanner.nextLine();
				start = combat == 1 ? true : false;
			}
			
			if ((player.getLife() == 0 || enemy.getLife() == 0) || combat != 1) {
				String winner;
				if (player.getLife() > enemy.getLife()) {
					winner = player.toString();
				} else if (player.getLife() == enemy.getLife()){
					winner = "both!";
				} else {
					winner = enemy.toString();
				}
				System.out.println("The fight is done. The winner is: " + winner);
			}
			System.out.println("Do you wanna play again? \n1. yes \n2. no (exit)");
			combat = scanner.nextInt();
			scanner.nextLine();
			start = combat == 1 ? true : false;
		}
		
		if (start == false) {
			System.out.println("Thanks for playing! See you soon!");
		}
	
	}

	public static Character getPlayer(int c) {
		Random random = new Random();
		Character player = null;
		switch (c) {
		case 1:
			player = new Hero();
			break;
		case 2:
			player = new Vampire();
			break;
		case 3:
			player = new Werewolf(false);
			break;
		case 4:
			c = random.nextInt(1, 3);
			System.out.println(c);
			player = getPlayer(c);
			break;
		default:
			c = 4;
			break;
		}
		return player;
	}
	
	public static void setWerewolf() {
		
	}

	public static void combat(Character player, Character enemy) {
		Random random = new Random();
		boolean moon;
		if (player instanceof Werewolf) {
			moon = random.nextBoolean();
			((Werewolf) player).setIsHuman(moon);
			player.attack(enemy, moon);
		} else {
			player.attack(enemy);
		}

		if (enemy instanceof Werewolf) {
			moon = random.nextBoolean();
			((Werewolf) player).setIsHuman(moon);
			enemy.attack(player, moon);
		} else {
			enemy.attack(player);

		}
	}
}
