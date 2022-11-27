import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.Arrays;


/*********************************************************************
 FileName:     TestApplication.java
 Created by:   The A team
 Created on:   05/12/2021
 Comments:     Test Application for the Group 1 project & Demo
 *********************************************************************/

// Class created with a combination of work from all Group Members
public class TestApplication
{
    // Setting Scanner object to read user input
    static Scanner keyboard = new Scanner(System.in);

    // Setting int & double variables
    int userID, distance, count = 0, charity ;
    double amountRaised;

    // 'Deco' method will be used for printing decorations to the output
    // Will aid with code readability in the main block
    // Parameters to add a title to the printout, a symbol to print and the number of times to print the symbol
    public static void deco(String pName, String pSym, int pNum)
    {
        // Setting final variable for use in print-statement
        final String MYLINE = "\n";
        // Printing value of 'pName' wrapped in passed decorator symbol
        System.out.println(pSym.repeat(pNum) + pName + pSym.repeat(pNum));
    }//deco

    // 'getText' will accept a string parameter to display a prompt message for user input
    // and return the read input as a String type
    protected static String getText(String message)
    {
        System.out.print(message);
        return keyboard.next();
    } //getText

    // 'getInt' will accept a string parameter to display a prompt message for user input
    // and return the read input as a Int type
    protected static int getInt(String message)
    {
        System.out.print(message);
        return keyboard.nextInt() ;
    } //getiD

    // 'getCharityChoice' method Created by Sophie B
    // Method will be used to select a value for the 'charity' variable which will be used to build the
    // user objects
    protected static String getCharityChoice(int pAccType)
    {
        // Setting method variables
        int charity;
        String charityChoice = "";
        boolean valid = true;

        // Condition check will check if the passed parameter equals one and prompt user for input if true
        // The read input will be stored in the method variable 'charity'
        if (pAccType == 1)
        {
            System.out.println("\nBelow are the charities you can donate to");
            System.out.println("Menu:");
            System.out.println("1. Chest Heart & Stroke");
            System.out.println("2. MIND");
            System.out.println("3. NI Hospice");
            System.out.println("4. Salvation Army");
            System.out.print("Please enter which charity you would like to donate to (1-4): ");
            charity = keyboard.nextInt();
            keyboard.nextLine();
        }//fi
        // If the passed parameter does not equal one, a number generator will automatically initialize 'charity'
        // with a number between 1 & 4 using a call to Math.random
        else
        {
            charity = (int) (Math.random() * 4 + 1);
        }//else

        // Switch statement will condition check the value of 'charity' and initialize the 'charityChoice'
        // variable with a String value based on the corresponding number
        switch (charity)
        {
            case 1:
                charityChoice = "Chest Heart & Stroke";
                break;
            case 2:
                charityChoice = "MIND";
                break;
            case 3:
                charityChoice = "NI Hospice";
                break;
            case 4:
                charityChoice = "Salvation Army";
                break;
            default:
                System.out.println("Invalid charity");
                valid = false;
        }//switch
        // Returning String value of 'charityChoice'
        return charityChoice;
    }//getCharityChoice

    //Output method
    public class WriteDonations
    {
        // Setting up a writer variable which will hold app output
        static PrintWriter myOutFile;
    }//class


