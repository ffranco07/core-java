import java.util.*;
public class Parse {
   public static void main (String[] args) {
		 Integer selDigits = 1234 ;
		 String selections = String.format("%04d", selDigits);
		 System.out.println("selections:" + selections);
		 int[] selectionArray = new int[5]; 
     for(int i=0; i< selections.length(); i++) {
			 selectionArray[i] = Integer.parseInt(selections.charAt(i)+"");
		 }
		 
   }
}
