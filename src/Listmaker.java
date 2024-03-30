import java.util.ArrayList;
import java.util.Scanner;

public class Listmaker {
    static ArrayList<String> myArrList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    static void menu() {
        while (true) {
            System.out.println("Options:\n"
                    + "A - Add an item to the list\n"
                    + "D - Delete an item from the list\n"
                    + "P - Print (i.e. display) the list\n"
                    + "Q - Quit the program");

            String choice = SafeInput.getRegExString(scanner, "Enter your choice", "[AaDdPpQq]");
            switch (choice.toUpperCase()) {
                case "A":
                    addItem();
                    break;
                case "D":
                    deleteItem();
                    break;
                case "P":
                    printList();
                    break;
                case "Q":
                    if (confirmQuit()) {
                        System.out.println("Exiting the program...");
                        return;
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    static void addItem() {
        System.out.println("Enter an item to add:");
        String item = scanner.nextLine();
        myArrList.add(item);
        System.out.println("Item added successfully.");
    }

    static void deleteItem() {
        if (myArrList.isEmpty()) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }

        System.out.println("Current list:");
        printList();

        int index = SafeInput.getRangedInt(scanner, "Enter the index of the item to delete", 1, myArrList.size()) - 1;
        String deletedItem = myArrList.remove(index);
        System.out.println("Deleted item: " + deletedItem);
    }

    static void printList() {
        if (myArrList.isEmpty()) {
            System.out.println("List is empty.");
            return;
        }

        System.out.println("Current list:");
        for (int i = 0; i < myArrList.size(); i++) {
            System.out.println((i + 1) + ". " + myArrList.get(i));
        }
    }

    static boolean confirmQuit() {
        return SafeInput.getYNConfirm("Are you sure you want to quit? (Y/N)", scanner);
    }
}