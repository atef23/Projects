import java.util.*;
import student.*;

// -------------------------------------------------------------------------
/**.
 *  FaceBooklet Class allows users' UserProfile objects to
 *  login to the FaceBooklet Application and create new profiles
 * 
 *  @author  atef
 *  @version 2010.10.01
 */
public class FaceBooklet
    extends student.web.Application
{
    //~ Instance/static variables .............................................
    private String loginFeedback;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new FaceBooklet object.
     */
    public FaceBooklet()
    {
        super("AtefAziz");
        loginFeedback = new String();
    }


    //~ Methods ...............................................................
    
    /**.
     * Accessor method for the current user
     * @return getCurrentUser(UserProfile.class) the current profile 
     */
    public UserProfile getCurrentUser()
    {
        return getCurrentUser(UserProfile.class);
    }
    
    /**.
     * Saves current state of the profile
     */
    public void storeCurrentUserChanges()
    {
        UserProfile myUserProfile = getCurrentUser();
        setSharedObject(myUserProfile.getName(), myUserProfile);
    }
    
    /**.
     * Resets profile to original state
     */
    public void cancelCurrentUserChanges()
    {
        UserProfile myUserProfile = getCurrentUser();
        reloadSharedObject(myUserProfile.getName(), myUserProfile);
    }
    
    /**.
     * Takes user to login page if 
     * no profile is currently logged in
     */
    public void goToLoginIfNecessary()
    {
        if (hasNoCurrentUser())
        {
            showWebPage("https://cloudspace.cs.vt.edu/"
                + "work/Fall2010/CS1114/atef/program5/");
        }
    }
    
    /**.
     * Accessor method for the users
     * logged into the system
     * @return noUserLoggedIn the status  
     */
    public boolean hasNoCurrentUser()
    {
        boolean noUserLoggedIn = false;
        
        if (hasCurrentUser())
        {
            noUserLoggedIn = false;
        }
        
        if (!hasCurrentUser())
        {
            noUserLoggedIn = true;
        }
        
        return noUserLoggedIn;
    }    
    
    /**.
     * mutator method for creating a new profile
     * @param userName1 tag for user name.
     * @param password1 tag for password.
     * @return accountCreation the status of the new account
     */ 
    public boolean createUser(String userName1, String password1)
    {
        boolean accountCreation = false;
        loginFeedback = "Login Failed";
        
        if (userName1 != null && !userName1.isEmpty() 
            && hasSharedObject(userName1)) 
        {
            accountCreation = false;
            loginFeedback = "The provided user name already exists";
        }
   
        if (userName1 != null && !userName1.isEmpty() 
            && !hasSharedObject(userName1)
            && password1 != null && !password1.isEmpty())
        {
            UserProfile myUserProfile = new UserProfile();
            myUserProfile.setName(userName1);
            myUserProfile.setPassword(password1);
            setSharedObject(myUserProfile.getName(), myUserProfile);
            setCurrentUser(myUserProfile);
            accountCreation = true;
            loginFeedback = "Login Successful";
        }
 
        return accountCreation;   
    }
    
    /**.
     * Method for logging in and checking password validity
     * @param userName2 @param UserProfile.class tags for information
     * @param password2 tag for password
     * @return status the validity of the password
     */
    public boolean login(String userName2, String password2)
    {
        boolean status = false;      
        if (hasSharedObject(userName2))
        { 
            UserProfile loginRef = 
                getSharedObject(userName2, UserProfile.class);
                
            if (password2 != null && userName2 != null 
                && password2.equals(loginRef.getPassword()))
            {
                status = true;
                loginFeedback = "Login Successful";
                setCurrentUser(loginRef);
            }
        
        }
        
        if (!hasSharedObject(userName2))
        {
            status = false;
            loginFeedback = "The user name provided does not exist";
        }

        return status;
    }
    
    /**.
     * Accessor method for the login feedback
     * @return loginFeedback the feedback 
     */
    public String getLoginFeedback()
    {
        return loginFeedback;
    }
    
    /**.
     * overrides the default logout method
     */
    public void logout()
    {
        super.logout();
        goToLoginIfNecessary();
    }
    
    /**.
     * Method for retrieving a profile in by its name
     * @param inputName tag for profile name
     * @return getSharedObject(inputName, UserProfile.class) the 
     * UserProfile matching the name
     */
    public UserProfile getAProfile(String inputName)
    {
        return getSharedObject(inputName, UserProfile.class);
    }
    
    /**.
     * Creates a calendar and stores it on the application
     * @param calendarName the name of the Calendar
     */
    public void createCalendar(String calendarName)
    {
        EventCalendar currentCalendar = new EventCalendar(calendarName);
        setSharedObject(currentCalendar.getCalendarName(), currentCalendar);
    }
    
    /**.
     * Accessor method for calendar objects 
     * shared on the application
     * @param calendarName the name of the calendar
     * @return getSharedObject(calendarName, EventCalendar.class)
     * the calendar with name "calendarName"
     */
    public EventCalendar getACalendar(String calendarName)
    {
        return getSharedObject(calendarName, EventCalendar.class);
    }       

}
