package main;

import main.service.Operations;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Display{

    private final String message = "Welcome to LockedMe.com!";
    private final String author = "Author: Gerhard Allamani";
    private final String invalidInput = "Invalid input!";
    private Scanner sc = new Scanner(System.in);
    private Operations operations = new Operations();

    private void welcome() { //welcoming message
        System.out.println(message);
        System.out.println(author);
        System.out.println();
    }

    private void mainscreen() { //main menu message
        System.out.println("Main Menu");
        System.out.println("Press 1 to show files");
        System.out.println("Press 2 to show file options");
        System.out.println("Press 3 to quit the application");
    }

    private void optionScreen(){ //option message
        System.out.println("Press 1 to add a file");
        System.out.println("Press 2 to delete a file");
        System.out.println("Press 3 to search a file");
        System.out.println("Press 4 to go to Main Menu");
    }

    private void mainMenu() throws InputMismatchException{
        this.welcome();

        loop:while (true) { //infinite loop that will be stopped only by a break statement
            mainscreen();
            String choice = sc.next(); //scanner that lets the user chose the branch
            switch (choice) {
                case "1": {
                    operations.showFiles(); //showing all files
                    break;
                }
                case "2": { //going to second option list
                    this.options();
                    break;
                }
                case "3": { //exiting the application
                    System.out.println("Exiting the application!");
                    break loop;
                }
                default: {
                    System.out.println(invalidInput);
                }
            }
        }

    }

    private void options() throws InputMismatchException {  //second screen options
        loop:while (true) { //infinite loop that can be stopped by a break condition
            optionScreen();
            String choice = sc.next();
            try{
            switch (choice) { //switch command for every option
                case "1": { //adding a file
                    System.out.println("Enter the file name that you want to add");
                    String fileName = sc.next();
                    operations.addFile(fileName);
                    break;
                }
                case "2": { //deleting a file
                    System.out.println("Enter the file name you want to delete");
                    String fileName = sc.next();
                    operations.deleteFile(fileName);
                    break;
                }
                case "3": { //searching for a file
                    System.out.println("Enter the file name you want to search");
                    String fileName = sc.next();
                    operations.searchFileBinary(fileName);
                    break;
                }
                case "4": { //going to main menu (Break command)
                    System.out.println("Going back to the Main Menu.\n");
                    break loop;
                }
                default: { //if the input is invalid
                    System.out.println(invalidInput);
                }
            }
        }
            catch(InputMismatchException e){
                System.out.println("Wrong input format!");
            }}
    }

    public void main() { //public method that can be seen by everyone
        this.mainMenu();
    }
}
