package main.java;

import java.util.Scanner;

//TODO:refactor the sutitable name for the class
public class MyUtils {

    public static void printEnterElement() {
        System.out.println("\nPlease enter the element: ");
    }

    public static Object getItemInput() {
        Scanner scan = new Scanner(System.in);
        Object item = (Object) scan.next();
        return item;
    }

    public static void printEnterIndex() {
        System.out.println("\nPlease enter the index: ");
    }

    public static int getIndexInput() {

        Scanner scan = new Scanner(System.in);
        String indexStr = scan.next();

        char[] indexChars = indexStr.toCharArray();

        for (char c : indexChars) {
            if (Character.isDigit(c) == false) {
                System.out.println("\nOh, you should enter a number");
                return getIndexInput();
            }
        }
        int index = Integer.parseInt(indexStr);
        if (index < 0) {
            System.out.println("\nOh, you should enter a number from 0, not below");
            return getIndexInput();
        }

        return index;
    }

    public static void printStructureChoser() {
        System.out.println("Please, choose the data structure you wanna check:");
        System.out.println("\n1. Array List\n2. Linked List\n3. Stack\n4.Queue\n5. MinHeap");
    }

    public static int getStructureChoice() {
        Scanner scan = new Scanner(System.in);

        System.out.println("\nEnter choice:");

        String choiceStr = scan.next();

        char[] choiceChars = choiceStr.toCharArray();
        if (choiceChars.length > 1) {
            System.out.println("\nOh, you entered invalid number.");
            return getStructureChoice();
        }

        if (Character.isDigit(choiceChars[0]) == false) {
            System.out.println("\nOh, you should enter a number from 1 to 5.");
            return getStructureChoice();

        }
        int choice = Integer.parseInt(choiceStr);
        if (choice <= 0 || choice >= 6) {
            System.out.println("\nOh, you should enter a number from 1 to 5.");
            return getStructureChoice();
        }

        return choice;
    }

    public static void printMyListActions() {
        System.out.println("\nPlease, choose the action you want to do:");
        System.out.println("\n1. Add\n2. Set\n3. Add(by index)\n4. Add first\n5. Add last\n6. Get\n7. Get first\n8." +
                " Get last\n9. Remove\n10. Remove first\n11. Remove last\n12. Sort\n13. Index of\n14. Last index of\n15."
                +
                " Exists\n16. To array\n17. Clear\n18. Get size\n19. Exit menu");

    }

    public static int getMyListActionChoice() {
        Scanner scaner = new Scanner(System.in);
        System.out.println("\nEnter choice:");

        String choiceStr = scaner.next();

        char[] choiceChars = choiceStr.toCharArray();
        if (choiceChars.length > 3) {
            System.out.println("\nOh, you entered invalid number.");
            return getMyListActionChoice();
        }

        if (Character.isDigit(choiceChars[0]) == false) {
            System.out.println("\nOh, you should enter a number from 1 to 19.");
            return getMyListActionChoice();

        }
        int choice = Integer.parseInt(choiceStr);
        if (choice <= 0 || choice >= 20) {
            System.out.println("\nOh, you should enter a number from 1 to 19.");
            return getMyListActionChoice();
        }

        return choice;
    }

    public static void printAddChoices() {
        System.out.println("\nHow many elements do you want to add?");
        System.out.println("\n1. One element\n2. Multiple elements");
    }

    public static int getAddChoice() {
        Scanner scan = new Scanner(System.in);

        System.out.println("\nEnter choice:");

        String choiceStr = scan.next();

        char[] choiceChars = choiceStr.toCharArray();
        if (choiceChars.length > 1) {
            System.out.println("\nOh, you entered invalid number.");
            return getAddChoice();
        }

        if (Character.isDigit(choiceChars[0]) == false) {
            System.out.println("\nOh, you should enter a number from 1 to 2.");
            return getAddChoice();

        }
        int choice = Integer.parseInt(choiceStr);
        if (choice <= 0 || choice >= 3) {
            System.out.println("\nOh, you should enter a number from 1 to 2.");
            return getAddChoice();
        }

        return choice;
    }

}
