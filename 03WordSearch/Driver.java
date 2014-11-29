import java.util.*;
import java.io.*;
  public class Driver{

    public static void main(String[]args)throws FileNotFoundException{
      
      if (args.length != 3 && args.length != 4) {     
        System.out.println("Usage:");
        System.out.println("java WordGrid <rows> <columns> [seed <answer>]");
        return;
      }
      

      //set up empty word search grid
      String s = args[1];
      String w = args[2];
      int ro = Integer.parseInt(s);
      int col = Integer.parseInt(w);
      WordGrid x = new WordGrid(ro,col);
      r.setSeed(args[3]);
      

      //test it out
      /*  x.addWordH("meow",3,0);
      System.out.println(x.toString());
      */
      x.addWordHB("woof",3,3);
      System.out.println(x.toString());
      /*
      x.addWordV("rawr",0,2);
      System.out.println(x.toString());
      */
      x.addWordVB("evil",3,1);
      System.out.println(x.toString());
    }
  }
