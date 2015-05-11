
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Program that takes in a 24 character string and sets each character
 * to a location on the cube. The program also takes in a list of words.
 * The program then tries to see which of the words on the list can 
 * be found on the cube.
 * @author ryanegan
 * @HW3
 */
public class BoggleCube {

    // Instance variables
    private ArrayList<Space> spaces = new ArrayList<Space>();
    int count = 0;
    private Space zero = new Space(0,null);
    private Space one = new Space(0,null);
    private Space two = new Space(0,null);
    private Space three = new Space(0,null);
    private Space four = new Space(0,null);
    private Space five = new Space(0,null);
    private Space six = new Space(0,null);
    private Space seven = new Space(0,null);
    private Space eight = new Space(0,null);
    private Space nine = new Space(0,null);
    private Space ten = new Space(0,null);
    private Space eleven = new Space(0,null);
    private Space twelve = new Space(0,null);
    private Space thirteen = new Space(0,null);
    private Space fourteen = new Space(0,null);
    private Space fifteen = new Space(0,null);
    private Space sixteen = new Space(0,null);
    private Space seventeen = new Space(0,null);
    private Space eighteen = new Space(0,null);
    private Space nineteen = new Space(0,null);
    private Space twenty = new Space(0,null);
    private Space twentyone = new Space(0,null);
    private Space twentytwo = new Space(0,null);
    private Space twentythree = new Space(0,null);

    /**
     * Main method used to run boggle cube.
     */
    public static void main(String[] args) {
        BoggleCube b = 
        new BoggleCube
        ("/Users/ryanegan/Documents/CS225/Homework/BoggleCube/Letters.txt",
        "/Users/ryanegan/Documents/CS225/Homework/BoggleCube/Words.txt");
    }
    
    /**
     * Constructor for boggle cube object. Reads in the word list and the string
     * of characters. Sets the edges of each space on the board. Adds each space
     * to the array of spaces. Gives the spaces the proper character value. Then
     * starts the recursive search for each word.
     * @param filenameString is the variable for the 24 characters
     * @param filenameWords is the string variable for the word list
     */
    public BoggleCube(String filenameString,String filenameWords){
        zero.setEdges(one,two,four,twentytwo);
        one.setEdges(zero,three, thirteen,twentythree);
        two.setEdges(zero,three,five,eight);
        three.setEdges(one,two, nine, twelve);
        four.setEdges(zero,five,six,twentytwo);
        five.setEdges(two,four,seven,eight);
        six.setEdges(four, seven, eighteen, twenty);
        seven.setEdges(five,six,ten,sixteen);
        eight.setEdges(two,five,nine,ten);
        nine.setEdges(three,eight,eleven,twelve);
        ten.setEdges(seven, eight, eleven, sixteen);
        eleven.setEdges(nine,ten,fourteen,seventeen);
        twelve.setEdges(three,nine,thirteen,fourteen);
        thirteen.setEdges(one,twelve,fifteen,twentythree);
        fourteen.setEdges(eleven,twelve,fifteen,seventeen);
        fifteen.setEdges(thirteen,fourteen,nineteen,twentyone);
        sixteen.setEdges(seven,ten,seventeen,eighteen);
        seventeen.setEdges(eleven,fourteen,sixteen,nineteen);
        eighteen.setEdges(six,sixteen,nineteen,twenty);
        nineteen.setEdges(fifteen,seventeen,eighteen,twentyone);
        twenty.setEdges(six,eighteen,twentyone,twentytwo);
        twentyone.setEdges(fifteen,nineteen,twenty,twentythree);
        twentytwo.setEdges(zero,four,twenty,twentythree);
        twentythree.setEdges(one,thirteen,twentyone,twentytwo);

        spaces.add(zero);
        spaces.add(one);
        spaces.add(two);
        spaces.add(three);
        spaces.add(four);
        spaces.add(five);
        spaces.add(six);
        spaces.add(seven);
        spaces.add(eight);
        spaces.add(nine);
        spaces.add(ten);
        spaces.add(eleven);
        spaces.add(twelve);
        spaces.add(thirteen);
        spaces.add(fourteen);
        spaces.add(fifteen);
        spaces.add(sixteen);
        spaces.add(seventeen);
        spaces.add(eighteen);
        spaces.add(nineteen);
        spaces.add(twenty);
        spaces.add(twentyone);
        spaces.add(twentytwo);
        spaces.add(twentythree);

        Scanner inFile1;
        Scanner inFile2;
        inFile2 = null;
        inFile1 = null;
        
        try{
            inFile1 = new Scanner(new File(filenameString));

        }
        catch(FileNotFoundException e){
            System.out.println("error opening Strings.");
            System.exit(0);
        }
        try{
            inFile2 = new Scanner(new File(filenameWords));
        }
        catch(FileNotFoundException e){
            System.out.println("error opening Words.");
            System.exit(0);
        }
        if(inFile1!=null){
            String s = inFile1.next();

            for(int i = 0;i<24;i++){
                Character c = s.charAt(i);
                String d = c.toString();
                Space a = spaces.get(i);
                a.setLetter(d);
            }

        }
        if(inFile2!=null){
            while(inFile2.hasNext()){
                String s = inFile2.next();
                for(int i =0;i<24;i++){
                    spaces.get(i).markUnvisited();
                }
                for(int i=0;i<24;i++){
                    Character c = s.charAt(0);
                    String d = c.toString();
                    if(d.equalsIgnoreCase(spaces.get(i).getLetter())){
                        boolean a = 
                        recursiveFind(spaces.get(i),s,spaces.get(i).
                        getLetter());
                        if(a==true){
                            System.out.println(s);
                            count++;
                            break;
                        }
                    }
                }
            } 
        }
        System.out.println(count);

    }
 
    /**
     * Method to search if each word is in the word list. Looks at a word from
     * the word list then recursively tries to find it on the cube. Creates a 
     * string to compare to the original string to see if there is a match.
     * @param space the space that the method is currently looking at
     * @param original is the word from the word list that it is trying to match
     * @param sub is the current sub-string that has been created to compare to 
     * original
     * @retrun boolean of whether or not the string has been found
     */
    public boolean recursiveFind(Space space,String original, String sub){
        space.markVisited();
        if(sub.equalsIgnoreCase(original)){
            return true;
        }
        if(sub.length()>=original.length()){
            space.markUnvisited();
            return false;
        }
        Character n = original.charAt(sub.length());
        String s = n.toString();
        if(space.get1st().isVisited() == false){
            if(space.get1st().getLetter().equalsIgnoreCase(s)){
                boolean a = 
                recursiveFind(space.get1st(),original,sub+space.get1st().
                getLetter());
                if(a==true){
                    return true;
                }
            }
        }
        if(space.get2nd().isVisited() == false){
            if(space.get2nd().getLetter().equalsIgnoreCase(s)){
                boolean b = 
                recursiveFind(space.get2nd(),original,sub+space.get2nd().
                        getLetter());
                if(b==true){
                    return true;
                }    
            }
        }
        if(space.get3rd().isVisited() == false){
            if(space.get3rd().getLetter().equalsIgnoreCase(s)){
                boolean c = 
                recursiveFind(space.get3rd(),original,sub+space.get3rd().
                        getLetter());
                if(c==true){
                    return true;
                }
            }

        }
        if(space.get4th().isVisited() == false){
            if(space.get4th().getLetter().equalsIgnoreCase(s)){
                boolean d = 
                recursiveFind(space.get4th(),original,sub+space.get4th().
                        getLetter());
                if(d==true){
                    return true;
                }

            }
        }
        space.markUnvisited();
        return false;
    }       
}

