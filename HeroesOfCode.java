import java.util.*;

public class HeroesOfCode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        HashMap<String, List<String>> heroMap = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {

            String [] heroes = scanner.nextLine().split(" ");
            String heroName = heroes[0];

            String hp = heroes[1];
            String mana = heroes[2];
            List<String> list = new ArrayList<>();
            list.add(hp);
            list.add(mana);
            heroMap.put(heroName, list);

        }

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String []commands = input.split(" - ");

            String command = commands[0];
            String heroName = commands[1];
            if (command.equals("CastSpell")) {


                int mana = Integer.parseInt(commands[2]);
                String spellName = commands[3];

                int currentMana = Integer.parseInt(heroMap.get(heroName).get(1));
                if (mana<=currentMana) {
                    currentMana = currentMana-mana;
                    heroMap.get(heroName).set(1, String.valueOf(currentMana));
                    System.out.printf("%s has successfully cast %s and now has %d MP!%n", heroName, spellName, currentMana);
                }
                else {
                    System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spellName);
                }
            }

            else if (command.equals("TakeDamage")) {

            int damage = Integer.parseInt(commands[2]);
            int currentHealth = Integer.parseInt(heroMap.get(heroName).get(0));
            currentHealth= currentHealth-damage;
            String attacker = commands[3];
            if (currentHealth >0) {
                heroMap.get(heroName).set(0, String.valueOf(currentHealth));
                System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", heroName,  damage,attacker, currentHealth);
            }

            else {
                System.out.printf("%s has been killed by %s!%n", heroName, attacker);
                heroMap.remove(heroName);
            }

            }

            else if (command.equals("Recharge")) {
                int manaAmount = Integer.parseInt(commands[2]);
                 int currentMana = Integer.parseInt(heroMap.get(heroName).get(1));
                 int newMana = currentMana+manaAmount;

                 if (newMana<=200) {
                     heroMap.get(heroName).set(1, String.valueOf(newMana));
                     System.out.printf("%s recharged for %d MP!%n", heroName, manaAmount);
                 }
                 else {
                     heroMap.get(heroName).set(1, String.valueOf(200));
                     int manaFor = 200 - currentMana;
                     System.out.printf("%s recharged for %d MP!%n", heroName, manaFor);
                 }
            }

            else if (command.equals("Heal")) {
                int healAmount = Integer.parseInt(commands[2]);
                int currentHealth = Integer.parseInt(heroMap.get(heroName).get(0));
                int newHealth = currentHealth+healAmount;

                if (newHealth<=100) {
                    heroMap.get(heroName).set(0, String.valueOf(newHealth));
                    System.out.printf("%s healed for %s HP!%n", heroName, healAmount);
                }
                else {
                    heroMap.get(heroName).set(0, String.valueOf(100));
                    int healedFor = 100 - currentHealth;
                    System.out.printf("%s healed for %s HP!%n", heroName, healedFor);
                }
            }


            input = scanner.nextLine();
        }
        heroMap.entrySet()
                .stream()

                .forEach(g -> System.out.println(String.format
                        ("%s%n  HP: %s%n  MP: %s", g.getKey(), g.getValue().get(0), g.getValue().get(1))));
    }
}
