import java.util.*;
public class Sorts{

  public static void insertionSort(int[]data){
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

  public static void selectionSort(int[]data){
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

  public static void bubbleSort(int[]data){
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

}
