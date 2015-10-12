import com.sun.tools.javac.jvm.Items;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by macbookair on 10/12/15.
 */
public class Inventory {
    public static void main (String [] args){
        ArrayList <Item> items = new ArrayList();
        Scanner scanner = new Scanner (System.in);
        String item = new String ();

        while (true) {
            int itemNum = 1;
            int amount = 0;

            System.out.println(itemNum + " " + item);

            System.out.println("Would you like to do?");
            System.out.println("[1] Add an Item");
            System.out.println("[2] Remove an item" );
            System.out.println("[3] Update the quantity of this item");

            String choice = scanner.nextLine();
            int choiceNum = Integer.valueOf(choice);

            if (choiceNum == 1) {
                System.out.println("What would you like to add?");
                String input = scanner.nextLine();
                Item inventory = new Item (input);
                items.add(inventory);

            }

        }
    }
}