import java.util.ArrayList;

public class collapseDuplicates{

  public static void collapseDuplicates(ArrayList<Integer> L){
    for(int i = 0;i<L.size()-1;i++){
      if(L.get(i) == L.get(i+1)){
        L.remove(i);
        i--;
      }
    }
  }

  public static void main(String[]args){
    ArrayList<Integer> L = new ArrayList<Integer>();
    L.add(1);
    L.add(2);
    L.add(2);
    L.add(2);
    L.add(3);
    L.add(4);
    L.add(4);
    L.add(5);
    L.add(6);
    L.add(6);
    L.add(6);
    L.add(7);
    L.add(8);
    L.add(9);
    L.add(0);
    //before collapse
    System.out.println(L.toString());
    //after collapse
    collapseDuplicates(L);
    System.out.println(L.toString());
  }
  
}
