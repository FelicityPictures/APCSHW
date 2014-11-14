import java.util.*;

public class ArrayListMethods{

  public static void collapseDuplicates(ArrayList<Integer> L){
    for(int i = 0;i<L.size()-1;i++){
      if(L.get(i) == L.get(i+1)){
        L.remove(i);
        i--;
      }
    }
  }

  public static void randomize(ArrayList<Integer> L){
    Random r = new Random();
    for(int i = L.size(); i>0; i--){
      int h = r.nextInt(i);
      L.add(L.get(h));
      L.remove(h);
    }
  }

  public static void main(String[]args){
    ArrayList <Integer> L = new ArrayList<Integer>();
    for(int i=0;i<=10;i++){
      L.add(i);
    }
    System.out.println(L.toString());
    randomize(L);
    System.out.println(L.toString());
  }
}
