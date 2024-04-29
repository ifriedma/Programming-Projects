/* Isaac Friedman
* Tile class
* initializes getters and setters for TileClientA.java
* also initializes the toString, equals, and compareTo methods
*/
public class Tile {
    
    char letter;
    int value;
    
    //sets default Tile value
    public Tile() {
        this.letter = 'A';
        this.value = 1; 
    }

    //sets user Tile value
    public Tile(char letter, int value) {
        this.letter = letter;
        this.value = value; 
    }
    
    //getter for pbject's letter
    public char getLetter() {
        return  letter; 
    }
    
    //getter for object's value
    public int getValue() {
        return value; 
    }
    
    //setter for object's letter
    public void setLetter(char letter) {
        this.letter = letter; 
    }
    
    //setter for object's value
    public void setValue(int value) {
        this.value = value; 
    }
        
    //toString that returns Tile object's print statement
    public String toString() {
        return "Letter: " + this.letter + " Value: " + this.value; 
    }

    //equals method that returns true if both letter and value are equal
    public boolean equals(Tile that) {
        return this.letter == that.letter && this.value == that.value; 
    }

    //compareTo method that returns difference of object's letter field or difference of object's value field
    public int compareTo(Tile that) {
        int compareInt; 
        if (this.letter != that.letter) {
            compareInt = this.letter - that.letter;
        }
        else {
            compareInt = this.value - that.value;
        }
        return compareInt;
    }
}
