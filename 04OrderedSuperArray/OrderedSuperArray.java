import java.util.*;
public class OrderedSuperArray extends SuperArray{
    
  public OrderedSuperArray(){
    data = new String[2];
  }

  public void add(int index, String o){
    add(o);
  }

  public void add(String o){
    super.add(o);
    insertionSort();
  }
  
  public String set(int index, String o){
    String x = super.set(index,o);
    super.set(index, o);
    insertionSort();
    return x;
  }
}
