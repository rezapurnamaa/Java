package threads;

public class Parkhaus{
  
  private int freiPlatz;
  private String name;
  
  public Parkhaus(int anzahlFreiPlatz, String parkhausName){
    setAnzahlFreiPlatz(anzahlFreiPlatz);
    setName(parkhausName);
  }
  
  public void setAnzahlFreiPlatz( int derPlatz){
   freiPlatz = derPlatz; 
  }
  
  public int getAnzahlFreiPlatz(){
    return freiPlatz;
  }
  
  public void setName(String name){
    this.name = name;
  }
  
  public String getName(){
    return name;
  }
  
  public static void main(String args[]){
    Parkhaus mainParkhaus = new Parkhaus(100,"Frankfurter Allee");
    System.out.println(mainParkhaus.getName() + " hat freie Plaetze von = " + mainParkhaus.getAnzahlFreiPlatz());
    
  }
}