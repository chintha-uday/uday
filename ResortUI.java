import java.util.*;
/**
 * Write a description of class ResortIO here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ResortUI
{
    
    private Scanner reader = new Scanner(System.in);
    private STARS wayward = new Resort("Wayward Asteroids");
    
    private void runUI()
    {   

        int choice = getOption();        
        while (choice != 0)
        {            
            // process choice
            if      (choice == 1){listAllWorlds();}
            else if (choice == 2){listAllCards();}
            else if (choice == 3){listOneWorld();}
            else if (choice == 4){findACard();}
            else if (choice == 5){tryTravel();}
            else if (choice == 6){travelNow();}
            else if (choice == 7){updateCredits();}
            // output menu & get choice
            choice = getOption();
        }
        System.out.println("\nThank-you");
    }
    
    
    private int getOption()
    {
       System.out.println("What would you like to do ?");
       System.out.println("0. Quit");
       System.out.println("1. List all world details");
       System.out.println("2. List all cards on each world");
       System.out.println("3. List all cards on one world");
       System.out.println("4. Find a card");
       System.out.println("5. Say if card can move by shuttle");
       System.out.println("6. Move a card by shuttle");
       System.out.println("7. Top up credits");

       System.out.println("Enter your choice");
       // read choice
       int option = reader.nextInt();
       reader.nextLine();
       return option;
    }
    
    // This one has been done for you 
    private void listAllWorlds()
    {
        
        System.out.println(wayward.toString());
    }
    
    // provide the code here  
    private void listAllCards()
    {
        System.out.println(wayward.getAllCardsOnEachWorld());
    }
   
    // This one has been done for you 
    private void listOneWorld()
    {
        System.out.println("Enter name of world");
        String ww = reader.nextLine();
        System.out.println(wayward.getAllCardsOnOneWorld(ww));
    }
    
    // provide the code here
    private void findACard()
    {
        System.out.println("Enter cardId");
        int ww = reader.nextInt();
        System.out.println(wayward.findCard(ww));
    }
    
    // This one has been done for you 
    private void tryTravel()
    {
        System.out.println("Enter card id");
        int trav = reader.nextInt();
        reader.nextLine();
        System.out.println("Enter shuttle code");
        String shuttle = reader.nextLine();
        System.out.println(wayward.canTravel(trav,shuttle));
    }
    
    // Provide the code here
    private void travelNow()
    {
        //boolean result = tryTravel();

    }
    
    // provide the code here
    private void updateCredits()
    {
                
    }
    public static void main(String[] args)
    {
        ResortUI xx = new ResortUI();
        xx.runUI();
    }
}
