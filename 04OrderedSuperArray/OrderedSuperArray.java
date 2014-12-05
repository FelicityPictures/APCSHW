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

  public int search(String t){
    int c = 0;
    int m = (int)Math.pow(2,c);
    int x = size/2;
    while(!data[x].equals(t)){
      int result = data[x].compareTo(t);    
	    c++;
	    if(result<0){
        x=x+m;
	    }
	    if(result>0){
        x=x-m;
	    }
    }
    return x;
  }
  
  public static void main(String[]args){
    SuperArray test = new OrderedSuperArray();
    test.add("dog");
    test.add("cat");
    test.add("frog");
    test.add("beetle");
    test.add("cows");
    test.add("turtle");
    test.add("hedgehog");
    test.add("chameleon");
    test.add("lion");
    test.add("ferret");
    test.add("bird");
    System.out.println(test.toString());
    try{
      System.out.println(test.find("lion"));
    }catch(Exception e){
      System.out.println("String not found in the array.");
    }
  }

}
