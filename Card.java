import java.util.ArrayList;

// import java.util.ArrayList;

/**
 * A Card has an id number, name, a luxury rating and number of credits.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Card 
{
    private int ID;
    private String CName;
    private int Luxtyp;
    private int credit;
    private String Card_latest_world;

    public Card(){

    }
    public Card( int id, String cardn, int lux, int cred,String Card_latest_world)
    {
    this.ID = id;
    this.CName = cardn;
    this.Luxtyp = lux;
    this.credit = cred;
    this.Card_latest_world = Card_latest_world;
    }
    public String getCardlatestworld()
    {
        return Card_latest_world;   
    }
    public int getId()
    {
        return ID;   
    }
    public String getName()
    {
        return CName;
    }
    public int getLux()
    {
        return Luxtyp;
    }
    public int getcredits()
    {
        return credit;
    }
    public void setcredit(int credits)
    {
        credit= credits;
    }
    public void setID(int cardid)
    {
        ID= cardid;
    }
    public void setName( String nme)
    {
        CName = nme;
    }
    public void setLux( int rating)
    {
        Luxtyp = rating;
    }
    public void AddCred( int newcred)

    {
        credit = credit+newcred;
    }
    public void DedCred( int dedcred)
    {
        credit = credit - dedcred;
    }

    public boolean CredChek(int id)
    {
        // for(int i =0;i<arr.length;i++){
        //     if(id == arr[i]){
        //         if()
        //     }
        // }
        // if ( credit >= 4)
        // {
        //     return true;
    // }
    return false;
    }

    public String toString(ArrayList  al)
    {
        
        return "ID Number : " + ID + "\n" + "Card Name : " + CName +"\n"+ "Card Rating : "+Luxtyp + "\n"+"Credits : "+credit;
        
        
    }
}

