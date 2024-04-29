/** 
 * Secondary driver for BiasedDie
 * Calls roll() method and defeats() method in BiasedDie and constructs percentage of victory for specified BiasedDie objects
 * Isaac Friedman
 */ 
import java.util.*;

public class BDDriverB {

    public static void main(String [] args) {
        //Scanner for input
        Scanner scnr = new Scanner(System.in);

        //BiasedDie object, equal to sameB
        int[] sidesSameA = {1,2,3,4,5,6};
        BiasedDie sameA = new BiasedDie(sidesSameA);

        //BiasedDie object, equal to sameA
        int[] sidesSameB = {1,2,3,4,5,6};
        BiasedDie sameB = new BiasedDie(sidesSameB);

        //if loop for checking if equals() method correctly returns true when passed two equal objects
        if (sameA.equals(sameB)) {
            System.out.println("sameA and sameB are equal" + "\n");
        }
        else {
            System.out.println("sameA and sameB are not equal" + "\n");
        }

        //BiasedDie object, different from diffB
        int[] sidesDiffA = {1,1,3,3,5,6};
        BiasedDie diffA = new BiasedDie(sidesDiffA);

        //BiasedDie object, different from diffA
        int[] sidesDiffB = {1,2,3,4,5,5};
        BiasedDie diffB = new BiasedDie(sidesDiffB);

        //if loop for checking if equals() memthod correctly returns flase when passed two different objects
        if (diffA.equals(diffB)) {
            System.out.println("diffA and diffB are equal" + "\n");
        }
        else {
            System.out.println("diffA and diffB are not equal" + "\n");
        }

        //creates "A" BiasedDie object from magazine article
        int[] sidesA = {3,3,3,3,3,6};
        BiasedDie A = new BiasedDie(sidesA);

        //creates "B" BiasedDie object from magazine article
        int[] sidesB = {2,2,2,5,5,5};
        BiasedDie B = new BiasedDie(sidesB);

        //creates "C" BiasedDie object from magazine article
        int[] sidesC = {1,4,4,4,4,4}; 
        BiasedDie C = new BiasedDie(sidesC);

        //input from scanner for number of games played
        int numPlayed = scnr.nextInt();

        //double fields for BiasedDie "A" victory count
        double aBeatsB = 0;
        double aBeatsC = 0;

        //double fields for BiasedDie "B" victory count
        double bBeatsA = 0;
        double bBeatsC = 0;

        //double fields for BiasedDie "C" victory count
        double cBeatsA = 0;
        double cBeatsB = 0;

        //for look that takes A, B, and C and rolls them numPlayed times, updating each variable to count victories
        for (int i = 0; i <= numPlayed; i++) {
            if (A.defeats(B) == true) {
                aBeatsB++;
            }
            else {
                bBeatsA++;
            }
            if (A.defeats(C) == true) {
                aBeatsC++;
            }
            else {
                cBeatsA++;
            }
            if (B.defeats(C) == true) {
                bBeatsC++;
            }
            else {
                cBeatsB++;
            }
        }

        //print statements to display times played, and each dice's victory percentage compared to the other
        System.out.println();
        System.out.println("Number of times games played: " + numPlayed);
        System.out.println("A beats B " + ((aBeatsB /(aBeatsB + bBeatsA)) * 100) + " % of the time.");
        System.out.println("B beats C " + ((bBeatsC / (bBeatsC + cBeatsB)) * 100) + " % of the time.");
        System.out.println("C beats A " + ((cBeatsA / (cBeatsA + aBeatsC)) * 100) + " % of the time.");

        //closes scnr object used to input numPlayed
        scnr.close();
    }
}
