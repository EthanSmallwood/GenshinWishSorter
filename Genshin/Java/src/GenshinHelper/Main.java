package GenshinHelper;

import java.util.Scanner;

public class Main {

/*
 *
 *
 *
 */
    private static Stats stats = new Stats();
    private static Scanner scanner = new Scanner(System.in);
    private static DatabaseHandler databaseHandler = new DatabaseHandler();
    public static void main(String[] args) {
/*
*
*
*
 */

        for(int i = 1; i <= databaseHandler.dbMaxID();i++){
            stats.setItems(databaseHandler.initialiseObject(i));
        }
        stats.initialiseCounters(stats);
/*
*
*
*
 */
        boolean quitYN = false;
        while (!quitYN) {
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("""
                                                    Genshin Wish Helper
                                                    
                            1.  How many of each rarity has been rolled.
                            2.  How many weapons been rolled.
                            3.  How many Characters been rolled.
                            4.  Pity Status.
                            5.  Character and weapons filtered by rarity.
                            6.  Quit
                    """);
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.print("Please enter option(Index only): ");
            int index = scanner.nextInt();
            scanner.nextLine();
            switch (index) {
                case 1 -> System.out.println("There has been "+stats.getThreeStarsCount()+" Three stars, "+stats.getFourStarsCount()+" Four stars and "+stats.getFiveStarsCount()+" Five stars.");
                case 2 -> System.out.println("There has been "+stats.getWeaponCounter()+" weapons rolled.");
                case 3 -> System.out.println("There has been "+stats.getCharacterCounter()+" characters rolled");
                case 4 -> System.out.println((90-stats.getPity())+ " rolls left till pity.");
                case 5 -> stats.orderedArray();
                case 6 -> quitYN = true;
            }
        }
    }




}
