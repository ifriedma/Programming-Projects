/**
* A client to test competitors implementing the CompetitorInterface
*
* @author (David Luginbuhl)
* @version (Spring 2022 Assn2)
*/
public class CompetitorClient {
    public static void main(String[] args) throws Exception {
        
        // Player names taken from characters in The Stormlight Archives, by Brandon Sanderson
        // Copyright 2010, 2014, 2017, 2020
        //Szeth is from team Shin
        Competitor szeth = new Competitor("Szeth","Shin");

        //These are Szeth's "forces"
        String[] sArray = {"rock","rock","rock","rock","paper","paper","paper","scissors","scissors","scissors"};

        for (int i = 0; i < 10; i++) { 
            szeth.equip(sArray[i]); //Add Szeth's weapons to his bag
        }

        //Jasnah is from team Alethi
        Competitor jasnah = new Competitor("Jasnah","Alethi");

        // Jasnah's forces
        String[] jArray = {"scissors","scissors","scissors","scissors","paper","paper","paper","rock","rock","rock"};

        for (int i = 0; i < 10; i++) {
            jasnah.equip(jArray[i]); //Add Jasnah's weapons to her bag
        }

        // List the competitors
        System.out.println("Champion " + szeth); //Print out Szeth's info
        System.out.println("Challenger " + jasnah); //Print out Jasnah's info

        // Time for them to compete!
        for (int i = 0; i < 10; i++) {
            if (szeth.defeats(jasnah)) {
                System.out.println(szeth.getName() + " wins! Team " + szeth.getTeam() + " wins!"); 
            }
            else {
                if (jasnah.getImplement().equals(szeth.getImplement())) {
                    System.out.println("Tie goes to the challenger!");
                }
                System.out.println(jasnah.getName() + " wins! Team " + jasnah.getTeam() + " wins!");
            }

            //Print out what each competitor used in this round
            String jForce = jasnah.getImplement();
            String sForce = szeth.getImplement();
            System.out.println(jasnah.getName() + " had " + jForce + " and " + szeth.getName() + " had " + sForce);
            System.out.println();
        }
    }
}
