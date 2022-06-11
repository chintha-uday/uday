import java.util.*;
/**
 * An world is part of a STAR resort.Each world has a reference number, name, 
 * a luxury rating and a capacity which represents the maximum number of 
 * people(cards) who can be on the world at any one time. Each world must 
 * maintain a list of all people (cards)currently on the world. This list 
 * is updated whenever cards enter or leave a world,so that it is always 
 * possible to say how many people (cards) are on the world and who they are.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class World 
{
    private String RefNo;
    private String Wname;
    private int rat;
    private int Capcty;
    private int current_Capcty;
    ArrayList<World> cardlist = new ArrayList<World>();


    public World(){

    }
    
    public World(String ref, String name, int rating, int capacity,int current_Capcty)
    {    
    RefNo = ref;
    Wname = name;
    rat = rating;
    Capcty=capacity;  
    this.current_Capcty = current_Capcty;  
    }

    public void addCard(World w)
    {
        // Card cd = new Card(ref, name, rating, capacity);
        // cardlist.add(cd);
    }
    public void enter(Card c)
    {
        //cardlist.add(c); 
    }

    public void leave(Card c)
    {

        for (int count=0; count < cardlist.size(); count ++)
        {
            // Card remv = cardlist.get(count);
            //int nid= remv.getId();
            //int rid = c.getId();
            // if (remv.getId()==c.getId())
            // {
            //   cardlist.remove(count);   
            //   break;
            // }
            //System.out.println("Card does not exist");
    
        }
    }

    public boolean checkCpty(World w)
    {
        
        if (w.getCapacity()>w.getcurrentCapcty())
        {
            // System.out.println("Maximum capacity has been reached");
            return true;
        }
        else
        {
            // System.out.println("There is still capacity");
            return false;
        }
    }

    public void showcards()
    {
        //System.out.println("Size: " +cardlist.size());
        for(int i =0; i<cardlist.size(); i++)
        {
            System.out.println(cardlist.toString());
            System.out.println("*****************");;
        }
    }
    public int getcurrentCapcty()
    {
        return current_Capcty;   
    }
    public String getRefno()
    {
        return RefNo;   
    }
    public String getName()
    {
        return Wname;
    }
    public int getRatng()
    {
        return rat;
    }
    public int getCapacity()
    {
        return Capcty;
    }
    public void setcurrentCapcty(int current_Capcty_new)
    {
        current_Capcty = current_Capcty_new;
    }
    public void setRef(String ref)
    {
        RefNo= ref;
    }
    public void setWName( String name)
    {
        Wname = name;
    }
    public void setRat( int rating)
    {
        rat = rating;
    }
    public void setCap( int capa)
    {
        Capcty = capa;
    }
    /**public Card findbyrefno(int refno)
    {
        int rfn;
    for ( Card temp: cardlist)

    { rfn = cardlist.getRefno();
            if(refno==rfn)
            {
                System.out.println(cardlist.get(temp));
            }
        }
        return null;
    }*/


    public String toString(ArrayList al)
    {
        Iterator<World> iter = al.iterator();
            while(iter.hasNext())
            {
                World yp = iter.next();
                setCap(yp.getCapacity());
                setRat(yp.getRatng());
                setRef(yp.getRefno());
                setWName(yp.getName());
                setcurrentCapcty(yp.getcurrentCapcty());
            }
        return "World Name : " + this.getName() + "\n Reference Number : "+this.getRefno() + "\nRating : " + this.getRatng() +"\n Capacity : "+this.getCapacity()+"\n Current_Capacity : "+this.getcurrentCapcty();
    }
}
