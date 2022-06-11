/**
 * A shuttle provides a one-way connection between two worlds. It
 * has a Shuttle code and information about both the source and
 * the destination world
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shuttle
{
    private String code,source,destination;

    /** constructor
     */
    public Shuttle(){

    }

    public Shuttle(String code,String source,String destination)
    {
        this.code = code;
        this.source = source;
        this.destination = destination;
    }

    public String getcode(){
        return this.code;
    }
    public String getSource(){
        return this.source;
    }
    public String getDestination(){
        return this.destination;
    }
    public void setcode(String code){
        this.code = code;
    }
    public void setSoruce(String source){
        this.source = source;
    }
    public void setDestination(String destinatio){
        this.destination = destination;
    }
}
