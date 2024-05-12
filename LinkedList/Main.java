package node;
// Assignment: 5
// Author: Oleg Muraviov, ID: 321163446
import java.util.Scanner;

public class Main {

    private static void showMenu() {
        System.out.println("Menu:");
        System.out.println("1. add first");
        System.out.println("2. add last");
        System.out.println("3. clear");
        System.out.println("4. contains");
        System.out.println("5. isEmpty");
        System.out.println("6. print backward ");
        System.out.println("7. print forward");
        System.out.println("8. remove");
        System.out.println("9. Exit");
        System.out.print("Choose an option: ");
    }

    // Enum to represent the menu choices
    enum Menu {
        ADD_FIRST(1), ADD_LAST(2), CLEAR(3), CONTAINS(4), IS_EMPTY(5),
        PRINT_BACKWARD(6), PRINT_FORWARD(7), REMOVE(8),EXIT(9);
        private final int choice;

        Menu(int choice) {
            this.choice = choice;
        }

        public int getChoice() {
            return choice;
        }


        public static Menu fromChoice(int choice) {
            for (Main.Menu menu : Main.Menu.values()) {
                if (menu.getChoice() == choice) {
                    return menu;
                }
            }
            return null;
        }

    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        Scanner scanner = new Scanner(System.in);
        boolean endProgram = false;
        while (!endProgram) {
            showMenu();
            int choice = scanner.nextInt();

            Menu selectedChoice = Menu.fromChoice(choice);
            if (selectedChoice == null) {
                System.out.println("Invalid option. Please try again.");
                continue;
            }

            switch (selectedChoice) {
                case ADD_FIRST:
                    System.out.println("Enter a number: ");
                    int addNumFirst = scanner.nextInt();
                    list.addFirst(addNumFirst);
                    break;
                case ADD_LAST:
                    System.out.println("Enter a number: ");
                    int addNumLast = scanner.nextInt();
                    list.addLast(addNumLast);
                    break;
                case CLEAR:
                    list.clear();
                    break;
                case CONTAINS:
                    System.out.println("Enter a number: ");
                    int num = scanner.nextInt();
                    boolean isContains =list.contains(num);
                    if (isContains)
                        System.out.println(num+" "+"is present int the list");
                    else System.out.println(num+" "+"was not found");
                    break;
                case IS_EMPTY:
                    boolean listEmpty=list.isEmpty();
                    if (listEmpty)
                        System.out.println("the list is Empty");
                    else System.out.println("the list is not empty");
                    break;
                case PRINT_BACKWARD:
                    list.printBackward();
                    break;
                case  PRINT_FORWARD:
                    list.printForward();
                    break;
                case REMOVE:
                    System.out.println("Enter a number: ");
                    int removedNum = scanner.nextInt();
                    list.remove(removedNum);
                    if (list.contains(removedNum))
                        System.out.println(removedNum+" "+"was removed successfully");
                    else System.out.println("number was not found");
                    break;
                case EXIT:
                    endProgram = true;
                    break;

            }
        }





    }


}

