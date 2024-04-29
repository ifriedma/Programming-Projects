/* Isaac Friedman
* TileClientA class
* Creates Tile objects, and calls Tile.java to get and set Tile values
* Contains print statements, including equals and compareTo print statements
*/
public class TileClientA {
        public static void main(String[] args) {
            
            //construct three Tile objects using both constructors
            Tile tile1 = new Tile();
            Tile tile2 = new Tile('A',1);
            Tile tile3 = new Tile('Z',6);
            
            //Do tiles have correct values?
            System.out.println("(Tile 1 should have letter A and value 1)");
            System.out.println("Tile 1 info --> " + tile1);
            System.out.println();
            System.out.println("(Tile 2 should have letter A and value 1)");
            System.out.println("(Tile 2 info --> " + tile2);
            System.out.println();
            System.out.println("(Tile 3 should have letter Z and value 6)");
            System.out.println("Tile 3 info --> " + tile3);
            System.out.println();
             
            //Change value of Tile 1 and letter of Tile 3
            System.out.println("Change value of Tile 1 to 5");
            tile1.setValue(5);
            
            //Test getter method
            System.out.println("Tile 1's new value is " + tile1.getValue());
            
            //Change letter  of Tile 3
            System.out.println("Change letter of Tile 3 to G");
            tile3.setLetter('G');
            
            //Test getter method
            System.out.println("Tile 3's new letter is " + tile3.getLetter());
            
            System.out.println();
            
            System.out.println("(Tile 1 should now have letter A and value 5)");
            System.out.println("Tile 1 info --> " + tile1);
            System.out.println();
            System.out.println("(Tile 3 should now have letter G and value 6)");
            System.out.println("Tile 3 info --> " + tile3);
            System.out.println();  

            //equals() print method
            System.out.println(tile1.equals(tile2));
            System.out.println(tile1.equals(tile3));
            System.out.println(tile2.equals(tile3));
            System.out.println();

            //compareTo() print method
            System.out.println(tile1.compareTo(tile2));
            System.out.println(tile1.compareTo(tile3));
            System.out.println(tile2.compareTo(tile3));
            System.out.println();
        }
    }