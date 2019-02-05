// This Sean's heading for Simone's class, section airplanes are cool!
// This class implements a map...
// A LetterInventory keeps track of how many of a letters are in a given string of data
// It provides access to the amount of letters given the letter (or key :)

import java.util.Arrays;

public class LetterInventory {
	
   // the size of the inventory array (number of letters in alphabet)
	private final int SIZE = 26;
   // the first character accepted by the inventory
	private final char FIRST_CHAR = 'a';
   
   // the inventory containing the counts of the letters
	private int[] inventory;
   // the total number of letters accounted for in the inventory
	private int inventorySize;
	
// Constructs an empty LetterInventory with initial capacity SIZE with all values filled as 0
	public LetterInventory() {
//       LetterInventory("");
		inventory = new int[SIZE];
// 		Arrays.fill(inventory, 0); // no fill needed, this is default
		inventorySize = 0;
	}
	
// Constructs a LetterInventory with initial capacity SIZE and populates the initial inventory given data
	public LetterInventory(String data) {
//       LetterInventory();
		inventory = new int[SIZE];
      inventorySize = 0;
		for (int i = 0; i < data.length(); i++) {
			char currentChar = Character.toLowerCase(data.charAt(i));
         int charIndex = currentChar - FIRST_CHAR;
         if (charIndex < SIZE && charIndex >= 0) {
			   inventory[charIndex]++;
            inventorySize++;
         }
	   }
   }
	
// returns number of mapped letters (number of alpha characters in inventory)
	public int size() {
		return inventorySize;
	}
	
// Returns if inventory is empty
	public boolean isEmpty() {
		return inventorySize == 0;
	}
	
// gets the number of the given letter currently in the inventory
	public int get(char letter) {
		return inventory[convertLetterToCharDiff(letter)];
	}
	
// converts inventory to a string
	public String toString() {
		String outputString = "[";
		for (int i = 0; i <	SIZE; i++) {
			String result = Character.toString((char) (FIRST_CHAR + i));
			for (int j = 0; j < inventory[i]; j++) {
				outputString += (result);
			}
		}
		outputString += "]";
		return outputString;
	}
	
   // ask about removing all reduncancy of Character.toLowerCase(letter) - FIRST_CHAR
	public void set(char letter, int value) {
		if (convertLetterToCharDiff(letter) >= 0 && 
          convertLetterToCharDiff(letter) < SIZE && value >= 0){
         inventorySize += (value - inventory[convertLetterToCharDiff(letter)]);
         inventory[convertLetterToCharDiff(letter)] = value;
		} else {
         throw new IllegalArgumentException();
      }
	}
   
// Constructs and returns new LetterInventory that represents the sum of this and other LetterInventory
	public LetterInventory add(LetterInventory other) {
      LetterInventory newInventory = new LetterInventory();
      for (char i = FIRST_CHAR; i < FIRST_CHAR + SIZE; i++) {
         newInventory.set(i, this.get(i) + other.get(i));
      }
      return newInventory;
	}
	
// Constructs and returns new LetterInventory that represents the difference of this and other LetterInventory
// Returns null if difference is negative
	public LetterInventory subtract(LetterInventory other) {
		LetterInventory newInventory = new LetterInventory();
      for (char c = FIRST_CHAR; c < FIRST_CHAR + SIZE; c++) {
         int newValue = this.get(c) - other.get(c);
         if (newValue >= 0) {
            newInventory.set(c, newValue);
         } else {
            return null;
         }
      }
      return newInventory;
	}
	
// Returns percentage of letters in inventory that are the given letter
	public double getLetterPercentage(char letter) {
      if (convertLetterToCharDiff(letter) >= 0 && 
          convertLetterToCharDiff(letter) < SIZE){
         return (double) this.get(letter) / this.size();
		} else {
         throw new IllegalArgumentException();
      }
	}
   
   private int convertLetterToCharDiff(char letter) {
      return Character.toLowerCase(letter) - FIRST_CHAR;
   }
   
}







