/** 
 * Constructs and initializes normal and/or biased die 
 * containts equals() method, roll() method, and defeats() method for simulation
 * Isaac Friedman
 */ 
import java.util.*;

public class BiasedDie {

//initializes die and random fields for class
    private int[] faces;
    private Random rand = new Random();

//method used for implementing input integer and constructing a normal die object
    public BiasedDie(int n) { 
        this.faces = new int[n];
        for (int i = 1; i <= n; i++) {
            this.faces[i - 1] = i;
        }
    }

//method used for implementing input array and constructing a biased die object
    public BiasedDie(int sides[]) {
        this.faces = sides.clone();
    }

//method that organizes die object data and returns a proper print format
    public String toString() {
        String dieSides = "";
        for (int i = 0; i <= this.faces.length - 1; i++) {
            dieSides += this.faces[i] + " ";
        }
        return "This die has " + this.faces.length + " sides: " + dieSides;
    }

    //equals() method that evaluates to true if number of faces and values on each face of biased die is equal to the other
    public boolean equals(Object biasedDie) { 
        BiasedDie other = (BiasedDie) biasedDie;
        if (this.faces.length != other.faces.length) {
            return false;
        }
        for (int i = 0; i < this.faces.length; i++) {
            if (this.faces[i] != other.faces[i]) {
                return false;
            }
        }
        return true;
    }

    //roll() method simulates a roll of the dice by randomly selecting one of the object values useing rand
    public int roll() {
        return faces[rand.nextInt(faces.length)];
    }

    //defeats() method that simulates two rolled dice, and determines whether the passed object wins or fails the roll
    public boolean defeats(Object obj) {
        BiasedDie other = (BiasedDie) obj;
        if (this.roll() >= other.roll()) {
            return true;
        }
        else {
            return false;
        }
    }
}
