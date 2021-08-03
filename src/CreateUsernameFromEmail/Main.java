/* Main.java
* CSCI 112 - Summer 2021
* Last edited Jul. 26, 2021 by M. Lacanilao
*
* This program is designed to create an account for a subscription service that is free to
* anyone with an educational email address. The program will deny the user access if their
* email is not from an educational domain.
 */

package CreateUsernameFromEmail;

import java.util.Scanner; // import Scanner Class

public class Main {

    /* The main method demonstrates how strings can be scanned and manipulated
     * to create new strings. Strings in Java are immutable, therefore we
     * must create new strings our of old ones in order to modify the actual output.
     */

    public static void main(String[] args) {
        String username, username2, domain, password, password2; // user input variables

        // instsantiate Scanner object to read user email
        Scanner email = new Scanner(System.in);

        System.out.println("Welcome to College Student Union!");
        System.out.println("To create an account, please enter your student email address: ");
        username = email.nextLine();

        /* In order to extract a username from an email, we must create a substring that begins
        at the index of the "@" character of the original email string. */
        domain = username.substring (username.indexOf ("@"));

        /* We can use the Java String replaceAll() method to create a new string that
        omits the domain substring we just created, and replace it with a "" to delete it. */
        username2 = username.replaceAll (domain, "");

        /* This while loop will force user to enter an email with an ".edu" domain. Any non-.edu
        email will be rejected and will reset the loop.
        */
        while (!username.contains(".edu")) {
            System.out.println("Invalid email address!");
            System.out.println("Please enter a valid school email: ");
            username = email.nextLine();
            domain = username.substring (username.indexOf ("@"));
            username2 = username.replaceAll (domain, "");
        } // end while ()

              /* This if statement will create two user input strings and if they do not match
              each other, then the while loop below it will reset, forcing the user to input
              two matching password strings. Only then will the program end, allowing the user
              to access College Student Union!
              */
        if (username.contains(".edu")) {
            System.out.println("Your new username is: " + username2);
            Scanner code = new Scanner(System.in);
            System.out.println("Please create a password: ");
            password = code.nextLine();
            System.out.println("Please verify your password: ");
            password2 = code.nextLine();

            while (!password.equals(password2)) {
                System.out.println("Your passwords do not match. Try again!");
                System.out.println("Please create a password: ");
                password = code.nextLine();
                System.out.println("Please verify your password: ");
                password2 = code.nextLine();
            } // end while()

            if (password.equals(password2)) {
                System.out.println("Your password has been created.");
                System.out.println("You may now access the forum!");
            } // end if()
        } // end if()
    } // end main()
} // end class Main