
/**
 * Creates a space object to be used for boggle cube. Holds location, letter,
 * whether the space has been visited or not, and its 4 edges.
 * @author ryanegan
 * @HW3
 */
public class Space {
    //Instance variables
    protected String letter;
    protected int location;
    protected boolean visited;
    protected Space a,b,c,d;
    
    /**
     * Constructor for the space. Default, takes no parameters and sets the
     * letter to nothing and visited to false.
     */
    public Space(){
     letter = "";
     visited = false;
    }
    
    /**
     * Constructor for the space.
     * @param loc location on the cube
     * @param let letter that the space holds
     */
    public Space(int loc,String let){
        location = loc;
        letter = let;
        visited = false;
       
    }
    
    /**
     * gets the location on the cube of the space
     * @return int number on the cube
     */
    public int getLocation(){
        return location;
    }
    
    /**
     * gets the letter that the space holds.
     * @return the letter as a string
     */
    public String getLetter(){
        return letter;
    }
    
    /**
     * sets the letter the space holds
     * @param a the letter as a string
     */
    public void setLetter(String a){
        letter = a;
        }
        
    /**
     * finds whether the space has been visited or not
     * @return boolean true if the space has been visited and
     * false if it has not
     */
    public boolean isVisited(){
        
        return visited;
    }
    
    /**
     * sets the space to visted
     */
    public void markVisited(){
        visited = true;
    }
    
    /**
     * sets the space to unvisited
     */
    public void markUnvisited(){
        visited =false;
    }
    
    /**
     * gets the first edge of the space
     * @return the first space touching this space
     */
    public Space get1st(){
        return a;
    }
    
     /**
     * gets the second edge of the space
     * @return the second space touching this space
     */
    public Space get2nd(){
        return b;
    }
    
     /**
     * gets the third edge of the space
     * @return the third space touching this space
     */
    public Space get3rd(){
        return c;
    }
    
   /**
     * gets the fourth edge of the space
     * @return the fourth space touching this space
     */
    public Space get4th(){
        return d;
    }
    
    /**
     * sets the four edges of the space.
     * @param first the first space touching this space
     * @param second the second space touching this space
     * @param third the third space touching this space
     * @param fourth the fourth space touching this space
     */
    public void setEdges(Space first, Space second, Space third, Space fourth)
    {
        a = first;
        b = second;
        c = third;
        d = fourth;
    }
}