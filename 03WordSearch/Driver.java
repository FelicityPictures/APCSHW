import java.util.*;
import java.io.File;
  public class Driver{
    public static void main(String[]args){

      //set up empty word search grid
      WordGrid x = new WordGrid(5,5);
      System.out.println(x.toString());

      //add words list
      File text = new File("APCSHW/03WordSearch/HappyWords.txt");
      Scanner sc = new Scanner(text);
      ArrayList<String>list = new ArrayList<String>();
      for(int i=0;sc.hasNextLine();i++){
        list.add(sc.nextLine());
      }

      //test it out
      x.addWord("meow",3,0);
      System.out.println(x.toString());
    }
  }
