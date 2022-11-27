/**
 * Filename:AccountType
 * Created by the A team
 * Created on 05/12/2021
 * UPDATE PROGRAM COMMENTS ABOUT PROGRAM HERE
 **/

// Child class inherits from 'User' 
public class AccountType extends User
{
    // Declaring instance variables
    private double distance ;
    private String charity, accType;
    private static double amountRaised;


    public AccountType()
    {
        super () ;
        this.distance = 0;
        this.charity = "";
        this.accType = "BASIC";
    }//Default Constructor

    public AccountType(String userName, int usrID, double distance)
    {
        super (userName, usrID);
        this.distance = distance ;
        this.charity = "";
        this.accType = "BASIC";
    }//Alternative Constructor

    public AccountType(String userName, int usrID, String accType, double distance)
    {
        super (userName, usrID);
        this.distance = distance ;
        this.charity = "";
        this.accType = accType;
    }//Alternative Constructor

    public AccountType(String userName, int usrID, String accType, double distance, String charity)
    {
        super (userName, usrID) ;
        this.distance = distance;
        this.charity = charity;
        this.accType = accType;
    }//Alternative Constructor


    //Getter for 'accType' attribute
    protected String getAccType()
    {
        return accType;
    }//getAccType

    //Setter for 'accType' attribute
    protected void setAccType(String accType)
    {
        this.accType = accType;
    }//setAccType

    //Getter for 'getDistance' attribute
    protected double getDistance()
    {
        return distance;
    }

    //Getter for 'charity' attribute
    protected String getCharity()
    {
        return charity;
    }//getCharity

    //Setter for 'charity' attribute
    protected void setCharity(String charity)
    {
        this.charity = charity;
    }//setCharity

    //Setter for 'distance' attribute
    protected void setDistance(double distance)
    {
        this.distance = distance;
    }//setDistance

    //Getter will call 'calculateamountRaised' and return the value
    protected double getAmountRaised()
    {
        return calculateamountRaised();
    }//getAmountRaised

    protected String getStatus()
    {
        return accType;
    }//getStatus

    //Method override from parent. Method will get 'name' attribute from parent class when called
    protected String getName()
    {
        return super.getName();
    }//getName

    //Class method will apply a modifier to the amount raised based on the 'accType' attribute
    private double calculateamountRaised()
    {
        // Initializing final variables with static values
        final double BASICPERMILE = 5.00, PREMPERMILE = 10.00;
        //Condition check will check 'accType' and multiply the value of distance by either 'BASICPERMILE' or 'PREMPERMILE'
        if (accType.equalsIgnoreCase("premium"))
        {
            return amountRaised = distance * PREMPERMILE;
        }//fi
        else
        {
            return amountRaised = distance * BASICPERMILE;
        }//else
    }//calculateAmountRaised

    public String toString()
    {
        return super.toString() + "Based on your distance of " + distance + " miles, you have raised " + getAmountRaised()
                + " pounds" ;
    }//toString
} //Class