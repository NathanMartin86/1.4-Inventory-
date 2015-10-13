import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by macbookair on 10/12/15.
 */
public class Inventory {

    public static void main(String[] args) throws Exception {
        ArrayList<Item> items = new ArrayList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            for (Item element : items) {
                System.out.format("%d %s\n %s\n", element.quantity,element.item,element.category);
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
                System.out.println("What category?");
                String category = scanner.nextLine();
                Item inventory = createItem(input, 1, category);
                items.add(inventory);
            }
            if (choiceNum == 2) {
                System.out.println("Which Item Would You like to Remove?");
                String edit = scanner.nextLine();
                int removeNum = Integer.valueOf(edit);
                items.remove(removeNum - 1);
            }
            if (choiceNum == 3) {
                System.out.println("Which Quantity Would You Like to Update?");
                String adjust = scanner.nextLine();
                Item found = null;
                for (Item thing : items) {
                    if (thing.item.equals(adjust)) {
                        found = thing;
                        break;
                    }

                }

                if (found == null) {
                    System.out.println("Item not found");
                } else {
                    System.out.println("What's the new quantity?");
                    String newValStr = scanner.nextLine();
                    int newVal = Integer.valueOf(newValStr);
                    found.quantity = newVal;
                }


            }
        }
    }


    static Item createItem (String name,int quantity, String category)throws Exception {
        Item newItem = null;
        if (category.toLowerCase() == "lance") {
            newItem = new Lance(name, quantity);
        } else if (category.toLowerCase().equals("potion")) {
            newItem = new Potion(name, quantity);
        } else if (category.toLowerCase().equals("armor")) {
            newItem = new Armor(name, quantity);
        } else if (category.toLowerCase().equals( "boots")) {
            newItem = new Boots(name, quantity);
        } else if (category.toLowerCase().equals("gold")) {
            newItem = new Gold(name, quantity);
        } else {
            throw new Exception("Error occurred");
        }

        return newItem;
    }
}

