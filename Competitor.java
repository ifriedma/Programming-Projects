//Isaac Friedman
//Competitor class that is used to simulate two competitors playing rock paper scissors
//competitors draw from a preselected pouch, weapons, and discard the element played for the current game
import java.util.*;

public class Competitor {

    //Fields which will hold relavant values as Competitor is called
    public String name;
    public String teamName;
    public String placeholder;
    public ArrayList<String> weapons = new ArrayList<>();

    //default constructor, which assigns the Competitor object its name, teamName, and weapons which hold all implements
    public Competitor(String name, String teamName) {
        this.name = name;
        this.teamName = teamName;
        this.weapons = new ArrayList<>();
    }

    //returns the string name of the competitor when called
    public String getName() {
        return this.name;
    }

    //returns the string teamName of the competitor when called
    public String getTeam() {
        return this.teamName;
    }

    //Takes the string weapon element as an argument and adds it to the Objects weapons ArrayList, equiping the champions weapons
    public void equip(String weapon) {
        this.weapons.add(weapon);
    }

    //Defeats method that simulates each Competitor playing rock paper scissors, tie goes to the opponent. 
    //Each element is removed from the weapons ArrayList after being played
    public boolean defeats(Competitor opponent) {

        //myWeapon and their Weapon hold the value of each play
        String myWeapon = this.weapons.get(0);
        String theirWeapon = opponent.weapons.get(0);

        //this.placeholder and opponent.placeholder hold the value of each play before being removed, for use in retrieveImplement
        this.placeholder = retrieveImplement(this.weapons.get(0));
        opponent.placeholder = retrieveImplement(opponent.weapons.get(0));

        //returns false if there is a tie, goes to opponent
        if (myWeapon.equals(theirWeapon)) {
            this.weapons.remove(0);
            opponent.weapons.remove(0);
            return false;
        }

        //returns true for all possible conditions where Competitor wins
        else if (myWeapon.equals("rock") && theirWeapon.equals("scissors")
                || myWeapon.equals("paper") && theirWeapon.equals("rock")
                || myWeapon.equals("scissors") && theirWeapon.equals("paper")) {
            this.weapons.remove(0);
            opponent.weapons.remove(0);
            return true;
        } 

        //accounts for all Competitor losses, returning false as victory goes to the Opponent
        else {
            this.weapons.remove(0);
            opponent.weapons.remove(0);
            return false;
        }
    }

    //private helper method that is called within the defeats method, stores value of most recent play into placeholder
    private String retrieveImplement(String holding) {
        String placeholder = holding;
        return placeholder;
    }

    //returns the placeholder string of the object to which this method was called, the value of the most recent play
    public String getImplement() {
        return this.placeholder;
    }

    //method that organizes and displays the Competitor and Opponent's name and teamName at the start of the program
    public String toString() {
        return this.name + " from team " + this.teamName;
    }
}
