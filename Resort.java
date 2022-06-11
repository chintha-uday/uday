import java.util.*;

/**This class implements the STARS interface
 *
 * @author A.A.Marczyk 
 * @version 02/11/21
 **/
public class Resort implements STARS
{
    /** fields
     */
    ArrayList<Card> al_cards = new ArrayList<Card>();
    ArrayList<Shuttle> al_shuttles = new ArrayList<Shuttle>();
    ArrayList<World> al_worlds = new ArrayList<World>();
    
    /** constructor
     */
    public Resort(String loc)
    {
        loadCards();
        setUpShuttles();
        loadWorlds();
    }
    
    /**
     * Returns the location and all  details of all worlds including the cards
     * currently on each world, or "No cards"
     * @return location and details of all worlds including location 
     * and all cards currently on each world, or "No cards" 
     */
    public String toString()
    {
        Card c=new Card();
        return c.toString(al_worlds);
    }

    /**Returns a String representation of cards on each world.
     * Include the name of the world 
     * @return a String representation of cards on each world.
     **/
    public String getAllCardsOnEachWorld()
    {
        Card E = al_cards.get(3);
        return E.getName();
    }
    
    
    /**Returns the name of the world which contains the specified card or null
     * @param tr - the specified card
     * @return the name of the World which contains the card, or null
     **/
    public String findCard(int tr)
    {
        String temp;
        Card c = getCard(tr);
        temp = c.getCardlatestworld();
        return temp;
    }
    
    
    /** Given the name of a world, returns the world id number
     * or -1 if world does not exist
     * @param name of world
     * @return id number of world
     */
    public int getWorldNumber(String ww)
    {
        return -1;
    }
    
                
    /**Returns a String representation of all the cards on specified world
     * @return a String representation of all cards on specified world
     **/
    public String getAllCardsOnOneWorld(String world)
    {
        String result = "";
        Iterator<Card> itr=al_cards.iterator();//getting the Iterator  
        while(itr.hasNext()){//check if iterator has the elements  
             Card c = itr.next();
             String str_temp = c.getCardlatestworld();
             if(str_temp.equals(world)){
                result = result + "\t" +c.getId();
             }
        }     
        return result;
    }
  
    
     /**Returns true if a Card is allowed to move using the shuttle, false otherwise
     * A move can be made if:  
     * the rating of the card  >= the rating of the destination world
     * AND the destination world is not full
     * AND the card has sufficient credits
     * AND the card is currently in the source world
     * AND the card id is for a card on the system
     * AND the shuttle code is the code for a shuttle on the system
     * @param trId is the id of the card requesting the move
     * @param shtlCode is the code of the shuttle journey by which the card wants to pCardel
     * @return true if the card is allowed on the shuttle journey, false otherwise 
     **/
    public boolean canTravel(int trId, String shtlCode)
    {
        boolean istravel = false;
        try{
            
            Card c= getCard(trId);
            World w = getWorld(shtlCode);
            if(c.getLux()>=w.getRatng()){//the rating of the card  >= the rating of the destination world
                if(w.checkCpty(w)){//the destination world is not full
                    if(c.getcredits()>4){//the card has sufficient credits
                        istravel =true;
                    }
                }
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println();
        }
        return istravel;
    }
    

    /**Returns the result of a card requesting to move by Shuttle.
     * A move will be successful if:  
     * the luxury rating of the card  >= the luxury rating of the destination world
     * AND the destination world is not full
     * AND the card has sufficient credits
     * AND the card is currently in the source world
     * AND the card id is for a card on the system
     * AND the shuttle code is the code for a shuttle on the system
     * If the shuttle journey can be made, the card information is removed from the source
     * world, added to the destination world and a suitable message returned.
     * If shuttle journey cannot be made, the state of the system remains unchanged
     * and a message specifying the reason is returned.
     * @param pCardId is the id of the card requesting the move
     * @param shtlCode is the code of the shuttle journey by which the card wants to pCardel
     * @return a String giving the result of the request 
     **/
    public String travel(int cardId, String shtlCode )
    {
        try{
            boolean cantravel_result = canTravel(cardId, shtlCode);
            if(cantravel_result){
                Card c = getCard(cardId);//get Card object for specified cardid
                Shuttle s = getShuttle(shtlCode);//get Shuttle object for specified shtlcode
                String card_latest_world = c.getCardlatestworld();//get present card is in which world
                String shuttle_source = s.getSource();//get shuttle source 
                if(card_latest_world.equals(shuttle_source)){//checking condition if card present world and shuttle source is same or not
                    
                    //update Card latest world with shuttle destion world
                    //how to add updated Card object to arraylist
                    //first remove that oject from list with that cardid
                    //then add new entry with latest record
                }
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return " ";
    }
    
     
      
    /** Allows a card to top up their credits.This method is not concerned with 
     *  the cost of a credit as currency and prices may vary between resorts.
     *  @param id the id of the card toping up their credits
     *  @param creds the number of credits purchased to be added to cards information
     */
    public void topUpCredits(int id, int creds)
    {
    
    }
      
    
    //***************private methods**************
    private void loadWorlds()
    {
        
        al_worlds.add(new World("ABC1","HOME",1,100,0));
        al_worlds.add(new World("BCD2","HOME",1,100,0));
        al_worlds.add(new World("JKL8","Fantasia",5,2,0));
        al_worlds.add(new World("EFG5","Sprite",1,100,0));
        al_worlds.add(new World("HJK7","Sprite",1,100,0));
        al_worlds.add(new World("DEF4","Sprite",1,100,0));
        al_worlds.add(new World("CDE3","Tropicana",3,10,0));
        al_worlds.add(new World("GHJ6","Solo",1,1,0));
        
    }
    
    private void setUpShuttles()
    {
        
        al_shuttles.add(new Shuttle("ABC1", "HOME","Sprite"));
        al_shuttles.add(new Shuttle("JKL8", "Tropicana","Fantasia"));
        al_shuttles.add(new Shuttle("BCD2", "Sprite","HOME"));
        al_shuttles.add(new Shuttle("EFG5", "Fantasia","Sprite"));
        al_shuttles.add(new Shuttle("HJK7", "Solo","Sprite"));
        al_shuttles.add(new Shuttle("DEF4", "Tropicana","Sprite"));
        al_shuttles.add(new Shuttle("CDE3", "Sprite","Tropicana"));
        al_shuttles.add(new Shuttle("GHJ6", "Sprite","Solo"));
    }
    
    private void loadCards()
    {
        
        al_cards.add(new Card(1000, "Lynn", 5, 10,"HOME"));
        al_cards.add(new Card(1001, "May", 3, 20,"HOME"));
        al_cards.add(new Card(1002, "Nils", 10, 20,"HOME"));
        al_cards.add(new Card(1003, "Olek", 2, 12,"HOME"));
        al_cards.add(new Card(1004, "Pan", 3, 3,"HOME"));
        al_cards.add(new Card(1005, "Quin", 1, 5,"HOME"));
        al_cards.add(new Card(1006, "Raj", 10, 6,"HOME"));
        al_cards.add(new Card(1007, "Sol", 7, 20,"HOME"));
        al_cards.add(new Card(1008, "Tel", 6, 24,"HOME"));
        
    }
 
    /** Returns the card with the card id specified by the parameter
     * @return the card with the specified name
     **/
    private Card getCard(int id)
    {
        Card rc = new Card();
        try{
            
            Iterator<Card> iter = al_cards.iterator();
            while(iter.hasNext())
            {
                Card yp = iter.next();
                int temp = yp.getId();
                if(temp==id){
                    rc = yp;
                    break;
                }    
            }
        }
        catch(Exception e){
            System.out.println("card id not found");
        }
        
        return rc;
    }
    
    
    /** Returns the world with the name specified by the parameter
     * @return the world with the specified name
     **/
    private World getWorld(String shuttlename)
    {
        World rc = new World();
        try{
            Iterator<World> iter = al_worlds.iterator();
            while(iter.hasNext())
            {
                World yp = iter.next(); 
                String temp = yp.getRefno(); 
                if( temp.equals(shuttlename)){
                    rc = yp;
                    break;
                }    
            }
        }
        catch(Exception e){
            System.out.println("shuttle name not found");
        }
        
        return rc;
    }
    
    /** Returns the world with the name specified by the parameter
     * @return the world with the specified name
    **/
    private Shuttle getShuttle(String shut)
    {
        Shuttle rc = new Shuttle();
        try{
            Iterator<Shuttle> iter = al_shuttles.iterator();
            while(iter.hasNext())
            {
                Shuttle yp = iter.next(); 
                String temp = yp.getcode(); 
                if( temp.equals(shut)){
                    rc = yp;
                    break;
                }    
            }
        }
        catch(Exception e){
            System.out.println("shuttle name not found");
        }
        
        return rc;
    }
}