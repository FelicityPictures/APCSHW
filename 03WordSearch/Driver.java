import java.util.*;
import java.io.*;
public class Driver{

  public static void main(String[]args)throws FileNotFoundException{

    //instructions for using Driver   
    if (args.length != 3 && args.length != 4) {     
      System.out.println("Usage:");
      System.out.println("java WordGrid <rows> <columns> [seed <answer>]");
      return;
    }
    
    //set up empty word search grid
    String s = args[0];
    String w = args[1];
    int ro = Integer.parseInt(s);
    int col = Integer.parseInt(w);
    WordGrid x = new WordGrid(ro,col);
    String rs = args[2];
    int rands = Integer.parseInt(rs);
    if(rands>=0){
      x.setSeed(rands);
    }
      
    //make word search
    loadWordsFromFile("APCSHW/03WordSearch/HappyWords.txt");
  }
}
