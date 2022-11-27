import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;




/**
 * Filename: ArrayHelper
 * Created by the A team
 * Created on 05/12/2021
 * Helper class will be used to sort and return values passed to it from the 'Account Type' class
 **/

public class ArrayHelper implements Comparator<AccountType>
{
    //Method will be used to sort an object array when called
    public int compare(AccountType b, AccountType a)
    {
        return (int) a.getDistance() - (int) b.getDistance();
    }



}//class