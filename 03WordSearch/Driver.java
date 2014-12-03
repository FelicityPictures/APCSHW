import java.util.*;
import java.io.*;
public class Driver{

  public static WordGrid x;

  public static void main(String[]args)throws FileNotFoundException{

    //instructions for using Driver   
    if (args.length != 3 && args.length != 4) {     
      System.out.println("Usage:");
      System.out.println("java WordGrid <rows> <columns> [seed <answer>]");
      return;
    }
    
    //set up word grid
    String s = args[0];
    String w = args[1];
    int ro = Integer.parseInt(s);
    int col = Integer.parseInt(w);
    x = new WordGrid(ro,col);
    
    try{
      String rs = args[2];
      int rands = Integer.parseInt(rs);
      if(rands>=0){
        x.setSeed(rands);
      }
    }catch(Exception e){
    }

    boolean t = false;
    try{
      String lie = args[3];
      int tf = Integer.parseInt(s);
      if(tf == 1){
        t = true;
      }
    }catch(Exception e){
    }
    //make word search
    x.loadWordsFromFile("APCSHW/03WordSearch/HappyWords.txt", t);
  }
}
