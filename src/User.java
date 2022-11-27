/**
 * Filename:User
 * Created by the A team
 * Created on 05/12/2021
 * UPDATE PROGRAM COMMENTS ABOUT PROGRAM HERE
 **/
abstract public class User
{
    private String name;
    private int iD;

    public User()
    {
    } //default constructor

    public User(String userName, int usrID)
    {
        name = userName ;
        iD = usrID ;
    }//Alternative constructor with all the attributes needed

    protected void setName(String userName)
    {
        name = userName ;
    }//setName

    protected String getName()
    {
        return name ;
    }//getName

    protected void setiD(int usrID)
    {
        iD = usrID ;
    }//setiD

    protected int getiD()
    {
        return iD ;
    }//getiD

    public String toString()
    {
        return "Hello " + name + " user ID " + iD + ", welcome to FUNDRACE!!" ;

    }//toString

    abstract protected String getStatus() ;

}//class
