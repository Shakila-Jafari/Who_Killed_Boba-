import java.util.ArrayList;
import java.util.Map;

/*
 * keeps track of the player's name, location, and stuff they carry (inventory)
 * is a Coordinates object (inherits x, y, name, and description)
 */
 public class Player extends Coordinates{

    private String PlayerName;  //player's name
    private ArrayList<Item>iventory; //items player has picked up



    /*
     * Constructor – player with a name and starting location
     */
        public Player (String PlayerName, double x, double y, String locName, String locDes) {
            super(x,y, locName, locDes);
            this.PlayerName = playerName;
            this.inventory = new ArrayList<>(); //empty bag at the begginning, No items


        }
        
        public String getName(){
            return playerName;
        }


        //where the player is currently
        public Coordinates getLocation(){
            return new Coordinates(getX(), getY(), getName(), getDescription());

        }

        //what the player have (what objects)
        public void showInventory(){
            if(inventory.idEmpty()){
                System.out.println("You don't have anything yet");
            } else {
                System.out.println("You have:");
                for(Item item : inventory){
                    System.out.println(" " + item.getName()); //just show item names
                }
            }
        }

        //Shows the map's description ( the map should have a getDescription method)
        public void showMap(Map map){
            System.out.println(map.getDescription());

        }

        //picks up an item if it hasn't already been picked up
        public void pickUp(Item item){
            if (!item.hasItem()){
                inventory.add(item); //add it to the bag
                item.addItem();  // mark the item as picked up!
                System.out.println("You picked up: " + item.getName());
            } else {
                System.out.println("You've already picked this up.");

            }
        }  
        
        //remove an item from invwntory
        public void putdown(Item item){
            if (inventory.contain(item)){
                inventory,remove(item);
                System.out.println("You put down:" + item.getName());
            } else{
                System.out.println("You don't even have that item!");
            }
        } 
        public void inspect(Item item){
            System.out.println(item.showDescription());
        } 

        //talk to the person if they are in the same plave
        public void talkTo(NCP ncp){
            if (ncp.getLocatoin().equals(this.getLocation())){
                ncp.talk(); //the NCP speaks
            } else{
                System.out.println(ncp.getName()+ "isn't here right now");
            }
        }

        }


