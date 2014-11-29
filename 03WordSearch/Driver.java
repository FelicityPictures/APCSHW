import java.util.*;
import java.io.*;
  public class Driver{

    public static void main(String[]args)throws FileNotFoundException{
      /*
      if (args.length != 4 && args.length != 5) {     
        System.out.println("Usage:");
        System.out.println("java WordGrid <rows> <columns> [seed <answer>]");
        return;
      }
      */

      //set up empty word search grid
      WordGrid x = new WordGrid(5,5);
      System.out.println(x.toString());

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
