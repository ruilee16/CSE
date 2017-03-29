import java.util.*;

public class LetterInventory{
   private int[] list;
   private int size;
   
   public final int LISTLENGTH = 26;
   // input : data as String type
   public LetterInventory(String data){
      data = data.toLowerCase();
      list = new int[LISTLENGTH];
      size = 0;
      for (int i = 0; i < data.length(); i++){
         if (data.charAt(i) >= 'a' && data.charAt(i) <= 'z'){
            list[data.charAt(i) - 'a']++;
            size++;
         }
      }
   }
   
   public LetterInventory(){
      this("");
   }
   
   /*Returns count of how many this letter are in the inventory*/
   // pre : letter
   // post: if letter is nonalphabetic, throw IllegalArgumentException ; 
   //       else, return the count of the letter.
   public int get(char letter){
      letter = Character.toLowerCase(letter);
      isRange(letter);
      // count the number of letter in list
      return list[letter - 'a'];
   }
   
   /*return the size of letterInventory */
   public int size(){
      return size;
   }
   
   /*return true if the inventory is empty*/
   public boolean isEmpty(){
      return size == 0;
   }
   
   /*sets the count for the given letter to the given value.*/
   public void set(char letter, int value){
      letter = Character.toLowerCase(letter);
      isRange(letter);
      list[letter - 'a'] = value;
   }
   
   
   /*Retruns a String representation fo the inventory with the letters*/
   public String toString(){
      String temp = "[";
      for (int i = 0; i < 26; i++){
         for (int j = 1; j <= list[i]; j++){
            temp += (char)('a' + i);
         }
      }
      temp += "]";
      return temp;
   }
   
   /*returns a new LetterInventory object that represents the sum of this list and another one*/
   public LetterInventory add(LetterInventory other){
      LetterInventory newList = new LetterInventory();
      for(int i = 0; i < LISTLENGTH; i++){
         newList.list[i] = list[i] + other.list[i];
      }
      newList.size = size + other.size;
      return newList;
   }
   
   /*return a new LetterInventory that represents the result of subtracting the other*/
   public LetterInventory subtract(LetterInventory other){
      LetterInventory newList = new LetterInventory();
      for(int i = 0; i < LISTLENGTH; i++){
         newList.list[i] = list[i] - other.list[i];
         if(newList.list[i] < 0){
            return null;
         }
      }
      newList.size = size - other.size;
      return newList;
   }
   
   /*Judge the range of the letter*/
   public void isRange(char letter){
      if (letter < 'a' || letter > 'z'){
         throw new IllegalArgumentException();
      }
   }
}