    // Main method created with a combination of elements from all Group Members
    public static void main(String[] args)
    {
        // Setting up scanner object to read user input
        Scanner keyboard = new Scanner(System.in);
        // Setting up two decimal formatters to represent miles and currency
        DecimalFormat df1 = new DecimalFormat("00 Miles");
        DecimalFormat df2 = new DecimalFormat("£00.00");

        // Setting variables
        int userID, distance, count = 0;
        double amountRaised;
        String names, charity, status, accType;

        // Setting final int variables to be used in loops and arrays
        final int MAX = 4, LOOP = 3;

        // Setting up object array which will store user objects
        AccountType[] accountList = new AccountType[MAX];

        // Primary loop Created by Paul A
        // Forloop will be used to collect information from user to build the user objects
        // For the demo we have set the loop to iterate four times to create four users.
        for (count = 0 ; count <= LOOP; count++)
        {
            // Prompting user for input, value will be stored in 'names' variable
            names = getText("\nPlease enter your name: ");

            // Prompting user for input, value will be stored in 'userID'
            userID = getInt("Please enter your ID: ");

            // Printing information to user to explain differences between basic and premium account types
            deco("", "*", 45);
            System.out.println("Membership Type");
            System.out.println("Basic\t\t-We choose your charity at random \n\t\t\t-You donate £5.00 for every mile ran\n");
            System.out.println("Premium\t\t-Choose which charity you would like to donate to\n\t\t" +
                    "\t-Double your donation for every mile you run");
            deco("", "*", 45);

            // Prompting user for input, value will be stored in 'accType'
            accType = getText("\nPlease enter if you are a premium or basic user: ");

            // Prompting user for input, value will be stored in 'distance'
            distance = getInt("Please enter distance completed in miles: ");

            // Condition check will check if 'accType' passed string is "premium" ignoring case
            // and call the 'getcharityChoice' method
            if (accType.equalsIgnoreCase("premium"))
            {
                // If check is true, the method will pass 1 as the argument
                // and initialize 'charity' with the return value
                charity = getCharityChoice(1);
            }//fi
            else
            {
                // If check is false, the method will pass 0 as the argument
                // and initialize 'charity' with the return value
                charity = getCharityChoice(0);
            }//else

            // New object will be built using the initialized variables as parameters
            // and indexed into the object array
            accountList[count] = new AccountType(names, userID, accType, distance, charity);
        }//forend


        // Sorted Array and table output created by Stuart B
        // Calling Arrays.sort and sorting the 'accountList' array with the 'ArrayHelper' class
        Arrays.sort(accountList, new ArrayHelper());
        // Printing sorted elements of object array
        System.out.println();
        deco("", "-", 40);
        // Calling a printf statement to produce a table-like output and printing column headers
        System.out.printf("%-15s%-20s%15s%15s%15s%n","Name", "Charity", "Distance", "Raised", "Type");
        deco("", "-", 40);
        // Forloop will be used to iterate over each array element in order to print to output
        for (int index = 0; index < MAX; index++)
        {
            // Calling a printf statement to display Object attributes in a single row for each element
            // printf allows the output to stay uniform with the printed headers
            System.out.printf("%-15s%-20s%15s%15s%15s%n", accountList[index].getName(), accountList[index].getCharity(),
                    df1.format(accountList[index].getDistance()), df2.format(accountList[index].getAmountRaised()), accountList[index].getAccType().toUpperCase());
        }//for


        // File creation/output and error handling created by Sophie B
        // A text file will be produced with a list of donations and by which user
        // Setting variables for file creation
        boolean open;
        String myFilename = "donations.txt";

        // Exception block will create the file or catch an error if the file cannot be created/opened
        try
        {
            WriteDonations.myOutFile = new PrintWriter(myFilename);
            open = true;
        }//try
        catch(FileNotFoundException error)
        {
            // Informing user of error opening file
            System.out.println("Error opening the file");
            open = false;
        }//catch

        // Exception block will be used to catch errors that occur while the file is being written to
        try
        {
            // Condition check on boolean var 'open'. If true program will write to file
            if(open)
            {
                WriteDonations.myOutFile.println("Donations List");
                WriteDonations.myOutFile.println("================");
                WriteDonations.myOutFile.print("Total number of donations made: ");
                WriteDonations.myOutFile.println(accountList.length);
                // Forloop will iterate over the length of the 'accountList' array
                for(int index = 0; index < accountList.length; index++)
                {
                    // Writing desired attributes from the array index location to file
                    WriteDonations.myOutFile.print("\n" + accountList[index].getName() + " has raised £ " + (df2.format(accountList[index].getAmountRaised()) + "\n"));
                }//for
                WriteDonations.myOutFile.println();
                WriteDonations.myOutFile.close();
                open = false;
                // Informing user that the file has been written successfully
                System.out.println("\n\nThe donations have been successfully written to a text file and closed.");
            }//if
        }//try
        catch(Exception error)
        {
            // Informing user of any errors that have been caught
            System.out.println("Exception " + error.getMessage() + " caught");
        }//catch
    }//main
}//class
