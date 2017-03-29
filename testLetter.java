public class testLetter{
   public static void main(String[] argv){
      LetterInventory inventory1 = new LetterInventory("George W. Bush");
      System.out.println(inventory1);
      LetterInventory inventory2 = new LetterInventory("hello Mona Lee");
      System.out.println(inventory1.add(inventory2));
      System.out.println(inventory1.subtract(inventory2));
   }
}