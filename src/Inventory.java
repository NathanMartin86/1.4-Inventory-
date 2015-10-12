import com.sun.tools.javac.jvm.Items;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by macbookair on 10/12/15.
 */
public class Inventory {
    public static void main(String[] args) {
        ArrayList<Item> items = new ArrayList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            for (Item element : items) {
                System.out.println(element.quantity + " " + element.item);
            }
            System.out.println("Would you like to do?");
            System.out.println("[1] Add an Item");
            System.out.println("[2] Remove an item");
            System.out.println("[3] Change the Quantity of your items");

            String choice = scanner.nextLine();
            int choiceNum = Integer.valueOf(choice);

            if (choiceNum == 1) {
                System.out.println("What would you like to add?");
                String input = scanner.nextLine();
                Item inventory = new Item(input);
                items.add(inventory);
            }
            if (choiceNum == 2) {
                System.out.println("Which Item Would You like to Remove?");
                String edit = scanner.nextLine();
                int removeNum = Integer.valueOf(edit);
                items.remove(removeNum-1);
            }
            if (choiceNum == 3){
                System.out.println("Which Quantity Would You Like to Update?");
                String adjust = scanner.nextLine();
                Item found = null;
                for (Item thing : items){
                    if (thing.item.equals(adjust)){
                        found = thing;
                        break;
                    }

                }
                if (found == null){
                    System.out.println("Item not found");
                }
                else{
                    System.out.println("What's the new quantity?");
                    String newValStr = scanner.nextLine();
                    int newVal = Integer.valueOf(newValStr);
                    found.quantity = newVal;
                }
            }
        }
    }
}

