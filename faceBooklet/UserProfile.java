
import student.*;
import java.util.*;

// -------------------------------------------------------------------------
/**.
 *  User Profile class that is a subclass of entity
 *  Contains additional information about a user and the information 
 *  specific to the given user's profile
 * 
 *  @author  atef
 *  @version 2010.09.13
 */
public class UserProfile
    extends Entity

{
    //~ Instance/static variables .............................................
    private String password;
    private String email;
    private String pictureThumbUrl;
    private String nickName;
    private String status;
    private int age;
    private ArrayList < WallPosting > wall;
    private ArrayList < String > photoAlbum;
    

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new UserProfile object.
     */
    public UserProfile()
    {
        password = "-";
        email = "-";
        pictureThumbUrl = "-";
        nickName = "-";
        status = "-";
        age = 0;
        wall = new ArrayList < WallPosting > ();
        photoAlbum = new ArrayList < String > ();
    }

    //~ Methods ...............................................................
 
    /**.
     * setter method for the password object
     * @param inputPassword tag for 'password'.
     */ 
    public void setPassword(String inputPassword)
    {
        password = inputPassword;
    }
    
    /**.
     * setter method for the email object
     * @param inputEmail tag for 'email'.
     */ 
    public void setEmail(String inputEmail)
    {
        email = inputEmail;
    }
 
    /**.
     * setter method for the thumbnail url object
     * @param inputPictureThumbUrl tag for 'pictureThumbUrl'.
     */ 
    public void setPictureThumbUrl(String inputPictureThumbUrl)
    {
        pictureThumbUrl = inputPictureThumbUrl;
    }
    
    /**.
     * setter method for the nickname  object
     * @param inputNickName tag for 'nickname'.
     */ 
    public void setNickName(String inputNickName)
    {
        nickName = inputNickName;
    }
    
    /**.
     * setter method for the status object
     * @param inputStatus tag for 'status'.
     */ 
    public void setStatus(String inputStatus)
    {
        status = inputStatus;
    }
    
    /**.
     * setter method for the age object
     * @param inputAge tag for 'age'.
     */ 
    public void setAge(int inputAge)
    {
        age = inputAge;
    }

    /**.
     * Accessor method for the password field
     * @return password the password 
     */
    public String getPassword()
    {
        return password;
    }
    
    /**.
     * Accessor method for the email field
     * @return email the email address 
     */
    public String getEmail()
    {
        return email;
    }
    
    /**.
     * Accessor method for the thumbnail url field
     * @return pictureThumbUrl the URL address of the thumbnail 
     */
    public String getPictureThumbUrl()
    {
        return pictureThumbUrl;
    }
    
    /**.
     * Accessor method for the nickname field
     * @return nickName the user's nickname 
     */
    public String getNickName()
    {
        return nickName;
    }
    
    /**.
     * Accessor method for the status field
     * @return status the user's status 
     */
    public String getStatus()
    {
        return status;
    }
    
    /**.
     * Accessor method for the age field
     * @return age the integer age of the user 
     */
    public int getAge()
    {
        return age;
    }
    
    /**.
     * Accessor method for the wall field
     * @return wall the posts
     */
    public ArrayList < WallPosting > getWall()
    {
        return wall;
    }
    
    /**.
     * Mutator method for the wall field
     * @param inAuthor the author
     * @param inMessage the message
     */
    public void postToWall(String inAuthor, String inMessage)
    {      
        if (wall.size() == 20)
        {
            
            wall.add(0, new WallPosting(inAuthor, inMessage));    
            wall.remove(20);
        }
        
        else
        {
            wall.add(0, new WallPosting(inAuthor, inMessage));
        }
    }
    
    /**.
     * Mutator method for a 
     * wallPosting's love
     * @param index the location
     */
    public void loveAPost(int index)
    {
        wall.get(index).setPostLove();
    }
    
    /**.
     * Mutator which adds a photo source 
     * location to the photo album
     * @param imageSource the location
     */
    public void addPhoto(String imageSource)
    {
        photoAlbum.add(imageSource);
    }
    
    /**.
     * Accessor method for the photo album, returns
     * an ArrayList of strings containing image source
     * locations
     * @return photoAlbum the ArrayList of photo sources
     */
    public ArrayList < String > getPhotoAlbum()
    {
        return photoAlbum;
    }
    
    /**.
     * Mutator method for the photo album, deletes 
     * the image at the selected location 
     * @param index the location in the album 
     * of the photo to be deleted
     */
    public void deletePhoto(int index)
    {
        photoAlbum.remove(index);
    }
    

}
