import java.util.*;
public class Sorts{

  public static String name(){
    return "Ng,Felicity";
  }

  public static int period(){
    return 6;
  }
    
  public static void insertion(int[]data){
    for(int i = 0; i<data.length-1;i++){
	    if(data[i]>data[i+1]){
        int x = data[i];
        data[i]=data[i+1];
        data[i+1]=x;
        for(int m = i+1;m>0;m--){
          if(data[m]<data[m-1]){
            int t = data[m];
            data[m]=data[m-1];
            data[m-1]=t;
          }
        }
	    }
    }
  }

  public static void selection(int[]data){
    for(int i=0; i<data.length; i++){
	    int s=data[i];
	    for(int m=i; m<data.length; m++){
        if(s>data[m]){
          int q = s;
          s = data[m];
          data[m]=q;
        }
	    }
	    if(s!=data[i]){
        data[i]=s;
	    }
    }
  }

  public static void bubble(int[]data){
    for(int i=data.length-1;i>0;i--){
	    for(int w=0;w<i;w++){
        if(data[w]>data[w+1]){
          int m = data[w];
          data[w]=data[w+1];
          data[w+1]=m;
        }
	    }
    }
  }

  //get place digit
  public static int getPlaceValue(int num, int p){
    int m = Math.abs((num / (int) Math.pow(10, (double) p - 1)) % 10);
    return m;
  }

  private static int getDigitsIn(int n) {
    int digits = 0;
    while (Math.abs(n) > 0) {
      n /= 10;
      digits++;
    }
    return digits;
  }

  public static void radix(int[] data){
    ArrayList<ArrayList<Integer>> b = new ArrayList<ArrayList<Integer>>();
    for(int i=0;i<10;i++){
      b.add(new ArrayList<Integer>());
    }
    int p = getDigitsIn(data[0]);
    for(int i=1;i<data.length;i++){
      p = Math.max(p,data[i]);
    }
    for(int m = 0;m<p;m++){
      for(int i = 0; i<data.length;++i){
        b.get(getPlaceValue(data[i],m+1)).add(data[i]);
      }
      int c = 0;
      for (int i = 0; i < b.size(); ++i){
        for (int j = 0; j < b.get(i).size(); ++j){
          data[c] = b.get(i).get(j);
          c++;
        }
        b.get(i).clear();
      }
    }
  }           

  //From Alvin Lin's code
  public static void out(int[] c) {
    String out = "[ ";
    for (int i = 0; i < c.length - 1; ++i) {
      out += c[i] + ", ";
    }
    out += c[c.length - 1] + " ]";
    System.out.println(out);
  }
                              
  public static void main(String[]args){
    int[]t = new int[11];
    t[0]=104;
    t[1]=9;
    t[2]=32;
    t[3]=32;
    t[4]=11;
    t[5]=4;
    t[6]=2;
    t[7]=0;
    t[8]=7;
    t[9]=19;
    t[10]=20;
    out(t);
    radix(t);
    out(t);
  }
}
