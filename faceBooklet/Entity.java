
import student.*;
import java.util.*;

// -------------------------------------------------------------------------
/**.
 *  facebooklet entity class for basic facebooklet objects
 *  Contains constructor for new entities containing name and picture fields 
 *  for users
 * 
 *  @author  atef
 *  @version 2010.09.13
 */
public class Entity
{
    //~ Instance/static variables .............................................
    
    private String name;
    private String pictureUrl;
    private ArrayList < String > friendsList;



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Entity object.
     */
    public Entity()
    {
        name = "";
        pictureUrl = "";
        friendsList = new ArrayList < String > ();
    }


    /**.
     * Accessor method for the name field
     * @return name the name of the entity
     */
    public String getName()
    {
        return name;
    }

    /**.
     * setter method for the name object
     * @param inputName tag for 'name'
     */     
    public void setName(String inputName)
    {
        name = inputName;
    }
 
    /**.
     * Accessor method for the pictureUrl field
     * @return pictureUrl the location of the picture
     */
    public String getPictureUrl()
    {
        return pictureUrl;
    }
  
    /**.
     * setter method for the pictureUrl object
     * @param inputPictureUrl tag for 'pictureUrl'
     */    
    public void setPictureUrl(String inputPictureUrl)
    {
        pictureUrl = inputPictureUrl;
    }
    
    /**.
     * Accessor method for the friends list
     * @return friendsList the list of friends
     */
    public ArrayList < String > getFriends()
    {
        return friendsList;
    }
    
    /**.
     * mutator method for the friendsList
     * @param newFriend tag for friend to add
     */
    public void addFriend(String newFriend)
    {     
        if (!friendsList.contains(newFriend))
        {
            friendsList.add(newFriend);
        }

    }
        

}
