import java.util.*;
import java.io.*;
public class Driver{

  public static void main(String[]args)throws FileNotFoundException{
      
    if (args.length != 3 && args.length != 4) {     
      System.out.println("Usage:");
      System.out.println("java WordGrid <rows> <columns> [seed <answer>]");
      return;
    }
      
    File text=null;
    Scanner scan=null;
    try{
      text = new File("APCSHW/03WordSearch/HappyWords.txt");
      scan = new Scanner(text);
    }catch(Exception e){
      System.out.println("File was not found.");
    }
    while(scan.hasNextLine()){
      words.add(scan.nextLine());
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
      

    //test it out
    x.addWordBU("meow",4,4);
    System.out.println(x.toString());
  }
}
